package com.zak.da.daily;

import java.util.Arrays;

/**
 * 每日一题: 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * eg: 输入: [10, 2] 输出 210
 */
public class Day20210412 {

    public static void main(String[] args) {
        System.out.println("179. 最大数");
        int[] demo179 = new int[] {3, 30, 34, 5, 9};
        System.out.println("demo179 的最大数为: " + largestNumber(demo179));
    }

    public static String largestNumber(int[] num) {
        int length = num.length;

        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = num[i];
        }

        // 传入比较器
        Arrays.sort(numArr, (x, y) -> {
            long sx = 10;
            long sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int item : numArr) {
            result.append(item);
        }
        return result.toString();
    }
}
