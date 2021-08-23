package com.zak.da.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
 *  BST 的根节点 root 会作为构造函数的一部分给出。
 *  指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *
 * int next()将指针向右移动，然后返回指针处的数字。
 *
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * 你可以设计一个满足下述条件的解决方案吗？
 * next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 */
public class BSTIterator {

    private final List<Integer> inOrderList = new ArrayList<>();
    private int currentIndex = 0;

    public BSTIterator(BinaryTreeNode root) {
        inOrderList.add(-1);
        List<Integer> inOrderResult = BinTreeTraversal.inOrderTraversalWithResult(root);
        inOrderList.addAll(inOrderResult);
    }

    public int next() {
        if (currentIndex == inOrderList.size()) {
            currentIndex = inOrderList.size() - 1;
        }
        return inOrderList.get(++currentIndex);
    }

    public boolean hasNext() {
        return (currentIndex + 1) < inOrderList.size();
    }
}
