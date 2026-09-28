package com.zak.da.template.leetcode.editor.cn;

// 739. 每日温度
// LeetCode: https://leetcode-cn.com/problems/daily-temperatures/
// Related Topics 面试刷题提纲 — 单调栈

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(nums)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 单调递减栈存下标：遇到更高温度时，栈顶日期的「等待天数」被确定。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
