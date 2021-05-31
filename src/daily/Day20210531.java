package daily;

/**
 * 每日一题: 342. 4的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210531 {

    public static void main(String[] args) {
        System.out.println("342. 4的幂: ");
        System.out.println("示例 1 结果 = " + isPowerOfFour(16));
        System.out.println("示例 2 结果 = " + isPowerOfFour(5));
        System.out.println("示例 3 结果 = " + isPowerOfFour(1));
    }

    /**
     * n & (n - 1) == 0 为 n 的 2 次幂
     * n 的 4 次幂在二进制中偶数位置为 1，后面的偶数位置需为 0
     * 因此 32 为二进制中偶数位均置为 1，然后进行与运算，为 0 表示为 4 的幂
     * @param n 输入
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
