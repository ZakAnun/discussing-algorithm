package com.zak.da.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的遍历（N 叉树）
 */
public class TreeTraversal {

    public static void main(String[] args) {
        Node demoTree = new Node(1, null);
        List<Node> childrenGroup2 = new ArrayList<>();
        Node demoTree559Second = new Node(3, null);
        childrenGroup2.add(demoTree559Second);
        childrenGroup2.add(new Node(2, null));
        childrenGroup2.add(new Node(4, null));
        demoTree.setChildren(childrenGroup2);
        List<Node> childrenGroup3 = new ArrayList<>();
        childrenGroup3.add(new Node(5, null));
        childrenGroup3.add(new Node(6, null));
        demoTree559Second.setChildren(childrenGroup3);
        System.out.print("559.N 叉树的最大深度: " + maxDepth(demoTree));
        System.out.println();
        System.out.println("429.N 叉树的层序遍历如下:");
        List<List<Integer>> result429 = levelOrder(demoTree);
        for (List<Integer> group : result429) {
            System.out.print("[");
            for (Integer item : group) {
                System.out.print(item + " ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println("429.N 叉树的层序遍历结束");
        System.out.print("589.N 叉树前序遍历: ");
        List<Integer> result589 = preOrder(demoTree);
        for (Integer item: result589) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("590. N 叉树后序遍历: ");
        List<Integer> result590 = postOrder(demoTree);
        for (Integer item : result590) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * 559.N 叉树的最大深度
     * 给定一个 N 叉树，找到其最大深度（指从根节点到最远子节点的最长路径上的节点总数）
     *
     * @param root 根节点
     */
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getChildren() == null) {
            return 1;
        }
        List<Integer> childNodeList = new LinkedList<>();
        for (Node child : root.getChildren()) {
            childNodeList.add(maxDepth(child));
        }
        return Collections.max(childNodeList) + 1;
    }

    /**
     * 429.N 叉树的层序遍历
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）
     *
     * @param root N 叉树根节点
     *
     * @return N 叉树层序遍历结果集
     */
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < curSize; ++i) {
                Node node = queue.poll();
                if (node != null) {
                    group.add(node.getValue());
                    if (node.getChildren() != null) {
                        for (Node child : node.getChildren()) {
                            queue.offer(child);
                        }
                    }
                }
            }
            result.add(group);
        }
        return result;
    }

    /**
     * 589.N 叉树的前序遍历
     * 给定一个 N 叉树，返回其节点的前序遍历
     *
     * @param root N 叉树根节点
     *
     * @return 前序遍历序列
     */
    public static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreOrder(root, result);
        return result;
    }

    private static void doPreOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.getValue());
        List<Node> children = root.getChildren();
        if (children != null) {
            for (Node node : children) {
                doPreOrder(node, result);
            }
        }
    }

    /**
     * 590. N 叉树的后序遍历
     *
     * @param root N 叉树根节点
     *
     * @return 后序遍历序列
     */
    public static List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPostOrder(root, result);
        return result;
    }

    private static void doPostOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        List<Node> children = root.getChildren();
        if (children != null) {
            for (Node node : children) {
                doPostOrder(node, result);
            }
        }
        result.add(root.getValue());
    }
}
