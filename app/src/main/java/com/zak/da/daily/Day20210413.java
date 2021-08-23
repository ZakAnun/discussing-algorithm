package com.zak.da.daily;

import com.zak.da.tree.BinaryTreeNode;

/**
 * 每日一题: 783. 二叉搜索树节点最小距离
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class Day20210413 {

    private static int pre = -1;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("783. 二叉搜索树节点最小距离");
        BinaryTreeNode demo783 = new BinaryTreeNode(4,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(1, null, null),
                        new BinaryTreeNode(3, null, null)),
                new BinaryTreeNode(6, null, null));
        minDiffInBST(demo783);
        System.out.println("demo782 树节点最小距离为: " + result);
    }

    public static void minDiffInBST(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        minDiffInBST(root.getLeft());
        if (pre != -1) {
            result = Math.min(result, Math.abs(root.getValue() - pre));
        }
        pre = root.getValue();
        minDiffInBST(root.getRight());
    }

}
