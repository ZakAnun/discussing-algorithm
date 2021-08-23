package com.zak.da.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题: 137. 只出现一次的数字 II
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，
 * 其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 */
public class Day20210430 {

    public static void main(String[] args) {
        System.out.println("137. 只出现一次的数字 II");
        int[] demo137One = new int[] {2, 2, 3, 2};
        int[] demo137Two = new int[] {0, 1, 0, 1, 0, 1, 99};
        System.out.println("demoOne 的结果为: " + singleNumber(demo137One) + "\n" +
                "demoTwo 的结果为: " + singleNumber(demo137Two));
    }

    /**
     * 常规解法
     *
     * @param nums 目标数组
     *
     * @return 结果值
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                int record = numMap.get(num);
                numMap.put(num, record + 1);
            } else {
                numMap.put(num, 1);
            }
        }
        int result = 0;
        for (int key : numMap.keySet()) {
            if (numMap.get(key) == 1) {
                result = key;
            }
        }
        return result;
    }
}
