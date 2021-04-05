package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 构造二叉树
 */
public class BinTreeCreation {

    public static void main(String[] args) {
        int[] preOrder = new int[] {3, 9, 20, 15, 7};
        int[] inOrder = new int[] {9, 3, 15, 20, 7};
        int[] postOrder = new int[] {9, 15, 7, 20, 3};
        System.out.println("======== 105 ========");
        BinaryTreeNode result105 = buildTreeWithPreOrderAndInOrder(preOrder, inOrder);
        System.out.println("根据前序遍历和中序遍历序列得出构造的结果树为: ");
        System.out.print("前序遍历: ");
        BinTreeTraversal.preOrderTraversal(result105, null);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversal(result105, null);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversal(result105, null);
        System.out.println();
        System.out.println("======== 105 ========");
        System.out.println();
        System.out.println("======== 106 ========");
        BinaryTreeNode result106 = buildTreeWithInOrderAndPostOrder(inOrder, postOrder);
        System.out.println("根据中序遍历和后序遍历序列得出构造的结果树为: ");
        System.out.print("前序遍历: ");
        BinTreeTraversal.preOrderTraversal(result106, null);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversal(result106, null);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversal(result106, null);
        System.out.println();
        System.out.println("======== 106 ========");

        int[] pre = new int[] {1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[] {4, 5, 2, 6, 7, 3, 1};
        System.out.println();
        System.out.println("======== 889 ========");
        BinaryTreeNode result889 = buildTreeWithPreOrderAndPostOrder(pre, post);
        System.out.println("根据前序遍历和后序遍历序列得出构造的结果树为: ");
        System.out.print("前序遍历: ");
        BinTreeTraversal.preOrderTraversal(result889, null);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversal(result889, null);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversal(result889, null);
        System.out.println();
        System.out.println("======== 889 ========");
        System.out.println();

        System.out.println("======== 1008 ========");
        int[] pre1008 = new int[] {8, 5, 1, 7, 10, 12};
        BinaryTreeNode result1008 = bstFromPreOrder(pre1008);
        System.out.println("根据前序遍历构造出二叉搜索树结果为: ");
        System.out.print("前序遍历: ");
        BinTreeTraversal.preOrderTraversalWithResult(result1008);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversalWithResult(result1008);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversalWithResult(result1008);
        System.out.println();
        System.out.println("======== 1008 ========");
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * 构造哈希映射，帮助我们快速定位根节点
     */
    private static final Map<Integer, Integer> preAndInIndexMap = new HashMap<>();

    /**
     * 105.从前序与中序遍历序列构造二叉树
     *
     * @return binaryTree
     */
    public static BinaryTreeNode buildTreeWithPreOrderAndInOrder(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        preAndInIndexMap.clear();
        for (int i = 0; i < n; i++) {
            preAndInIndexMap.put(inOrder[i], i);
        }
        return doBuildTreeWithPreOrderAndInOrder(
                preOrder, 0, n - 1,
                inOrder, 0, n - 1);
    }

    /**
     * 执行构建
     *
     * @param preOrder      前序遍历结果集
     * @param preOrderStart  前序遍历左子树
     * @param preOrderEnd 前序遍历右子树
     * @param inOrder       终须遍历结果集
     * @param inOrderStart   中序遍历左子树
     * @param inOrderEnd  中序遍历右子树
     * @return  结果二叉树
     */
    private static BinaryTreeNode doBuildTreeWithPreOrderAndInOrder(int[] preOrder, int preOrderStart, int preOrderEnd,
                                                                    int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }

        int root = preOrder[preOrderStart];
        // 前序遍历中的第一个节点就是根节点，通过它在中序遍历中定位根节点
        int rootIndex = preAndInIndexMap.get(root);

        // 先把根节点建立出来
        BinaryTreeNode rooNode = new BinaryTreeNode(preOrder[preOrderStart], null, null);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = rootIndex - inOrderStart;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        rooNode.setLeft(
                doBuildTreeWithPreOrderAndInOrder(
                        preOrder, preOrderStart + 1, preOrderStart + sizeLeftSubtree,
                        inOrder, inOrderStart, rootIndex - 1));
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        rooNode.setRight(
                doBuildTreeWithPreOrderAndInOrder(
                        preOrder, preOrderStart + sizeLeftSubtree + 1, preOrderEnd,
                        inOrder,rootIndex + 1, inOrderEnd));
        return rooNode;
    }

    /**
     * 106.从中序与后序遍历序列构造二叉树
     * 构造哈希映射，帮助我们快速定位根节点
     */
    private static final Map<Integer, Integer> InAndPostIndexMap = new HashMap<>();

    /**
     * 106.从中序与后序遍历序列构造二叉树
     *
     * @param inOrder   中序遍历    [[左子树中序], 根节点, [右子树中序]]
     * @param postOrder 后序遍历    [[左子树后序], [右子树后序], 根节点]
     * @return 还原的二叉树
     */
    public  static BinaryTreeNode buildTreeWithInOrderAndPostOrder(int[] inOrder, int[] postOrder) {
        int resultLength = inOrder.length;
        for (int index = 0; index < resultLength; index++) {
            InAndPostIndexMap.put(inOrder[index], index);
        }
        return doBuildTreeWithInOrderAndPostOrder(inOrder, 0, resultLength - 1, postOrder, 0, resultLength - 1);
    }

    /**
     * 执行构建
     *
     * @param inOrder           中序遍历序列
     * @param inOrderStart      中序遍历开始下标
     * @param inOrderEnd        中序遍历结束下标
     * @param postOrder         后序遍历序列
     * @param postOrderStart    后序遍历开始下标
     * @param postOrderEnd      后序遍历结束下标
     *
     * @return  构建后的树
     */
    private static BinaryTreeNode doBuildTreeWithInOrderAndPostOrder(int[] inOrder, int inOrderStart, int inOrderEnd,
                                                                     int[] postOrder, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        // 拿到中序遍历的根节点
        int rootInMid = postOrder[postOrderEnd];
        // 拿到中序遍历根节点的下标
        int rootIndexInMid = InAndPostIndexMap.get(rootInMid);
        // 拿到左子树的大小
        int leftTreeSize = rootIndexInMid - inOrderStart;

        // 构建树
        return new BinaryTreeNode(rootInMid,
                doBuildTreeWithInOrderAndPostOrder(inOrder, inOrderStart, rootIndexInMid - 1,
                        postOrder, postOrderStart, postOrderStart + leftTreeSize - 1),
                doBuildTreeWithInOrderAndPostOrder(inOrder, rootIndexInMid + 1, inOrderEnd,
                        postOrder, postOrderStart + leftTreeSize, postOrderEnd - 1));
    }

    /**
     * 根据前序遍历和后序遍历构造二叉树
     *
     * @param preOrder  前序遍历结果集     [根节点, [左子树前序], [右子树前序]]
     * @param postOrder 后序遍历结果集     [[左子树后序], [右子树后序], 根节点]
     * @return          返回构建后的二叉树
     */
    public static BinaryTreeNode buildTreeWithPreOrderAndPostOrder(int[] preOrder, int[] postOrder) {

        int preLength = preOrder.length;
        if (preLength == 0) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preOrder[0], null, null);
        if (preLength == 1) {
            return root;
        }

        // 确定子树的节点数
        int subTreeNodeCount = 0;
        for (int i = 0; i < preLength; ++i) {
            if (preOrder[1] == postOrder[i]) {
                subTreeNodeCount = i + 1;
            }
        }

        root.setLeft(buildTreeWithPreOrderAndPostOrder(Arrays.copyOfRange(preOrder, 1, subTreeNodeCount + 1),
                Arrays.copyOfRange(postOrder, 0, subTreeNodeCount)));
        root.setRight(buildTreeWithPreOrderAndPostOrder(Arrays.copyOfRange(preOrder, subTreeNodeCount + 1, preLength),
                Arrays.copyOfRange(postOrder, subTreeNodeCount, preLength - 1)));

        return root;
    }

    /**
     * 1008. 前序遍历构造二叉搜索树
     *
     * @param preOrder 前序遍历序列
     *
     * @return 结果树
     */
    public static BinaryTreeNode bstFromPreOrder(int[] preOrder) {
        if (preOrder == null) {
            return null;
        }
        int length = preOrder.length;
        if (length == 0) {
            return null;
        }
        int[] preOrderCopy = Arrays.copyOf(preOrder, length);
        Arrays.sort(preOrder);
        preAndInIndexMap.clear();
        for (int i = 0; i < length; i++) {
            preAndInIndexMap.put(preOrder[i], i);
        }
        return doBuildTreeWithPreOrderAndInOrder(preOrderCopy, 0, length - 1,
                preOrder, 0, length - 1);
    }
}
