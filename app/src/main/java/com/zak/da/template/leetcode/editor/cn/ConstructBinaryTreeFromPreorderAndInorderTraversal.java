package com.zak.da.template.leetcode.editor.cn;

// 105. 从前序与中序构造二叉树
// LeetCode: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BinaryTreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root != null ? root.getValue() : "null");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO: 递归分治
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
