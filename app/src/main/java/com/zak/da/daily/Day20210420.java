package com.zak.da.daily;

/**
 * 每日一题: 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）
 * 如果不存在，则返回  -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210420 {

    public static void main(String[] args) {
        System.out.println("28. 实现 strStr()");
        System.out.println("haystack = \"hello\", needle = \"ll\" index = " + strStr("hello", "ll"));
        System.out.println("haystack = \"aaaaa\", needle = \"bba\" index = " + strStr("aaaaa", "bba"));
        System.out.println("haystack = \"\", needle = \"\" index = " + strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (!haystack.contains(needle)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }
}
