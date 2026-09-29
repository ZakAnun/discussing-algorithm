package com.zak.da.template.leetcode.editor.cn;

// 33. 搜索旋转排序数组
// LeetCode: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
// Related Topics 面试刷题提纲

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 0)); // 4
        System.out.println(solution.search(nums, 3)); // -1
        // 短旋转数组：左半无序时需走右半有序分支
        int[] nums1 = new int[]{3, 1};
        System.out.println(solution.search(nums1, 1)); // 1
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 先判断左半 [left, mid] 是否升序
            if (nums[left] <= nums[mid]) {
                // 左半有序：看 target 是否落在左半数值范围内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // 在有序左半里
                } else {
                    left = mid + 1;  // 不在，去右半继续
                }
            } else {
                // 右半 [mid, right] 有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // 在有序右半里
                } else {
                    right = mid - 1; // 不在，去左半继续
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
