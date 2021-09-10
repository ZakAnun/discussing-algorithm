package com.zak.da.template.leetcode.editor.cn;

/**
<p>一个班级里有 <code>n</code> 个学生，编号为 <code>0</code> 到 <code>n - 1</code> 。每个学生会依次回答问题，编号为 <code>0</code> 的学生先回答，然后是编号为 <code>1</code> 的学生，以此类推，直到编号为 <code>n - 1</code> 的学生，然后老师会重复这个过程，重新从编号为 <code>0</code> 的学生开始回答问题。</p>

<p>给你一个长度为 <code>n</code> 且下标从 <code>0</code> 开始的整数数组 <code>chalk</code> 和一个整数 <code>k</code> 。一开始粉笔盒里总共有 <code>k</code> 支粉笔。当编号为 <code>i</code> 的学生回答问题时，他会消耗 <code>chalk[i]</code> 支粉笔。如果剩余粉笔数量 <strong>严格小于</strong> <code>chalk[i]</code> ，那么学生 <code>i</code> 需要 <strong>补充</strong> 粉笔。</p>

<p>请你返回需要 <strong>补充</strong> 粉笔的学生 <strong>编号</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>chalk = [5,1,5], k = 22
<b>输出：</b>0
<strong>解释：</strong>学生消耗粉笔情况如下：
- 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
- 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
- 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
- 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
- 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
- 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>chalk = [3,4,1,2], k = 25
<b>输出：</b>1
<b>解释：</b>学生消耗粉笔情况如下：
- 编号为 0 的学生使用 3 支粉笔，然后 k = 22 。
- 编号为 1 的学生使用 4 支粉笔，然后 k = 18 。
- 编号为 2 的学生使用 1 支粉笔，然后 k = 17 。
- 编号为 3 的学生使用 2 支粉笔，然后 k = 15 。
- 编号为 0 的学生使用 3 支粉笔，然后 k = 12 。
- 编号为 1 的学生使用 4 支粉笔，然后 k = 8 。
- 编号为 2 的学生使用 1 支粉笔，然后 k = 7 。
- 编号为 3 的学生使用 2 支粉笔，然后 k = 5 。
- 编号为 0 的学生使用 3 支粉笔，然后 k = 2 。
编号为 1 的学生没有足够的粉笔，所以他需要补充粉笔。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>chalk.length == n</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= chalk[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>模拟</li></div></div><br><div><li>👍 69</li><li>👎 0</li></div>
*/
public class FindTheStudentThatWillReplaceTheChalk{

    public static void main(String[] args) {
        Solution solution = new FindTheStudentThatWillReplaceTheChalk().new Solution();

        System.out.println("[5, 1, 5], k = 22, 需要补充粉笔的学生编号为: " + solution.chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println("[3, 4, 1, 2], k = 25, 需要补充粉笔的学生编号为: " + solution.chalkReplacer(new int[]{3, 4, 1, 2}, 25));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long total = 0;
        for (int num : chalk) {
            total += num;
        }
        k %= total;
        int res = -1;
        for (int i = 0; i < len; i++) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}