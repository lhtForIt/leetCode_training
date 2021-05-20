//题号：518
//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 397 👎 0

  
package leetcode.editor.cn;
public class CoinChange2{
      public static void main(String[] args) {
           Solution solution = new CoinChange2().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {

            /**
             *  动态规划二维数组
             *
             * dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
             * State transition:
             *
             * not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
             * using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1] by using first i coins(including ith), which is dp[i][j-coins[i-1]]
             * Initialization: dp[i][0] = 1
             *
             */

//        int[][] dp = new int[coins.length+1][amount+1];
//        dp[0][0] = 1;
//
//        for (int i = 1; i <= coins.length; i++) {
//            dp[i][0] = 1;
//            for (int j = 1; j <= amount; j++) {
//                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
//            }
//        }
//        return dp[coins.length][amount];


        /**
         * 动态规划压缩一维数组
         *
         * dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]],
         * then we can optimize the space by only using one-dimension array.
         *
         */

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];








    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }