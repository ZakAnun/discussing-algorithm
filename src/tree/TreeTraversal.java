package tree;

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
        Node demoTree559 = new Node(1, null);
        List<Node> childrenGroup2 = new ArrayList<>();
        Node demoTree559Second = new Node(3, null);
        childrenGroup2.add(demoTree559Second);
        childrenGroup2.add(new Node(2, null));
        childrenGroup2.add(new Node(4, null));
        demoTree559.setChildren(childrenGroup2);
        List<Node> childrenGroup3 = new ArrayList<>();
        childrenGroup3.add(new Node(5, null));
        childrenGroup3.add(new Node(6, null));
        demoTree559Second.setChildren(childrenGroup3);
        System.out.print("559.N 叉树的最大深度: " + maxDepth(demoTree559));
        System.out.println();
        System.out.println("429.N 叉树的层序遍历如下: ");
        Node demoTree429 = demoTree559;
        List<List<Integer>> result = levelOrder(demoTree429);
        for (List<Integer> group : result) {
            System.out.print("[");
            for (Integer item : group) {
                System.out.print(item + " ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println("429.N 叉树的层序遍历结束");
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
}
