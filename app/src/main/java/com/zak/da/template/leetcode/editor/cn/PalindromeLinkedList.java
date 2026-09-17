package com.zak.da.template.leetcode.editor.cn;

// 234. 回文链表
// LeetCode: https://leetcode-cn.com/problems/palindrome-linked-list/
// Related Topics 面试刷题提纲



public class PalindromeLinkedList {

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(solution.isPalindrome(head));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(ListNode head) {
        // TODO
        return false;
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
