package com.zak.da.template.leetcode.editor.cn;

//A linked list of length n is given such that each node contains an additional 
//random pointer, which could point to any node in the list, or null. 
//
// Construct a deep copy of the list. The deep copy should consist of exactly n 
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list. 
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y. 
//
// Return the head of the copied linked list. 
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node. 
// 
//
// Your code will only be given the head of the original linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// Example 4: 
//
// 
//Input: head = []
//Output: []
//Explanation: The given linked list is empty (null pointer), so return null.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 1000 
// -10000 <= Node.val <= 10000 
// Node.random is null or is pointing to some node in the linked list. 
// 
// Related Topics 哈希表 链表 
// 👍 675 👎 0

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer{

    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();

        Node one = new Node(7);
        Node oneN = new Node(13);
        Node oneNN = new Node(11);
        Node oneNNN = new Node(10);
        Node oneNNNN = new Node(1);
        one.next = oneN;
        oneN.next = oneNN;
        oneNN.next = oneNNN;
        oneNNN.next = oneNNNN;
        one.random = null;
        oneN.random = one;
        oneNN.random = oneNNNN;
        oneNNN.random = oneNN;
        oneNNNN.random = one;

        System.out.println("标准解法（HashMap 两遍扫描，O(n) 时间 / O(n) 空间）");
        Node standardCopy = solution.copyRandomList(one);
        printCopyList(standardCopy);

        System.out.println("---");

        System.out.println("时间复杂度 O(n)，空间复杂度 O(n) — 递归 + HashMap");
        solution.cacheMap.clear();
        Node newNode = solution.copyRandomListSpaceN(one);
        printCopyList(newNode);

        System.out.println("---");

        System.out.println("时间复杂度 O(n)，空间复杂度 O(1) — 穿插节点");
        Node newNode1 = solution.copyRandomListSpaceOne(one);
        printCopyList(newNode1);
    }

    private static void printCopyList(Node head) {
        while (head != null) {
            System.out.print("val = " + head.val + ", ");
            if (head.random != null) {
                System.out.println("random val = " + head.random.val);
            } else {
                System.out.println("random == null");
            }
            head = head.next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
*/
static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {

    Map<Node, Node> cacheMap = new HashMap<>();

    /**
     * LeetCode 标准入口：HashMap 两遍扫描。
     * 第一遍建立原节点 → 新节点映射；第二遍连接 next 与 random。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = cur.next != null ? map.get(cur.next) : null;
            copy.random = cur.random != null ? map.get(cur.random) : null;
            cur = cur.next;
        }

        return map.get(head);
    }

    /**
     * 空间复杂度为 O(n) 的解法（递归 + 备忘录）
     * @param head head
     * @return 拷贝后的链表
     */
    public Node copyRandomListSpaceN(Node head) {
        if (head == null) {
            return null;
        }

        if (!cacheMap.containsKey(head)) {
            Node newNode = new Node(head.val);
            cacheMap.put(head, newNode);
            newNode.next = copyRandomListSpaceN(head.next);
            newNode.random = copyRandomListSpaceN(head.random);
        }

        return cacheMap.get(head);
    }

    /**
     * 空间复杂度为 O(1) 的解法
     * @param head head
     * @return 拷贝后的链表
     */
    public Node copyRandomListSpaceOne(Node head) {
        if (head == null) {
            return null;
        }

        // 拷贝逐个节点
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        // 拷贝 random：原节点 A 的拷贝是 A.next，A.random 的拷贝是 A.random.next
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = node.next;
            newNode.random = node.random != null ? node.random.next : null;
        }

        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
        }

        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}