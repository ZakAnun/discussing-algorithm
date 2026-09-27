package com.zak.da.template.leetcode.editor.cn;

// 105. 从前序与中序构造二叉树
// LeetCode: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Related Topics 面试刷题提纲

import com.zak.da.tree.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BinaryTreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root != null ? root.getValue() : "null");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] preorder;
    private Map<Integer, Integer> inIndex;

    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 用前序区间 [preL, preR]、中序区间 [inL, inR] 构造子树。
     * 出口：区间为空（left > right）→ null
     */
    private BinaryTreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        int rootVal = preorder[preL];
        BinaryTreeNode root = new BinaryTreeNode(rootVal, null, null);
        int rootIn = inIndex.get(rootVal);
        int leftSize = rootIn - inL;

        // 前序：根 | 左子树(leftSize个) | 右子树
        // 中序：左子树 | 根 | 右子树
        root.setLeft(build(preL + 1, preL + leftSize, inL, rootIn - 1));
        root.setRight(build(preL + leftSize + 1, preR, rootIn + 1, inR));
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
