package com.zak.da.daily;

/**
 * 每日一题: 263. 丑数
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class Day20210410 {

    public static void main(String[] args) {
        System.out.println("263. 丑数");
        System.out.print("6 is ugly number: " + isUgly(6));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] simple = new int[] {2, 3, 5};

        for (int item : simple) {
            while (n % item == 0) {
                n = n / item;
            }
        }

        return n == 1;
    }
}
