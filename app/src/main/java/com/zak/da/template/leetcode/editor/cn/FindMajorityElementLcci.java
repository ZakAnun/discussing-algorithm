package com.zak.da.template.leetcode.editor.cn;

//A majority element is an element that makes up more than half of the items in 
//an array. Given a integers array, find the majority element. If there is no majo
//rity element, return -1. Do this in O(N) time and O(1) space. 
//
// Example 1: 
//
// 
//Input: [1,2,5,9,5,9,5,5,5]
//Output: 5 
//
// 
//
// Example 2: 
//
// 
//Input: [3,2]
//Output: -1 
//
// 
//
// Example 3: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics 数组 计数 
// 👍 161 👎 0

import java.util.Arrays;

public class FindMajorityElementLcci{

    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();

        int[] one = new int[] {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int[] two = new int[] {3, 2};
        int[] thr = new int[] {2, 2, 1, 1, 1, 2, 2};
        int[] four = new int[] {3, 2, 3};

        System.out.println("方法一: ");
        System.out.println("[1, 2, 5, 9, 5, 9, 5, 5, 5]，符合条件的值为 " + solution.majorityElement(one));
        System.out.println("[3, 2]，符合条件的值为 " + solution.majorityElement(two));
        System.out.println("[2, 2, 1, 1, 1, 2, 2]，符合条件的值为 " + solution.majorityElement(thr));
        System.out.println("[3, 2, 3]，符合条件的值为 " + solution.majorityElement(four));

        System.out.println();
        System.out.println("---");
        System.out.println();

        System.out.println("方法二: ");
        System.out.println("[1, 2, 5, 9, 5, 9, 5, 5, 5]，符合条件的值为 " + solution.majorityElement2(one));
        System.out.println("[3, 2]，符合条件的值为 " + solution.majorityElement2(two));
        System.out.println("[2, 2, 1, 1, 1, 2, 2]，符合条件的值为 " + solution.majorityElement2(thr));
        System.out.println("[3, 2, 3]，符合条件的值为 " + solution.majorityElement2(four));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int maxTimes = length / 2;
        int maxNum = -1;
        int roundTimes = 0;
        int roundNum = 0;
        for (int item : nums) {
            if (roundNum != item) {
                if (roundTimes > maxTimes) {
                    maxNum = roundNum;
                    maxTimes = roundTimes;
                }
                roundNum = item;
                roundTimes = 1;
            } else {
                roundTimes++;
            }
        }
        if (roundTimes > maxTimes) {
            maxNum = roundNum;
            maxTimes = roundTimes;
        }
        return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}