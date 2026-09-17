#!/usr/bin/env python3
"""生成面试刷题提纲对应的 Java 模板文件（已存在则跳过）。"""

from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
CN_DIR = ROOT / "app/src/main/java/com/zak/da/template/leetcode/editor/cn"
PKG = "com.zak.da.template.leetcode.editor.cn"
BASE_URL = "https://leetcode-cn.com/problems"
GITHUB_BASE = "https://github.com/ZakAnun/discussing-algorithm/blob/master/app/src/main/java/com/zak/da/template/leetcode/editor/cn"

ISSUE_PREFIX = "2026-09"

SECTIONS = [
    {
        "title": "1. 哈希 / 数组（4）",
        "topic": "哈希/数组",
        "items": [
            ("两数之和", "简单", "哈希映射（热身第一题）", 1, "two-sum", "TwoSum", True),
            ("最长连续序列", "中等", "哈希集合", 128, "longest-consecutive-sequence", "LongestConsecutiveSequence", False),
            ("三数之和", "中等", "排序 + 双指针（高频）", 15, "3sum", "ThreeSum", False),
            ("合并区间", "中等", "排序 + 区间（可绑定看板项目）", 56, "merge-intervals", "MergeIntervals", False),
        ],
    },
    {
        "title": "2. 链表（5 — 客户端最高频）",
        "topic": "链表",
        "items": [
            ("反转链表", "简单", "必考，迭代+递归都要会", 206, "reverse-linked-list", "ReverseLinkedList", True),
            ("环形链表 II", "中等", "快慢指针（高频）", 142, "linked-list-cycle-ii", "LinkedListCycleIi", False),
            ("删除链表倒数第 N 个节点", "中等", "快慢指针", 19, "remove-nth-node-from-end-of-list", "RemoveNthNodeFromEndOfList", False),
            ("回文链表", "简单", "快慢指针 + 反转", 234, "palindrome-linked-list", "PalindromeLinkedList", False),
            ("复制带随机指针的链表", "中等", "哈希 / 拼接拆分", 138, "copy-list-with-random-pointer", "CopyListWithRandomPointer", True),
        ],
    },
    {
        "title": "3. 二叉树（5）",
        "topic": "二叉树",
        "items": [
            ("层序遍历", "中等", "BFS + 队列", 102, "binary-tree-level-order-traversal", "BinaryTreeLevelOrderTraversal", False),
            ("最大深度", "简单", "递归", 104, "maximum-depth-of-binary-tree", "MaximumDepthOfBinaryTree", False),
            ("验证二叉搜索树", "中等", "中序 / 上下界", 98, "validate-binary-search-tree", "ValidateBinarySearchTree", False),
            ("最近公共祖先", "中等", "高频", 236, "lowest-common-ancestor-of-a-binary-tree", "LowestCommonAncestorOfABinaryTree", False),
            ("从前序与中序构造二叉树", "中等", "递归分治", 105, "construct-binary-tree-from-preorder-and-inorder-traversal", "ConstructBinaryTreeFromPreorderAndInorderTraversal", False),
        ],
    },
    {
        "title": "4. 栈 / 队列（2）",
        "topic": "栈/队列",
        "items": [
            ("最小栈", "中等", "辅助栈设计", 155, "min-stack", "MinStack", False),
            ("每日温度", "中等", "单调栈（高频模板）", 739, "daily-temperatures", "DailyTemperatures", False),
        ],
    },
    {
        "title": "5. 二分查找（2）",
        "topic": "二分查找",
        "items": [
            ("搜索插入位置", "简单", "基础二分", 35, "search-insert-position", "SearchInsertPosition", False),
            ("搜索旋转排序数组", "中等", "高频，二分变形", 33, "search-in-rotated-sorted-array", "SearchInRotatedSortedArray", False),
        ],
    },
    {
        "title": "6. 双指针 / 滑动窗口（3）",
        "topic": "双指针/滑动窗口",
        "items": [
            ("无重复字符的最长子串", "中等", "滑动窗口（必考模板）", 3, "longest-substring-without-repeating-characters", "LongestSubstringWithoutRepeatingCharacters", False),
            ("长度最小的子数组", "中等", "滑动窗口", 209, "minimum-size-subarray-sum", "MinimumSizeSubarraySum", False),
            ("盛最多水的容器", "中等", "双指针", 11, "container-with-most-water", "ContainerWithMostWater", False),
        ],
    },
    {
        "title": "7. 动态规划（4 — 只刷基础经典）",
        "topic": "动态规划",
        "items": [
            ("爬楼梯", "简单", "DP 入门", 70, "climbing-stairs", "ClimbingStairs", False),
            ("最大子数组和", "中等", "Kadane（高频）", 53, "maximum-subarray", "MaximumSubarray", False),
            ("打家劫舍", "中等", "一维 DP", 198, "house-robber", "HouseRobber", False),
            ("最长递增子序列", "中等", "高频，O(n²) 即可", 300, "longest-increasing-subsequence", "LongestIncreasingSubsequence", False),
        ],
    },
    {
        "title": "8. 设计题（1 — 性价比最高）",
        "topic": "设计题",
        "items": [
            ("LRU 缓存", "中等", "哈希 + 双向链表（极高频，可绑定 Android LruCache）", 146, "lru-cache", "LruCache", True),
        ],
    },
    {
        "title": "9. BFS / DFS / 回溯（3）",
        "topic": "BFS/DFS/回溯",
        "items": [
            ("岛屿数量", "中等", "DFS/BFS（必考）", 200, "number-of-islands", "NumberOfIslands", False),
            ("全排列", "中等", "回溯模板", 46, "permutations", "Permutations", False),
            ("子集", "中等", "回溯", 78, "subsets", "Subsets", False),
        ],
    },
]

TEMPLATES = {
    "array_int": '''        int[] nums = {{demo}};
        System.out.println(java.util.Arrays.toString(solution.{method}(nums{extra})));''',
    "linked_list": '''        ListNode head = {demo};
        ListNode result = solution.{method}(head);
        if (result != null) {{
            result.print();
        }} else {{
            System.out.println("null");
        }}''',
    "tree": '''        import com.zak.da.tree.BinaryTreeNode;
        BinaryTreeNode root = {demo};
        System.out.println(solution.{method}(root));''',
    "design": '''        {class_name} obj = new {class_name}({demo});
        System.out.println("initialized");''',
    "grid": '''        char[][] grid = {demo};
        System.out.println(solution.{method}(grid));''',
    "string": '''        String s = "{demo}";
        System.out.println(solution.{method}(s{extra}));''',
}

SIGNATURES = {
    "TwoSum": ("int[]", "twoSum", "array_int", "[2,7,11,15]", ", 9"),
    "LongestConsecutiveSequence": ("int", "longestConsecutive", "array_int", "[100,4,200,1,3,2]", ""),
    "ThreeSum": ("java.util.List", "threeSum", "array_int", "[-1,0,1,2,-1,-4]", ""),
    "MergeIntervals": ("int[][]", "merge", "array_int", "[[1,3],[2,6],[8,10],[15,18]]", ""),
    "ReverseLinkedList": None,
    "LinkedListCycleIi": ("ListNode", "detectCycle", "linked_list", "new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))))", ""),
    "RemoveNthNodeFromEndOfList": ("ListNode", "removeNthFromEnd", "linked_list", "new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))", ", 2"),
    "PalindromeLinkedList": ("boolean", "isPalindrome", "linked_list", "new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))", ""),
    "CopyListWithRandomPointer": None,
    "BinaryTreeLevelOrderTraversal": ("java.util.List", "levelOrder", "tree", "new BinaryTreeNode(3, new BinaryTreeNode(9), new BinaryTreeNode(20, new BinaryTreeNode(15), new BinaryTreeNode(7)))", ""),
    "MaximumDepthOfBinaryTree": ("int", "maxDepth", "tree", "new BinaryTreeNode(3, new BinaryTreeNode(9), new BinaryTreeNode(20, new BinaryTreeNode(15), new BinaryTreeNode(7)))", ""),
    "ValidateBinarySearchTree": ("boolean", "isValidBST", "tree", "new BinaryTreeNode(2, new BinaryTreeNode(1), new BinaryTreeNode(3))", ""),
    "LowestCommonAncestorOfABinaryTree": ("BinaryTreeNode", "lowestCommonAncestor", "tree", "new BinaryTreeNode(3, new BinaryTreeNode(5), new BinaryTreeNode(1))", ", new BinaryTreeNode(5), new BinaryTreeNode(1)"),
    "ConstructBinaryTreeFromPreorderAndInorderTraversal": ("BinaryTreeNode", "buildTree", "array_int", "[3,9,20,15,7]", ", new int[]{9,3,15,20,7}"),
    "MinStack": None,
    "DailyTemperatures": ("int[]", "dailyTemperatures", "array_int", "[73,74,75,71,69,72,76,73]", ""),
    "SearchInsertPosition": ("int", "searchInsert", "array_int", "[1,3,5,6]", ", 5"),
    "SearchInRotatedSortedArray": ("int", "search", "array_int", "[4,5,6,7,0,1,2]", ", 0"),
    "LongestSubstringWithoutRepeatingCharacters": ("int", "lengthOfLongestSubstring", "string", "abcabcbb", ""),
    "MinimumSizeSubarraySum": ("int", "minSubArrayLen", "array_int", "[2,3,1,2,4,3]", ", 7"),
    "ContainerWithMostWater": ("int", "maxArea", "array_int", "[1,8,6,2,5,4,8,3,7]", ""),
    "ClimbingStairs": ("int", "climbStairs", "array_int", "3", ""),
    "MaximumSubarray": ("int", "maxSubArray", "array_int", "[-2,1,-3,4,-1,2,1,-5,4]", ""),
    "HouseRobber": ("int", "rob", "array_int", "[1,2,3,1]", ""),
    "LongestIncreasingSubsequence": ("int", "lengthOfLIS", "array_int", "[10,9,2,5,3,7,101,18]", ""),
    "LruCache": None,
    "NumberOfIslands": ("int", "numIslands", "grid", "{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}", ""),
    "Permutations": ("java.util.List", "permute", "array_int", "[1,2,3]", ""),
    "Subsets": ("java.util.List", "subsets", "array_int", "[1,2,3]", ""),
}


def needs_list_node(class_name: str) -> bool:
    return class_name in {
        "LinkedListCycleIi",
        "RemoveNthNodeFromEndOfList",
        "PalindromeLinkedList",
    }


def needs_min_stack(class_name: str) -> bool:
    return class_name == "MinStack"


def build_method_body(class_name, ret, method, kind, demo, extra):
    if class_name == "ConstructBinaryTreeFromPreorderAndInorderTraversal":
        return f'''        int[] preorder = {demo};
        int[] inorder = {extra.lstrip(", ")};
        BinaryTreeNode root = solution.{method}(preorder, inorder);
        System.out.println(root != null ? root.getValue() : "null");'''
    if class_name == "LowestCommonAncestorOfABinaryTree":
        return f'''        BinaryTreeNode root = new BinaryTreeNode(3,
                new BinaryTreeNode(5),
                new BinaryTreeNode(1));
        BinaryTreeNode p = new BinaryTreeNode(5);
        BinaryTreeNode q = new BinaryTreeNode(1);
        BinaryTreeNode ans = solution.{method}(root, p, q);
        System.out.println(ans != null ? ans.getValue() : "null");'''
    if class_name == "MergeIntervals":
        return f'''        int[][] intervals = {demo};
        System.out.println(java.util.Arrays.deepToString(solution.{method}(intervals)));'''
    if class_name == "ClimbingStairs":
        return f'''        int n = {demo};
        System.out.println(solution.{method}(n));'''
    if kind == "tree":
        return f'''        BinaryTreeNode root = {demo};
        System.out.println(solution.{method}(root{extra}));'''
    if kind == "linked_list":
        return f'''        ListNode head = {demo};
        ListNode result = solution.{method}(head{extra});
        if (result != null) {{
            result.print();
        }} else {{
            System.out.println("null");
        }}'''
    if kind == "string":
        return f'''        String s = "{demo}";
        System.out.println(solution.{method}(s{extra}));'''
    if kind == "grid":
        return f'''        char[][] grid = {demo};
        System.out.println(solution.{method}(grid));'''
    return f'''        int[] nums = {demo};
        System.out.println(solution.{method}(nums{extra}));'''


def build_solution(class_name, ret, method):
    if needs_min_stack(class_name):
        return f'''class {class_name} {{
    // TODO: 实现最小栈
}}

class Solution {{
    // 占位，本题主逻辑在 {class_name}
}}'''
    if class_name == "LruCache":
        return f'''class Solution {{
    // 见同目录 LruCache.java 中的 LRUCache 实现
}}'''
    if ret == "int[]":
        body = f"return new int[0];"
    elif ret == "int[][]":
        body = "return new int[0][];"
    elif ret == "int":
        body = "return 0;"
    elif ret == "boolean":
        body = "return false;"
    elif ret == "String":
        body = 'return "";'
    elif ret == "ListNode":
        body = "return null;"
    elif ret == "BinaryTreeNode":
        body = "return null;"
    elif ret == "java.util.List":
        body = "return new java.util.ArrayList<>();"
    else:
        body = "return null;"

    if class_name == "ConstructBinaryTreeFromPreorderAndInorderTraversal":
        return f'''class Solution {{
    public BinaryTreeNode {method}(int[] preorder, int[] inorder) {{
        // TODO: 递归分治
        {body}
    }}
}}'''
    if class_name == "LowestCommonAncestorOfABinaryTree":
        return f'''class Solution {{
    public BinaryTreeNode {method}(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {{
        // TODO: 最近公共祖先
        {body}
    }}
}}'''
    if class_name == "BinaryTreeLevelOrderTraversal":
        return f'''class Solution {{
    public java.util.List<java.util.List<Integer>> {method}(BinaryTreeNode root) {{
        // TODO: BFS 层序遍历
        return new java.util.ArrayList<>();
    }}
}}'''
    if class_name == "ThreeSum":
        return f'''class Solution {{
    public java.util.List<java.util.List<Integer>> {method}(int[] nums) {{
        // TODO: 排序 + 双指针
        return new java.util.ArrayList<>();
    }}
}}'''
    if class_name == "Permutations":
        return f'''class Solution {{
    public java.util.List<java.util.List<Integer>> {method}(int[] nums) {{
        // TODO: 回溯
        return new java.util.ArrayList<>();
    }}
}}'''
    if class_name == "Subsets":
        return f'''class Solution {{
    public java.util.List<java.util.List<Integer>> {method}(int[] nums) {{
        // TODO: 回溯
        return new java.util.ArrayList<>();
    }}
}}'''
    if class_name == "MergeIntervals":
        return f'''class Solution {{
    public int[][] {method}(int[][] intervals) {{
        // TODO: 排序 + 合并区间
        {body}
    }}
}}'''
    if class_name == "ClimbingStairs":
        return f'''class Solution {{
    public int {method}(int n) {{
        // TODO: DP 入门
        {body}
    }}
}}'''
    if class_name == "SearchInsertPosition":
        return f'''class Solution {{
    public int {method}(int[] nums, int target) {{
        // TODO: 基础二分
        {body}
    }}
}}'''
    if class_name == "SearchInRotatedSortedArray":
        return f'''class Solution {{
    public int {method}(int[] nums, int target) {{
        // TODO: 旋转数组二分
        {body}
    }}
}}'''
    if class_name == "MinimumSizeSubarraySum":
        return f'''class Solution {{
    public int {method}(int target, int[] nums) {{
        // TODO: 滑动窗口
        {body}
    }}
}}'''
    if class_name == "RemoveNthNodeFromEndOfList":
        return f'''class Solution {{
    public ListNode {method}(ListNode head, int n) {{
        // TODO: 快慢指针
        {body}
    }}
}}'''
    params = {
        "TwoSum": "int[] nums, int target",
        "LongestConsecutiveSequence": "int[] nums",
        "LongestSubstringWithoutRepeatingCharacters": "String s",
        "DailyTemperatures": "int[] temperatures",
        "MaximumSubarray": "int[] nums",
        "HouseRobber": "int[] nums",
        "LongestIncreasingSubsequence": "int[] nums",
        "NumberOfIslands": "char[][] grid",
        "ContainerWithMostWater": "int[] height",
        "ValidateBinarySearchTree": "BinaryTreeNode root",
        "MaximumDepthOfBinaryTree": "BinaryTreeNode root",
        "PalindromeLinkedList": "ListNode head",
        "LinkedListCycleIi": "ListNode head",
    }.get(class_name, "int[] nums")

    return f'''class Solution {{
    public {ret} {method}({params}) {{
        // TODO
        {body}
    }}
}}'''


def list_node_helper():
    return '''
private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
'''


def generate_file(cn, num, slug, class_name):
    url = f"{BASE_URL}/{slug}/"
    sig = SIGNATURES.get(class_name)
    if sig is None:
        return None

    ret, method, kind, demo, extra = sig
    imports = []
    if kind == "tree" or class_name in {
        "ConstructBinaryTreeFromPreorderAndInorderTraversal",
        "LowestCommonAncestorOfABinaryTree",
    }:
        imports.append("import com.zak.da.tree.BinaryTreeNode;")

    main_body = build_method_body(class_name, ret, method, kind, demo, extra)
    solution = build_solution(class_name, ret, method)
    list_node = list_node_helper() if needs_list_node(class_name) else ""

    if needs_min_stack(class_name):
        main_body = '''        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());'''
        solution = build_solution(class_name, ret, method)

    content = f"""package {PKG};

// {num}. {cn}
// LeetCode: {url}
// Related Topics 面试刷题提纲

{chr(10).join(imports)}

public class {class_name} {{

    public static void main(String[] args) {{
        Solution solution = new {class_name}().new Solution();
{main_body}
    }}

//leetcode submit region begin(Prohibit modification and deletion)
{solution}
{list_node}//leetcode submit region end(Prohibit modification and deletion)

}}
"""
    path = CN_DIR / f"{class_name}.java"
    path.write_text(content, encoding="utf-8")
    return path


def section_issue_title(section: dict, index: int) -> str:
    return f"{ISSUE_PREFIX} · {index:02d} {section['topic']}"


def build_section_table(section: dict) -> list[str]:
    lines = [
        "| 题 | 难度 | 考点 | LeetCode | 代码 |",
        "| --- | --- | --- | --- | --- |",
    ]
    for cn, diff, point, num, slug, class_name, _ in section["items"]:
        url = f"{BASE_URL}/{slug}/"
        code = f"{GITHUB_BASE}/{class_name}.java"
        lines.append(
            f"| [{cn}]({url}) | {diff} | {point} | [#{num}]({url}) | [{class_name}.java]({code}) |"
        )
    return lines


def build_section_issue_body(section: dict, index: int) -> str:
    lines = [
        f"**{section_issue_title(section, index)}**",
        "",
        f"面试刷题提纲 · {section['title']}",
        "",
        "代码目录：`app/src/main/java/com/zak/da/template/leetcode/editor/cn/`",
        "",
    ]
    lines.extend(build_section_table(section))
    lines.extend(
        [
            "",
            "---",
            "",
            "在本 Issue 下按日期补充刷题笔记，格式示例：` **2026.09.17** `",
            "",
        ]
    )
    return "\n".join(lines)


def build_index_issue_body(section_links: list[tuple[int, str, str]]) -> str:
    lines = [
        f"**算法面试刷题提纲（{ISSUE_PREFIX}）**",
        "",
        "本 Issue 为总目录，各模块已拆分为独立 Topic Issue：",
        "",
    ]
    for index, topic, url in section_links:
        lines.append(f"- [{section_issue_title({'topic': topic}, index)}]({url}) — {SECTIONS[index - 1]['title']}")
    lines.extend(
        [
            "",
            "代码目录：`app/src/main/java/com/zak/da/template/leetcode/editor/cn/`",
            "",
            "---",
            "",
            "请在对应 Topic Issue 下记录刷题笔记。",
            "",
        ]
    )
    return "\n".join(lines)


def main():
    CN_DIR.mkdir(parents=True, exist_ok=True)
    created = []
    skipped = []
    for section in SECTIONS:
        for item in section["items"]:
            cn, diff, topic, num, slug, class_name, exists = item
            path = CN_DIR / f"{class_name}.java"
            if path.exists():
                skipped.append(class_name)
                continue
            result = generate_file(cn, num, slug, class_name)
            if result:
                created.append(result.name)

    issues_dir = ROOT / "scripts" / "interview-issues"
    issues_dir.mkdir(parents=True, exist_ok=True)
    for index, section in enumerate(SECTIONS, start=1):
        path = issues_dir / f"{index:02d}-{section['topic'].replace('/', '-')}.md"
        path.write_text(build_section_issue_body(section, index), encoding="utf-8")

    index_path = ROOT / "scripts" / "interview-outline-index.md"
    placeholder_links = [
        (i, SECTIONS[i - 1]["topic"], f"#issue-{i}")
        for i in range(1, len(SECTIONS) + 1)
    ]
    index_path.write_text(build_index_issue_body(placeholder_links), encoding="utf-8")

    print("CREATED:", ", ".join(created))
    print("SKIPPED:", ", ".join(skipped))
    print("ISSUE_FILES:", issues_dir)
    print("INDEX:", index_path)


if __name__ == "__main__":
    main()
