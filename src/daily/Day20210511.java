package daily;

/**
 * 每日一题: 1734. 解码异或后的排列
 *
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，
 * 满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，
 * 那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 * 示例 1：
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 *
 * 示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210511 {

    public static void main(String[] args) {
        System.out.println("1734. 解码异或后的排列");
        int[] demoOne = new int[] {3, 1};
        int[] demoTwo = new int[] {6, 5, 4, 6};
        int[] resultOne = decode(demoOne);
        int[] resultTwo = decode(demoTwo);
        System.out.print("示例 1 输出结果: ");
        for (int item : resultOne) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("示例 2 输出结果: ");
        for (int item : resultTwo) {
            System.out.print(item + " ");
        }
    }

    public static int[] decode(int[] encoded) {
        int encodedLength = encoded.length;
        int resultLength = encodedLength + 1;
        int[] result = new int[resultLength];

        int total = 0;
        for (int i = 1; i <= resultLength; i++) {
            total ^= i;
        }

        int odd = 0;
        for (int i = 1; i < encodedLength; i += 2) {
            odd ^= encoded[i];
        }

        result[0] = total ^ odd;

        for (int i = 0; i < encodedLength; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }

        return result;
    }
}
