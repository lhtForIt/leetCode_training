//题号：198
//https://leetcode-cn.com/problems/house-robber/
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1310 👎 0

  
package leetcode.editor.cn;
public class HouseRobber{
      public static void main(String[] args) {
           Solution solution = new HouseRobber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {


        //这里的nums条件好像是nums.length>1,而不是题解写的那样nums>=0,所以不用判断0的情况
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
















        /**
         * 子问题：S(i)=Math.max(S(i-1),S(i-2)+nums[i])
         * 状态转移结构：dp[]
         * 状态转移方程：dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
         *
         * 这里为什么要用dp[i-1]因为不知道是否偷了第i-1个房子，因此不能直接加nums[i]，
         * 但是dp[i-2]最多是只会偷i-2个房子，因此需要加上nums[i]
         *
         * 思路：首先要判定dp[n]是否能表示全局最大值，有的题不能表示全局最大值，
         * 这个时候就需要引入额外变量，来记录最大值，这里dp[n]可以表示全局最大值，
         * 因为每次都是得到的前两步最大值，因此最后一定是最大的，但是有的进步性，比如
         * 最大公共子序列那个，存在舍弃元素的问题，就需要全局变量去记录最大值。
         *
         *
         */
//        if (nums == null || nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[nums.length - 1];


        /**
         * 这个空间复杂度可以优化
         * 考虑到其实每次只会用到两个值，因此可以只用两个变量递推即可,
         * 参考爬楼梯问题
         */

//        int pre = 0, cur = 0, temp;
//        for (int i = 0; i < nums.length; i++) {
//            temp = cur;
//            cur = Math.max(pre + nums[i], cur);
//            pre = temp;
//        }
//
//        return cur;
//        int pre = 0, cur = 0, max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(pre + nums[i], cur);
//            pre = cur;
//            cur = max;
//        }
//
//        return max;


















        /**
         * 动态规划转移方程：dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
         */

//        if (nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[nums.length - 1];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }