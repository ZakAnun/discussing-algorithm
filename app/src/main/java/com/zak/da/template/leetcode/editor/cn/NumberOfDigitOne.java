package com.zak.da.template.leetcode.editor.cn;

//Given an integer n, count the total number of digit 1 appearing in all non-neg
//ative integers less than or equal to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 13
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 278 👎 0

public class NumberOfDigitOne{

    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();

        System.out.println("13 出现 1 的个数 == " + solution.countDigitOne(13));
        System.out.println("0 出现 1 的个数 == " + solution.countDigitOne(0));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int mulk = 1;

        while (mulk <= n) {
            res += (n / (mulk * 10)) * mulk +
                    Math.min(
                            Math.max(n % (mulk * 10) - mulk + 1, 0),
                            mulk);
            mulk *= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}