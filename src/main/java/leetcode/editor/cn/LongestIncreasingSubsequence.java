//题号：300
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1479 👎 0

  
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence{
      public static void main(String[] args) {
           Solution solution = new LongestIncreasingSubsequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int max = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {

        /**
         *
         * 这里因为不具有连续性，因此不能用一个max保存所有，因为在a情况下可能成立，B情况下就不成立了，
         * 你需要重新去遍历以前所有的可能，然后如果能就+1
         * 子问题：S(i)=foreach(S(i-1))if(nums[i]>dp[j])?S(i-1)+1:S(i-1)
         * 状态转移数组：dp[]，还需要一个额外变量记录前一个最大值
         * 状态转移方程：foreach(dp(j))(j>=0&&j<i)dp[i]=nums[i]>dp[j]?dp[i-1]+1:dp[i-1]
         *
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int res = 0;
        //这儿i必须从0开始，如果从1开始会出现一个元素的话返回值一直为0，其实应该为1
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = res > dp[i] ? res : dp[i];
        }

        return res;

        /**
         * 动态规划+二分
         * 状态定义：
         *
         * tails[k]的值代表 长度为 k+1 子序列 的尾部元素值。
         * 转移方程： 设 res 为 tails 当前长度，代表直到当前的最长上升子序列长度。设 j∈[0,res)，考虑每轮遍历 nums[k] 时，通过二分法遍历 [0,res) 列表区间，找出 nums[k] 的大小分界点，会出现两种情况：
         *
         * 区间中存在 tails[i] > nums[k] ： 将第一个满足 tails[i] > nums[k] 执行 tails[i] = nums[k] ；因为更小的 nums[k] 后更可能接一个比它大的数字（前面分析过）。
         * 区间中不存在 tails[i] > nums[k] ： 意味着 nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 resres ），新子序列长度为 res + 1。
         * 初始状态：
         *
         * 令 tails 列表所有值 =0。
         * 返回值：
         *
         * 返回 res ，即最长上升子子序列长度。
         */

//        int[] tails = new int[nums.length];
//        int res = 0;
//        for(int num : nums) {
//            int i = 0, j = res;
//            while(i < j) {
//                int m = (i + j) / 2;
//                if(tails[m] < num) i = m + 1;
//                else j = m;
//            }
//            tails[i] = num;
//            if(res == j) res++;
//        }
//        return res;

    }
          }
//leetcode submit region end(Prohibit modification and deletion)

  }