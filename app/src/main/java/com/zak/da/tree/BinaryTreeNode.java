package com.zak.da.tree;

/**
 * 二叉树节点（Java 版，供 LeetCode 题目引用；IDE 可正确解析）。
 */
public class BinaryTreeNode {

    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
