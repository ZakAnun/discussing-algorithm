package com.zak.da.template.leetcode.editor.cn;

//Given two integers representing the numerator and denominator of a fraction, r
//eturn the fraction in string format. 
//
// If the fractional part is repeating, enclose the repeating part in parenthese
//s. 
//
// If multiple answers are possible, return any of them. 
//
// It is guaranteed that the length of the answer string is less than 104 for al
//l the given inputs. 
//
// 
// Example 1: 
// Input: numerator = 1, denominator = 2
//Output: "0.5"
// Example 2: 
// Input: numerator = 2, denominator = 1
//Output: "2"
// Example 3: 
// Input: numerator = 2, denominator = 3
//Output: "0.(6)"
// Example 4: 
// Input: numerator = 4, denominator = 333
//Output: "0.(012)"
// Example 5: 
// Input: numerator = 1, denominator = 5
//Output: "0.2"
// 
// 
// Constraints: 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 244 👎 0

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal{

    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();

        System.out.println("1 / 2 == " + solution.fractionToDecimal(1, 2));
        System.out.println("2 / 1 == " + solution.fractionToDecimal(2, 1));
        System.out.println("2 / 3 == " + solution.fractionToDecimal(2, 3));
        System.out.println("4 / 333 == " + solution.fractionToDecimal(4, 333));
        System.out.println("1 / 5 == " + solution.fractionToDecimal(1, 5));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long top = Math.abs(numerator);
        long bottom = Math.abs(denominator);
        sb.append(top / bottom);
        long reminder = top % bottom;
        if (reminder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            map.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / bottom);
            reminder %= bottom;
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}