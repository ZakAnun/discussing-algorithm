package com.zak.da.template.leetcode.editor.cn;

// 234. 回文链表
// LeetCode: https://leetcode-cn.com/problems/palindrome-linked-list/
// Related Topics 面试刷题提纲

public class PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        System.out.println(solution.isPalindrome(head));
        System.out.println(solution.isPalindrome(head1));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 快慢指针找中点：fast 走完时，slow 在中点（后半段起点）
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 只反转后半段，得到新头 second
        ListNode second = reverse(slow);
        ListNode first = head;

        // 3. 前半 vs 后半逐个比；以后半长度为准（奇数时多出的中点会被比到自身或自然覆盖）
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
