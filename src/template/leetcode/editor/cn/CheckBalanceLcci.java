package template.leetcode.editor.cn;

//Implement a function to check if a binary tree is balanced. For the purposes o
//f this question, a balanced tree is defined to be a tree such that the heights o
//f the two subtrees of any node never differ by more than one. 
//
// 
//Example 1: 
//
// 
//Given tree [3,9,20,null,null,15,7]
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return true. 
//
// Example 2: 
//
// 
//Given [1,2,2,3,3,null,null,4,4]
//      1
//     / \
//    2   2
//   / \
//  3   3
// / \
//4   4
//return false. 
//
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 65 👎 0

import tree.BinaryTreeNode;

public class CheckBalanceLcci{

    public static void main(String[] args) {
        Solution solution = new CheckBalanceLcci().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));

        BinaryTreeNode demoTwo = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3,
                                new BinaryTreeNode(4, null, null),
                                new BinaryTreeNode(4, null, null)),
                        new BinaryTreeNode(3, null, null)),
                new BinaryTreeNode(2, null, null));

        boolean resultOne = solution.isBalanced(demoOne);
        boolean resultTwo = solution.isBalanced(demoTwo);

        System.out.println("二叉树 [3, 9, 20, null, null, 15, 7] 是否平衡？" + resultOne);
        System.out.println("二叉树 [1, 2, 2, 3, 3, null, null, 4, 4] 是否平衡？" + resultTwo);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(BinaryTreeNode root) {
        return judgeIsBalanced(root) != -1;
    }

    private int judgeIsBalanced(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = judgeIsBalanced(root.getLeft());
        int right = judgeIsBalanced(root.getRight());

        if (left == -1) {
            return -1;
        }
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}