package template.leetcode.editor.cn;

//Given the roots of two binary trees root and subRoot, return true if there is 
//a subtree of root with the same structure and node values of subRoot and false o
//therwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree and
// all of this node's descendants. The tree tree could also be considered as a sub
//tree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 539 👎 0

import tree.BinaryTreeNode;

public class SubtreeOfAnotherTree{

    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(3,
                new BinaryTreeNode(4,
                        new BinaryTreeNode(1, null, null),
                        new BinaryTreeNode(2, null, null)),
                new BinaryTreeNode(5, null, null));

        BinaryTreeNode demoTwo = new BinaryTreeNode(3,
                new BinaryTreeNode(4,
                        new BinaryTreeNode(1, null, null),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(0, null, null), null)),
                new BinaryTreeNode(5, null, null));

        BinaryTreeNode demoSub = new BinaryTreeNode(4,
                new BinaryTreeNode(1, null, null),
                new BinaryTreeNode(2, null, null));

        BinaryTreeNode demoThr = new BinaryTreeNode(1,
                new BinaryTreeNode(1, null, null),
                null);

        BinaryTreeNode demoSubOne = new BinaryTreeNode(1, null, null);

        System.out.println("树 1: [3,4,5,1,2]，树 2: [4,1,2]，树 2 是否为树 1 的子树 == " + solution.isSubtree(demoOne, demoSub));
        System.out.println("树 1: [3,4,5,1,2,null,null,null,null,0]，树 2: [4,1,2]，树 2 是否为树 1 的子树 == " + solution.isSubtree(demoTwo, demoSub));
        System.out.println("树 1: [1,1]，树 2: [1]，树 2 是否为树 1 的子树 == " + solution.isSubtree(demoThr, demoSubOne));
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
    public boolean isSubtree(BinaryTreeNode root, BinaryTreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(BinaryTreeNode root, BinaryTreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return check(root, subRoot) || dfs(root.getLeft(), subRoot) || dfs(root.getRight(), subRoot);
    }

    private boolean check(BinaryTreeNode root, BinaryTreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.getValue() != subRoot.getValue()) {
            return false;
        }

        return check(root.getLeft(), subRoot.getLeft()) && check(root.getRight(), subRoot.getRight());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}