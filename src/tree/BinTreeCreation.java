package tree;

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
        BinTreeTraversal.preOrderTraversal(result105);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversal(result105);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversal(result105);
        System.out.println();
        System.out.println("======== 105 ========");
        System.out.println();
        System.out.println("======== 106 ========");
        BinaryTreeNode result106 = buildTreeWithInOrderAndPostOrder(inOrder, postOrder);
        System.out.println("根据中序遍历和后序遍历序列得出构造的结果树为: ");
        System.out.print("前序遍历: ");
        BinTreeTraversal.preOrderTraversal(result106);
        System.out.println();
        System.out.print("中序遍历: ");
        BinTreeTraversal.inOrderTraversal(result106);
        System.out.println();
        System.out.print("后序遍历: ");
        BinTreeTraversal.postOrderTraversal(result106);
        System.out.println();
        System.out.println("======== 106 ========");
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
        for (int i = 0; i < n; i++) {
            preAndInIndexMap.put(inOrder[i], i);
        }
        return doBuildTreeWithPreOrderAndInOrder(preOrder, inOrder, 0, n - 1, 0, n - 1);
    }

    /**
     * 执行构建
     *
     * @param preOrder      前序遍历结果集
     * @param inOrder       终须遍历结果集
     * @param preOrderLeft  前序遍历左子树
     * @param preOrderRight 前序遍历右子树
     * @param inOrderLeft   中序遍历左子树
     * @param inOrderRight  中序遍历右子树
     * @return  结果二叉树
     */
    private static BinaryTreeNode doBuildTreeWithPreOrderAndInOrder(int[] preOrder, int[] inOrder,
                                                                   int preOrderLeft, int preOrderRight,
                                                                   int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点，通过它在中序遍历中定位根节点
        int inOrderRoot = preAndInIndexMap.get(preOrder[preOrderLeft]);

        // 先把根节点建立出来
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preOrderLeft], null, null);
        // 得到左子树中的节点数目
        int sizeLeftSubtree = inOrderRoot - inOrderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.setLeft(doBuildTreeWithPreOrderAndInOrder(preOrder, inOrder,
                preOrderLeft + 1, preOrderLeft + sizeLeftSubtree,
                inOrderLeft, inOrderRoot - 1));
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.setRight(doBuildTreeWithPreOrderAndInOrder(preOrder, inOrder,
                preOrderLeft + sizeLeftSubtree + 1,
                preOrderRight, inOrderRoot + 1, inOrderRight));
        return root;
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

    private static BinaryTreeNode doBuildTreeWithInOrderAndPostOrder(int[] inOrder, int inOrderStart, int inOrderEnd,
                                                                     int[] postOrder, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int rootInMid = postOrder[postOrderEnd];
        int rootIndexInMid = InAndPostIndexMap.get(rootInMid);

        int leftTreeSize = rootIndexInMid - inOrderStart;

        return new BinaryTreeNode(rootInMid,
                doBuildTreeWithInOrderAndPostOrder(inOrder, inOrderStart, rootIndexInMid - 1, postOrder, postOrderStart, postOrderStart + leftTreeSize - 1),
                doBuildTreeWithInOrderAndPostOrder(inOrder, rootIndexInMid + 1, inOrderEnd, postOrder, postOrderStart + leftTreeSize, postOrderEnd - 1));
    }
}
