package com.zak.da.template.leetcode.editor.cn;

//Given the root of a binary tree and an integer targetSum, return true if the t
//ree has a root-to-leaf path such that adding up all the values along the path eq
//uals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 634 👎 0

import com.zak.da.tree.BinaryTreeNode;

public class PathSum{

    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(5,
                new BinaryTreeNode(4,
                        new BinaryTreeNode(11,
                                new BinaryTreeNode(7, null, null),
                                new BinaryTreeNode(2, null, null)),
                        null),
                new BinaryTreeNode(8,
                        new BinaryTreeNode(13, null, null),
                        new BinaryTreeNode(4,
                                null,
                                new BinaryTreeNode(1, null, null))));

        BinaryTreeNode demoTwo = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null),
                new BinaryTreeNode(3, null, null));

        BinaryTreeNode demoThr = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null), null);

        boolean resultOne = solution.hasPathSum(demoOne, 22);
        boolean resultTwo = solution.hasPathSum(demoTwo, 5);
        boolean resultThr = solution.hasPathSum(demoThr, 0);

        System.out.println("二叉树 [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1] 是否存在根节点到叶子结点路径和 == 22 的路径" + resultOne);
        System.out.println("二叉树 [1, 2, 3] 是否存在根节点到叶子结点路径和 == 5 的路径" + resultTwo);
        System.out.println("二叉树 [1, 2] 是否存在根节点到叶子结点路径和 == 0 的路径" + resultThr);
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
    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return root.getValue() == targetSum;
        }
        return hasPathSum(root.getLeft(), targetSum - root.getValue()) ||
                hasPathSum(root.getRight(), targetSum - root.getValue());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}