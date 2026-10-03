package com.zak.da.template.leetcode.editor.cn;

// 300. 最长递增子序列
// LeetCode: https://leetcode-cn.com/problems/longest-increasing-subsequence/
// Related Topics 面试刷题提纲

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        // 4: [2,3,7,101] 或 [2,3,7,18]
        System.out.println(solution.lengthOfLISDp(nums));
        System.out.println(solution.lengthOfLISBinary(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /** 提交入口：默认走 O(n log n) */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISBinary(nums);
    }

    /**
     * O(n^2) DP —— 两个量各管一件事：
     *
     * lisEndingAt[i]（状态表，长度 n）
     *   含义：在所有「最后一个元素必须是 nums[i]」的递增子序列里，最长那条的长度。
     *   例：nums=[2,5,3,7]，lisEndingAt[3] 对应以 7 结尾 → 可以是 2,5,7 或 2,3,7，值为 3。
     *   注意：它不是「前 i 个元素的 LIS」，也不是最终要 return 的那个数。
     *
     * longestOverall（标量）
     *   含义：上面整张表里的最大值，也就是题目要的「任意结尾」的最长递增子序列长度。
     *   因为最优序列可能结束在下标 2，也可能结束在下标 5，必须对所有 i 取 max。
     *   对应关系：longestOverall == max(lisEndingAt[0], lisEndingAt[1], ...)。
     *
     * 每个 i 怎么填 lisEndingAt[i]：
     *   先 = 1（序列里只有 nums[i]）；
     *   再看每个更靠左的 j：若 nums[j] 小于 nums[i]，则可接在「以 j 结尾的那条」后面，
     *   候选长度 = lisEndingAt[j] + 1，取最大。
     */
    public int lengthOfLISDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        // 状态：lisEndingAt[i] = 以 nums[i] 结尾时，最长递增子序列有多长
        int[] lisEndingAt = new int[n];
        // 答案：所有可能结尾里，最长的那一个（题目要的结果）
        int longestOverall = 1;

        for (int i = 0; i < n; i++) {
            lisEndingAt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lisEndingAt[i] = Math.max(lisEndingAt[i], lisEndingAt[j] + 1);
                }
            }
            // 算完「以 i 结尾」这一格后，更新全局最长
            longestOverall = Math.max(longestOverall, lisEndingAt[i]);
        }
        return longestOverall;
    }

    /**
     * O(n log n)：tails[len-1] = 长度为 len 的递增子序列的最小末尾值
     * 扫到 x：若 x 更大则扩长；否则二分替换第一个 >= x 的末尾（严格递增用 >=）
     * tails 里未必是真实一条 LIS，但长度等价于 LIS 长度
     */
    public int lengthOfLISBinary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int left = 0;
            int right = size;
            // 找第一个 >= x 的位置，便于严格递增时替换
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = x;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
