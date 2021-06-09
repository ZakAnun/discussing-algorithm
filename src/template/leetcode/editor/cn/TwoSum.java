package template.leetcode.editor.cn;

//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics 数组 哈希表 
// 👍 11298 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] resultOne = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        int[] resultTwo = solution.twoSum(new int[] {3, 2, 4}, 6);
        int[] resultThr = solution.twoSum(new int[] {3, 3}, 6);

        System.out.println("示例一: " + Arrays.toString(resultOne));
        System.out.println("示例二: " + Arrays.toString(resultTwo));
        System.out.println("示例三: " + Arrays.toString(resultThr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        // O(n^2)
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] {i, j};
//                }
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int delta = target - nums[i];
            if (map.containsKey(delta)) {
                return new int[] {map.get(delta), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}