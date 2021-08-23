package com.zak.da.tree;

import java.util.List;

public class BinTreePractice {

    public static void main(String[] args) {
        BinaryTreeNode demoTree606_1 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), null),
                new BinaryTreeNode(3, null, null));
        BinaryTreeNode demoTree606_2 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(3, null, null));

        System.out.println("606.根据二叉树创建字符串");
        System.out.println("606_1: " + tree2Str(demoTree606_1));
        System.out.println("606_2: " + tree2Str(demoTree606_2));

        BinaryTreeNode demoTree897 = new BinaryTreeNode(5,
                new BinaryTreeNode(3,
                        new BinaryTreeNode(2, new BinaryTreeNode(1, null, null), null),
                        new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(6, null, new BinaryTreeNode(8,
                        new BinaryTreeNode(7, null, null),
                        new BinaryTreeNode(9, null, null))));
        System.out.println("897. 递增顺序查找树");
        System.out.print("中序遍历结果: ");
        BinaryTreeNode result897 = increasingBST(demoTree897);
        System.out.println();
        System.out.print("结果树前序遍历结果: ");
        BinTreeTraversal.inOrderTraversal(result897, null);
    }

    /**
     * 606.根据二叉树创建字符串
     *
     * 需要采用前序遍历将二叉树转换成一个由括号和整数组成的字符串
     * 比如二叉树: [1, 2, 3, 4] 预期输出 1(2(4))(3)，原本是 1(2(4)())(3())，但是要省略不影响字符串和原始二叉树之间的一对一映射关系
     * 再如二叉树: [1, 2, 3, null, 4] 就需要输出 1(2()(4))(3)
     *
     * @return 由二叉树转换后的字符串
     */
    public static String tree2Str(BinaryTreeNode treeNode) {
        String result = "";

        if (treeNode == null) {
            return result;
        }

        result += treeNode.getValue();

        if (treeNode.getLeft() == null) {
            if (treeNode.getRight() == null) {
                result += "";
            } else {
                result += "()";
            }
        } else {
            result += "(" + tree2Str(treeNode.getLeft()) + ")";
        }

        if (treeNode.getRight() == null) {
            result += "";
        } else {
            result += "(" + tree2Str(treeNode.getRight()) + ")";
        }

        return result;
    }

    /**
     * 897.递增顺序查找树
     * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     *
     * @param root 树的根节点
     *
     * @return 结果树
     */
    public static BinaryTreeNode increasingBST(BinaryTreeNode root) {
        List<Integer> inOrderList = BinTreeTraversal.inOrderTraversalWithResult(root);
//        return buildTree(inOrderList); // 递归的方式
        BinaryTreeNode newRoot = new BinaryTreeNode(0, null, null);
        BinaryTreeNode curRoot = newRoot;
        for (Integer item : inOrderList) {
            if (curRoot != null) {
                curRoot.setRight(new BinaryTreeNode(item, null, null));
                curRoot = curRoot.getRight();
            }
        }
        return newRoot.getRight();
    }

    /**
     * 879.根据中序遍历构建结果树
     *
     * @param result 中序遍历
     * @return 结果树
     */
    private static BinaryTreeNode buildTree(List<Integer> result) {
        if (result == null || result.size() == 0) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(result.get(0), null, null);
        result.remove(result.get(0));
        root.setRight(buildTree(result));
        return root;
    }
}
