package com.zak.da.daily;

/**
 * 每日一题: 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 */
public class Day20210415 {

    public static void main(String[] args) {
        System.out.println("213. 打家劫舍 II");
        int[] demo213 = new int[] {2, 3, 2};
        int result = rob(demo213);
        System.out.println("最高能拿到: " + result);
    }

    // TODO: 重温
    public static int rob(int[] num) {
        int length = num.length;
        if (length == 1) {
            return num[0];
        } else if (length == 2) {
            return Math.max(num[0], num[1]);
        }
        return Math.max(robRange(num, 0, length - 2), robRange(num, 1, length - 1));
    }

    public static int robRange(int[] num, int start, int end) {
        int first = num[start], second = Math.max(num[start], num[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + num[i], second);
            first = temp;
        }
        return second;
    }
}
