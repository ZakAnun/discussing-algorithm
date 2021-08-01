package template.leetcode.editor.cn;

//You are given an m x n binary matrix mat of 1's (representing soldiers) and 0'
//s (representing civilians). The soldiers are positioned in front of the civilian
//s. That is, all the 1's will appear to the left of all the 0's in each row. 
//
// A row i is weaker than a row j if one of the following is true: 
//
// 
// The number of soldiers in row i is less than the number of soldiers in row j.
// 
// Both rows have the same number of soldiers and i < j. 
// 
//
// Return the indices of the k weakest rows in the matrix ordered from weakest t
//o strongest. 
//
// 
// Example 1: 
//
// 
//Input: mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//Output: [2,0,3]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 2 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 2 
//- Row 4: 5 
//The rows ordered from weakest to strongest are [2,0,3,1,4].
// 
//
// Example 2: 
//
// 
//Input: mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//Output: [0,2]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 1 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 1 
//The rows ordered from weakest to strongest are [0,2,3,1].
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] is either 0 or 1. 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 80 👎 0

import java.util.Arrays;
import java.util.Comparator;

public class TheKWeakestRowsInAMatrix{

    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();

        int[][] demoOne = new int[][] {
                new int[] {1, 1, 0, 0, 0},
                new int[] {1, 1, 1, 1, 0},
                new int[] {1, 0, 0, 0, 0},
                new int[] {1, 1, 0, 0, 0},
                new int[] {1, 1, 1, 1, 1}
        };

        int[][] demoTwo = new int[][]{
                new int[] {1, 0, 0, 0},
                new int[] {1, 1, 1, 1},
                new int[] {1, 0, 0, 0},
                new int[] {1, 0, 0, 0}
        };

        System.out.println("demoOne k = 3，最弱的三组序号为: ");
        int[] resultOne = solution.kWeakestRows(demoOne, 3);
        System.out.print("[");
        for (int item : resultOne) {
            System.out.print(item + " ");
        }
        System.out.println("]");

        System.out.println("demoTwo k = 2, 最弱的两组序号为: ");
        int[] resultTwo = solution.kWeakestRows(demoTwo, 2);
        System.out.print("[");
        for (int item : resultTwo) {
            System.out.print(item + " ");
        }
        System.out.println("]");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 暴力解法（先记录军人数量和行数，再进行排序，然后根据 k，获取到指定数量的结果数组）
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int low = mat.length;
        int[][] temp = new int[low][1];
        for (int i = 0; i < low; i++) {
            int groupMax = 0;
            for (int item : mat[i]) {
                if (item == 1) {
                    groupMax++;
                }
            }
            temp[i] = new int[] {groupMax, i};
        }
        Arrays.sort(temp, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = temp[i][1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}