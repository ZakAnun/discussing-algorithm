package com.zak.da.template.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
<p>给你一个整数数组&nbsp;<code>nums</code>，请你将该数组升序排列。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [5,2,3,1]
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [5,1,1,2,0,0]
<strong>输出：</strong>[0,0,1,1,2,5]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
	<li><code>-50000 &lt;= nums[i] &lt;= 50000</code></li>
</ol>
<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>桶排序</li><li>计数排序</li><li>基数排序</li><li>排序</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 350</li><li>👎 0</li></div>
*/
public class SortAnArray{

    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

        int[] arrOne = new int[] {5, 2, 3, 1};
        System.out.println("[5, 2, 3, 1] 排序前: " + Arrays.toString(arrOne));
        solution.sortArray(arrOne);
        System.out.println("[5, 2, 3, 1] 排序后: " + Arrays.toString(arrOne));

        int[] arrTwo = new int[] {5, 1, 1, 2, 0, 0};
        System.out.println("[5, 1, 1, 2, 0, 0] 排序前: " + Arrays.toString(arrTwo));
        solution.sortArray(arrTwo);
        System.out.println("[5, 1, 1, 2, 0, 0] 排序后: " + Arrays.toString(arrTwo));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
//        Arrays.sort(nums);
        // 快排实现
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pos = randomPartPos(arr, left, right);
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }
    }

    private int randomPartPos(int[] arr, int left, int right) {
        int pos = new Random().nextInt(right - left + 1) + left;
        swap(arr, right, pos);
        return part(arr, left, right);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private int part(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}