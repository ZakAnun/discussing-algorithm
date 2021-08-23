package com.zak.da.template.leetcode.editor.cn;

//The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the la
//rgest pair sum in a list of pairs. 
//
// 
// For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum w
//ould be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8. 
// 
//
// Given an array nums of even length n, pair up the elements of nums into n / 2
// pairs such that: 
//
// 
// Each element of nums is in exactly one pair, and 
// The maximum pair sum is minimized. 
// 
//
// Return the minimized maximum pair sum after optimally pairing up the elements
//. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,5,2,3]
//Output: 7
//Explanation: The elements can be paired up into pairs (3,3) and (5,2).
//The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,5,4,2,4,6]
//Output: 8
//Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
//
//The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 105 
// n is even. 
// 1 <= nums[i] <= 105 
// Related Topics 贪心 数组 双指针 排序 
// 👍 50 👎 0

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray{

    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumPairSumInArray().new Solution();
        int[] demoOne = new int[] {3, 5, 2, 3};
        int[] demoTwo = new int[] {3, 5, 4, 2, 4, 6};

        System.out.println("[3, 5, 2, 3] 最小的最大数对和 == " + solution.minPairSum(demoOne));
        System.out.println("[3, 5, 4, 2, 4, 6] 最小的最大数对和 == " + solution.minPairSum(demoTwo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while (low < high) {
            result = Math.max(nums[low] + nums[high], result);
            low++;
            high--;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}