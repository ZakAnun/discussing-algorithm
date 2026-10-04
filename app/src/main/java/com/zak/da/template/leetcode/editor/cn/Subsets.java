package com.zak.da.template.leetcode.editor.cn;

// 78. 子集
// LeetCode: https://leetcode-cn.com/problems/subsets/
// Related Topics 面试刷题提纲

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 子集 vs 全排列：还是回溯，但「何时收集」不同。
     *
     * 排列：path 选满 n 个才算一条合法答案 → if (path.size()==n) 再收集
     * 子集：path 的每一个中间状态都是合法子集（含空集 []）
     *       → 一进入递归就先收集当前 path，再决定要不要继续往后选
     *
     * 为何用 start 而不是 used：
     *   子集不区分顺序，[1,2] 和 [2,1] 算同一个；
     *   只从下标 start 往后选，保证元素按原数组下标递增选取，避免重复子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> path, List<List<Integer>> result) {
        // 收集成功的判断：无需等选满；当前 path 就是一个子集
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            // 下一层从 i+1 开始，不能再用 i 及之前，避免重复组合
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
