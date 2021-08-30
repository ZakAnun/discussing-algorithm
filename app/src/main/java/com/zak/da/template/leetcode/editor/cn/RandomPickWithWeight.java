package com.zak.da.template.leetcode.editor.cn;

import java.util.Arrays;

/**
<p>给定一个正整数数组&nbsp;<code>w</code> ，其中&nbsp;<code>w[i]</code>&nbsp;代表下标 <code>i</code>&nbsp;的权重（下标从 <code>0</code> 开始），请写一个函数&nbsp;<code>pickIndex</code>&nbsp;，它可以随机地获取下标 <code>i</code>，选取下标 <code>i</code>&nbsp;的概率与&nbsp;<code>w[i]</code>&nbsp;成正比。</p>

<ol>
</ol>

<p>例如，对于 <code>w = [1, 3]</code>，挑选下标 <code>0</code> 的概率为 <code>1 / (1 + 3)&nbsp;= 0.25</code> （即，25%），而选取下标 <code>1</code> 的概率为 <code>3 / (1 + 3)&nbsp;= 0.75</code>（即，75%）。</p>

<p>也就是说，选取下标 <code>i</code> 的概率为 <code>w[i] / sum(w)</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[&quot;Solution&quot;,&quot;pickIndex&quot;]
[[[1]],[]]
<strong>输出：</strong>
[null,0]
<strong>解释：</strong>
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
[&quot;Solution&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;]
[[[1,3]],[],[],[],[],[]]
<strong>输出：</strong>
[null,1,1,1,1,0]
<strong>解释：</strong>
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
诸若此类。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= w.length &lt;= 10000</code></li>
	<li><code>1 &lt;= w[i] &lt;= 10^5</code></li>
	<li><code>pickIndex</code>&nbsp;将被调用不超过&nbsp;<code>10000</code>&nbsp;次</li>
</ul>
<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li><li>前缀和</li><li>随机化</li></div></div><br><div><li>👍 166</li><li>👎 0</li></div>
*/
public class RandomPickWithWeight{

    public static void main(String[] args) {
        int[] demoOne = new int[] {1};
        Solution solution = new RandomPickWithWeight().new Solution(demoOne);
        System.out.println("[1] pickIndex == " + solution.pickIndex());
        System.out.println("[1] pickIndex == " + solution.pickIndex());
        System.out.println("[1] pickIndex == " + solution.pickIndex());
        System.out.println("[1] pickIndex == " + solution.pickIndex());
        System.out.println("[1] pickIndex == " + solution.pickIndex());
        System.out.println("[1] pickIndex == " + solution.pickIndex());

        System.out.println("====== Split ======");

        int[] demoTwo = new int[] {1, 3};
        Solution solution1 = new RandomPickWithWeight().new Solution(demoTwo);
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
        System.out.println("[1, 3] pickIndex == " + solution1.pickIndex());
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] pre;
    private int total;

    public Solution(int[] w) {
        int length = w.length;
        pre = new int[length];
        pre[0] = w[0];
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }
    
    public int pickIndex() {
        // 1 到 total 的随机数
        int x = (int) (Math.random() * total + 1);
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0;
        int high = pre.length - 1;

        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}