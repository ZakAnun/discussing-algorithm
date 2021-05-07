package daily;

/**
 * 每日一题: 1486. 数组异或操作
 *
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 *
 * 示例 4：
 * 输入：n = 10, start = 5
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210507 {

    public static void main(String[] args) {
        System.out.println("1486. 数组异或操作");
        System.out.println("示例 1，n = 5，start = 0，结果为: " + xorOperation(5, 0));
        System.out.println("示例 2，n = 4，start = 3，结果为: " + xorOperation(4, 3));
        System.out.println("示例 3，n = 1，start = 7，结果为: " + xorOperation(1, 7));
        System.out.println("示例 4，n = 10，start = 5，结果为: " + xorOperation(10, 5));
    }

    public static int xorOperation(int n, int start) {
        int result = start;
        // 下标从 1 开始
        for (int i = 1; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }
}
