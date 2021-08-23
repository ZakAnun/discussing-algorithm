package com.zak.da.template.leetcode.editor.cn;

//Design a class to find the kth largest element in a stream. Note that it is th
//e kth largest element in the sorted order, not the kth distinct element. 
//
// Implement KthLargest class: 
//
// 
// KthLargest(int k, int[] nums) Initializes the object with the integer k and t
//he stream of integers nums. 
// int add(int val) Appends the integer val to the stream and returns the elemen
//t representing the kth largest element in the stream. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//Output
//[null, 4, 5, 5, 8, 8]
//
//Explanation
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 104 
// 0 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// -104 <= val <= 104 
// At most 104 calls will be made to add. 
// It is guaranteed that there will be at least k elements in the array when you
// search for the kth element. 
// 
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 
// 👍 283 👎 0

import java.util.PriorityQueue;

public class KthLargestElementInAStream{

    public static void main(String[] args) {
        KthLargest solution = new KthLargestElementInAStream().new KthLargest(3, new int[] {4, 5, 8, 2});

        System.out.println("add(3), return = " + solution.add(3));
        System.out.println("add(5), return = " + solution.add(5));
        System.out.println("add(10), return = " + solution.add(10));
        System.out.println("add(9), return = " + solution.add(9));
        System.out.println("add(4), return = " + solution.add(4));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {

    private int k = 0;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int item : nums) {
            add(item);
        }
    }
    
    public int add(int val) {
        queue.offer(val);

        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}