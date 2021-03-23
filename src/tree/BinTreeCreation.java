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
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * 构造哈希映射，帮助我们快速定位根节点
     */
    private static Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 105.从前序与中序遍历序列构造二叉树
     *
     * @return binaryTree
     */
    public static BinaryTreeNode buildTreeWithPreOrderAndInOrder(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inOrder[i], i);
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
    public static BinaryTreeNode doBuildTreeWithPreOrderAndInOrder(int[] preOrder, int[] inOrder,
                                                                   int preOrderLeft, int preOrderRight,
                                                                   int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点，通过它在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preOrder[preOrderLeft]);

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


}
