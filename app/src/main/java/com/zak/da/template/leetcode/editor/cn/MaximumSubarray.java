package com.zak.da.template.leetcode.editor.cn;

// 53. 最大子数组和
// LeetCode: https://leetcode-cn.com/problems/maximum-subarray/
// Related Topics 面试刷题提纲

public class MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = 以 i 结尾的最大子数组和
        // 转移：接在前面 or 从自己重新开 → dp[i] = max(nums[i], dp[i-1] + nums[i])
        // 「窗口」直觉：dp[i-1] < 0 时丢掉左半段，等价于左端重置
        int maxEndingHere = nums[0]; // dp[i]
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            answer = Math.max(answer, maxEndingHere);
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
