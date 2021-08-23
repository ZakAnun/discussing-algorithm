package com.zak.da.daily;

/**
 * 每日一题: 1310. 子数组异或查询
 *
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 示例 1：
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 *
 * 示例 2：
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day20210513 {

    public static void main(String[] args) {
        int[] demoArrOne = new int[] {1, 3, 4, 8};
        int[][] demoArrOneQuery = new int[][] {
                new int[] {0, 1},
                new int[] {1, 2},
                new int[] {0, 3},
                new int[] {3, 3}};
        int[] demoArrTwo = new int[] {4, 8, 2, 10};
        int[][] demoArrTwoQuery = new int[][] {
                new int[] {2, 3},
                new int[] {1, 3},
                new int[] {0, 0},
                new int[] {0, 3}};

        System.out.println("1310. 子数组异或查询:");
        System.out.print("示例 1 结果为: ");
        int[] resultOne = xorQueries(demoArrOne, demoArrOneQuery);
        for (int item : resultOne) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.print("示例 2 结果为: ");
        int[] resultTwo = xorQueries(demoArrTwo, demoArrTwoQuery);
        for (int item : resultTwo) {
            System.out.print(item + " ");
        }
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int arrLength = arr.length;
        int queriesLength = queries.length;
        int[] result = new int[arrLength];

        for (int i = 0; i < queriesLength; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            if (start < 0 || start >= arrLength ||
                    end < 0 || end >= arrLength ) {
                continue;
            }

            int itemResult = arr[start];
            for (int j = start + 1; j <= end; j++) {
                itemResult ^= arr[j];
            }
            result[i] = itemResult;
        }

        return result;
    }
}
