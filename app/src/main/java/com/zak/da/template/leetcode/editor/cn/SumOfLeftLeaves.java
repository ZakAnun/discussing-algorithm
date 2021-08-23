package com.zak.da.template.leetcode.editor.cn;

//Given the root of a binary tree, return the sum of all left leaves. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 1
//5 respectively.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 332 👎 0

import com.zak.da.tree.BinaryTreeNode;

public class SumOfLeftLeaves{

    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();

        BinaryTreeNode demo = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));
        System.out.println("二叉树 [3, 9, 20, null, null, 15, 7] 的左叶子节点值和 == " + solution.sumOfLeftLeaves(demo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int result = 0;

    public int sumOfLeftLeaves(BinaryTreeNode root) {
        result = 0;
        dfs(root, false);
        return result;
    }

    private void dfs(BinaryTreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (isLeft &&
                node.getLeft() == null &&
                node.getRight() == null) {
            result += node.getValue();
        }
        dfs(node.getLeft(), true);
        dfs(node.getRight(), false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}