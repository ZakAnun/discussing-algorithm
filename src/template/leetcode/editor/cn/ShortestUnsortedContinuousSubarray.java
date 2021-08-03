package template.leetcode.editor.cn;

//Given an integer array nums, you need to find one continuous subarray that if 
//you only sort this subarray in ascending order, then the whole array will be sor
//ted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics 栈 贪心 数组 双指
//针 排序 单调栈 
// 👍 647 👎 0

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray{

    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();

        int[] demoOne = new int[]{2, 6, 4, 8, 10, 9, 15};
        int[] demoTwo = new int[]{1, 2, 3, 4};
        int[] demoThr = new int[]{1};

        System.out.println("[2, 6, 4, 8, 10, 9, 15] 最短子数组长度 == " + solution.findUnsortedSubArray(demoOne));
        System.out.println("[1, 2, 3, 4] 最短子数组长度 == " + solution.findUnsortedSubArray(demoTwo));
        System.out.println("[1] 最短子数组长度 == " + solution.findUnsortedSubArray(demoThr));

        System.out.println();

        System.out.println("[2, 6, 4, 8, 10, 9, 15] 最短子数组长度 == " + solution.findUnsortedSubArrayBetter(demoOne));
        System.out.println("[1, 2, 3, 4] 最短子数组长度 == " + solution.findUnsortedSubArrayBetter(demoTwo));
        System.out.println("[1] 最短子数组长度 == " + solution.findUnsortedSubArrayBetter(demoThr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubArray(int[] arr) {
        if (isSorted(arr)) {
            return 0;
        }
        int length = arr.length;
        int[] sortedArr = new int[length];
        System.arraycopy(arr, 0, sortedArr, 0, length);
        Arrays.sort(sortedArr);
        int left = 0;
        int right = length - 1;
        while (arr[left] == sortedArr[left]) {
            left++;
        }
        while (arr[right] == sortedArr[right]) {
            right--;
        }
        return right - left + 1;
    }

    private boolean isSorted(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int findUnsortedSubArrayBetter(int[] arr) {
        int n = arr.length;
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int right = -1;
        int left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > arr[i]) {
                right = i;
            } else {
                maxn = arr[i];
            }
            if (minn < arr[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = arr[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}