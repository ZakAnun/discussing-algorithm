package com.zak.da.template.leetcode.editor.cn;

// 102. 层序遍历
// LeetCode: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        BinaryTreeNode root = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));
        System.out.println(solution.levelOrder(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public java.util.List<java.util.List<Integer>> levelOrder(BinaryTreeNode root) {
        // TODO: BFS 层序遍历
        return new java.util.ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
