package daily;

/**
 * 每日一题: 461. 汉明距离
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * （就是找出二进制中对应的位值不同的个数，使用疑惑然后计算 1 的位置）
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 示例 1:
 * 输入: x = 1, y = 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: x = 3, y = 1
 * 输出: 1
 */
public class Day20210527 {

    public static void main(String[] args) {
        System.out.println("461. 汉明距离: ");
        System.out.println("示例 1: 结果 = " + hammingDistance(1, 4));
        System.out.println("示例 2: 结果 = " + hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
