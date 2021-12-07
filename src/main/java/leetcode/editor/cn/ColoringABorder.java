//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 102 👎 0

package leetcode.editor.cn;
public class ColoringABorder {
    public static void main(String[] args) {
        Solution solution = new ColoringABorder().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if(grid == null || grid.length == 0)
            return null;
        int oldColor = grid[row][col];
        dfs(grid, row, col, oldColor);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        return grid;
    }

        public void dfs(int[][] grid, int i, int j, int oldColor) {
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oldColor)
                return;
            grid[i][j] = -oldColor;
            dfs(grid, i+1, j, oldColor);
            dfs(grid, i-1, j, oldColor);
            dfs(grid, i, j+1, oldColor);
            dfs(grid, i, j-1, oldColor);
            if(i > 0 && j > 0 && i < grid.length-1 && j < grid[0].length-1
                    && oldColor == Math.abs(grid[i+1][j])
                    && oldColor == Math.abs(grid[i-1][j])
                    && oldColor == Math.abs(grid[i][j+1])
                    && oldColor == Math.abs(grid[i][j-1]))
                grid[i][j] = oldColor;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}