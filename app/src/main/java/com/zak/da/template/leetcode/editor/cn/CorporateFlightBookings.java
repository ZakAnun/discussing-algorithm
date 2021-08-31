package com.zak.da.template.leetcode.editor.cn;

import java.util.Arrays;

/**
<p>这里有 <code>n</code> 个航班，它们分别从 <code>1</code> 到 <code>n</code> 进行编号。</p>

<p>有一份航班预订表 <code>bookings</code> ，表中第 <code>i</code> 条预订记录 <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> 意味着在从 <code>first<sub>i</sub></code> 到 <code>last<sub>i</sub></code> （<strong>包含</strong> <code>first<sub>i</sub></code> 和 <code>last<sub>i</sub></code> ）的 <strong>每个航班</strong> 上预订了 <code>seats<sub>i</sub></code> 个座位。</p>

<p>请你返回一个长度为 <code>n</code> 的数组 <code>answer</code>，其中 <code>answer[i]</code> 是航班 <code>i</code> 上预订的座位总数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
<strong>输出：</strong>[10,55,45,25,25]
<strong>解释：</strong>
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10,55,45,25,25]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>bookings = [[1,2,10],[2,2,15]], n = 2
<strong>输出：</strong>[10,25]
<strong>解释：</strong>
航班编号        1   2
预订记录 1 ：   10  10
预订记录 2 ：       15
总座位数：      10  25
因此，answer = [10,25]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 2 * 10<sup>4</sup></code></li>
	<li><code>1 <= bookings.length <= 2 * 10<sup>4</sup></code></li>
	<li><code>bookings[i].length == 3</code></li>
	<li><code>1 <= first<sub>i</sub> <= last<sub>i</sub> <= n</code></li>
	<li><code>1 <= seats<sub>i</sub> <= 10<sup>4</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 222</li><li>👎 0</li></div>
*/
public class CorporateFlightBookings{

    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();

        int[][] bookingOne = new int[][] {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int[] resultOneBl = solution.corpFlightBookingsBaoLi(bookingOne, 5);
        int[] resultOne = solution.corpFlightBookings(bookingOne, 5);

        int[][] bookingTwo = new int[][] {
                {1, 2, 10},
                {2, 2, 15}
        };
        int[] resultTwoBl = solution.corpFlightBookingsBaoLi(bookingTwo, 2);
        int[] resultTwo = solution.corpFlightBookings(bookingTwo, 2);

        System.out.println("暴力解法 [[1, 2, 10], [2, 3, 20], [2, 5, 25]] 得到的航班订座总数为 " + Arrays.toString(resultOneBl));
        System.out.println("差分 + 前缀和解法 [[1, 2, 10], [2, 3, 20], [2, 5, 25]] 得到的航班订座总数为 " + Arrays.toString(resultOne));

        System.out.println();

        System.out.println("暴力解法 [[1, 2, 10], [2, 2, 15]] 得到的航班订座总数为 " + Arrays.toString(resultTwoBl));
        System.out.println("差分 + 前缀和解法 [[1, 2, 10], [2, 2, 15]] 得到的航班订座总数为 " + Arrays.toString(resultTwo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] corpFlightBookingsBaoLi(int[][] bookings, int n) {
        int[] result = new int[n];
        int length = bookings.length;

        for (int i = 0; i < length; i++) {
            int[] bookingItem = bookings[i];
            for (int j = bookingItem[0]; j <= bookingItem[1]; j++) {
                result[j - 1] += bookingItem[2];
            }
        }

        return result;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                result[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}