//题号：410
//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 106 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 二分查找 动态规划 
// 👍 482 👎 0

  
package leetcode.editor.cn;
public class SplitArrayLargestSum{
      public static void main(String[] args) {
           Solution solution = new SplitArrayLargestSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        /**
         * 二分
         */

//        int max = 0; long sum = 0;
//        for (int num : nums) {
//            max = Math.max(num, max);
//            sum += num;
//        }
//        if (m == 1) return (int)sum;
//        //binary search
//        long l = max; long r = sum;
//        while (l <= r) {
//            long mid = (l + r)/ 2;
//            if (valid(mid, nums, m)) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return (int)l;

        /**
         * 动态规划
         */

        int L = nums.length;
        int[] S = new int[L+1];
        S[0]=0;
        for(int i=0; i<L; i++)
            S[i+1] = S[i]+nums[i];

        int[] dp = new int[L];
        for(int i=0; i<L; i++)
            dp[i] = S[L]-S[i];

        for(int s=1; s<m; s++)
        {
            for(int i=0; i<L-s; i++)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int j=i+1; j<=L-s; j++)
                {
                    int t = Math.max(dp[j], S[j]-S[i]);
                    if(t<=dp[i])
                        dp[i]=t;
                    else
                        break;
                }
            }
        }

        return dp[0];


    }

          private boolean valid(long target, int[] nums, int m) {
              int count = 1;
              long total = 0;
              for(int num : nums) {
                  total += num;
                  if (total > target) {
                      total = num;
                      count++;
                      if (count > m) {
                          return false;
                      }
                  }
              }
              return true;

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }