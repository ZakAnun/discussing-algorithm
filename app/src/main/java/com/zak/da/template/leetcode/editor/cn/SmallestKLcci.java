package com.zak.da.template.leetcode.editor.cn;

import java.util.Arrays;

/**
<p>设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong> arr = [1,3,5,7,2,4,6,8], k = 4
<strong>输出：</strong> [1,2,3,4]
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= len(arr) &lt;= 100000</code></li>
	<li><code>0 &lt;= k &lt;= min(100000, len(arr))</code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 131</li><li>👎 0</li></div>
*/
public class SmallestKLcci{

    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] demoOne = new int[] {1, 3, 5, 7, 2, 4, 6, 8};
        int[] demoTwo = new int[] {1, 2, 3};
        int[] resultOne = solution.smallestK(demoOne, 4);
        int[] resultTwo = solution.smallestK(demoTwo, 0);

        System.out.println("[1, 3, 5, 7, 2, 4, 6, 8]，最小的 4 个元素组成的数组为 " + Arrays.toString(resultOne));
        System.out.println("[1, 2, 3]，最小的 0 个元素组成的数组为 " + Arrays.toString(resultTwo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}