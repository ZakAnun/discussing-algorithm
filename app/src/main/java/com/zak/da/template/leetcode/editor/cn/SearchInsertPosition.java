package com.zak.da.template.leetcode.editor.cn;

// 35. 搜索插入位置
// LeetCode: https://leetcode-cn.com/problems/search-insert-position/
// Related Topics 面试刷题提纲



public class SearchInsertPosition {

    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(solution.searchInsert(nums, 5));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 没找到时，left 就是应插入的位置
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
