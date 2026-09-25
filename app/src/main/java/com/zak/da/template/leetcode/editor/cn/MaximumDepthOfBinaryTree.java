package com.zak.da.template.leetcode.editor.cn;

// 104. 最大深度
// LeetCode: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        BinaryTreeNode root = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));
        System.out.println(solution.maxDepth(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(BinaryTreeNode root) {
        // 空节点深度为 0
        if (root == null) {
            return 0;
        }
        // 根的深度 = 左右子树较大深度 + 1（算上自己这一层）
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
