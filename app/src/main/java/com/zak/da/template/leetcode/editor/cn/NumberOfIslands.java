package com.zak.da.template.leetcode.editor.cn;

// 200. 岛屿数量
// LeetCode: https://leetcode-cn.com/problems/number-of-islands/
// Related Topics 面试刷题提纲

public class NumberOfIslands {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid)); // 1
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 主流程只做两件事：
     * 1) 扫到一个还是 '1' 的格子 → 说明碰到一座「还没数过」的岛 → islands++
     * 2) 立刻 sink：把这座岛上所有连着的陆地改成 '0'
     *
     * 若不 sink，双重循环后面还会再次碰到同一座岛上的其他 '1'，会把一座岛数成很多座。
     * sink 的作用 = 访问标记：这片连通陆地已经统计过了。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    sink(grid, r, c);
                }
            }
        }
        return islands;
    }

    /**
     * sink(r, c)：从当前格出发，淹没「同一座岛」上的全部陆地。
     *
     * 为什么叫淹没：把 '1' 改成 '0'，之后主循环再扫到这里会当成水，不会再 islands++。
     * 也可以另开 visited[][]，改格子是为了省空间、代码短。
     *
     * 执行顺序（以某一格为例）：
     *   ① 非法/不是陆地 → 直接 return（越界、水、已淹没都不继续）
     *   ② 先把当前格改成 '0'（必须先改，否则四个方向递归会互相又走回来，死循环）
     *   ③ 再对上、下、左、右四个邻居递归 sink
     *      能一路走通的 '1' 都属于同一连通块；走不通（水/边界）自然停。
     *
     * 直观理解：站在岛上的一点，向四周泼水，水会流过所有相连陆地，流不到另一座岛。
     */
    private void sink(char[][] grid, int r, int c) {
        // ① 停下来的条件：出界，或当前已经不是未访问陆地
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] != '1') {
            return;
        }
        // ② 标记：当前格已处理（等价于 visited[r][c] = true）
        grid[r][c] = '0';
        // ③ 向四连通扩散，把整座岛清掉
        sink(grid, r - 1, c); // 上
        sink(grid, r + 1, c); // 下
        sink(grid, r, c - 1); // 左
        sink(grid, r, c + 1); // 右
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
