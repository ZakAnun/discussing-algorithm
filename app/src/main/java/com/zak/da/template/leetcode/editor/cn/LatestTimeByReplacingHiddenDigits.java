package com.zak.da.template.leetcode.editor.cn;

//You are given a string time in the form of hh:mm, where some of the digits in 
//the string are hidden (represented by ?). 
//
// The valid times are those inclusively between 00:00 and 23:59. 
//
// Return the latest valid time you can get from time by replacing the hidden di
//gits. 
//
// 
// Example 1: 
//
// 
//Input: time = "2?:?0"
//Output: "23:50"
//Explanation: The latest hour beginning with the digit '2' is 23 and the latest
// minute ending with the digit '0' is 50.
// 
//
// Example 2: 
//
// 
//Input: time = "0?:3?"
//Output: "09:39"
// 
//
// Example 3: 
//
// 
//Input: time = "1?:22"
//Output: "19:22"
// 
//
// 
// Constraints: 
//
// 
// time is in the format hh:mm. 
// It is guaranteed that you can produce a valid time from the given string. 
// 
// Related Topics 字符串 
// 👍 53 👎 0

public class LatestTimeByReplacingHiddenDigits{

    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();

        System.out.println("\"2?:?0\" = " + solution.maximumTime("2?:?0"));
        System.out.println("\"0?:3?\" = " + solution.maximumTime("0?:3?"));
        System.out.println("\"1?:22\" = " + solution.maximumTime("1?:22"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {
        char[] times = time.toCharArray();
        if (times[0] == '?') {
            times[0] = (times[1] >= '4' && times[1] <= '9') ? '1' : '2';
        }
        if (times[1] == '?') {
            times[1] = (times[0] == '2') ? '3' : '9';
        }
        if (times[3] == '?') {
            times[3] = '5';
        }
        if (times[4] == '?') {
            times[4] = '9';
        }
        return String.valueOf(times);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}