#!/usr/bin/env python3
"""从 GitHub Issues 生成 docs/index.md（GitHub Pages 首页）。"""

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


def clean_snippet(text: str, limit: int = 100) -> str:
    text = re.sub(r"\[([^\]]+)\]\([^)]+\)", r"\1", text)
    text = re.sub(r"!\[[^\]]*\]\([^)]+\)", "", text)
    text = re.sub(r"[`#>*_\r\n]+", " ", text).strip()
    text = re.sub(r"\s+", " ", text)
    return text[:limit]


def extract_entries(text: str):
    entries = []
    parts = DATE_RE.split(text or "")
    if len(parts) == 1:
        problems = PROBLEM_RE.findall(text or "")
        if problems:
            entries.append(
                {
                    "date": None,
                    "problems": problems,
                    "snippet": clean_snippet(text or ""),
                }
            )
        return entries

    for i in range(1, len(parts), 2):
        date = parts[i]
        content = parts[i + 1] if i + 1 < len(parts) else ""
        entries.append(
            {
                "date": date,
                "problems": PROBLEM_RE.findall(content),
                "snippet": clean_snippet(content),
            }
        )
    return entries


def sort_key(entry):
    return entry["date"] or "0000.00.00"


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
        "完整讨论见 GitHub Issues，本页为 Issue 内容索引与题目汇总。",
        "",
        "---",
        "",
        "## Issue 目录",
        "",
    ]

    all_entry_count = 0
    all_problem_count = 0
    issue_blocks = []

    for issue in issues:
        num = issue["number"]
        title = issue["title"]
        state = issue["state"].lower()
        url = issue["html_url"]
        body = issue.get("body") or ""

        comments = gh_api(f"repos/{REPO}/issues/{num}/comments")
        entries = extract_entries(body)
        for comment in comments:
            entries.extend(extract_entries(comment.get("body") or ""))

        entries = [e for e in entries if e["problems"] or e["snippet"]]
        entries.sort(key=sort_key)

        problem_count = sum(len(e["problems"]) for e in entries)
        all_entry_count += len(entries)
        all_problem_count += problem_count

        lines.append(
            f"- [#{num} {title}]({url}) — {len(entries)} 条记录，"
            f"{problem_count} 道题 ({state})"
        )

        block = [f"## [#{num} {title}]({url})", ""]
        intro = clean_snippet(body, 200)
        if intro and not DATE_RE.search(body):
            block.extend([f"> {intro}", ""])

        if not entries:
            block.extend(["_暂无记录_", ""])
        else:
            block.extend(
                [
                    "| 日期 | 题目 | 备注 |",
                    "| --- | --- | --- |",
                ]
            )
            for entry in entries:
                date = entry["date"] or "—"
                if entry["problems"]:
                    links = "<br>".join(
                        f"[{name}]({link})" for name, link in entry["problems"]
                    )
                else:
                    links = "—"
                snippet = (entry["snippet"] or "—").replace("|", "\\|")
                if len(snippet) > 80:
                    snippet = snippet[:77] + "..."
                block.append(f"| {date} | {links} | {snippet} |")

        block.extend(["", f"[查看完整讨论 →]({url})", "", "---", ""])
        issue_blocks.append("\n".join(block))

    lines.extend(
        [
            "",
            f"**合计：** {len(issues)} 个 Issue，{all_entry_count} 条刷题记录，"
            f"约 {all_problem_count} 道题。",
            "",
            "---",
            "",
        ]
    )
    lines.extend(issue_blocks)
    lines.extend(
        [
            "",
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

    OUTPUT.write_text(build_page(issues), encoding="utf-8")
    print(f"Generated {OUTPUT}", file=sys.stderr)


if __name__ == "__main__":
    main()
