package com.zak.da.template.leetcode.editor.cn;

// 98. 验证二叉搜索树
// LeetCode: https://leetcode-cn.com/problems/validate-binary-search-tree/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        BinaryTreeNode root = new BinaryTreeNode(2,
                new BinaryTreeNode(1, null, null),
                new BinaryTreeNode(3, null, null));
        System.out.println(solution.isValidBST(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidBST(BinaryTreeNode root) {
        // TODO
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
