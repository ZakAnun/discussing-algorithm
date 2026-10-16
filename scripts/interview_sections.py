"""面试刷题提纲静态数据（供 generate-pages 与 create-interview-outline 共用）。"""

BASE_URL = "https://leetcode-cn.com/problems"
GITHUB_CN = (
    "https://github.com/ZakAnun/discussing-algorithm/blob/master"
    "/app/src/main/java/com/zak/da/template/leetcode/editor/cn"
)
ISSUE_PREFIX = "2026-09"
INDEX_ISSUE_NUM = 5
FIRST_TOPIC_ISSUE_NUM = 6

# (中文名, 难度, 考点, LeetCode题号, slug, Java类名)
SectionItem = tuple[str, str, str, int, str, str]

# Topic 核心要点（Pages 首页速查表上方；口诀 / 备案与面试附录对齐）
# motto: 一句话口诀；backup: 忘题时先想什么；complexity: 复杂度直觉
TOPIC_CORES: list[dict[str, str]] = [
    {
        "topic": "哈希/数组",
        "motto": "别暴力扫；连续 / 区间 → Set 或排序",
        "backup": "能 O(1) 查吗？区间要先排序吗？",
        "complexity": "扫一遍 O(n)",
    },
    {
        "topic": "链表",
        "motto": "指针游戏；倒数 / 环 → 快慢针；random → HashMap 两遍",
        "backup": "dummy？快慢针？改 next 前存 successor？",
        "complexity": "一般 O(n)",
    },
    {
        "topic": "二叉树",
        "motto": "深度/验证 → 递归+边界；层序 → BFS；LCA → 后序；建树 → 前序根+中序分左右",
        "backup": "递归返回什么？BFS 用 queue + 每层 size？",
        "complexity": "O(n)",
    },
    {
        "topic": "栈/队列",
        "motto": "最小值 → 同步最小栈；下一个更大 → 单调栈存下标",
        "backup": "设计题双栈？「下一个更大」→ 单调栈存下标",
        "complexity": "均摊 O(1) / O(n)",
    },
    {
        "topic": "二分查找",
        "motto": "有序 → while(l<=r)；旋转 → 至少一半有序，判 target 在哪半",
        "backup": "l<=r，旋转数组哪半边有序？",
        "complexity": "O(log n)",
    },
    {
        "topic": "双指针/滑动窗口",
        "motto": "连续子串/子数组 → 扩右收左；盛水 → 移较短边",
        "backup": "右扩、不满足则左缩；盛水移短板",
        "complexity": "O(n)",
    },
    {
        "topic": "动态规划",
        "motto": "写清 dp 含义；子数组最大和 → Kadane",
        "backup": "dp[i] 一句话含义 + 从 i-1/i-2 转移",
        "complexity": "看维度",
    },
    {
        "topic": "设计题",
        "motto": "LRU = HashMap 定位 + 双向链表管顺序",
        "backup": "get/put 都要 moveToHead；满则删尾",
        "complexity": "get/put O(1)",
    },
    {
        "topic": "BFS/DFS/回溯",
        "motto": "网格 '1' → DFS 沉岛；排列 used；子集 选/不选 或 start",
        "backup": "沉岛 DFS；回溯 选→递归→撤销",
        "complexity": "视状态空间",
    },
]

# 闭卷复习卡（与 TOPIC_CORES 同序 9 项；坑点摘自 Issue #6–#14 笔记）
# anchor_class / relay_class：Java 类名，对应 SECTIONS 中题目
TOPIC_REVIEW: list[dict] = [
    {
        "anchor_class": "ThreeSum",
        "relay_class": "LongestConsecutiveSequence",
        "triggers": "查互补、在不在 → 哈希；连续整数段 → Set 只从链头数；多数字和/去重组合 → 排序+双指针；区间能否接 → 按起点排序",
        "pitfalls": [
            "最长连续序列：遍历 Set 而非原数组；只从没有 x-1 的位置往后数",
            "三数之和：i 固定后 l/r 夹逼；sum==0 后跳过重复下标",
            "合并区间：按 start 排序，只跟结果里最后一段比 end",
            "要返回下标时不能先排序（两数之和）",
        ],
        "acceptance": "20 分钟闭卷写出三数之和（含去重）；30 秒口述两数之和 Map 查 target−x",
        "issue_notes": ("#6", "概括总结", "issue-6-comment-3-0"),
    },
    {
        "anchor_class": "LinkedListCycleIi",
        "relay_class": "ReverseLinkedList",
        "triggers": "改 next → 先存后继；倒数第 k / 环 → dummy+快慢针；random → Map 两遍建链",
        "pitfalls": [
            "反转：先 next=cur.next 再改 cur.next，最后 cur=next",
            "环入口：快慢相遇后，head 与相遇点同步走再遇即入口",
            "删倒数第 n 个：dummy，快指针先走 n+1 步",
            "复制 random：第一遍 Map 旧→新，第二遍接 next/random",
        ],
        "acceptance": "15 分钟闭卷写出环入口 + 迭代反转；口述 dummy 快指针 n+1 步",
        "issue_notes": ("#7", "2026.09.25", "issue-7-comment-1-2026-09-25"),
    },
    {
        "anchor_class": "ConstructBinaryTreeFromPreorderAndInorderTraversal",
        "relay_class": "LowestCommonAncestorOfABinaryTree",
        "triggers": "按层 → BFS+queue+每层 size；深度 → 递归 max(左,右)+1；BST → 上下界；LCA → 后序看左右返回值",
        "pitfalls": [
            "验证 BST：val 与 (low,high) 比，不能只看父节点",
            "层序：入队前判 null，一层处理 size 次",
            "LCA：左右都非空则当前为答案，否则返回非空一侧",
            "建树：前序[0] 为根，中序定位 leftSize，再切前/中序子数组",
        ],
        "acceptance": "25 分钟闭卷写出前序+中序建树或 LCA 其一；口述 BST 上下界",
        "issue_notes": ("#8", "2026.09.27", "issue-8-comment-1-2026-09-27"),
    },
    {
        "anchor_class": "DailyTemperatures",
        "relay_class": "MinStack",
        "triggers": "下一个更大/更小 → 单调栈存下标；O(1) 最小值 → 同步 min 栈",
        "pitfalls": [
            "每日温度：栈存下标，当前更高时弹栈算 i−prev",
            "最小栈：push 时 minStack 同步 push min(x, 栈顶)",
            "场景翻译：「等几天更暖」= 下一个更大元素距离",
        ],
        "acceptance": "15 分钟闭卷写出单调栈版每日温度 + 最小栈 push/pop 同步",
        "issue_notes": ("#9", "2026.09.28", "issue-9-comment-1-2026-09-28"),
    },
    {
        "anchor_class": "SearchInRotatedSortedArray",
        "relay_class": "SearchInsertPosition",
        "triggers": "有序 → while(l<=r)；旋转 → 至少一半有序，判 target 落在哪半",
        "pitfalls": [
            "搜索插入位置：结束时 return left（不是 0）",
            "旋转数组：先判 [left,mid] 或 [mid,right] 哪段有序，再缩区间",
            "有序前提不满足时不能裸二分",
        ],
        "acceptance": "15 分钟闭卷写出旋转数组二分；口述插入位置 return left",
        "issue_notes": ("#10", "2026.09.29", "issue-10-comment-1-2026-09-29"),
    },
    {
        "anchor_class": "LongestSubstringWithoutRepeatingCharacters",
        "relay_class": "MinimumSizeSubarraySum",
        "triggers": "窗口合法条件明确（无重复 / sum≥target）→ 扩右收左；无目标、要最大面积/和 → 别硬套窗口（盛水移短板）",
        "pitfalls": [
            "无重复子串：lastIndex.get(c) >= left 才算窗口内重复",
            "最小长度子数组：正整数 sum≥target 时左缩求更短；从未达标 return 0",
            "盛水：移较短边，left<right 不是 left<=right",
        ],
        "acceptance": "20 分钟闭卷写出无重复子串 + 最小长度子数组；口述盛水为何移短板",
        "issue_notes": ("#11", "2026.09.30", "issue-11-comment-1-2026-09-30"),
    },
    {
        "anchor_class": "MaximumSubarray",
        "relay_class": "HouseRobber",
        "triggers": "能由更小规模拼 → 先写 dp 含义一句；最后一步有哪些选择 → 转移",
        "pitfalls": [
            "最大子数组：dp=以 i 结尾最大和，答案要另存 maxEndingHere 的全局 max",
            "打家劫舍：max(dp[i-1], dp[i-2]+nums[i])，不是奇偶两条链",
            "爬楼梯：滚动变量是 dp[i-1]/dp[i-2]，答案在 oneStepBack",
            "LIS：lisEndingAt[i] 必须以 i 结尾，答案 max(表)",
        ],
        "acceptance": "20 分钟闭卷写出 Kadane + 打家劫舍；能写 LIS 的 O(n²) 双重循环",
        "issue_notes": ("#12", "2026.10.03", "issue-12-comment-1-2026-10-03"),
    },
    {
        "anchor_class": "LruCache",
        "relay_class": "LruCache",
        "triggers": "O(1) 查 + 按访问顺序淘汰 → Map 定位 + 双向链表维序",
        "pitfalls": [
            "get/put 命中都要 moveToHead；满容 insert 先删 tail 再 map.remove",
            "手写链表是为 O(1) 按节点删；JDK LinkedList 按值删是 O(n)",
            "写不出代码也要能口述 Map+链表分工与四步操作",
        ],
        "acceptance": "25 分钟闭卷写出 Map+哑结点双向链表 LRU，或白板讲清 get/put 流程",
        "issue_notes": ("#13", "2026.10.04", "issue-13-comment-1-2026-10-04"),
    },
    {
        "anchor_class": "NumberOfIslands",
        "relay_class": "Permutations",
        "triggers": "网格连通块 → 计数+DFS/BFS 标掉；枚举排列 → used+选满再收；子集 → 入口即收集+start",
        "pitfalls": [
            "岛屿：见 '1' 则 islands++ 再 sink；先改 '0' 再四向递归防死循环",
            "全排列：path 选满 n 才收集；递归返回必须撤销 path/used",
            "子集：一进 backtrack 就 add(path)；for 从 start 到 n-1",
        ],
        "acceptance": "20 分钟闭卷写出沉岛 DFS + 全排列回溯；口述子集与排列收集时机差别",
        "issue_notes": ("#14", "2026.10.04", "issue-14-comment-1-2026-10-04"),
    },
]

SECTIONS: list[dict] = [
    {
        "title": "1. 哈希 / 数组（4）",
        "topic": "哈希/数组",
        "items": [
            ("两数之和", "简单", "哈希映射（热身第一题）", 1, "two-sum", "TwoSum"),
            ("最长连续序列", "中等", "哈希集合", 128, "longest-consecutive-sequence", "LongestConsecutiveSequence"),
            ("三数之和", "中等", "排序 + 双指针（高频）", 15, "3sum", "ThreeSum"),
            ("合并区间", "中等", "排序 + 区间（可绑定看板项目）", 56, "merge-intervals", "MergeIntervals"),
        ],
    },
    {
        "title": "2. 链表（5 — 客户端最高频）",
        "topic": "链表",
        "items": [
            ("反转链表", "简单", "必考，迭代+递归都要会", 206, "reverse-linked-list", "ReverseLinkedList"),
            ("环形链表 II", "中等", "快慢指针（高频）", 142, "linked-list-cycle-ii", "LinkedListCycleIi"),
            ("删除链表倒数第 N 个节点", "中等", "快慢指针", 19, "remove-nth-node-from-end-of-list", "RemoveNthNodeFromEndOfList"),
            ("回文链表", "简单", "快慢指针 + 反转", 234, "palindrome-linked-list", "PalindromeLinkedList"),
            ("复制带随机指针的链表", "中等", "哈希 / 拼接拆分", 138, "copy-list-with-random-pointer", "CopyListWithRandomPointer"),
        ],
    },
    {
        "title": "3. 二叉树（5）",
        "topic": "二叉树",
        "items": [
            ("层序遍历", "中等", "BFS + 队列", 102, "binary-tree-level-order-traversal", "BinaryTreeLevelOrderTraversal"),
            ("最大深度", "简单", "递归", 104, "maximum-depth-of-binary-tree", "MaximumDepthOfBinaryTree"),
            ("验证二叉搜索树", "中等", "中序 / 上下界", 98, "validate-binary-search-tree", "ValidateBinarySearchTree"),
            ("最近公共祖先", "中等", "高频", 236, "lowest-common-ancestor-of-a-binary-tree", "LowestCommonAncestorOfABinaryTree"),
            ("从前序与中序构造二叉树", "中等", "递归分治", 105, "construct-binary-tree-from-preorder-and-inorder-traversal", "ConstructBinaryTreeFromPreorderAndInorderTraversal"),
        ],
    },
    {
        "title": "4. 栈 / 队列（2）",
        "topic": "栈/队列",
        "items": [
            ("最小栈", "中等", "辅助栈设计", 155, "min-stack", "MinStack"),
            ("每日温度", "中等", "单调栈（高频模板）", 739, "daily-temperatures", "DailyTemperatures"),
        ],
    },
    {
        "title": "5. 二分查找（2）",
        "topic": "二分查找",
        "items": [
            ("搜索插入位置", "简单", "基础二分", 35, "search-insert-position", "SearchInsertPosition"),
            ("搜索旋转排序数组", "中等", "高频，二分变形", 33, "search-in-rotated-sorted-array", "SearchInRotatedSortedArray"),
        ],
    },
    {
        "title": "6. 双指针 / 滑动窗口（3）",
        "topic": "双指针/滑动窗口",
        "items": [
            ("无重复字符的最长子串", "中等", "滑动窗口（必考模板）", 3, "longest-substring-without-repeating-characters", "LongestSubstringWithoutRepeatingCharacters"),
            ("长度最小的子数组", "中等", "滑动窗口", 209, "minimum-size-subarray-sum", "MinimumSizeSubarraySum"),
            ("盛最多水的容器", "中等", "双指针", 11, "container-with-most-water", "ContainerWithMostWater"),
        ],
    },
    {
        "title": "7. 动态规划（4 — 只刷基础经典）",
        "topic": "动态规划",
        "items": [
            ("爬楼梯", "简单", "DP 入门", 70, "climbing-stairs", "ClimbingStairs"),
            ("最大子数组和", "中等", "Kadane（高频）", 53, "maximum-subarray", "MaximumSubarray"),
            ("打家劫舍", "中等", "一维 DP", 198, "house-robber", "HouseRobber"),
            ("最长递增子序列", "中等", "高频，O(n²) 即可", 300, "longest-increasing-subsequence", "LongestIncreasingSubsequence"),
        ],
    },
    {
        "title": "8. 设计题（1 — 性价比最高）",
        "topic": "设计题",
        "items": [
            ("LRU 缓存", "中等", "哈希 + 双向链表（极高频，可绑定 Android LruCache）", 146, "lru-cache", "LruCache"),
        ],
    },
    {
        "title": "9. BFS / DFS / 回溯（3）",
        "topic": "BFS/DFS/回溯",
        "items": [
            ("岛屿数量", "中等", "DFS/BFS（必考）", 200, "number-of-islands", "NumberOfIslands"),
            ("全排列", "中等", "回溯模板", 46, "permutations", "Permutations"),
            ("子集", "中等", "回溯", 78, "subsets", "Subsets"),
        ],
    },
]


def item_by_class(class_name: str) -> SectionItem | None:
    for section in SECTIONS:
        for item in section["items"]:
            if item[5] == class_name:
                return item
    return None


def topic_issue_number(topic_index: int) -> int:
    """Topic 1..9 → GitHub Issue #6..#14."""
    return FIRST_TOPIC_ISSUE_NUM + topic_index - 1
