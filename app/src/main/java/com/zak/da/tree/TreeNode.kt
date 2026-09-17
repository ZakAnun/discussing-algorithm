package com.zak.da.tree

/**
 * 树节点实例
 *
 * @param value     节点存的值
 * @param children  节点的子节点
 */
class Node(var value: Int = 0,
           var children: List<Node>? = null)