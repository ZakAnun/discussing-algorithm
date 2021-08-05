package template.leetcode.editor.cn;

//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 558 👎 0

import tree.BinaryTreeNode;

public class MinimumDepthOfBinaryTree{

    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));

        BinaryTreeNode demoTwo = new BinaryTreeNode(2,
                null,
                new BinaryTreeNode(3,
                        null,
                        new BinaryTreeNode(4,
                                null,
                                new BinaryTreeNode(5,
                                        null,
                                        new BinaryTreeNode(6, null, null)))));

        System.out.println("二叉树 [3, 9, 20, null, null, 15, 7] 的最小深度 == " + solution.minDepth(demoOne));
        System.out.println("二叉树 [2, null, 3, null, 4, null, 5, null, 6] 的最小深度 == " + solution.minDepth(demoTwo));
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
    public int minDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        int depth = Integer.MAX_VALUE;
        if (root.getLeft() != null) {
            depth = Math.min(minDepth(root.getLeft()), depth);
        }
        if (root.getRight() != null) {
            depth = Math.min(minDepth(root.getRight()), depth);
        }

        return depth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}