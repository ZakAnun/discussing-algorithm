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
        // dummy 保证删头节点时也有前驱
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 快指针先走 n+1 步，最终 slow 停在待删节点的前一个
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 一起走，直到 fast 到 null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除倒数第 n 个
        slow.next = slow.next.next;
        return dummy.next;
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
