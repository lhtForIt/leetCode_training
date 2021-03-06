//题号：55
//https://leetcode-cn.com/problems/jump-game/
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1063 👎 0


package leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {

            /**
             * 贪心算法
             */
//            int canReach = nums.length - 1;
//            for (int i = nums.length - 2; i >= 0; i--) {
//                if (i + nums[i] >= canReach) {
//                    canReach = i;
//                }
//            }
//
//            return canReach == 0;


            /**
             * 动态规划
             * 这里反着推的话会高效很多，但是你写出这个动态规划会发现其实基本就是贪心算法
             * 的代码了，这个boolean的数组其实没多少用，
             */

            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[n - 1] = true;
            int canReach = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (i + nums[i] >= canReach) {
                    dp[i] = true;
                    canReach = i;
                }
            }

            return dp[0];









            /**
             * 贪心思路：
             * 这里从前面往后贪不太好我们从后往前贪
             * 用一个变量记录每次能到的位置，初始位最后一个位置。
             * 如果i+nums[i]>=endReach，说明能到当前位置，就将endReach换成i的值，
             * 最后判断i是不是等于0即可
             */
//            if (nums == null || nums.length == 0) {
//                return false;
//            }
//
//            int canReach = nums.length - 1;
//
//            //这里不用从nums.length-1开始，初始值就是这个，直接从nums.length-2开始
//            for (int i = nums.length - 2; i >= 0; i--) {
//                if (i + nums[i] >= canReach) {
//                    canReach = i;
//                }
//            }
//
//            return canReach == 0;









        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}