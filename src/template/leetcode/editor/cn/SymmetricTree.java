package template.leetcode.editor.cn;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1436 👎 0

import java.util.LinkedList;
import java.util.Queue;

import tree.BinaryTreeNode;

public class SymmetricTree{

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        BinaryTreeNode one = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3, null, null),
                        new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4, null, null),
                        new BinaryTreeNode(3, null, null)));
        BinaryTreeNode two = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, new BinaryTreeNode(3, null, null)),
                new BinaryTreeNode(2, null, new BinaryTreeNode(3, null, null)));

        System.out.println("深度优先");
        System.out.println("[1, 2, 2, 3, 4, 4, 3] 是否为对称二叉树? " + solution.isSymmetric(one));
        System.out.println("[1, 2, 2, null, 3, null, 3] 是否为对称二叉树? " + solution.isSymmetric(two));
        System.out.println("[1] 是否为对称二叉树? " + solution.isSymmetric(new BinaryTreeNode(1, null, null)));
        System.out.println("null 是否为对称二叉树? " + solution.isSymmetric(null));

        System.out.println();

        System.out.println("广度优先");
        System.out.println("[1, 2, 2, 3, 4, 4, 3] 是否为对称二叉树? " + solution.isSymmetricBreadth(one));
        System.out.println("[1, 2, 2, null, 3, null, 3] 是否为对称二叉树? " + solution.isSymmetricBreadth(two));
        System.out.println("[1] 是否为对称二叉树? " + solution.isSymmetricBreadth(new BinaryTreeNode(1, null, null)));
        System.out.println("null 是否为对称二叉树? " + solution.isSymmetricBreadth(null));
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
    public boolean isSymmetric(BinaryTreeNode root) {
        return isSymmetricDeep(root, root);
//        return isSymmetricBreadth(root);
    }

    /**
     * 深度优先
     *
     * @param left left
     * @param right right
     * @return result
     */
    private boolean isSymmetricDeep(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.getValue() == right.getValue() &&
                isSymmetricDeep(left.getLeft(), right.getRight()) &&
                isSymmetricDeep(right.getLeft(), left.getRight());
    }

    /**
     * 广度优先
     *
     * @param root root
     * @return result
     */
    private boolean isSymmetricBreadth(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        boolean result = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode left = queue.poll();
            BinaryTreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.getValue() != right.getValue()) {
                return false;
            }

            result = left.getValue() == right.getValue();

            queue.offer(left.getLeft());
            queue.offer(right.getRight());
            queue.offer(left.getRight());
            queue.offer(right.getLeft());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}