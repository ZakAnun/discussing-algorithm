package com.zak.da.daily;

/**
 * 每日一题: 477. 汉明距离总和
 *
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210528 {

    public static void main(String[] args) {
        System.out.println("477. 汉明距离总和: ");
        System.out.println(System.currentTimeMillis());
        System.out.println("示例 1 结果 = " + totalHammingDistance(new int[] {4, 14, 2}));
        System.out.println(System.currentTimeMillis());
        System.out.println();
        System.out.println(System.currentTimeMillis());
        System.out.println("示例 1 结果(better) = " + betterTotalHammingDistance(new int[] {4, 14, 2}));
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 暴力解法
     * @param num 输入数组
     * @return result
     */
    public static int totalHammingDistance(int[] num) {
        int result = 0;
        int length = num.length;
        for (int index = 0; index < length; index++) {
            int temp = num[index];
            for (int nextIndex = index + 1; nextIndex < length; nextIndex ++) {
                temp ^= num[nextIndex];
                result += Integer.bitCount(temp);
                temp = num[index];
            }
        }
        return result;
    }

    /**
     * @link https://leetcode-cn.com/problems/total-hamming-distance/solution/yi-ming-ju-chi-zong-he-by-leetcode-solut-t0ev/
     * @param num num
     * @return result
     */
    public static int betterTotalHammingDistance(int[] num) {
        int result = 0;
        int length = num.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int val : num) {
                c += (val >> i) & 1;
            }
            result += c * (length - c);
        }
        return result;
    }
}
