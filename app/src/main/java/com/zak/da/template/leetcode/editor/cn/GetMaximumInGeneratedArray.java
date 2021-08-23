package com.zak.da.template.leetcode.editor.cn;

import java.util.Arrays;

/**
<p>给你一个整数 <code>n</code> 。按下述规则生成一个长度为 <code>n + 1</code> 的数组 <code>nums</code> ：</p>

<ul>
	<li><code>nums[0] = 0</code></li>
	<li><code>nums[1] = 1</code></li>
	<li>当 <code>2 <= 2 * i <= n</code> 时，<code>nums[2 * i] = nums[i]</code></li>
	<li>当 <code>2 <= 2 * i + 1 <= n</code> 时，<code>nums[2 * i + 1] = nums[i] + nums[i + 1]</code></li>
</ul>

<p>返回生成数组 <code>nums</code> 中的 <strong>最大</strong> 值。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 7
<strong>输出：</strong>3
<strong>解释：</strong>根据规则：
  nums[0] = 0
  nums[1] = 1
  nums[(1 * 2) = 2] = nums[1] = 1
  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
  nums[(2 * 2) = 4] = nums[2] = 1
  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
  nums[(3 * 2) = 6] = nums[3] = 2
  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>1
<strong>解释：</strong>根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>2
<strong>解释：</strong>根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= n <= 100</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>模拟</li></div></div><br><div><li>👍 34</li><li>👎 0</li></div>
*/
public class GetMaximumInGeneratedArray{

    public static void main(String[] args) {
        Solution solution = new GetMaximumInGeneratedArray().new Solution();

        System.out.println("7 生成的数组中，最大值 == " + solution.getMaximumGenerated(7));
        System.out.println("2 生成的数组中，最大值 == " + solution.getMaximumGenerated(2));
        System.out.println("3 生成的数组中，最大值 == " + solution.getMaximumGenerated(3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaximumGenerated(int n) {

        if (n == 0) {
            return 0;
        }

        int[] arr = new int[n + 1];

        arr[1] = 1;

        for (int i = 2; i <= n ; i++) {
            arr[i] = arr[i / 2] + (i % 2) * arr[i / 2 + 1];
        }

        return Arrays.stream(arr).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}