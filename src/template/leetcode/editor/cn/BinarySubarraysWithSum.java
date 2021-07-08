package template.leetcode.editor.cn;

//Given a binary array nums and an integer goal, return the number of non-empty 
//subarrays with a sum goal. 
//
// A subarray is a contiguous part of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
//Explanation: The 4 subarrays are bolded and underlined below:
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,0,0,0], goal = 0
//Output: 15
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] is either 0 or 1. 
// 0 <= goal <= nums.length 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 180 👎 0

public class BinarySubarraysWithSum{

    public static void main(String[] args) {
        Solution solution = new BinarySubarraysWithSum().new Solution();

        System.out.println("nums = [1, 0, 1, 0, 1], goal = 2，满足条件的个数为: " + solution.numSubarraysWithSum(new int[] {1, 0, 1, 0, 1}, 2));
        System.out.println("nums = [0, 0, 0, 0, 0], goal = 0，满足条件的个数为: " + solution.numSubarraysWithSum(new int[] {0, 0, 0, 0, 0}, 0));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int left1 = 0;
        int left2 = 0;
        int right = 0;
        int sum1 = 0;
        int sum2 = 0;

        int result = 0;

        while (right < length) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }

            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }

            result += left2 - left1;
            right++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}