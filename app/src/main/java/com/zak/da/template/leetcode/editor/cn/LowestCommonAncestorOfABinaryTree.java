package com.zak.da.template.leetcode.editor.cn;

// 236. 最近公共祖先
// LeetCode: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        BinaryTreeNode root = new BinaryTreeNode(3,
                new BinaryTreeNode(5, null, null),
                new BinaryTreeNode(1, null, null));
        // 必须用树上的同一批节点引用（按 == 比较，不能 new 同值新节点）
        BinaryTreeNode p = root.getLeft();
        BinaryTreeNode q = root.getRight();
        BinaryTreeNode ans = solution.lowestCommonAncestor(root, p, q);
        System.out.println(ans != null ? ans.getValue() : "null");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        // 空，或撞上 p/q：作为「找到了」往上返回
        if (root == null || root == p || root == q) {
            return root;
        }

        BinaryTreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.getRight(), p, q);

        // 左右都找到 → 当前就是 LCA
        if (left != null && right != null) {
            return root;
        }
        // 只在一边 → 把那一边的结果继续往上递
        return left != null ? left : right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
