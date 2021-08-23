package com.zak.da.template.leetcode.editor.cn;

//It is a sweltering summer day, and a boy wants to buy some ice cream bars. 
//
// At the store, there are n ice cream bars. You are given an array costs of len
//gth n, where costs[i] is the price of the ith ice cream bar in coins. The boy in
//itially has coins coins to spend, and he wants to buy as many ice cream bars as 
//possible. 
//
// Return the maximum number of ice cream bars the boy can buy with coins coins.
// 
//
// Note: The boy can buy the ice cream bars in any order. 
//
// 
// Example 1: 
//
// 
//Input: costs = [1,3,2,4,1], coins = 7
//Output: 4
//Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total pri
//ce of 1 + 3 + 2 + 1 = 7.
// 
//
// Example 2: 
//
// 
//Input: costs = [10,6,8,7,7,8], coins = 5
//Output: 0
//Explanation: The boy cannot afford any of the ice cream bars.
// 
//
// Example 3: 
//
// 
//Input: costs = [1,6,3,1,2,5], coins = 20
//Output: 6
//Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6
// + 3 + 1 + 2 + 5 = 18.
// 
//
// 
// Constraints: 
//
// 
// costs.length == n 
// 1 <= n <= 105 
// 1 <= costs[i] <= 105 
// 1 <= coins <= 108 
// Related Topics 贪心 数组 排序 
// 👍 64 👎 0

import java.util.Arrays;

public class MaximumIceCreamBars{

    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        int [] example1 = new int[] {1, 3, 2, 4, 1};
        int [] example2 = new int[] {10, 6, 8, 7, 7, 8};
        int [] example3 = new int[] {1, 6, 3, 1, 2, 5};
        System.out.println("Example 1 result = " + solution.maxIceCream(example1, 7));
        System.out.println("Example 2 result = " + solution.maxIceCream(example2, 5));
        System.out.println("Example 3 result = " + solution.maxIceCream(example3, 20));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;

        for (int cost : costs) {
            if (coins - cost >= 0) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}