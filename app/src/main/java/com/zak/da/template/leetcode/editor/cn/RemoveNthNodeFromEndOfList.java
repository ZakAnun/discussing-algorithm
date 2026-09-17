package com.zak.da.template.leetcode.editor.cn;

// 19. 删除链表倒数第 N 个节点
// LeetCode: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
// Related Topics 面试刷题提纲



public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.removeNthFromEnd(head, 2);
        if (result != null) {
            result.print();
        } else {
            System.out.println("null");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // TODO: 快慢指针
        return null;
    }
}

private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
