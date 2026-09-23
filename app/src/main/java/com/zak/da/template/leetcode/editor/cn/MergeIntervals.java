package com.zak.da.template.leetcode.editor.cn;

// 56. 合并区间
// LeetCode: https://leetcode-cn.com/problems/merge-intervals/
// Related Topics 面试刷题提纲

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 1. 按 start 从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        for (int[] cur : intervals) {
            // 篮子为空，或当前 start > 最后一段 end → 接不上，新开一段
            if (merged.isEmpty() || cur[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(cur);
            } else {
                // 当前 start <= 最后一段 end → 重叠，拉长最后一段的 end
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], cur[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
