package daily;

/**
 * 每日一题: 1442. 形成两个异或相等数组的三元组数目
 *
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 * 示例 1：
 * 输入：arr = [2,3,1,6,7]
 * 输出：4
 * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
 *
 * 示例 2：
 * 输入：arr = [1,1,1,1,1]
 * 输出：10
 *
 * 示例 3：
 * 输入：arr = [2,3]
 * 输出：0
 *
 * 示例 4：
 * 输入：arr = [1,3,5,7,9]
 * 输出：3
 *
 * 示例 5：
 * 输入：arr = [7,11,12,9,5,2,7,17,22]
 * 输出：8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210518 {

    public static void main(String[] args) {
        System.out.println("1442. 形成两个异或相等数组的三元组数目");
        int[] demoOne = new int[] {2, 3, 1, 6, 7};
        int[] demoTwo = new int[] {1, 1, 1, 1, 1};
        int[] demoThr = new int[] {2, 3};
        int[] demoFou = new int[] {1, 3, 5, 7, 9};
        int[] demoFiv = new int[] {7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println("示例 1 结果: " + countTriplets(demoOne));
        System.out.println("示例 2 结果: " + countTriplets(demoTwo));
        System.out.println("示例 3 结果: " + countTriplets(demoThr));
        System.out.println("示例 4 结果: " + countTriplets(demoFou));
        System.out.println("示例 5 结果: " + countTriplets(demoFiv));
    }

    public static int countTriplets(int[] arr) {
        int length = arr.length;
        int[] xorSum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            xorSum[i + 1] = xorSum[i] ^ arr[i];
        }
        int result = 0;
        for (int i = 0 ; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j; k < length; k++) {
                    if (xorSum[i] == xorSum[k + 1]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
