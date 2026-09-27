package com.zak.da.template.leetcode.editor.cn;

// 98. 验证二叉搜索树
// LeetCode: https://leetcode-cn.com/problems/validate-binary-search-tree/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        BinaryTreeNode root = new BinaryTreeNode(2,
                new BinaryTreeNode(1, null, null),
                new BinaryTreeNode(3, null, null));
        System.out.println(solution.isValidBST(root));

        // 反例：只比左右孩子会误判为 true
        BinaryTreeNode bad = new BinaryTreeNode(5,
                new BinaryTreeNode(1, null, null),
                new BinaryTreeNode(7,
                        new BinaryTreeNode(4, null, null),
                        null));
        System.out.println(solution.isValidBST(bad));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidBST(BinaryTreeNode root) {
        // 根的初始范围：(-∞, +∞)
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 当前节点值必须落在 (low, high) 开区间内；
     * 左子树收紧上界为当前值，右子树收紧下界为当前值。
     */
    private boolean validate(BinaryTreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        long val = node.getValue();
        if (val <= low || val >= high) {
            return false;
        }
        return validate(node.getLeft(), low, val)
                && validate(node.getRight(), val, high);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
