package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的遍历
 *
 *  前序遍历
 *  中序遍历
 *  后序遍历
 */
public class BinTreeTraversal {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();
        root.setValue(1);
        BinaryTreeNode secRight = new BinaryTreeNode();
        secRight.setValue(2);
        root.setRight(secRight);
        BinaryTreeNode thrLeft = new BinaryTreeNode();
        thrLeft.setValue(3);
        secRight.setLeft(thrLeft);

        System.out.println("二叉树前序遍历结果如下:");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("二叉树中序遍历结果如下:");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("二叉树后序遍历结果如下:");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("二叉树自顶向下层序遍历结果如下:");
        topToBottomLevelOrder(root);
        System.out.println();
        System.out.println("二叉树自底向上层序遍历结果如下:");
        bottomToTopLevelOrder(root);
        System.out.println();
        System.out.println("二叉树锯齿形层序遍历结果如下：");
        jaggedOrder(root);
    }

    /**
     * 前序遍历
     *
     * @param treeNode treeNode
     */
    public static void preOrderTraversal(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getValue() + " ");
        preOrderTraversal(treeNode.getLeft());
        preOrderTraversal(treeNode.getRight());
    }

    /**
     * 中序遍历
     *
     * @param treeNode treeNode
     */
    public static void inOrderTraversal(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.getLeft());
        System.out.print(treeNode.getValue() + " ");
        inOrderTraversal(treeNode.getRight());
    }

    /**
     * 后序遍历
     *
     * @param treeNode treeNode
     */
    public static void postOrderTraversal(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.getLeft());
        postOrderTraversal(treeNode.getRight());
        System.out.print(treeNode.getValue() + " ");
    }

    /**
     * 自顶向下的层序遍历
     *
     * @param treeNode treeNode
     */
    public static void topToBottomLevelOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.getValue() + " ");
                    if (node.getLeft() != null) {
                        queue.offer(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.offer(node.getRight());
                    }
                }
            }
        }
    }

    /**
     * 自底向上的层序遍历
     *
     * @param treeNode treeNode
     */
    public static void bottomToTopLevelOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        // 用于记录结果（与实际的遍历过程无关～）
        List<Integer> result = new ArrayList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            for (int i = 0; i < currentLevel; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    result.add(0, node.getValue());
                    if (node.getLeft() != null) {
                        queue.offer(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.offer(node.getRight());
                    }
                }
            }
        }
        for (int item: result) {
            System.out.print(item + " ");
        }
    }


    /**
     * 二叉树的锯齿形层序遍历
     *
     * @param treeNode treeNode
     */
    public static void jaggedOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        int countIndex = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            countIndex++;
            int currentLevel = queue.size();
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < currentLevel; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    if (countIndex % 2 == 0) {
                        group.add(0, node.getValue());
                    } else {
                        group.add(node.getValue());
                    }
                    if (node.getLeft() != null) {
                        queue.offer(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.offer(node.getRight());
                    }
                }
            }
            result.add(group);
        }
        for (List<Integer> group : result) {
            for (Integer item : group) {
                System.out.print(item + " ");
            }
        }
    }
}
