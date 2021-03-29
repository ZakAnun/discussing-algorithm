package tree;

public class BinTreePractice {

    public static void main(String[] args) {
        BinaryTreeNode demoTree606_1 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), null),
                new BinaryTreeNode(3, null, null));
        BinaryTreeNode demoTree606_2 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(3, null, null));

        System.out.println("606.根据二叉树创建字符串");
        System.out.println("606_1: " + tree2Str(demoTree606_1));
        System.out.println("606_2: " + tree2Str(demoTree606_2));
    }

    /**
     * 606.根据二叉树创建字符串
     *
     * 需要采用前序遍历将二叉树转换成一个由括号和整数组成的字符串
     * 比如二叉树: [1, 2, 3, 4] 预期输出 1(2(4))(3)，原本是 1(2(4)())(3())，但是要省略不影响字符串和原始二叉树之间的一对一映射关系
     * 再如二叉树: [1, 2, 3, null, 4] 就需要输出 1(2()(4))(3)
     *
     * @return 由二叉树转换后的字符串
     */
    public static String tree2Str(BinaryTreeNode treeNode) {
        String result = "";

        if (treeNode == null) {
            return result;
        }

        result += treeNode.getValue();

        if (treeNode.getLeft() == null) {
            if (treeNode.getRight() == null) {
                result += "";
            } else {
                result += "()";
            }
        } else {
            result += "(" + tree2Str(treeNode.getLeft()) + ")";
        }

        if (treeNode.getRight() == null) {
            result += "";
        } else {
            result += "(" + tree2Str(treeNode.getRight()) + ")";
        }

        return result;
    }
}
