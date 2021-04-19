//题号：63
//https://leetcode-cn.com/problems/unique-paths-ii/
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 509 👎 0

  
package leetcode.editor.cn;
public class UniquePathsIi{
      public static void main(String[] args) {
           Solution solution = new UniquePathsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int uniquePathsWithObstacles(int[][] obstacleGrid) {


              /**
               * 一维动态规划
               * 都需要将dp[0]进行初始化，
               * 二维动态规划还可以在数组中进行赋值，一维的完全不行，只能在外面初始化
               */
              int m = obstacleGrid.length;
              int n = obstacleGrid[0].length;

              int[] dp = new int[n];
              dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
              for (int i = 0; i < m; i++) {
                  for (int j = 0; j < n; j++) {
                      if (obstacleGrid[i][j] == 1) {
                          dp[j] = 0;
                      } else {
                          if (j > 0) {
                              dp[j] = dp[j] + dp[j - 1];
                          }
                      }
                  }
              }


              return dp[n - 1];
























              /**
               * 1<=m,n<=100，所以不需要判断数组是否为null
               *
               * 当有障碍物时即obstacleGrid[i][j]==0时，这时候步数是0，
               * 且如果是i=0||j=0时，后面的格子也会是0，
               * 因此要分开讨论i=0||j=0和i>0&&j>0的情况
               *
               * 当然，如果是一维的话直接讨论j>0和j=0即可
               *
               */
//              int m = obstacleGrid.length;
//              int n = obstacleGrid[0].length;
//
//              int[][] dp = new int[m][n];
//
//              //为00赋值
//              dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
//
//              for (int i = 0; i < m; i++) {
//                  for (int j = 0; j < n; j++) {
//                      if (obstacleGrid[i][j] != 1) {
//                          if (i > 0 && j > 0) {
//                              dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                          }else if (i > 0) {
//                              //i==0或者j==0因为要考虑障碍物所以要这么写
//                              dp[i][j] = dp[i - 1][j];
//                          } else if (j > 0) {
//                              dp[i][j] = dp[i][j - 1];
//                          }
//
//
//                      }
//                  }
//              }
//
//              return dp[m - 1][n - 1];




          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }