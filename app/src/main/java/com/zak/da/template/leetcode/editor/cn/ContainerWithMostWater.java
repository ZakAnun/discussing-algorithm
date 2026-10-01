package com.zak.da.template.leetcode.editor.cn;

// 11. 盛最多水的容器
// LeetCode: https://leetcode-cn.com/problems/container-with-most-water/
// Related Topics 面试刷题提纲

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        // 两端往中间夹；需要两根柱子，所以 left < right
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, area);
            // 矮的一边内移：面积受矮边限制，指望换一根更高的
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
