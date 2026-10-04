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


def topic_issue_number(topic_index: int) -> int:
    """Topic 1..9 → GitHub Issue #6..#14."""
    return FIRST_TOPIC_ISSUE_NUM + topic_index - 1
