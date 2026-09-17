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
        BinaryTreeNode p = new BinaryTreeNode(5, null, null);
        BinaryTreeNode q = new BinaryTreeNode(1, null, null);
        BinaryTreeNode ans = solution.lowestCommonAncestor(root, p, q);
        System.out.println(ans != null ? ans.getValue() : "null");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        // TODO: 最近公共祖先
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
