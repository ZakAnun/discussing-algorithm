package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * 题目出处均来源与力扣("https://leetcode-cn.com/")
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

        System.out.print("二叉树前序遍历结果:");
        preOrderTraversal(root, null);
        System.out.println();

        System.out.println();
        System.out.print("二叉树中序遍历结果:");
        inOrderTraversal(root, null);
        System.out.println();

        System.out.println();
        System.out.print("二叉树后序遍历结果:");
        postOrderTraversal(root, null);
        System.out.println();

        System.out.println();
        System.out.print("二叉树自顶向下层序遍历结果:");
        topToBottomLevelOrder(root);
        System.out.println();

        System.out.println();
        System.out.print("二叉树自底向上层序遍历结果:");
        bottomToTopLevelOrder(root);
        System.out.println();

        System.out.println();
        System.out.print("二叉树锯齿形层序遍历结果：");
        jaggedOrder(root);
        System.out.println();

        System.out.println();
        System.out.print("二叉树垂序遍历结果如下：");
        verticalTraversal(root);
        System.out.println();

        System.out.println();
        System.out.print("971. 翻转二叉树以匹配先序遍历: ");
        BinaryTreeNode root971 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null),
                null);
        List<Integer> result971 = flipMatchVoyage(root971, new int[] {2, 1});
        System.out.print("result: ");
        for (Integer item : result971) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("173. 二叉搜索树迭代器: ");
        BinaryTreeNode demo173 = new BinaryTreeNode(7,
                new BinaryTreeNode(3, null, null),
                new BinaryTreeNode(15,
                        new BinaryTreeNode(9, null, null),
                        new BinaryTreeNode(20, null, null)));
        System.out.print("demo173 中序遍历序列: ");
        BSTIterator bSTIterator = new BSTIterator(demo173);
        System.out.println();
        System.out.print("demo173 结果: ");
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

        System.out.println();
        System.out.println("114. 二叉树展开为链表");
        BinaryTreeNode demoTree114 = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3, null, null),
                        new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(5,
                        null,
                        new BinaryTreeNode(6, null, null)));
        flatten(demoTree114);
        System.out.println();
        System.out.print("结果前序遍历集合: ");
        preOrderTraversal(demoTree114, null);
        System.out.println();

        System.out.println();
        System.out.println("剑指 Offer 55 - I. 二叉树的深度");
        BinaryTreeNode demoOffer55 = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));
        System.out.println("递归 demoOffer55 树的深度为: " + maxDepth(demoOffer55));
        System.out.println("栈 demoOffer55 树的深度为: " + maxDepthByStack(demoOffer55));
        System.out.println();

        System.out.println("938. 二叉搜索树的范围和");
        BinaryTreeNode demo938 = new BinaryTreeNode(10,
                new BinaryTreeNode(5,
                        new BinaryTreeNode(3, null, null),
                        new BinaryTreeNode(7, null, null)),
                new BinaryTreeNode(15,
                        null,
                        new BinaryTreeNode(18, null, null)));
        System.out.println("demo938 树节点值在 7 到 15 的总和 = " + rangeSumBST(demo938, 7, 15));
        System.out.println();

        System.out.println("剑指 Offer 54. 二叉搜索树的第k大节点");
        BinaryTreeNode demoOffer54 = new BinaryTreeNode(3,
                new BinaryTreeNode(1, null,
                        new BinaryTreeNode(2, null, null)),
                new BinaryTreeNode(4, null, null));
        int result54 = kthLargest(demoOffer54, 1);
        System.out.println("demo54 树中第 1 大的节点值 = " + result54);
        System.out.println();

        System.out.println("637. 二叉树的层平均值");
        BinaryTreeNode demo637 = new BinaryTreeNode(3,
                new BinaryTreeNode(9, null, null),
                new BinaryTreeNode(20,
                        new BinaryTreeNode(15, null, null),
                        new BinaryTreeNode(7, null, null)));
        List<Double> result637BFS = averageOfLevelsBFS(demo637);
        System.out.print("demo637 树每层的节点值的平均值为: ");
        for (double item : result637BFS) {
            System.out.print(item + " ");
        }
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

    /**
     * 114. 二叉树展开为链表
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     *  展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root 根节点
     */
    public static void flatten(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print("前序遍历结果集合: ");
        List<Integer> preOrder = preOrderTraversalWithResult(root);

        BinaryTreeNode tempNode = root;
        int length = preOrder.size();
        for (int i = 0; i < length; i++) {
            tempNode.setValue(preOrder.get(i));
            tempNode.setLeft(null);
            if (i != length - 1) {
                tempNode.setRight(new BinaryTreeNode());
                tempNode = tempNode.getRight();
            }
        }
    }

    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * 104. 二叉树的最大深度
     *
     * 递归解法
     *
     * @param root 根节点
     *
     * @return 二叉树的深度
     */
    public static int maxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
    }

    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     *
     * 栈解法（垂序遍历代码也在这）
     *
     * @param root 根节点
     *
     * @return 二叉树的深度
     */
    public static int maxDepthByStack(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();

        nodeStack.push(root);
        levelStack.push(1);

        int depth = 0;

        while (!nodeStack.isEmpty()) {
            BinaryTreeNode node = nodeStack.pop();
            int temp = levelStack.pop();

            depth = Math.max(temp, depth);

            if (node.getLeft() != null) {
                nodeStack.push(node.getLeft());
                levelStack.push(temp + 1);
            }
            if (node.getRight() != null) {
                nodeStack.push(node.getRight());
                levelStack.push(temp + 1);
            }
        }

        return depth;
    }

    private static int rangSumBSTResult = 0;

    /**
     * 938. 二叉搜索树的范围和
     *
     * @param root  二叉搜索树
     * @param low   低范围边界值
     * @param high  高范围边界值
     *
     * @return  在指定范围的节点值总和
     */
    public static int rangeSumBST(BinaryTreeNode root, int low, int high) {
        inOrder(root, low, high);
        return rangSumBSTResult;
    }

    private static void inOrder(BinaryTreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeft(), low, high);

        if (root.getValue() >= low && root.getValue() <= high) {
            rangSumBSTResult += root.getValue();
        }

        inOrder(root.getRight(), low, high);
    }

    private static int kVal = 0;
    private static int res = 0;
    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     *
     * @param root  二叉搜索树
     * @param k     数字
     *
     * @return 二叉搜索树中第 k 大的节点
     */
    public static int kthLargest(BinaryTreeNode root, int k) {
        kVal = k;
        inOrderKthLargest(root);
        return res;
    }

    private static void inOrderKthLargest(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inOrderKthLargest(root.getRight());
        if (kVal == 0) {
            return;
        }
        if (--kVal == 0) {
            res = root.getValue();
        }
        inOrderKthLargest(root.getLeft());
    }

    /**
     * 637. 二叉树的层平均值（BFS）TODO: 补充 DFS 解法
     *
     * @param root 二叉树
     *
     * @return 结果序列
     */
    public static List<Double> averageOfLevelsBFS(BinaryTreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    levelSum += node.getValue();

                    if (node.getLeft() != null) {
                        queue.offer(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.offer(node.getRight());
                    }
                }
            }
            result.add((double) levelSum / size);
        }

        return result;
    }
}
