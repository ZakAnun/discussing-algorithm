package template.leetcode.editor.cn;

//You have a set of integers s, which originally contains all the numbers from 1
// to n. Unfortunately, due to some error, one of the numbers in s got duplicated 
//to another number in the set, which results in repetition of one number and loss
// of another number. 
//
// You are given an integer array nums representing the data status of this set 
//after the error. 
//
// Find the number that occurs twice and the number that is missing and return t
//hem in the form of an array. 
//
// 
// Example 1: 
// Input: nums = [1,2,2,4]
//Output: [2,3]
// Example 2: 
// Input: nums = [1,1]
//Output: [1,2]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 位运算 数组 哈希表 排序 
// 👍 214 👎 0

import java.util.Arrays;

public class SetMismatch{

    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();

        System.out.print("示例1 [1, 2, 2, 4]，错误集合 = [");
        int[] res1 = solution.findErrorNums(new int[] {1, 2, 2, 4});
        System.out.println(res1[0] + ", " + res1[1] + "]");

        System.out.print("示例2 [1, 1]，错误集合 = [");
        int[] res2 = solution.findErrorNums(new int[] {1, 1});
        System.out.println(res2[0] + ", " + res2[1] + "]");

        System.out.print("示例3 [2, 2]，错误集合 = [");
        int[] res3 = solution.findErrorNums(new int[] {2, 2});
        System.out.println(res3[0] + ", " + res3[1] + "]");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int length = nums.length;
        Arrays.sort(nums);

        int last = 0;
        for (int curr : nums) {
            if (curr == last) {
                result[0] = curr;
            } else if (curr - last > 1) {
                result[1] = last + 1;
            }

            last = curr;
        }

        if (nums[length - 1] != length) {
            result[1] = length;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}