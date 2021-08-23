package com.zak.da.template.leetcode.editor.cn;

//The Tribonacci sequence Tn is defined as follows: 
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 
//
// Given n, return the value of Tn. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// Example 2: 
//
// 
//Input: n = 25
//Output: 1389537
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 37 
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1. 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 89 👎 0

public class NThTribonacciNumber{

    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();

        System.out.println("第 4 个泰波那契数 == " + solution.tribonacci(4));
        System.out.println("第 25 个泰波那契数 == " + solution.tribonacci(25));
        System.out.println("第 35 个泰波那契数 == " + solution.tribonacci(35));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int p = 0;
        int q = 0;
        int r = 1;
        int s = 1;

        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }

        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}