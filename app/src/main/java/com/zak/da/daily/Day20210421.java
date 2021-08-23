package com.zak.da.daily;

/**
 * 每日一题: 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，
 * 反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，
 * 这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210421 {

    public static void main(String[] args) {
        System.out.println("91. 解码方法");
        System.out.println("输入字符串 \"12\", 得出的解码数为: " + numDecodingBetter("12"));
        System.out.println("输入字符串 \"226\", 得出的解码数为: " + numDecodingBetter("226"));
        System.out.println("输入字符串 \"0\", 得出的解码数为: " + numDecodingBetter("0"));
        System.out.println("输入字符串 \"06\", 得出的解码数为: " + numDecodingBetter("0"));
    }

    /**
     * 动态规划得出过程中的值
     *
     * @param s 待解码字符串
     * @return 解码方法总数
     */
    public static int numDecoding(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    /**
     * 空间复杂度为 1 的解题方式
     *
     * @param s  待解码字符串
     * @return 解码方法总数
     */
    public static int numDecodingBetter(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
