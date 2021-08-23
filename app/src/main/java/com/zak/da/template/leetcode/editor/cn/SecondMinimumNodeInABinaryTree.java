package com.zak.da.template.leetcode.editor.cn;

//Given a non-empty special binary tree consisting of nodes with the non-negativ
//e value, where each node in this tree has exactly two or zero sub-node. If the n
//ode has two sub-nodes, then this node's value is the smaller value among its two
// sub-nodes. More formally, the property root.val = min(root.left.val, root.right
//.val) always holds. 
//
// Given such a binary tree, you need to output the second minimum value in the 
//set made of all the nodes' value in the whole tree. 
//
// If no such second minimum value exists, output -1 instead. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,2,5,null,null,5,7]
//Output: 5
//Explanation: The smallest value is 2, the second smallest value is 5.
// 
//
// Example 2: 
//
// 
//Input: root = [2,2,2]
//Output: -1
//Explanation: The smallest value is 2, but there isn't any second smallest valu
//e.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 25]. 
// 1 <= Node.val <= 231 - 1 
// root.val == min(root.left.val, root.right.val) for each internal node of the 
//tree. 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 200 👎 0

import com.zak.da.tree.BinaryTreeNode;

public class SecondMinimumNodeInABinaryTree{

    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(2,
                new BinaryTreeNode(2, null, null),
                new BinaryTreeNode(5,
                        new BinaryTreeNode(5, null, null),
                        new BinaryTreeNode(7, null, null)));

        BinaryTreeNode demoTwo = new BinaryTreeNode(2,
                new BinaryTreeNode(2, null, null),
                new BinaryTreeNode(2, null, null));

        System.out.println("二叉树 [2, 2, 5, null, null, 5, 7] 的第二最小值为 " + solution.findSecondMinimumValue(demoOne));
        System.out.println("二叉树 [2, 2, 2] 的第二最小值为 " + solution.findSecondMinimumValue(demoTwo));
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

    int res = -1;
    int rootVal;

    public int findSecondMinimumValue(BinaryTreeNode root) {
        rootVal = root.getValue();
        res = -1;
        dfs(root);
        return res;
    }

    private void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (res != -1 && node.getValue() >= res) {
            return;
        }
        if (node.getValue() > rootVal) {
            res = node.getValue();
        }
        dfs(node.getLeft());
        dfs(node.getRight());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}