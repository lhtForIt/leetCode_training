//题号：152
//https://leetcode-cn.com/problems/maximum-product-subarray/description/
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 978 👎 0

  
package leetcode.editor.cn;
public class MaximumProductSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumProductSubarray().new Solution();
          solution.maxProduct(new int[]{-4,-3,-2});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {


        /**
         * 正常dp，状态转移方程为dpmax[i]=Math.max(Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i])
         * dpmin[i]=Math.min(Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]),nums[i])
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        int max = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            max = Math.max(dpMax[i], max);
        }

        return max;


        /**
         * 其实想想这个的状态数组能进一步压缩，只用两个变量代表分别记录最大值和最小值即可，
         */

//        int dpMax = nums[0];
//        int dpMin = nums[0];
//
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//
//            int tempMax = dpMax, tempMin = dpMin;
//            dpMax = Math.max(Math.max(tempMax * nums[i], tempMin * nums[i]), nums[i]);
//            dpMin = Math.min(Math.min(tempMax * nums[i], tempMin * nums[i]), nums[i]);
//
//            max = Math.max(dpMax, max);
//        }
//
//        return max;

        /**
         * 要么是以i为前缀的乘积，要么是以i为后缀的乘积，然后求最大值
         * 说实话我不知道怎么去证明
         */
//        int n = nums.length, res = nums[0], l = 0, r = 0;
//        for (int i = 0; i < n; i++) {
//            l =  (l == 0 ? 1 : l) * nums[i];
//            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
//            res = Math.max(res, Math.max(l, r));
//        }
//        return res;







        /**
         * 动态规划
         *
         * 1、program(i)=Math.max(subProgramMax(i-1)*nums[i],nums[i],subProgramMin(i-1)*nums[i]);
         * 2、状态数组dpMax[],dpMin[],或者两个变量：dpMax,dpMin
         * 3、dp转移方程：dp[i]=Math.max(dp/max[i-1]*nums[i],nums[i],dp/min(i-1)*nums[i]);
         *
         * 时间复杂度O(n),空间复杂度O(n)
         *
         */

//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int[] dpMax = new int[nums.length];
//        int[] dpMin = new int[nums.length];
//
//        dpMax[0] = nums[0];
//        dpMin[0] = nums[0];
//        int max = nums[0];
//
//
//        for (int i = 1; i < nums.length; i++) {
//            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
//            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(nums[i], dpMin[i - 1] * nums[i]));
//            max = max > dpMax[i] ? max : dpMax[i];
//        }
//
//        return max;


        /**
         * 动态规划优化，将数组改为变量
         *
         * 时间复杂度O(n)，空间复杂度O(1)
         *
         */
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//
//        int dpMax = nums[0];
//        int dpMin = nums[0];
//        int max = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            //这儿需要两个零时变量存储dpMax和dpMin的值，不然会在计算的时候被覆盖，导致dpMin计算有问题
//            int tMax = dpMax, tMin = dpMin;
//            dpMax = Math.max(tMax * nums[i], Math.max(nums[i], tMin * nums[i]));
//            dpMin = Math.min(tMax * nums[i], Math.min(nums[i], tMin * nums[i]));
//            max = Math.max(max, dpMax);
//        }
//
//        return max;








    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }