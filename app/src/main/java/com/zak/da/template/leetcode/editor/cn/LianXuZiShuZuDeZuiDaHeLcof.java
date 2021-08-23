package com.zak.da.template.leetcode.editor.cn;

//English description is not available for the problem. Please switch to Chinese
//. Related Topics 数组 分治 动态规划 
// 👍 334 👎 0

public class LianXuZiShuZuDeZuiDaHeLcof{

    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();

        int[] demo = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("[-2, 1, -3, 4, -1, 2, 1, -5, 4] 最大子数组的和 == " + solution.maxSubArray(demo));
        int[] demoOne = new int[] {1};
        System.out.println("[1] 最大子数组的和 == " + solution.maxSubArray(demoOne));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}