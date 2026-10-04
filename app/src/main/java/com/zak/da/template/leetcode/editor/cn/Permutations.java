package com.zak.da.template.leetcode.editor.cn;

// 46. 全排列
// LeetCode: https://leetcode-cn.com/problems/permutations/
// Related Topics 面试刷题提纲

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.permute(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 全排列：用回溯（DFS），不是 BFS。
     *
     * 为什么不是队列 BFS：
     *   BFS 适合「按层扩展、找最短/逐层状态」；排列要的是「一条路径选满 n 个数就收集」，
     *   用队列存所有中间排列前缀也能做，但状态拷贝多、代码更绕，面试标准解是回溯。
     *
     * 回溯三件套：
     *   path  —— 当前正在拼的一条排列
     *   used  —— 哪些数已经进 path（同一条路径里不能重复用）
     *   递归  —— 选一个未用过的数 → 深入 → 撤销（回溯）再试别的
     *
     * 终止：path.size() == nums.length → 收进答案（记得 new 一份拷贝）
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 做选择：把 nums[i] 放进当前路径
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, result);
            // 撤销：递归返回后，path / used 还残留着刚才的选择；
            // 必须还原，for 循环才能在「同一层前缀」下试下一个 i。
            // 例：path=[1,2] 递归结束 → 去掉 2、used[2]=false → 才能再试拼 [1,3,...]
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
