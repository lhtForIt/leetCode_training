//题号：213
//https://leetcode-cn.com/problems/house-robber-ii/
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 484 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class HouseRobberIi{
      public static void main(String[] args) {
           Solution solution = new HouseRobberIi().new Solution();
          solution.rob(new int[]{0, 0});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //分两种情况，因为第一家和最后一家不能都偷，那么超过两家的时候
        //我们分情况讨论，偷第一家情况和偷最后一家的情况，然后两种情况的最大值
        //在做比较，最后的最大值就是结果

        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        //因为包含了第一家，所以不能投最后一家，因此右边界是nums.length-2
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        //这里dp1的右边界是nums.length-2，不是nums.length-1了
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);









//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//        return Math.max(recurRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
//                recurRob(Arrays.copyOfRange(nums, 1, nums.length)));


//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//
//
//        //分两种情况，偷第一家和偷最后一家，然后比较大小
//        int[] dp1 = new int[nums.length];
//        dp1[0] = nums[0];
//        dp1[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i <= nums.length - 2; i++) {
//            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
//        }
//
//        int[] dp2 = new int[nums.length];
//        dp2[1] = nums[1];
//        dp2[2] = Math.max(nums[1], nums[2]);
//        for (int i = 3; i <= nums.length - 1; i++) {
//            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
//        }
//
//        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

          private int recurRob(int[] nums) {
              int pre = 0, cur = 0, tmp;
              for(int num : nums) {
                  tmp = cur;
                  cur = Math.max(pre + num, cur);
                  pre = tmp;
              }
              return cur;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }