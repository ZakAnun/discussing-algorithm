package com.zak.da.daily;

/**
 * 每日一题: 264. 丑数 II
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。（1 <= n <= 1690）
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class Day20210411 {

    public static void main(String[] args) {
        System.out.println("264. 丑数");
        System.out.println("从 1 开始，第 10 个丑数为: " + uglyNumber(10));
    }

    public static int uglyNumber(int n) {
        // 声明结集
        int[] dp = new int[n + 1];

        // base case
        dp[1] = 1;

        // 状态方程所需参数
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        // 执行状态转移方程
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;

            dp[i] = Math.min(Math.min(num2, num3), num5);

            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }

        // 返回结果
        return dp[n];
    }
}
