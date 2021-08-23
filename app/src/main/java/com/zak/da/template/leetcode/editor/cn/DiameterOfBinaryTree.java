package com.zak.da.template.leetcode.editor.cn;

//Given the root of a binary tree, return the length of the diameter of the tree
//. 
//
// The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root. 
//
// The length of a path between two nodes is represented by the number of edges 
//between them. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Example 2: 
//
// 
//Input: root = [1,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 750 👎 0

import com.zak.da.tree.BinaryTreeNode;

public class DiameterOfBinaryTree{

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();

        BinaryTreeNode demo = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4, null, null),
                        new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(3, null, null));

        System.out.println("二叉树 [1, 2, 3, 4, 5] 的直径 == " + solution.diameterOfBinaryTree(demo));
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

    public int diameterOfBinaryTree(BinaryTreeNode root) {
        result = 1;
        dfs(root);
        return result - 1;
    }

    private int dfs(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.getLeft());
        int right = dfs(node.getRight());

        result = Math.max(result, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}