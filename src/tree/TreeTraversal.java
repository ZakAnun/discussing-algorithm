package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
}
