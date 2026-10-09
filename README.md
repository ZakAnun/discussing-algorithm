# discussing-algorithm

个人算法刷题与面试复习仓库：Java 题解 + GitHub Issues 笔记 + Pages 归档。

## 工程作用

| 模块 | 作用 |
|------|------|
| 面试主线 | 2026-09 · 9 Topic / 29 题 |
| Issues | 按 Topic 记思路（[#5](https://github.com/ZakAnun/discussing-algorithm/issues/5) 总目录，[#6](https://github.com/ZakAnun/discussing-algorithm/issues/6)–[#14](https://github.com/ZakAnun/discussing-algorithm/issues/14)） |
| Pages | [在线速查](https://zakanun.github.io/discussing-algorithm/)：核心要点 + 题解链接 |
| 历史代码 | 早期每日一题、树练习等 |

题目来自 [LeetCode 中国站](https://leetcode-cn.com/)，思路参考 [labuladong](https://github.com/labuladong/fucking-algorithm)。欢迎在 Issue 讨论。

**29 题路径**：`app/src/main/java/com/zak/da/template/leetcode/editor/cn/`

## 目录

```text
app/src/main/java/com/zak/da/
  template/leetcode/editor/cn/   # 题解（含 29 题）
  tree/  daily/                  # 早期练习
scripts/
  generate-pages.py              # 生成 docs/index.md
  interview_sections.py          # 提纲与核心要点数据
  run-demo.sh                    # 单题运行
docs/                            # GitHub Pages
```

## 本地运行

需 Java 11 跑 Gradle（编译目标 Java 8）。仓库根目录：

```bash
bash scripts/run-demo.sh app/src/main/java/com/zak/da/template/leetcode/editor/cn/TwoSum.java
```

## 更新 Pages

```bash
cd scripts && python3 generate-pages.py
```

提交 `docs/index.md` 并 push `master` 后生效。
