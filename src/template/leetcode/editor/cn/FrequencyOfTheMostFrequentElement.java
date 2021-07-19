package template.leetcode.editor.cn;

//The frequency of an element is the number of times it occurs in an array. 
//
// You are given an integer array nums and an integer k. In one operation, you c
//an choose an index of nums and increment the element at that index by 1. 
//
// Return the maximum possible frequency of an element after performing at most 
//k operations. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,4], k = 5
//Output: 3
//Explanation: Increment the first element three times and the second element tw
//o times to make nums = [4,4,4].
//4 has a frequency of 3. 
//
// Example 2: 
//
// 
//Input: nums = [1,4,8,13], k = 5
//Output: 2
//Explanation: There are multiple optimal solutions:
//- Increment the first element three times to make nums = [4,4,8,13]. 4 has a f
//requency of 2.
//- Increment the second element four times to make nums = [1,8,8,13]. 8 has a f
//requency of 2.
//- Increment the third element five times to make nums = [1,4,13,13]. 13 has a 
//frequency of 2.
// 
//
// Example 3: 
//
// 
//Input: nums = [3,9,6], k = 2
//Output: 1
//
// Example 4:
//
//Input: nums = [9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966]
//k = 3056
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 1 <= k <= 105 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 104 👎 0

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement{

    public static void main(String[] args) {
        Solution solution = new FrequencyOfTheMostFrequentElement().new Solution();

        int[] demoOne = new int[]{1, 2, 4};
        int[] demoTwo = new int[]{1, 4, 8, 13};
        int[] demoThr = new int[]{3, 9, 6};
        int[] demoFou = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};

        System.out.print("arr = [1, 2, 4]，k = 5 的频数等于： ");
        System.out.println(solution.maxFrequency(demoOne, 5));
        System.out.print("arr = [1, 4, 8, 13]，k = 5 的频数等于： ");
        System.out.println(solution.maxFrequency(demoTwo, 5));
        System.out.print("arr = [3, 9, 6]，k = 2 的频数等于： ");
        System.out.println(solution.maxFrequency(demoThr, 2));
        System.out.print("arr = [9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,\n9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,\n9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,\n9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,\n9954,9932,9964,9972,9935,9946,9966]，k = 3056 的频数等于： ");
        System.out.println(solution.maxFrequency(demoFou, 3056));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int result = 1;

        for (int right = 1; right < length; right++) {
            total += (nums[right] - nums[right - 1]) * (right - left);
            while (total > k) {
                total -= nums[right] - nums[left];
                ++left;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}