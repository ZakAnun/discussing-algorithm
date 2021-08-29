package com.zak.da.template.leetcode.editor.cn;

/**
<p>给你一个正整数数组&nbsp;<code>arr</code>&nbsp;，请你计算所有可能的奇数长度子数组的和。</p>

<p><strong>子数组</strong> 定义为原数组中的一个连续子序列。</p>

<p>请你返回 <code>arr</code>&nbsp;中 <strong>所有奇数长度子数组的和</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [1,4,2,5,3]
<strong>输出：</strong>58
<strong>解释：</strong>所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [1,2]
<strong>输出：</strong>3
<strong>解释：</strong>总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [10,11,12]
<strong>输出：</strong>66
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 100</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 70</li><li>👎 0</li></div>
*/
public class SumOfAllOddLengthSubarrays{

    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();

        System.out.println("[1, 4, 2, 5, 3] 所有奇数子数组的和 == " + solution.sumOddLengthSubArrays(new int[] {1, 4, 2, 5, 3}));
        System.out.println("[1, 2] 所有奇数子数组的和 == " + solution.sumOddLengthSubArrays(new int[] {1, 2}));
        System.out.println("[10, 11, 12] 所有奇数子数组的和 == " + solution.sumOddLengthSubArrays(new int[] {10, 11, 12}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOddLengthSubArrays(int[] arr) {
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int leftOdd = (i + 1) / 2;
            int leftEven = i / 2 + 1;
            int rightOdd = (len - i) / 2;
            int rightEvent = (len - 1 - i) / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEvent);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}