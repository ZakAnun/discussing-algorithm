package template.leetcode.editor.cn;

//Given a root node reference of a BST and a key, delete the node with the given
// key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// Follow up: Can you solve it with time complexity O(height of tree)? 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and de
//lete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also
// accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -105 <= key <= 105 
// 
// Related Topics 树 二叉搜索树 二叉树 
// 👍 500 👎 0

import tree.BinTreeTraversal;
import tree.BinaryTreeNode;

public class DeleteNodeInABst{

    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();

        BinaryTreeNode demoTree = new BinaryTreeNode(5,
                new BinaryTreeNode(3,
                        new BinaryTreeNode(2, null, null),
                        new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(6, null,
                        new BinaryTreeNode(7, null, null)));

        System.out.print("删除前，中序遍历结果为: ");
        BinTreeTraversal.inOrderTraversal(demoTree, null);

        BinaryTreeNode result = solution.deleteNode(demoTree, 3);

        System.out.println();
        System.out.print("删除后，中序遍历结果为: ");
        BinTreeTraversal.inOrderTraversal(result, null);
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
    public BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.getValue()) {
            root.setRight(deleteNode(root.getRight(), key));
        } else if (key < root.getValue()) {
            root.setLeft(deleteNode(root.getLeft(), key));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getRight() != null) {
                root.setValue(getRightSmallest(root));
                root.setRight(deleteNode(root.getRight(), root.getValue()));
            } else {
                root.setValue(getLeftBiggest(root));
                root.setRight(deleteNode(root.getLeft(), root.getValue()));
            }
        }

        return root;
    }

    public int getRightSmallest(BinaryTreeNode root) {
        BinaryTreeNode node = root.getRight();
        if (node == null) {
            return 0;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public int getLeftBiggest(BinaryTreeNode root) {
        BinaryTreeNode node = root.getLeft();
        if (node == null) {
            return 0;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}