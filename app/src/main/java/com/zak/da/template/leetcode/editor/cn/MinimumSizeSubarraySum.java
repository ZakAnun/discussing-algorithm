package com.zak.da.template.leetcode.editor.cn;

// 209. 长度最小的子数组
// LeetCode: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
// Related Topics 面试刷题提纲

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int sum = 0;
        int left = 0;
        int min = len + 1;

        for (int right = 0; right < len; right++) {
            sum += nums[right];
            // 合法后尽量左缩，寻找更短窗口
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min == len + 1 ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
