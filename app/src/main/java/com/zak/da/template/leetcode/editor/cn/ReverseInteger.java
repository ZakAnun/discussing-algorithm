package com.zak.da.template.leetcode.editor.cn;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversi
//ng x causes the value to go outside the signed 32-bit integer range [-231, 231 -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2893 👎 0

public class ReverseInteger{

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println("input x = 123, result = " + solution.reverse(123));
        System.out.println("input x = -123, result = " + solution.reverse(-123));
        System.out.println("input x = 120, result = " + solution.reverse(120));
        System.out.println("input x = 0, result = " + solution.reverse(0));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}