package com.zak.da.daily;

/**
 * 每日一题: 523. 连续的子数组和
 *
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 *
 * 示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 *
 * 示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210602 {

    public static void main(String[] args) {
        System.out.println("523. 连续的子数组和");
        System.out.println("示例一 [23、2、4、6、7] 包含? = " + checkSubArraySum(new int[] {23, 2, 4, 6, 7}, 6));
        System.out.println("示例一 [23、2、4、6、6] 包含? = " + checkSubArraySum(new int[] {23, 2, 4, 6, 6}, 7));
    }

    public static boolean checkSubArraySum(int[] num, int k) {
        int length = num.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += num[i];
            int j = i + 1;
            if (j < length) {
                System.out.println("i = " + i + ", num[i] = " + num[i] + ", j = " + j + ", num[j] = " + num[j]);
                System.out.println((num[i] + num[j]) % k);
                if (((num[i] + num[j])) >= k && (num[i] + num[j]) % k == 0) {
                    return true;
                }
            }
        }
        return sum % k == 0;
    }
}
