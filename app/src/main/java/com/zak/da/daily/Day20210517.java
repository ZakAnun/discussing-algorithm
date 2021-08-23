package com.zak.da.daily;

import com.zak.da.tree.BinaryTreeNode;

/**
 * 每日一题: 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 示例 1:
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2:
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3:
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210517 {

    private static BinaryTreeNode xParentNode;
    private static int xVal;
    private static boolean isFoundX;
    private static int xDepth;

    private static BinaryTreeNode yParentNode;
    private static int yVal;
    private static boolean isFoundY;
    private static int yDepth;

    public static void main(String[] args) {
        System.out.println("993. 二叉树的堂兄弟节点: ");

        BinaryTreeNode demoOne = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4, null, null), null),
                new BinaryTreeNode(3, null, null));
        BinaryTreeNode demoTwo = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        null, new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(3,
                        null, new BinaryTreeNode(5, null, null)));
        BinaryTreeNode demoThr = new BinaryTreeNode(1,
                new BinaryTreeNode(2, null,
                        new BinaryTreeNode(4, null, null)),
                new BinaryTreeNode(3, null, null));

        System.out.println("示例 1: 是否为堂兄弟节点 = " + isCousins(demoOne, 4, 3));
        System.out.println("示例 2: 是否为堂兄弟节点 = " + isCousins(demoTwo, 5, 4));
        System.out.println("示例 3: 是否为堂兄弟节点 = " + isCousins(demoThr, 2, 3));
    }

    public static boolean isCousins(BinaryTreeNode root, int x, int y) {
        xVal = x;
        yVal = y;
        isFoundX = false;
        isFoundY = false;
        dfsTree(root, 0, null);
        return xParentNode != yParentNode && xDepth == yDepth;
    }

    /**
     *  深度优先遍历
     * @param node      node
     * @param depth     depth
     * @param parentNode parentNode
     */
    private static void dfsTree(BinaryTreeNode node, int depth, BinaryTreeNode parentNode) {
        if (node == null) {
            return;
        }

        if (node.getValue() == xVal) {
            xParentNode = parentNode;
            isFoundX = true;
            xDepth = depth;
        } else if (node.getValue() == yVal) {
            yParentNode = parentNode;
            isFoundY = true;
            yDepth = depth;
        }

        if (isFoundX && isFoundY) {
            return;
        }
        dfsTree(node.getLeft(), depth + 1, node);

        if (isFoundX && isFoundY) {
            return;
        }
        dfsTree(node.getRight(), depth + 1, node);
    }
}
