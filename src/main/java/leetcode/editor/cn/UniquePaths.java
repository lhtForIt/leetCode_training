//题号：62
//https://leetcode-cn.com/problems/unique-paths/
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 917 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class UniquePaths{
      public static void main(String[] args) {
           Solution solution = new UniquePaths().new Solution();
          solution.uniquePaths(7, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {

        /**
         * 动态规划：
         * dp转移方程: dp[i][j]=dp[i-1][j]+dp[i][j-1]
         * 以左上角为原点坐标，它能走的就向右和向下两种，
         * 然后右和下的走法又可以各自分成两种，而对于
         * 第一行和第一列只能有一种走法，最后右下角的
         * dp缓存值就是总条数
         *
         * 这个题既可以以左上为起点，又可以以右下为起点
         * 时间复杂度O(n^2)，空间复杂度O(m*n)
         *
         */
//        int[][] dp = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//        }
//
//        return dp[m - 1][n - 1];

        /**
         * 从终点往回走
         */
//        int[][] dp = new int[m][n];
//
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                if (i == m - 1 || j == n - 1) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//                }
//            }
//        }
//
//        return dp[0][0];

        /**
         * 因为都是第一行往下推的，且上一行的数据只会用一次，
         * 因此可以直接用以为数组保存每行的数据，将状态数组
         * 从二位降到了一维，从而节省了内存
         */
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];//dp[i,j-1]+dp[i-1,j]
            }
        }

        return dp[n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }