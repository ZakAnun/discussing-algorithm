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
        // 滚动时只保留「差 1 阶」「差 2 阶」两个结果
        int waysOneStepBack = 2;  // 到 i-1 的方法数，初始等价 dp[2]
        int waysTwoStepsBack = 1; // 到 i-2 的方法数，初始等价 dp[1]
        for (int i = 3; i <= n; i++) {
            int waysToI = waysOneStepBack + waysTwoStepsBack; // dp[i]
            // 窗口右移：原来的 i-1 变成新的 i-2，当前 i 变成新的 i-1
            waysTwoStepsBack = waysOneStepBack;
            waysOneStepBack = waysToI;
        }
        // 循环结束时 i 已走到 n，waysOneStepBack 就是「到 n」的方法数
        return waysOneStepBack;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
