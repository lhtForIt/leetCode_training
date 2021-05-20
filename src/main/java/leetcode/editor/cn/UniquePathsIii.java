//题号：980
//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
// Related Topics 深度优先搜索 回溯算法 
// 👍 137 👎 0

  
package leetcode.editor.cn;
public class UniquePathsIii{
      public static void main(String[] args) {
           Solution solution = new UniquePathsIii().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int res = 0, empty = 1, sx, sy;
          int ans;
          int[][] grid;
          int R, C;
          int tr, tc, target;
          int[] dr = new int[]{0, -1, 0, 1};
          int[] dc = new int[]{1, 0, -1, 0};
          Integer[][][] memo;

          public int uniquePathsIII(int[][] grid) {

              /**
               * 回溯+DFS
               */
              int m = grid.length, n = grid[0].length;
              for (int i = 0; i < m; ++i) {
                  for (int j = 0; j < n; ++j) {
                      if (grid[i][j] == 0) empty++;
                      else if (grid[i][j] == 1) {
                          sx = i;
                          sy = j;
                      }
                  }
              }
              dfs(grid, sx, sy);
              return res;

              /**
               * 动态规划
               */
//              this.grid = grid;
//              R = grid.length;
//              C = grid[0].length;
//              target = 0;
//
//              int sr = 0, sc = 0;
//              for (int r = 0; r < R; ++r)
//                  for (int c = 0; c < C; ++c) {
//                      if (grid[r][c] % 2 == 0)
//                          target |= code(r, c);
//
//                      if (grid[r][c] == 1) {
//                          sr = r;
//                          sc = c;
//                      } else if (grid[r][c] == 2) {
//                          tr = r;
//                          tc = c;
//                      }
//                  }
//
//              memo = new Integer[R][C][1 << R*C];
//              return dp(sr, sc, target);



          }

          private int dp(int r, int c, int todo) {
              if (memo[r][c][todo] != null)
                  return memo[r][c][todo];

              if (r == tr && c == tc) {
                  return todo == 0 ? 1 : 0;
              }

              int ans = 0;
              for (int k = 0; k < 4; ++k) {
                  int nr = r + dr[k];
                  int nc = c + dc[k];
                  if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                      if ((todo & code(nr, nc)) != 0)
                          ans += dp(nr, nc, todo ^ code(nr, nc));
                  }
              }
              memo[r][c][todo] = ans;
              return ans;

          }

          private int code(int r, int c) {
              return 1 << (r * C + c);
          }

          private void dfs(int[][] grid, int x, int y) {
              if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
                  return;
              if (grid[x][y] == 2) {
                  if (empty == 0) res++;
                  return;
              }
              grid[x][y] = -2;
              empty--;
              dfs(grid, x + 1, y);
              dfs(grid, x - 1, y);
              dfs(grid, x, y + 1);
              dfs(grid, x, y - 1);
              grid[x][y] = 0;
              empty++;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }