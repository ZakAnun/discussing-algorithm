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
        System.out.println();

        System.out.println("剑指 Offer 68 - II. 二叉树的最近公共祖先");
        BinaryTreeNode demoOffer68SubP = new BinaryTreeNode(5,
                new BinaryTreeNode(6, null, null),
                new BinaryTreeNode(2,
                        new BinaryTreeNode(7, null, null),
                        new BinaryTreeNode(4, null, null)));
        BinaryTreeNode demoOffer68SubQ = new BinaryTreeNode(1,
                new BinaryTreeNode(0, null, null),
                new BinaryTreeNode(8, null, null));
        BinaryTreeNode demoOffer68 = new BinaryTreeNode(3,
                demoOffer68SubP, demoOffer68SubQ);
        BinaryTreeNode resultOffer68 = lowestCommonAncestor(demoOffer68, demoOffer68SubP, demoOffer68SubQ);
        System.out.println("demoOffer68 的 P、Q 子树的最近公共祖先根节点为: " + resultOffer68.getValue());

        System.out.println();

        System.out.println("235. 二叉搜索树的最近公共祖先");
        BinaryTreeNode demo235TwoQ = new BinaryTreeNode(4,
                new BinaryTreeNode(3, null, null),
                new BinaryTreeNode(5, null, null));
        BinaryTreeNode demo235P = new BinaryTreeNode(2,
                new BinaryTreeNode(0, null, null), demo235TwoQ);
        BinaryTreeNode demo235Q = new BinaryTreeNode(8,
                new BinaryTreeNode(7, null, null),
                new BinaryTreeNode(9, null, null));
        BinaryTreeNode demo235 = new BinaryTreeNode(6,
                demo235P, demo235Q);
        BinaryTreeNode result235One = lowestCommonAncestorBST(demo235, demo235P, demo235Q);
        BinaryTreeNode result235Two = lowestCommonAncestorBST(demo235, demo235P, demo235TwoQ);
        System.out.println("235 示例 1 结果节点值 = " + result235One.getValue());
        System.out.println("235 示例 2 结果节点值 = " + result235Two.getValue());

        System.out.println();

        System.out.println("1022. 从根到叶的二进制数之和");
        BinaryTreeNode demo1022One = new BinaryTreeNode(1,
                new BinaryTreeNode(0,
                        new BinaryTreeNode(0, null, null),
                        new BinaryTreeNode(1, null, null)),
                new BinaryTreeNode(1,
                        new BinaryTreeNode(0, null, null),
                        new BinaryTreeNode(1, null, null)));
        BinaryTreeNode demo1022Two = new BinaryTreeNode(0, null, null);
        BinaryTreeNode demo1022Three = new BinaryTreeNode(1, null, null);
        BinaryTreeNode demo1022Four = new BinaryTreeNode(1,
                new BinaryTreeNode(1, null, null), null);
        System.out.println("1022 示例 1 的结果为: " + sumRootToLeaf(demo1022One));
        resultSumRootToLeaf = 0;
        System.out.println("1022 示例 2 的结果为: " + sumRootToLeaf(demo1022Two));
        resultSumRootToLeaf = 0;
        System.out.println("1022 示例 3 的结果为: " + sumRootToLeaf(demo1022Three));
        resultSumRootToLeaf = 0;
        System.out.println("1022 示例 4 的结果为: " + sumRootToLeaf(demo1022Four));
        resultSumRootToLeaf = 0;

        System.out.println();

        System.out.println("965. 单值二叉树");
        BinaryTreeNode demo965One = new BinaryTreeNode(1,
                new BinaryTreeNode(1,
                        new BinaryTreeNode(1, null, null),
                        new BinaryTreeNode(1, null, null)),
                new BinaryTreeNode(1,
                        null,
                        new BinaryTreeNode(1, null, null)));
        BinaryTreeNode demo965Two = new BinaryTreeNode(2,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(5, null, null),
                        new BinaryTreeNode(2, null, null)),
                new BinaryTreeNode(2,
                        null, null));
        System.out.println("965 示例 1: 结果 = " + isUniValTree(demo965One));
        System.out.println("965 示例 2: 结果 = " + isUniValTree(demo965Two));

        System.out.println();

        System.out.println("257. 二叉树的所有路径");
        BinaryTreeNode demo257 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null,
                        new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(3, null, null));
        List<String> result257 = binaryTreePaths(demo257);
        System.out.println("demo257 结果为: ");
        for (String item : result257) {
            System.out.println(item);
        }

        System.out.println();

        System.out.println("563. 二叉树的坡度: ");
        BinaryTreeNode demo563One = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null),
                new BinaryTreeNode(3, null, null));
        BinaryTreeNode demo563Two = new BinaryTreeNode(4,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3, null, null),
                        new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(9,
                        null,
                        new BinaryTreeNode(7, null, null)));
        BinaryTreeNode demo563Thr = new BinaryTreeNode(21,
                new BinaryTreeNode(7,
                        new BinaryTreeNode(1,
                                new BinaryTreeNode(3, null, null),
                                new BinaryTreeNode(3, null, null)),
                        new BinaryTreeNode(1, null, null)),
                new BinaryTreeNode(14,
                        new BinaryTreeNode(2, null, null),
                        new BinaryTreeNode(2, null, null)));
        System.out.println("563 示例 1 坡度 = " + findTilt(demo563One));
        System.out.println("563 示例 2 坡度 = " + findTilt(demo563Two));
        System.out.println("563 示例 3 坡度 = " + findTilt(demo563Thr));
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

    /**
     * 剑指 Offer 68 - II. 二叉树的最近公共祖先
     * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root  树的根节点
     * @param p     树的节点
     * @param q     树的节点
     * @return  最近公共祖先
     */
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root == p || root == q ||
                root.getValue() == p.getValue() ||
                root.getValue() == q.getValue()) {
            return root;
        }
        BinaryTreeNode left = lowestCommonAncestor(root.getLeft(), p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.getRight(), p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 示例1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * 示例2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static BinaryTreeNode lowestCommonAncestorBST(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        BinaryTreeNode result = root;
        while (true) {
            if (p.getValue() < result.getValue() && q.getValue() < result.getValue()) {
                result = result.getLeft();
            } else if (p.getValue() > result.getValue() && q.getValue() > result.getValue()) {
                result = result.getRight();
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 1022. 从根到叶的二进制数之和
     *
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     *
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     *
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     *
     * 示例1:
     * 输入：root = [1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     *
     * 示例 2：
     *
     * 输入：root = [0]
     * 输出：0
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：1
     * 示例 4：
     *
     * 输入：root = [1,1]
     * 输出：3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int resultSumRootToLeaf = 0;
    public static int sumRootToLeaf(BinaryTreeNode root) {
        doSumRootToLeaf(root, 0);
        return resultSumRootToLeaf;
    }

    private static void doSumRootToLeaf(BinaryTreeNode root, int val) {
        if (root == null) {
            return;
        }

        val = val << 1;
        if (root.getLeft() == null && root.getRight() == null) {
            resultSumRootToLeaf += root.getValue() == 0 ? val : val + 1;
            return;
        }

        val = root.getValue() == 0 ? val : val + 1;
        doSumRootToLeaf(root.getLeft(), val);
        doSumRootToLeaf(root.getRight(), val);
    }

    /**
     * 965. 单值二叉树
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     * 示例 1:
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
     *
     * 示例 2:
     * 输入：[2,2,2,5,2]
     * 输出：false
     *
     * @param root 二叉树根节点
     * @return  是否为单值二叉树
     */
    public static boolean isUniValTree(BinaryTreeNode root) {
        return postOrder(root, root.getValue());
    }

    private static boolean postOrder(BinaryTreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.getValue() != val) {
            return false;
        }
        return postOrder(root.getLeft(), val) && postOrder(root.getRight(), val);
    }

    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例
     * 输入: [1, 2, 5, 3]
     * 输出: 1->2->5, 1->3
     *
     * @param root 树
     * @return 从根节点到叶子节点的全部路径
     */
    public static List<String> binaryTreePaths(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        List<String> result = new ArrayList<>();
        binTreeTraversal257(root, "", result);
        return result;
    }

    private static void binTreeTraversal257(BinaryTreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(path);
        if (root.getLeft() == null && root.getRight() == null) {
            sb.append(root.getValue());
            result.add(sb.toString());
        } else {
            sb.append(root.getValue()).append("->");

            binTreeTraversal257(root.getLeft(), sb.toString(), result);
            binTreeTraversal257(root.getRight(), sb.toString(), result);
        }
    }

    private static int result563 = 0;
    /**
     * 563. 二叉树的坡度
     *
     * 给定一个二叉树，计算 整个树 的坡度 。
     *
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的差的绝对值。
     * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     *
     * 整个树 的坡度就是其所有节点的坡度之和。
     *
     * 示例 1:
     * 输入：root = [1,2,3]
     * 输出：1
     * 解释：
     * 节点 2 的坡度：|0-0| = 0（没有子节点）
     * 节点 3 的坡度：|0-0| = 0（没有子节点）
     * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
     * 坡度总和：0 + 0 + 1 = 1
     *
     * 示例 2:
     * 输入：root = [4,2,9,3,5,null,7]
     * 输出：15
     * 解释：
     * 节点 3 的坡度：|0-0| = 0（没有子节点）
     * 节点 5 的坡度：|0-0| = 0（没有子节点）
     * 节点 7 的坡度：|0-0| = 0（没有子节点）
     * 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
     * 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
     * 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
     * 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
     *
     * 示例 3:
     * 输入：root = [21,7,14,1,1,2,2,3,3]
     * 输出：9
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root root
     * @return 二叉树坡度
     */
    public static int findTilt(BinaryTreeNode root) {
        result563 = 0;
        doFindTile(root);
        return result563;
    }

    private static int doFindTile(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = doFindTile(root.getLeft());
        int right = doFindTile(root.getRight());

        result563 += Math.abs(left - right);
        return  left + right + root.getValue();
    }
}
