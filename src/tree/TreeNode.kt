package tree

/**
 * 二叉树节点实例
 *
 * @param value 节点存的值
 * @param left  指向左侧子节点的指针
 * @param right 执行右侧子节点的指针
 */
class BinaryTreeNode(var value: Int = 0,
                     var left: BinaryTreeNode? = null,
                     var right: BinaryTreeNode? = null)

/**
 * 树节点实例
 *
 * @param value     节点存的值
 * @param children  节点的子节点
 */
class Node(var value: Int = 0,
           var children: List<Node>? = null)