package com.zak.da.template.leetcode.editor.cn;

// 142. 环形链表 II
// LeetCode: https://leetcode-cn.com/problems/linked-list-cycle-ii/
// Related Topics 面试刷题提纲



public class LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        ListNode result = solution.detectCycle(head);
        if (result != null) {
            result.print();
        } else {
            System.out.println("null");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode detectCycle(ListNode head) {
        // TODO
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
