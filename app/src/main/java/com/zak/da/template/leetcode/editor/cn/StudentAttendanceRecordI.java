package com.zak.da.template.leetcode.editor.cn;

//You are given a string s representing an attendance record for a student where
// each character signifies whether the student was absent, late, or present on th
//at day. The record only contains the following three characters: 
//
// 
// 'A': Absent. 
// 'L': Late. 
// 'P': Present. 
// 
//
// The student is eligible for an attendance award if they meet both of the foll
//owing criteria: 
//
// 
// The student was absent ('A') for strictly fewer than 2 days total. 
// The student was never late ('L') for 3 or more consecutive days. 
// 
//
// Return true if the student is eligible for an attendance award, or false othe
//rwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "PPALLP"
//Output: true
//Explanation: The student has fewer than 2 absences and was never late 3 or mor
//e consecutive days.
// 
//
// Example 2: 
//
// 
//Input: s = "PPALLL"
//Output: false
//Explanation: The student was late 3 consecutive days in the last 3 days, so is
// not eligible for the award.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] is either 'A', 'L', or 'P'. 
// 
// Related Topics 字符串 
// 👍 78 👎 0

public class StudentAttendanceRecordI{

    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordI().new Solution();

        System.out.println("学生出勤 PPALLP 能否获得出勤奖励 == " + solution.checkRecord("PPALLP"));
        System.out.println("学生出勤 PPALLL 能否获得出勤奖励 == " + solution.checkRecord("PPALLL"));
        System.out.println("学生出勤 AA 能否获得出勤奖励 == " + solution.checkRecord("AA"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
        int length = s.length();
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < length; i++) {
            char item = s.charAt(i);
            if (item == 'A') {
                aCount++;
                if (aCount >= 2) {
                    return false;
                }
            }
            if (item == 'L') {
                lCount++;
                if (lCount >= 3) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}