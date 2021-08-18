package template.leetcode.editor.cn;

//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics 递归 链表 
// 👍 1906 👎 0

public class ReverseLinkedList{

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode demoOne = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        ListNode demoTwo = new ListNode(1,
                new ListNode(2, null));

        System.out.print("链表 [1, 2, 3, 4, 5] 的反转链表为: ");
        solution.reverseList(demoOne).print();

        System.out.println();

        System.out.print("链表 [1, 2] 的反转链表为: ");
        solution.reverseList(demoTwo).print();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
private static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode tempH = head;
        while (tempH != null) {
            ListNode next = tempH.next;
            tempH.next = result;
            result = tempH;
            tempH = next;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}