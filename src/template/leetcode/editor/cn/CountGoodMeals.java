package template.leetcode.editor.cn;

//A good meal is a meal that contains exactly two different food items with a su
//m of deliciousness equal to a power of two. 
//
// You can pick any two different foods to make a good meal. 
//
// Given an array of integers deliciousness where deliciousness[i] is the delici
//ousness of the ith item of food, return the number of different good meals you c
//an make from this list modulo 109 + 7. 
//
// Note that items with different indices are considered different even if they 
//have the same deliciousness value. 
//
// 
// Example 1: 
//
// 
//Input: deliciousness = [1,3,5,7,9]
//Output: 4
//Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
//Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
// 
//
// Example 2: 
//
// 
//Input: deliciousness = [1,1,1,3,3,3,7]
//Output: 15
//Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7
//) with 3 ways. 
//
// 
// Constraints: 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 
// 👍 101 👎 0

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals{

    public static void main(String[] args) {
        Solution solution = new CountGoodMeals().new Solution();

        System.out.println("[1, 3, 5, 7, 9] 组成的大餐数为 " + solution.countPairs(new int[] {1, 3, 5, 7, 9}));
        System.out.println("[1, 1, 1, 3, 3, 3, 7] 组成的大参数为 " + solution.countPairs(new int[] {1, 1, 1, 3, 3, 3, 7}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int max = 0;
        for (int item : deliciousness) {
            max = Math.max(item, max);
        }
        int maxSum = max * 2;
        // 至少要想到用 HashMap 来缓存计算结果...
        Map<Integer, Integer> cache = new HashMap<>(maxSum);

        int result = 0;
        for (int val : deliciousness) {
            for (int j = 1; j <= maxSum; j <<= 1) {
                int count = cache.getOrDefault(j - val, 0);
                result = (result + count) % MOD;
            }
            cache.put(val, cache.getOrDefault(val, 0) + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}