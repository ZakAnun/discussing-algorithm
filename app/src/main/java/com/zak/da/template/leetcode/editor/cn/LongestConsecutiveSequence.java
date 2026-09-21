package com.zak.da.template.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// 128. 最长连续序列
// LeetCode: https://leetcode-cn.com/problems/longest-consecutive-sequence/
// Related Topics 面试刷题提纲



public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int[] nums = new int[]{100,4,200,1,3,2,5};
        System.out.println(solution.longestConsecutive(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        // 必须遍历 set，不能遍历 nums：否则同一起点重复出现时会反复整段扫描导致 TLE
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
