package tree;


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

        System.out.println("前序遍历结果如下:");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("中序遍历结果如下:");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("后序遍历结果如下:");
        postOrderTraversal(root);
        System.out.println();
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
}
