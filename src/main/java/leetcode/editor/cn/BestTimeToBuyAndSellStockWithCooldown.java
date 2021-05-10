//题号：309
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 766 👎 0

  
package leetcode.editor.cn;
public class BestTimeToBuyAndSellStockWithCooldown{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 动态规划：
         * 我们用一个二维数组记录股票的三种状态
         * - 持有一支股票，累积最大值记做f[i][0]
         * - 不持有股票，且处在冻结期，累积最大值记做f[i][1]
         * - 不持有股票，且不处在冻结期，累积最大值记做f[i][2]
         *
         * 对于f[i][0] 有f[i][0]=max(f[i-1][0],f[i-1][2]-prices[i])
         * 对于f[i][1] 有f[i][1]=f[i-1][0]+prices[i]
         * 对于f[i][2] 有f[i][2]=max(f[i-1][1],f[i-1][2])
         *
         * 那么最大值就是三个值里面产生
         * 我们可以想到在最后一天，你还持有一支股票是没有任何意义的，因此f[n-1][0]可以排除。
         *
         * 所以最终最大值是max(f[n-1][1],f[n-1][2])
         *
         */

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益

        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);


        /**
         * 空间复杂度优化
         */
//        if (prices.length == 0) {
//            return 0;
//        }
//
//        int n = prices.length;
//        int f0 = -prices[0];
//        int f1 = 0;
//        int f2 = 0;
//        for (int i = 1; i < n; ++i) {
//            int newf0 = Math.max(f0, f2 - prices[i]);
//            int newf1 = f0 + prices[i];
//            int newf2 = Math.max(f1, f2);
//            f0 = newf0;
//            f1 = newf1;
//            f2 = newf2;
//        }
//
//        return Math.max(f1, f2);







    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }