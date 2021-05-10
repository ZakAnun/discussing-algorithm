package daily;

import java.util.ArrayList;
import java.util.List;

import tree.BinaryTreeNode;

/**
 * 每日一题: 872. 叶子相似的树
 *
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210510 {

    public static void main(String[] args) {
        System.out.println("872. 叶子相似的树: ");
        BinaryTreeNode demoOne1 = new BinaryTreeNode(3,
                new BinaryTreeNode(5,
                        new BinaryTreeNode(6, null, null),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(7, null, null),
                                new BinaryTreeNode(4, null, null))),
                new BinaryTreeNode(1,
                        new BinaryTreeNode(9, null, null),
                        new BinaryTreeNode(8, null, null)));
        BinaryTreeNode demoOne2 = new BinaryTreeNode(3,
                new BinaryTreeNode(5,
                        new BinaryTreeNode(6, null, null),
                        new BinaryTreeNode(7, null, null)),
                new BinaryTreeNode(1,
                        new BinaryTreeNode(4, null, null),
                        new BinaryTreeNode(2,
                                new BinaryTreeNode(9, null, null),
                                new BinaryTreeNode(8, null, null))));
        BinaryTreeNode demoTwo1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode demoTwo2 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode demoThr1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode demoThr2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode demoFou1 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null), null);
        BinaryTreeNode demoFou2 = new BinaryTreeNode(2,
                new BinaryTreeNode(2, null, null), null);
        BinaryTreeNode demoFiv1 = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null, null),
                new BinaryTreeNode(3, null, null));
        BinaryTreeNode demoFiv2 = new BinaryTreeNode(1,
                new BinaryTreeNode(3, null, null),
                new BinaryTreeNode(2, null, null));
        System.out.println("示例 1 是否为叶子相似的树: " + leafSimilar(demoOne1, demoOne2));
        System.out.println("示例 2 是否为叶子相似的树: " + leafSimilar(demoTwo1, demoTwo2));
        System.out.println("示例 3 是否为叶子相似的树: " + leafSimilar(demoThr1, demoThr2));
        System.out.println("示例 4 是否为叶子相似的树: " + leafSimilar(demoFou1, demoFou2));
        System.out.println("示例 5 是否为叶子相似的树: " + leafSimilar(demoFiv1, demoFiv2));
    }

    private static boolean leafSimilar(BinaryTreeNode root1, BinaryTreeNode root2) {
        List<Integer> firstLeafList = new ArrayList<>();
        List<Integer> secondLeafList = new ArrayList<>();
        dfs(root1, firstLeafList);
        dfs(root2, secondLeafList);

        return firstLeafList.equals(secondLeafList);
    }

    private static void dfs(BinaryTreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null &&
                root.getRight() == null) {
            leafList.add(root.getValue());
        } else {
            dfs(root.getLeft(), leafList);
            dfs(root.getRight(), leafList);
        }
    }
}
