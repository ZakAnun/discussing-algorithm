package daily;

/**
 * 每日一题: 421. 数组中两个数的最大异或值
 *
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 * 示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 *
 * 示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 *
 * 示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210516 {

    public static void main(String[] args) {
        System.out.println("421. 数组中两个数的最大异或值: ");

        int[] demo1 = new int[] {3, 10, 5, 25, 2, 8};
        int[] demo2 = new int[] {0};
        int[] demo3 = new int[] {2, 4};
        int[] demo4 = new int[] {8, 10, 2};
        int[] demo5 = new int[] {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};

        System.out.println("示例 1: max = " + findMaximumXOR(demo1));
        System.out.println("示例 2: max = " + findMaximumXOR(demo2));
        System.out.println("示例 3: max = " + findMaximumXOR(demo3));
        System.out.println("示例 4: max = " + findMaximumXOR(demo4));
        System.out.println("示例 5: max = " + findMaximumXOR(demo5));
    }

    public static int findMaximumXOR(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return 0;
        }

        int result = -1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                result = Math.max(result, nums[i] ^ nums[j]);
            }
        }
        return result;
    }
}
