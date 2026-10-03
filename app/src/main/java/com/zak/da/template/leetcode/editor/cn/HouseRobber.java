package com.zak.da.template.leetcode.editor.cn;

// 198. 打家劫舍
// LeetCode: https://leetcode-cn.com/problems/house-robber/
// Related Topics 面试刷题提纲

public class HouseRobber {

    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        // [1,2,3,1] -> 4；[2,1,1,2] -> 4（奇偶分路只能得到 3，会错）
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i] = 偷到第 i 间（下标 i）时能得到的最大金额
        // 决策：不偷 i → dp[i-1]；偷 i → dp[i-2] + nums[i]
        // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        int twoHousesBack = nums[0];              // dp[0]
        int oneHouseBack = Math.max(nums[0], nums[1]); // dp[1]
        for (int i = 2; i < nums.length; i++) {
            int robToI = Math.max(oneHouseBack, twoHousesBack + nums[i]);
            twoHousesBack = oneHouseBack;
            oneHouseBack = robToI;
        }
        // 答案就是「考虑到最后一间」的最优，即 dp[n-1]
        return oneHouseBack;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
