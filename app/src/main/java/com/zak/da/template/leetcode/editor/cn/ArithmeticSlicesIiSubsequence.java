package com.zak.da.template.leetcode.editor.cn;

//Given an integer array nums, return the number of all the arithmetic subsequen
//ces of nums. 
//
// A sequence of numbers is called arithmetic if it consists of at least three e
//lements and if the difference between any two consecutive elements is the same. 
//
//
// 
// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmeti
//c sequences. 
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence. 
// 
//
// A subsequence of an array is a sequence that can be formed by removing some e
//lements (possibly none) of the array. 
//
// 
// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10]. 
// 
//
// The answer is guaranteed to fit in 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,4,6,8,10]
//Output: 7
//Explanation: All arithmetic subsequence slices are:
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// Example 2: 
//
// 
//Input: nums = [7,7,7,7,7]
//Output: 16
//Explanation: Any subsequence of this array is arithmetic.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 动态规划 
// 👍 185 👎 0

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIiSubsequence{

    public static void main(String[] args) {
        Solution solution = new ArithmeticSlicesIiSubsequence().new Solution();

        int[] arr = new int[] {2, 4, 6, 8, 10};
        System.out.println("[2, 4, 6, 8, 10] 中所有等差子序列数目 == " + solution.numberOfArithmeticSlices(arr));
        int[] arr2 = new int[] {7, 7, 7, 7, 7};
        System.out.println("[7, 7, 7, 7, 7] 中所有等差子序列数目 == " + solution.numberOfArithmeticSlices(arr2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int length = nums.length;

        Map<Long, Integer>[] mapArr = new Map[length];
        for (int i = 0; i < length; i++) {
            mapArr[i] = new HashMap<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int ans = mapArr[j].getOrDefault(d, 0);
                result += ans;
                mapArr[i].put(d, mapArr[i].getOrDefault(d, 0) + ans + 1);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}