package com.zak.da.template.leetcode.editor.cn;

//Given the root of a binary tree, the value of a target node target, and an int
//eger k, return an array of the values of all nodes that have a distance k from t
//he target node. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 
//5) have values 7, 4, and 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], target = 1, k = 3
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 500]. 
// 0 <= Node.val <= 500 
// All the values Node.val are unique. 
// target is the value of one of the nodes in the tree. 
// 0 <= k <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 397 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zak.da.tree.BinaryTreeNode;

public class AllNodesDistanceKInBinaryTree{

    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();

        BinaryTreeNode demoOne = new BinaryTreeNode(3,
                new BinaryTreeNode(5,
                        new BinaryTreeNode(6, null, null),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(7, null, null),
                                new BinaryTreeNode(4, null, null))),
                new BinaryTreeNode(1,
                        new BinaryTreeNode(0, null, null),
                        new BinaryTreeNode(8, null, null)));

        System.out.println("tree = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], target = 5, k = 2 的节点列表为: ");
        List<Integer> result = solution.distanceK(demoOne, demoOne.getLeft(), 2);
        for (int item : result) {
            System.out.print(item + " ");
        }

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
    private Map<Integer, BinaryTreeNode> parentMap = new HashMap<>();
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(BinaryTreeNode root, BinaryTreeNode target, int k) {
        result.clear();

        dfsParent(root);
        findResult(target, null, 0, k);
        result.removeIf(next -> next == target.getValue());

        return result;
    }

    private void dfsParent(BinaryTreeNode root) {
        if (root.getLeft() != null) {
            parentMap.put(root.getLeft().getValue(), root);
            dfsParent(root.getLeft());
        }
        if (root.getRight() != null) {
            parentMap.put(root.getRight().getValue(), root);
            dfsParent(root.getRight());
        }
    }

    private void findResult(BinaryTreeNode node, BinaryTreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            result.add(node.getValue());
            return;
        }
        if (node.getLeft() != from) {
            findResult(node.getLeft(), node, depth + 1, k);
        }
        if (node.getRight() != from) {
            findResult(node.getRight(), node, depth + 1, k);
        }
        if (parentMap.get(node.getValue()) != null) {
            findResult(parentMap.get(node.getValue()), node, depth + 1, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}