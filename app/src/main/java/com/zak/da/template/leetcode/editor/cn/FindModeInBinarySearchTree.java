package com.zak.da.template.leetcode.editor.cn;

//Given the root of a binary search tree (BST) with duplicates, return all the m
//ode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the i
//mplicit stack space incurred due to recursion does not count). Related Topics 树 
//深度优先搜索 二叉搜索树 二叉树 
// 👍 329 👎 0

import java.util.ArrayList;
import java.util.List;

import com.zak.da.tree.BinaryTreeNode;

public class FindModeInBinarySearchTree{

    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();

        BinaryTreeNode demo = new BinaryTreeNode(1,
                null,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(2, null, null),
                        null));
        System.out.print("二叉搜索树 [1, null, 2, 2] 的众数为 = ");
        int[] result = solution.findMode(demo);
        for (int item : result) {
            System.out.print(item + " ");
        }

        System.out.println();
        System.out.println();

        System.out.print("非递归二叉搜索树 [1, null, 2, 2] 的众数为 = ");
        int[] resultWithoutDiGui = solution.findModeWithoutDiGui(demo);
        for (int item : resultWithoutDiGui) {
            System.out.print(item + " ");
        }

        System.out.println();
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
    List<Integer> result = new ArrayList<>();
    int count;
    int maxCount;
    int val;

    public int[] findMode(BinaryTreeNode root) {
        count = 0;
        maxCount = 0;
        val = 0;
        result.clear();
        dfs(root);
        int size = result.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void dfs(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.getLeft());
        update(node.getValue());
        dfs(node.getRight());
    }

    private void update(int value) {
        if (value == val) {
            ++count;
        } else {
            count = 1;
            val = value;
        }
        if (count == maxCount) {
            result.add(val);
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(val);
        }
    }

    public int[] findModeWithoutDiGui(BinaryTreeNode root) {
        count = 0;
        maxCount = 0;
        val = 0;
        result.clear();
        BinaryTreeNode cur = root;
        BinaryTreeNode pre = null;
        while (cur != null) {
            if (cur.getLeft() == null) {
                update(cur.getValue());
                cur = cur.getRight();
                continue;
            }
            pre = cur.getLeft();
            while (pre.getRight() != null && pre.getRight() != cur) {
                pre = pre.getRight();
            }
            if (pre.getRight() == null) {
                pre.setRight(cur);
                cur = cur.getLeft();
            } else {
                pre.setRight(null);
                update(cur.getValue());
                cur = cur.getRight();
            }
        }
        int[] mode = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            mode[i] = result.get(i);
        }
        return mode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}