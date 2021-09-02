package com.zak.da.template.leetcode.editor.cn;

/**
<p>输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。</p>

<p>例如，一个链表有 <code>6</code> 个节点，从头节点开始，它们的值依次是 <code>1、2、3、4、5、6</code>。这个链表的倒数第 <code>3</code> 个节点是值为 <code>4</code> 的节点。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
给定一个链表: <strong>1->2->3->4->5</strong>, 和 <em>k </em><strong>= 2</strong>.

返回链表 4<strong>->5</strong>.</pre>
<div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 267</li><li>👎 0</li></div>
*/
public class LianBiaoZhongDaoShuDiKgeJieDianLcof{

    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode demo = new ListNode(1);
        demo.next = new ListNode(2);
        demo.next.next = new ListNode(3);
        demo.next.next.next = new ListNode(4);
        demo.next.next.next.next = new ListNode(5);

        ListNode resultOrder = solution.getKthFromEndOrder(demo, 2);
        System.out.println("链表 [1, 2, 3, 4, 5] 的倒数第 2 个节点(顺序解法) == " + resultOrder.val);

        ListNode resultDp = solution.getKthFromEndDoublePointer(demo, 2);
        System.out.println("链表 [1, 2, 3, 4, 5] 的倒数第 2 个节点(双指针解法) == " + resultDp.val);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
private static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class Solution {
    /**
     * 顺序取值（先求出链表的长度，然后取 n - k 之后的数据）
     *
     * @param head head
     * @param k k
     * @return 结果链表
     */
    public ListNode getKthFromEndOrder(ListNode head, int k) {
        int n = 0;
        ListNode node = null;
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; --n) {
            node = node.next;
        }
        return node;
    }

    public ListNode getKthFromEndDoublePointer(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}