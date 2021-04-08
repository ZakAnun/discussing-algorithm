package tree;


import java.util.ArrayList;
import java.util.Collections;
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
        preOrderTraversal(root, null);
        System.out.println();
        System.out.println("二叉树中序遍历结果如下:");
        inOrderTraversal(root, null);
        System.out.println();
        System.out.println("二叉树后序遍历结果如下:");
        postOrderTraversal(root, null);
        System.out.println();
        System.out.println("二叉树自顶向下层序遍历结果如下:");
        topToBottomLevelOrder(root);
        System.out.println();
        System.out.println("二叉树自底向上层序遍历结果如下:");
        bottomToTopLevelOrder(root);
        System.out.println();
        System.out.println("二叉树锯齿形层序遍历结果如下：");
        jaggedOrder(root);
        System.out.println();
        System.out.println("二叉树垂序遍历结果如下：");
        verticalTraversal(root);
        System.out.println();
        System.out.println("971. 翻转二叉树以匹配先序遍历");
        BinaryTreeNode root971 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null),
                null);
        List<Integer> result971 = flipMatchVoyage(root971, new int[] {2, 1});
        System.out.print("result: ");
        for (Integer item : result971) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("173. 二叉搜索树迭代器");
        BinaryTreeNode demo173 = new BinaryTreeNode(7,
                new BinaryTreeNode(3, null, null),
                new BinaryTreeNode(15,
                        new BinaryTreeNode(9, null, null),
                        new BinaryTreeNode(20, null, null)));
        System.out.print("demo173 中序遍历序列: ");
        BSTIterator bSTIterator = new BSTIterator(demo173);
        System.out.println();
        System.out.print("结果: ");
        System.out.print(bSTIterator.next() + ", ");    // 返回 3
        System.out.print(bSTIterator.next() + ", ");    // 返回 7
        System.out.print(bSTIterator.hasNext() + ", "); // 返回 True
        System.out.print(bSTIterator.next() + ", ");    // 返回 9
        System.out.print(bSTIterator.hasNext() + ", "); // 返回 True
        System.out.print(bSTIterator.next() + ", ");    // 返回 15
        System.out.print(bSTIterator.hasNext() + ", "); // 返回 True
        System.out.print(bSTIterator.next() + ", ");    // 返回 20
        System.out.print(bSTIterator.hasNext() + ", "); // 返回 False
        System.out.println();
    }

    /**
     * 144.前序遍历
     *
     * @param treeNode treeNode
     * @return 前序遍历序列
     */
    public static List<Integer> preOrderTraversalWithResult(BinaryTreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(treeNode, result);
        return result;
    }

    /**
     * 144.前序遍历
     *
     * @param treeNode treeNode
     */
    public static void preOrderTraversal(BinaryTreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getValue() + " ");
        if (result != null) {
            result.add(treeNode.getValue());
        }
        preOrderTraversal(treeNode.getLeft(), result);
        preOrderTraversal(treeNode.getRight(), result);
    }

    /**
     * 94.中序遍历
     *
     * @param treeNode treeNode
     * @return 中序遍历序列
     */
    public static List<Integer> inOrderTraversalWithResult(BinaryTreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(treeNode, result);
        return result;
    }

    /**
     * 94.中序遍历
     *
     * @param treeNode treeNode
     */
    public static void inOrderTraversal(BinaryTreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.getLeft(), result);
        if (result != null) {
            result.add(treeNode.getValue());
        }
        System.out.print(treeNode.getValue() + " ");
        inOrderTraversal(treeNode.getRight(), result);
    }

    /**
     * 145.后序遍历
     *
     * @param treeNode treeNode
     * @return 后序遍历序列
     */
    public static List<Integer> postOrderTraversalWithResult(BinaryTreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(treeNode, result);
        return result;
    }

    /**
     * 145.后序遍历
     *
     * @param treeNode treeNode
     */
    public static void postOrderTraversal(BinaryTreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.getLeft(), result);
        postOrderTraversal(treeNode.getRight(), result);
        System.out.print(treeNode.getValue() + " ");
        if (result != null) {
            result.add(treeNode.getValue());
        }
    }

    /**
     * 102.自顶向下的层序遍历
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
     * 107.自底向上的层序遍历
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
     * 103.二叉树的锯齿形层序遍历
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

    static List<Location> locations;

    /**
     * 987.二叉树垂序遍历
     *
     * @param root root
     */
    public static void verticalTraversal(BinaryTreeNode root) {
        locations = new ArrayList<>();
        getFrontTraversal(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int prev = locations.get(0).x;

        for (Location loc: locations) {
            // If the x value changed, it's part of a new report.
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<>());
            }
            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(loc.value);
        }

        for (List<Integer> group : ans) {
            for (Integer item : group) {
                System.out.print(item + " ");
            }
        }
    }

    /**
     * 前序遍历记录节点坐标
     *
     * @param node   node
     * @param nodeX  nodeX
     * @param nodeY  nodeY
     */
    public static void getFrontTraversal(BinaryTreeNode node, int nodeX, int nodeY) {
        if (locations != null &&
                node != null) {
            locations.add(new Location(nodeX, nodeY, node.getValue()));
            getFrontTraversal(node.getLeft(), nodeX - 1, nodeY + 1);
            getFrontTraversal(node.getRight(), nodeX + 1, nodeY + 1);
        }
    }

    /**
     * 节点坐标
     */
    static class Location implements Comparable<Location> {
        int x;
        int y;
        int value;

        Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }


        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.y) {
                return Integer.compare(this.y, that.y);
            } else {
                return Integer.compare(this.value, that.value);
            }
        }
    }

    /**
     * 用于记录遍历的头节点位置
     */
    private static int currentRootIndex = 0;
    private static int[] expectedArr;

    /**
     * 971. 翻转二叉树以匹配先序遍历
     * 给定一个二叉树的根节点（每个节点的值都不一样）和一个预期的二叉树先序遍历
     * 通过交换节点的左右子树，可以翻转二叉树的任意节点，请翻转最少的树中节点
     * 使二叉树的先序遍历与预期的先序遍历序列一致
     * 返回，如果可以则是翻转的所有节点值，不可以则返回列表 -1
     *
     * @param root      二叉树根节点
     * @param voyage    预期先序遍历
     *
     * @return 翻转的节点值
     */
    public static List<Integer> flipMatchVoyage(BinaryTreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();
        expectedArr = voyage;

        doTraversal971(root, result);

        if (!result.isEmpty() && result.get(0) == -1) {
            result.clear();
            result.add(-1);
        }

        return result;
    }

    /**
     * 执行递归
     *
     * @param root   树的根节点
     * @param result 结果集合
     */
    private static void doTraversal971(BinaryTreeNode root, List<Integer> result) {
        if (root != null &&
                expectedArr != null &&
                expectedArr.length > 0) {
            if (root.getValue() != expectedArr[currentRootIndex++]) {
                result.clear();
                result.add(-1);
                return;
            }
            if (currentRootIndex < expectedArr.length &&
                    root.getLeft() != null &&
                    root.getLeft().getValue() != expectedArr[currentRootIndex]) {
                result.add(root.getValue());
                doTraversal971(root.getRight(), result);
                doTraversal971(root.getLeft(), result);
            } else {
                doTraversal971(root.getLeft(), result);
                doTraversal971(root.getRight(), result);
            }
        }
    }
}
