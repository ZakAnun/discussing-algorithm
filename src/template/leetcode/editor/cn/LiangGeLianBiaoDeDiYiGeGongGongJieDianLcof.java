package template.leetcode.editor.cn;

//English description is not available for the problem. Please switch to Chinese
//. Related Topics 哈希表 链表 双指针 
// 👍 300 👎 0

public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{

    public static void main(String[] args) {
        Solution solution = new LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(0);
        listB.next.next = new ListNode(1);
        listB.next.next.next = listA.next.next;

        ListNode result = solution.getIntersectionNode(listA, listB);
        if (result != null) {
            System.out.println("Intersected at " + result.val);
        } else {
            System.out.println("null");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}