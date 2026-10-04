#!/usr/bin/env python3
"""从 GitHub Issues 生成 docs/index.md（GitHub Pages 完整内容页）。"""

import json
import re
import subprocess
import sys
import time
from pathlib import Path

from interview_sections import (
    FIRST_TOPIC_ISSUE_NUM,
    GITHUB_CN,
    INDEX_ISSUE_NUM,
    ISSUE_PREFIX,
    SECTIONS,
    topic_issue_number,
)

REPO = "ZakAnun/discussing-algorithm"
BASE = f"https://github.com/{REPO}"
ROOT = Path(__file__).resolve().parent.parent
OUTPUT = ROOT / "docs" / "index.md"
CN_DIR = ROOT / "app/src/main/java/com/zak/da/template/leetcode/editor/cn"

DATE_RE = re.compile(r"\*\*(\d{4}\.\d{2}\.\d{2})\*\*")
PROBLEM_RE = re.compile(r"\[([^\]]+)\]\((https://leetcode-cn\.com/problems/[^)]+)\)")
SLUG_RE = re.compile(r"leetcode-cn\.com/problems/([^/)]+)")
def gh_api(path: str, retries: int = 4):
    last_err = None
    for attempt in range(retries):
        result = subprocess.run(
            ["gh", "api", path, "--paginate"],
            capture_output=True,
            text=True,
        )
        if result.returncode == 0:
            break
        last_err = result.stderr or result.stdout
        time.sleep(1.5 * (attempt + 1))
    else:
        raise RuntimeError(f"gh api failed for {path}: {last_err}")
    chunks = [c for c in result.stdout.strip().split("\n") if c.strip()]
    if len(chunks) == 1:
        return json.loads(chunks[0])
    items = []
    for chunk in chunks:
        items.extend(json.loads(chunk))
    return items


def normalize_markdown(text: str) -> str:
    if not text:
        return ""
    text = text.replace("\r\n", "\n").strip()
    # Issue 评论里常见的无加粗日期行 → 统一为 **YYYY.MM.DD**
    text = re.sub(r"(?m)^(\d{4}\.\d{2}\.\d{2})\s*$", r"**\1**", text)
    return text


def split_sections(text: str):
    """按 **YYYY.MM.DD** 切分，保留完整 Markdown 正文。"""
    text = normalize_markdown(text)
    if not text:
        return []

    parts = DATE_RE.split(text)
    sections = []

    preamble = parts[0].strip()
    if preamble:
        sections.append((None, preamble))

    for i in range(1, len(parts), 2):
        date = parts[i]
        content = parts[i + 1].strip() if i + 1 < len(parts) else ""
        sections.append((date, content))

    return sections


def anchor_id(issue_num: int, label: str) -> str:
    slug = re.sub(r"[^a-zA-Z0-9\u4e00-\u9fff]+", "-", label).strip("-").lower()
    return f"issue-{issue_num}-{slug}"


def count_problems(text: str) -> int:
    return len(PROBLEM_RE.findall(text or ""))


def slugs_in_text(text: str) -> set[str]:
    slugs = set()
    for _title, url in PROBLEM_RE.findall(text or ""):
        m = SLUG_RE.search(url)
        if m:
            slugs.add(m.group(1))
    return slugs


def render_section(
    title: str,
    anchor: str,
    content: str,
    lines: list,
    gh_link: str | None = None,
):
    lines.extend([f"#### {title}", "", f"<a id=\"{anchor}\"></a>", ""])
    if gh_link:
        lines.append(f"[在 GitHub 打开此段讨论 →]({gh_link})")
        lines.append("")
    if content:
        lines.append(content)
    else:
        lines.append("_（无正文）_")
    lines.append("")


def collect_notes_from_issue(issue: dict, notes_index: dict[str, list[dict]]):
    """第一遍扫描：从 Issue 正文与评论建立 LeetCode slug → 本页锚点索引。"""
    num = issue["number"]
    url = issue["html_url"]
    body = issue.get("body") or ""
    comments = gh_api(f"repos/{REPO}/issues/{num}/comments")

    def register(content: str, label: str, anchor: str, gh_link: str):
        for slug in slugs_in_text(content):
            notes_index.setdefault(slug, []).append(
                {
                    "label": label,
                    "anchor": anchor,
                    "gh": gh_link,
                    "issue_num": num,
                }
            )

    body_sections = split_sections(body)
    if not body_sections and body.strip():
        body_sections = [(None, normalize_markdown(body))]

    for idx, (date, content) in enumerate(body_sections):
        if date:
            label = date
            section_title = f"正文 · {date}"
        else:
            label = "intro" if idx == 0 else f"body-{idx}"
            section_title = "正文" if idx == 0 else f"正文 · 补充 {idx}"
        register(content, section_title, anchor_id(num, label), url)

    for comment_idx, comment in enumerate(comments, start=1):
        comment_body = comment.get("body") or ""
        comment_url = comment.get("html_url") or url
        created = (comment.get("created_at") or "")[:10]
        comment_sections = split_sections(comment_body)
        if not comment_sections and comment_body.strip():
            comment_sections = [(None, normalize_markdown(comment_body))]

        for sec_idx, (date, content) in enumerate(comment_sections):
            if date:
                section_title = f"评论 · {date}"
                label = f"comment-{comment_idx}-{date}"
                note_label = date
            else:
                section_title = f"评论 #{comment_idx}（{created}）"
                label = f"comment-{comment_idx}-{sec_idx}"
                note_label = section_title
            register(content, note_label, anchor_id(num, label), comment_url)


def index_note_for_slug(
    slug: str,
    notes_index: dict[str, list[dict]],
) -> str:
    entries = notes_index.get(slug, [])
    topic_range = range(
        FIRST_TOPIC_ISSUE_NUM, FIRST_TOPIC_ISSUE_NUM + len(SECTIONS)
    )
    preferred = [e for e in entries if e["issue_num"] in topic_range]
    if preferred:
        entries = preferred
    if not entries:
        return "—"
    seen = set()
    parts = []
    for e in entries:
        if e["anchor"] in seen:
            continue
        seen.add(e["anchor"])
        parts.append(
            f"[{e['label']}](#{e['anchor']})"
            f" ([GitHub]({e['gh']}))"
        )
    return " · ".join(parts)


def build_interview_hub(
    issues_by_num: dict[int, dict],
    notes_index: dict[str, list[dict]],
) -> tuple[list[str], list[str]]:
    """面试提纲速查表 + 各 Topic 子目录。"""
    hub_anchor = "interview-outline-2026-09"
    lines = [
        f"## {ISSUE_PREFIX} 面试刷题提纲速查",
        "",
        f"<a id=\"{hub_anchor}\"></a>",
        "",
        "下表可直达 **题解 Java 源码**、对应 **Topic Issue 归档**，以及 Issue **评论笔记**在本页的锚点。",
        "",
        f"总目录 Issue：[#{INDEX_ISSUE_NUM}]({BASE}/issues/{INDEX_ISSUE_NUM}) · "
        f"[本页归档](#{anchor_id(INDEX_ISSUE_NUM, 'overview')})",
        "",
        "| 模块 | 题目 | 难度 | LeetCode | 题解代码 | Issue | 评论笔记 |",
        "| --- | --- | --- | --- | --- | --- | --- |",
    ]

    topic_toc = [f"- [{ISSUE_PREFIX} 面试刷题提纲速查](#{hub_anchor})"]

    for topic_idx, section in enumerate(SECTIONS, start=1):
        issue_num = topic_issue_number(topic_idx)
        issue = issues_by_num.get(issue_num)
        issue_title = issue["title"] if issue else section["topic"]
        issue_page = f"#{anchor_id(issue_num, 'overview')}"
        issue_gh = f"{BASE}/issues/{issue_num}"
        topic_toc.append(
            f"  - [Topic {topic_idx:02d} {section['topic']} (#{issue_num})]"
            f"({issue_page}) · [GitHub]({issue_gh})"
        )

        for cn, diff, _point, num, slug, class_name in section["items"]:
            lc = f"https://leetcode-cn.com/problems/{slug}/"
            code_path = CN_DIR / f"{class_name}.java"
            code_url = f"{GITHUB_CN}/{class_name}.java"
            code_cell = f"[{class_name}.java]({code_url})"
            if not code_path.is_file():
                code_cell = f"~~{code_cell}~~ _缺失_"

            notes_cell = index_note_for_slug(slug, notes_index)
            lines.append(
                f"| {section['title'].split('.')[0].strip()} {section['topic']} "
                f"| [{cn}]({lc}) | {diff} | [#{num}]({lc}) | {code_cell} "
                f"| [#{issue_num}]({issue_page}) | {notes_cell} |"
            )

    lines.extend(["", "---", ""])
    return lines, topic_toc


def build_issue_block(issue: dict) -> tuple[str, int, int, list[str]]:
    num = issue["number"]
    title = issue["title"]
    url = issue["html_url"]
    body = issue.get("body") or ""
    comments = gh_api(f"repos/{REPO}/issues/{num}/comments")

    lines = [f"## [#{num} {title}]({url})", ""]
    issue_anchor = anchor_id(num, "overview")
    lines.extend([f"<a id=\"{issue_anchor}\"></a>", ""])
    lines.append(f"[在 GitHub 查看原 Issue →]({url})")
    lines.append("")

    if FIRST_TOPIC_ISSUE_NUM <= num <= FIRST_TOPIC_ISSUE_NUM + len(SECTIONS) - 1:
        lines.append(
            f"↑ 返回 [面试刷题提纲速查表](#interview-outline-2026-09) · "
            f"代码目录：`app/src/main/java/com/zak/da/template/leetcode/editor/cn/`"
        )
        lines.append("")

    sub_toc = []
    section_count = 0
    problem_count = count_problems(body)

    body_sections = split_sections(body)
    if not body_sections and body.strip():
        body_sections = [(None, normalize_markdown(body))]

    for idx, (date, content) in enumerate(body_sections):
        section_count += 1
        problem_count += count_problems(content)
        if date:
            label = date
            section_title = f"正文 · {date}"
        else:
            label = "intro" if idx == 0 else f"body-{idx}"
            section_title = "正文" if idx == 0 else f"正文 · 补充 {idx}"
        anchor = anchor_id(num, label)
        sub_toc.append((section_title, anchor))
        render_section(section_title, anchor, content, lines)

    for comment_idx, comment in enumerate(comments, start=1):
        comment_body = comment.get("body") or ""
        comment_url = comment.get("html_url") or url
        created = (comment.get("created_at") or "")[:10]
        problem_count += count_problems(comment_body)

        comment_sections = split_sections(comment_body)
        if not comment_sections and comment_body.strip():
            comment_sections = [(None, normalize_markdown(comment_body))]

        for sec_idx, (date, content) in enumerate(comment_sections):
            section_count += 1
            if date:
                section_title = f"评论 · {date}"
                label = f"comment-{comment_idx}-{date}"
                note_label = date
            else:
                section_title = f"评论 #{comment_idx}（{created}）"
                label = f"comment-{comment_idx}-{sec_idx}"
                note_label = section_title
            anchor = anchor_id(num, label)
            sub_toc.append((section_title, anchor))
            render_section(
                section_title,
                anchor,
                content,
                lines,
                gh_link=comment_url,
            )

    lines.extend(["---", ""])

    toc_lines = [f"- [#{num} {title}](#{issue_anchor})"]
    for section_title, anchor in sub_toc:
        toc_lines.append(f"  - [{section_title}](#{anchor})")

    block = "\n".join(lines)
    return block, section_count, problem_count, toc_lines


def build_page(issues):
    issues_by_num = {i["number"]: i for i in issues}
    notes_index: dict[str, list[dict]] = {}
    for issue in issues:
        collect_notes_from_issue(issue, notes_index)

    lines = [
        "---",
        "layout: default",
        "title: discussing-algorithm",
        "---",
        "",
        "# discussing-algorithm",
        "",
        "算法刷题记录与讨论总结，题目主要来自 [LeetCode 中国站](https://leetcode-cn.com/)，"
        "按 [labuladong 的刷题思路](https://github.com/labuladong/fucking-algorithm) 进行练习。",
        "",
        "本页完整归档 GitHub Issues 中的刷题笔记（含正文与全部评论）。"
        f" **{ISSUE_PREFIX} 面试提纲** 见下方速查表，可跳转题解源码与评论笔记。",
        "",
        "---",
        "",
    ]

    hub_lines, interview_toc = build_interview_hub(issues_by_num, notes_index)
    lines.extend(hub_lines)

    lines.extend(["## 目录", ""])
    lines.extend(interview_toc)
    lines.append("")
    lines.append("### 全部 Issue 归档")
    lines.append("")

    all_sections = 0
    all_problems = 0
    issue_blocks = []
    toc_entries = []

    for issue in issues:
        block, section_count, problem_count, toc_lines = build_issue_block(issue)
        all_sections += section_count
        all_problems += problem_count
        issue_blocks.append(block)
        toc_entries.extend(toc_lines)
        toc_entries.append("")

    lines.extend(toc_entries)
    lines.extend(
        [
            f"**合计：** {len(issues)} 个 Issue，{all_sections} 个章节，约 {all_problems} 道题。",
            "",
            "---",
            "",
        ]
    )
    lines.extend(issue_blocks)
    lines.extend(
        [
            "## 相关链接",
            "",
            f"- [GitHub 仓库]({BASE})",
            f"- [Issues 讨论区]({BASE}/issues)",
            f"- [{ISSUE_PREFIX} 面试提纲总目录 Issue #{INDEX_ISSUE_NUM}]({BASE}/issues/{INDEX_ISSUE_NUM})",
            "- [LeetCode 中国站](https://leetcode-cn.com/)",
            "- [labuladong 算法小抄](https://github.com/labuladong/fucking-algorithm)",
            "",
        ]
    )
    return "\n".join(lines)


def main():
    issues = gh_api(f"repos/{REPO}/issues?state=all&per_page=100")
    issues = [i for i in issues if "pull_request" not in i]
    issues.sort(key=lambda x: x["number"])

    content = build_page(issues)
    OUTPUT.write_text(content, encoding="utf-8")
    print(f"Generated {OUTPUT} ({len(content)} chars)", file=sys.stderr)


if __name__ == "__main__":
    main()
