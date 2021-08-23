package com.zak.da.template.leetcode.editor.cn;

//You are given a 2D integer array ranges and two integers left and right. Each 
//ranges[i] = [starti, endi] represents an inclusive interval between starti and e
//ndi. 
//
// Return true if each integer in the inclusive range [left, right] is covered b
//y at least one interval in ranges. Return false otherwise. 
//
// An integer x is covered by an interval ranges[i] = [starti, endi] if starti <
//= x <= endi. 
//
// 
// Example 1: 
//
// 
//Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
//Output: true
//Explanation: Every integer between 2 and 5 is covered:
//- 2 is covered by the first range.
//- 3 and 4 are covered by the second range.
//- 5 is covered by the third range.
// 
//
// Example 2: 
//
// 
//Input: ranges = [[1,10],[10,20]], left = 21, right = 21
//Output: false
//Explanation: 21 is not covered by any range.
// 
//
// 
// Constraints: 
//
// 
// 1 <= ranges.length <= 50 
// 1 <= starti <= endi <= 50 
// 1 <= left <= right <= 50 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 78 👎 0

public class CheckIfAllTheIntegersInARangeAreCovered{

    public static void main(String[] args) {
        Solution solution = new CheckIfAllTheIntegersInARangeAreCovered().new Solution();

        int[][] ranges = new int[][] {
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{5, 6}
        };

        System.out.println("[[1, 2], [3, 4], [5, 6]], left = 2, right = 5, ranges 是否覆盖 left 和 right？" + solution.isCoveredSimple(ranges, 2, 5));
        System.out.println("[[1, 2], [3, 4], [5, 6]], left = 2, right = 5, ranges 是否覆盖 left 和 right？" + solution.isCoveredBest(ranges, 2, 5));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isCoveredSimple(int[][] ranges, int left, int right) {
        boolean[] flags = new boolean[51];

        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                flags[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!flags[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isCoveredBest(int[][] ranges, int left, int right) {
        int[] diff = new int[52];   // 差分数组
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}