package com.zak.da.template.leetcode.editor.cn;

// 70. 爬楼梯
// LeetCode: https://leetcode-cn.com/problems/climbing-stairs/
// Related Topics 面试刷题提纲

public class ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int n = 3;
        System.out.println(solution.climbStairs(n));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // dp[i] = 爬到第 i 阶的方法数
        // 转移：最后一步走 1 阶 or 2 阶 → dp[i] = dp[i-1] + dp[i-2]
        int prev2 = 1; // dp[1]
        int prev1 = 2; // dp[2]
        for (int i = 3; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
