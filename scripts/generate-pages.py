#!/usr/bin/env python3
"""从 GitHub Issues 生成 docs/index.md（GitHub Pages 完整内容页）。"""

import json
import re
import subprocess
import sys
from pathlib import Path

REPO = "ZakAnun/discussing-algorithm"
BASE = f"https://github.com/{REPO}"
ROOT = Path(__file__).resolve().parent.parent
OUTPUT = ROOT / "docs" / "index.md"

DATE_RE = re.compile(r"\*\*(\d{4}\.\d{2}\.\d{2})\*\*")
PROBLEM_RE = re.compile(r"\[([^\]]+)\]\((https://leetcode-cn\.com/problems/[^)]+)\)")


def gh_api(path: str):
    result = subprocess.run(
        ["gh", "api", path, "--paginate"],
        capture_output=True,
        text=True,
        check=True,
    )
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
    return text.replace("\r\n", "\n").strip()


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


def render_section(title: str, anchor: str, content: str, lines: list):
    lines.extend([f"#### {title}", "", f"<a id=\"{anchor}\"></a>", ""])
    if content:
        lines.append(content)
    else:
        lines.append("_（无正文）_")
    lines.append("")


def build_issue_block(issue: dict) -> tuple[str, int, int]:
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

    sub_toc = []
    section_count = 0
    problem_count = count_problems(body)

    # Issue 正文
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

    # 评论（按时间顺序）
    for comment_idx, comment in enumerate(comments, start=1):
        comment_body = comment.get("body") or ""
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
            else:
                section_title = f"评论 #{comment_idx}（{created}）"
                label = f"comment-{comment_idx}-{sec_idx}"
            anchor = anchor_id(num, label)
            sub_toc.append((section_title, anchor))
            render_section(section_title, anchor, content, lines)

    lines.extend(["---", ""])

    toc_lines = [f"- [#{num} {title}](#{issue_anchor})"]
    for section_title, anchor in sub_toc:
        toc_lines.append(f"  - [{section_title}](#{anchor})")

    block = "\n".join(lines)
    return block, section_count, problem_count, toc_lines


def build_page(issues):
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
        "本页完整归档 GitHub Issues 中的刷题笔记（含正文与全部评论）。",
        "",
        "---",
        "",
        "## 目录",
        "",
    ]

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
