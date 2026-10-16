#!/usr/bin/env python3
"""从 GitHub Issues 生成 docs/index.md（GitHub Pages 完整内容页）。"""

import html
import json
import re
import subprocess
import sys
import time
from pathlib import Path

from interview_sections import (
    BASE_URL,
    FIRST_TOPIC_ISSUE_NUM,
    GITHUB_CN,
    INDEX_ISSUE_NUM,
    ISSUE_PREFIX,
    SECTIONS,
    TOPIC_CORES,
    TOPIC_REVIEW,
    item_by_class,
    topic_issue_number,
)

REPO = "ZakAnun/discussing-algorithm"
BASE = f"https://github.com/{REPO}"
ROOT = Path(__file__).resolve().parent.parent
OUTPUT = ROOT / "docs" / "index.md"
SIDEBAR_INCLUDE = ROOT / "docs" / "_includes" / "interview-sidebar.html"
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
    multiline: bool = False,
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
        parts.append(f"[{e['label']}](#{e['anchor']})")
    sep = "<br>" if multiline else " · "
    return sep.join(parts)


def build_topic_cores_block() -> list[str]:
    """9 个 Topic 核心要点（放在题目速查表之前）。"""
    cores_anchor = "interview-topic-cores"
    lines = [
        f"### Topic 核心要点",
        "",
        f'<a id="{cores_anchor}"></a>',
        "",
        "进考场先扫本表：每个 Topic **口诀 → 备案（忘题时先问自己）→ 复杂度直觉**。"
        " 面试陈述顺序：题意边界 → 模型 → 复杂度 → 编码 → 样例 + 边界。",
        "",
        '<div class="table-scroll" markdown="1">',
        "",
        "| Topic | 核心口诀 | 备案（忘题先问） | 复杂度直觉 |",
        "| --- | --- | --- | --- |",
    ]
    for idx, core in enumerate(TOPIC_CORES, start=1):
        issue_num = topic_issue_number(idx)
        topic_link = (
            f"{idx}. [{core['topic']}](#{anchor_id(issue_num, 'overview')})"
        )
        lines.append(
            f"| {topic_link} | {core['motto']} | {core['backup']} | {core['complexity']} |"
        )
    lines.extend(["", "</div>", ""])
    return lines


def problem_link(class_name: str) -> str:
    item = item_by_class(class_name)
    if not item:
        return class_name
    cn, _diff, _point, num, slug, cls = item
    lc = f"{BASE_URL}/{slug}/"
    code = f"{GITHUB_CN}/{cls}.java"
    return f"[{cn}]({lc}) · [题解 `{cls}`]({code})"


def build_topic_review_block() -> list[str]:
    """9 Topic 闭卷复习卡（代表题 / 轮转题 / 坑 / 验收；详笔记链到 Issue 归档）。"""
    review_anchor = "interview-topic-review"
    lines = [
        "### 闭卷复习卡（9 Topic）",
        "",
        f'<a id="{review_anchor}"></a>',
        "",
        "**用法（比通读 Issue 更有效）**",
        "",
        "1. **先遮住题解**：只看本节 + [核心要点](#interview-topic-cores)，闭卷写 **代表题**。",
        "2. **D+1** 写代表题，**D+3** 写 **轮转题**，**D+7** 九 Topic 各练 15 分钟骨架。",
        "3. 卡壳再打开题解 Java；坑点以本节为准，展开见 [Issue 笔记](#issue-6-comment-3-0) 链接。",
        "4. 新题推演四问：属于哪 Topic → motto 哪句 → 状态/path 一句话 → 与本 Topic 哪题同型。",
        "",
    ]
    for idx, (core, review) in enumerate(zip(TOPIC_CORES, TOPIC_REVIEW), start=1):
        issue_num = topic_issue_number(idx)
        issue_notes = review["issue_notes"]
        note_link = (
            f"[Issue {issue_notes[0]} · {issue_notes[1]}](#{issue_notes[2]})"
        )
        anchor = problem_link(review["anchor_class"])
        relay = problem_link(review["relay_class"])
        if review["anchor_class"] == review["relay_class"]:
            relay_line = f"- **闭卷题**：{anchor}"
        else:
            relay_line = (
                f"- **代表题（D+1）**：{anchor}  \n"
                f"- **轮转题（D+3）**：{relay}"
            )
        lines.append(f'<a id="interview-review-topic-{idx}"></a>')
        lines.append(f"#### {idx}. {core['topic']}")
        lines.append("")
        lines.append(relay_line)
        lines.append(f"- **认型**：{review['triggers']}")
        lines.append(f"- **口诀 / 备案**：{core['motto']} · _{core['backup']}_")
        lines.append("- **常见坑（Issue 提炼）**：")
        for p in review["pitfalls"]:
            lines.append(f"  - {p}")
        lines.append(f"- **闭卷验收**：{review['acceptance']}")
        lines.append(
            f"- **Issue 详笔记**：{note_link} · "
            f"[Topic 归档](#{anchor_id(issue_num, 'overview')})"
        )
        lines.append("")
    lines.extend(["---", ""])
    return lines


def build_interview_hub(
    issues_by_num: dict[int, dict],
    notes_index: dict[str, list[dict]],
) -> tuple[list[str], list[str]]:
    """面试提纲：Topic 核心要点 + 题目速查表 + 各 Topic 子目录。"""
    hub_anchor = "interview-outline-2026-09"
    cores_anchor = "interview-topic-cores"
    review_anchor = "interview-topic-review"
    lines = [
        f"## {ISSUE_PREFIX} 面试刷题提纲速查",
        "",
        f'<a id="{hub_anchor}"></a>',
        "",
        "复习入口：**[闭卷复习卡](#" + review_anchor + ")**（代表题 / 坑 / 验收）→ "
        "**[Topic 核心要点](#" + cores_anchor + ")** → 题目速查表 → Issue 详笔记。",
        "",
        f"总目录 Issue：[#{INDEX_ISSUE_NUM}]({BASE}/issues/{INDEX_ISSUE_NUM}) · "
        f"[本页归档](#{anchor_id(INDEX_ISSUE_NUM, 'overview')})",
        "",
    ]
    lines.extend(build_topic_review_block())
    lines.extend(build_topic_cores_block())
    lines.extend(
        [
            "### 题目速查表",
            "",
            "（表格较宽时可 **左右滑动** 查看；「笔记」为页内锚点，完整讨论见对应 Issue。）",
            "",
            '<div class="table-scroll" markdown="1">',
            "",
            "| 模块 | 题目 | 难度 | 题解 | Issue · 笔记 |",
            "| --- | --- | --- | --- | --- |",
        ]
    )

    topic_toc = [
        f"- [{ISSUE_PREFIX} 面试刷题提纲速查](#{hub_anchor})",
        f"  - [闭卷复习卡](#{review_anchor})",
        f"  - [Topic 核心要点](#{cores_anchor})",
        f"  - [题目速查表](#{hub_anchor})",
    ]

    for topic_idx, section in enumerate(SECTIONS, start=1):
        issue_num = topic_issue_number(topic_idx)
        issue = issues_by_num.get(issue_num)
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

            notes_cell = index_note_for_slug(slug, notes_index, multiline=True)
            issue_notes = f"[#{issue_num}]({issue_page}) · [GitHub]({issue_gh})"
            if notes_cell != "—":
                issue_notes += f"<br>{notes_cell}"
            title_cell = f"[{cn}]({lc}) · LC #{num}"
            module_cell = f"{section['title'].split('.')[0].strip()}<br>{section['topic']}"
            lines.append(
                f"| {module_cell} | {title_cell} | {diff} | {code_cell} | {issue_notes} |"
            )

    lines.extend(["", "</div>", "", "---", ""])
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
        f" **{ISSUE_PREFIX} 面试提纲** 复习请先看 **闭卷复习卡**，再查核心要点与题解链接。",
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


def write_interview_sidebar(issues: list[dict]) -> None:
    """生成左侧可折叠导航（与提纲数据同步）。"""
    lines = [
        '<nav class="sidebar-nav" aria-label="页面导航">',
        '  <p class="sidebar-nav-heading">本页导航</p>',
        "",
        '  <details class="sidebar-group" open>',
        f"    <summary>{ISSUE_PREFIX} 面试提纲</summary>",
        '    <ul class="sidebar-list">',
        '      <li><a href="#interview-outline-2026-09">提纲速查</a></li>',
        '      <li><a href="#interview-topic-review">闭卷复习卡</a></li>',
        '      <li><a href="#interview-topic-cores">Topic 核心要点</a></li>',
        "    </ul>",
        "",
        '    <details class="sidebar-group sidebar-group-nested" open>',
        "      <summary>9 Topic · 题解</summary>",
    ]
    for topic_idx, section in enumerate(SECTIONS, start=1):
        issue_num = topic_issue_number(topic_idx)
        topic_label = html.escape(section["topic"])
        overview = anchor_id(issue_num, "overview")
        review = f"interview-review-topic-{topic_idx}"
        lines.append('      <details class="sidebar-group sidebar-group-nested">')
        lines.append(f"        <summary>{topic_idx}. {topic_label}</summary>")
        lines.append('        <ul class="sidebar-list">')
        lines.append(f'          <li><a href="#{review}">复习卡</a></li>')
        lines.append(f'          <li><a href="#{overview}">Issue #{issue_num}</a></li>')
        for cn, _diff, _point, _num, _slug, class_name in section["items"]:
            cn_esc = html.escape(cn)
            code_url = f"{GITHUB_CN}/{class_name}.java"
            lines.append(
                f'          <li><a href="{code_url}" target="_blank" rel="noopener">'
                f"{cn_esc}</a></li>"
            )
        lines.append("        </ul>")
        lines.append("      </details>")
    lines.extend(
        [
            "    </details>",
            "  </details>",
            "",
            '  <details class="sidebar-group">',
            "    <summary>Issue 归档</summary>",
            '    <ul class="sidebar-list">',
        ]
    )
    for issue in issues:
        num = issue["number"]
        title = html.escape(issue.get("title") or f"Issue {num}")
        if len(title) > 42:
            title = title[:39] + "…"
        overview = anchor_id(num, "overview")
        lines.append(f'      <li><a href="#{overview}">#{num} {title}</a></li>')
    lines.extend(
        [
            "    </ul>",
            "  </details>",
            "",
            '  <details class="sidebar-group">',
            "    <summary>相关链接</summary>",
            '    <ul class="sidebar-list">',
            f'      <li><a href="{BASE}/issues/{INDEX_ISSUE_NUM}">提纲 Issue #{INDEX_ISSUE_NUM}</a></li>',
            f'      <li><a href="{BASE}/issues">Issues 讨论区</a></li>',
            '      <li><a href="https://leetcode-cn.com/">LeetCode</a></li>',
            "    </ul>",
            "  </details>",
            "</nav>",
            "",
        ]
    )
    SIDEBAR_INCLUDE.parent.mkdir(parents=True, exist_ok=True)
    SIDEBAR_INCLUDE.write_text("\n".join(lines), encoding="utf-8")


def main():
    issues = gh_api(f"repos/{REPO}/issues?state=all&per_page=100")
    issues = [i for i in issues if "pull_request" not in i]
    issues.sort(key=lambda x: x["number"])

    content = build_page(issues)
    OUTPUT.write_text(content, encoding="utf-8")
    write_interview_sidebar(issues)
    print(f"Generated {OUTPUT} ({len(content)} chars)", file=sys.stderr)
    print(f"Generated {SIDEBAR_INCLUDE}", file=sys.stderr)


if __name__ == "__main__":
    main()
