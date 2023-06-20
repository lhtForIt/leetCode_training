//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// cost 的长度范围是 [2, 1000]。 
// cost[i] 将会是一个整型数据，范围为 [0, 999] 。 
// 
// Related Topics 数组 动态规划 
// 👍 535 👎 0

package leetcode.editor.cn;
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        /**
         * dp(i)=min(dp(i-2)+cost(i-2),dp(i-1)+cost(i-1))
         *
         * 今天解动态规划有点感觉了，我的思路是先列举前几个数据的答案，然后找规律，推到出状态转移方程。
         * 转移方程出来之后，因为有i-x的操作，直接遍历会下标越界，所以就需要将一些前面的数据初始化，对于初始
         * 化的值根据题意能很好的知道，然后开始遍历验证状态转移方程是否正确。
         *
         */
        int[] dp = new int[cost.length + 1];
        //从下标为0的开始爬,从0这个点是没有花费的
        dp[0] = 0;
        //从下标为1的开始爬,从1这个点也是没有花费的
        dp[1] = 0;
        for (int i = 2; i <=cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}