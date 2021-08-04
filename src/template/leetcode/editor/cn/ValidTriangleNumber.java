package template.leetcode.editor.cn;

//Given an integer array nums, return the number of triplets chosen from the arr
//ay that can make triangles if we take them as side lengths of a triangle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,2,3,4]
//Output: 3
//Explanation: Valid combinations are: 
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,3,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 254 👎 0

import java.util.Arrays;

public class ValidTriangleNumber{

    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();

        int[] demoOne = new int[] {2, 2, 3, 4};
        int[] demoTwo = new int[] {7, 0, 0, 0};

        System.out.println("[2, 2, 3, 4] 组成三角形的组数 == " + solution.triangleNumber(demoOne));
        System.out.println("[7, 0, 0, 0] 组成三角形的组数 == " + solution.triangleNumber(demoTwo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int k = j;
                int left = j;
                int right = length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result += k - j;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}