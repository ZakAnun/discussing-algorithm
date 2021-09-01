package com.zak.da.template.leetcode.editor.cn;

/**
<p>给你两个版本号 <code>version1</code> 和 <code>version2</code> ，请你比较它们。</p>

<p>版本号由一个或多个修订号组成，各修订号由一个 <code>'.'</code> 连接。每个修订号由 <strong>多位数字</strong> 组成，可能包含 <strong>前导零</strong> 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，<code>2.5.33</code> 和 <code>0.1</code> 都是有效的版本号。</p>

<p>比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 <strong>忽略任何前导零后的整数值</strong> 。也就是说，修订号 <code>1</code> 和修订号 <code>001</code> <strong>相等 </strong>。如果版本号没有指定某个下标处的修订号，则该修订号视为 <code>0</code> 。例如，版本 <code>1.0</code> 小于版本 <code>1.1</code> ，因为它们下标为 <code>0</code> 的修订号相同，而下标为 <code>1</code> 的修订号分别为 <code>0</code> 和 <code>1</code> ，<code>0 < 1</code> 。</p>

<p>返回规则如下：</p>

<ul>
	<li>如果 <code><em>version1 </em>> <em>version2</em></code> 返回 <code>1</code>，</li>
	<li>如果 <code><em>version1 </em>< <em>version2</em></code> 返回 <code>-1</code>，</li>
	<li>除此之外返回 <code>0</code>。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>version1 = "1.01", version2 = "1.001"
<strong>输出：</strong>0
<strong>解释：</strong>忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>version1 = "1.0", version2 = "1.0.0"
<strong>输出：</strong>0
<strong>解释：</strong>version1 没有指定下标为 2 的修订号，即视为 "0"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>version1 = "0.1", version2 = "1.1"
<strong>输出：</strong>-1
<strong>解释：</strong>version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>version1 = "1.0.1", version2 = "1"
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>version1 = "7.5.2.4", version2 = "7.5.3"
<strong>输出：</strong>-1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= version1.length, version2.length <= 500</code></li>
	<li><code>version1</code> 和 <code>version2</code> 仅包含数字和 <code>'.'</code></li>
	<li><code>version1</code> 和 <code>version2</code> 都是 <strong>有效版本号</strong></li>
	<li><code>version1</code> 和 <code>version2</code> 的所有修订号都可以存储在 <strong>32 位整数</strong> 中</li>
</ul>
<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 217</li><li>👎 0</li></div>
*/
public class CompareVersionNumbers{

    public static void main(String[] args) {
        Solution solution = new CompareVersionNumbers().new Solution();

		System.out.println("版本号 1.01 和 1.001 比较的结果 == " + solution.compareVersion("1.01", "1.001"));
		System.out.println("版本号 1.0 和 1.0.0 比较的结果 == " + solution.compareVersion("1.0", "1.0.0"));
		System.out.println("版本号 0.1 和 1.1 比较的结果 == " + solution.compareVersion("0.1", "1.1"));
		System.out.println("版本号 1.0.1 和 1 比较的结果 == " + solution.compareVersion("1.0.1", "1"));
		System.out.println("版本号 7.5.2.4 和 7.5.3 比较的结果 == " + solution.compareVersion("7.5.2.4", "7.5.3"));

		System.out.println("==========");

		System.out.println("版本号 1.01 和 1.001 比较的结果 == " + solution.compareVersionBetter("1.01", "1.001"));
		System.out.println("版本号 1.0 和 1.0.0 比较的结果 == " + solution.compareVersionBetter("1.0", "1.0.0"));
		System.out.println("版本号 0.1 和 1.1 比较的结果 == " + solution.compareVersionBetter("0.1", "1.1"));
		System.out.println("版本号 1.0.1 和 1 比较的结果 == " + solution.compareVersionBetter("1.0.1", "1"));
		System.out.println("版本号 7.5.2.4 和 7.5.3 比较的结果 == " + solution.compareVersionBetter("7.5.2.4", "7.5.3"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	/**
	 * 会形成以 . 分割的字符串数组，所以空间复杂度是 O(n)
	 * 比较分割后的字符串数组的每个 item 得出结论
	 *
	 * @param version1 version1
	 * @param version2 version2
	 * @return 比较两个版本号的结果
	 */
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");

    	int len1 = v1.length;
    	int len2 = v2.length;

    	for (int i = 0; i < len1 || i < len2; ++i) {
    		int x = 0;
    		int y = 0;

    		if (i < len1) {
    			x = Integer.parseInt(v1[i]);
			}
    		if (i < len2) {
    			y = Integer.parseInt(v2[i]);
			}

    		if (x > y) {
    			return 1;
			}
    		if (x < y) {
    			return -1;
			}
		}
		return 0;
    }

	/**
	 * 针对空间复杂度 O(n) 进行优化
	 * 在分割版本号的同时解析出修订号进行比较（双指针）
	 *
	 * @param version1 version1
	 * @param version2 version2
	 * @return 比较两个版本号的结果
	 */
    public int compareVersionBetter(String version1, String version2) {
		int n = version1.length();
		int m = version2.length();
		int i = 0, j = 0;
		while (i < n || j < m) {
			int x = 0;
			for (; i < n && version1.charAt(i) != '.'; ++i) {
				x = x * 10 + version1.charAt(i) - '0';
			}
			++i; // 跳过点号
			int y = 0;
			for (; j < m && version2.charAt(j) != '.'; ++j) {
				y = y * 10 + version2.charAt(j) - '0';
			}
			++j; // 跳过点号
			if (x != y) {
				return x > y ? 1 : -1;
			}
		}
		return 0;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}