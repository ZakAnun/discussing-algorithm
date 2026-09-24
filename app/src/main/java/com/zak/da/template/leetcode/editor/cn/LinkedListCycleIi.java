package com.zak.da.template.leetcode.editor.cn;

// 142. 环形链表 II
// LeetCode: https://leetcode-cn.com/problems/linked-list-cycle-ii/
// Related Topics 面试刷题提纲

public class LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();

        // 构造: [3,2,0,-4], pos = 1 → -4.next 指向 2
        ListNode n0 = new ListNode(3);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(-4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        ListNode result = solution.detectCycle(n0);
        if (result != null) {
            System.out.println("环入口值: " + result.val);
        } else {
            System.out.println("null");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 阶段一：快 2 慢 1，能否相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 走 1 步
            fast = fast.next.next;     // 走 2 步

            // 相遇 = 两个引用指向同一个节点对象
            if (slow == fast) {
                // 阶段二：一个回 head，齐步走，再相遇即入口
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        // fast 先走到 null → 无环
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
