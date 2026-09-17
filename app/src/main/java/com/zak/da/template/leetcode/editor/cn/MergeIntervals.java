package com.zak.da.template.leetcode.editor.cn;

// 56. 合并区间
// LeetCode: https://leetcode-cn.com/problems/merge-intervals/
// Related Topics 面试刷题提纲



public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}};
        System.out.println(java.util.Arrays.deepToString(solution.merge(intervals)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        // TODO: 排序 + 合并区间
        return new int[0][];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
