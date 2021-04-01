//题号：718
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 406 👎 0

  
package leetcode.editor.cn;
public class MaximumLengthOfRepeatedSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int findLength(int[] A, int[] B) {


              /**
               * 法一：动态规划
               *
               * 子问题拆分：S(i)=(a(i-1)==b(i-1)?0:S(i-1)+1)这里思路是比较字符串尾部，看是否相等，
               * 如果不等就不用比前面元素了，如果相等，就比较前面元素是否相等，这里由于尾部相等，就
               * 一定有一个元素，因此+1.
               * 状态数组定义：因为有两个元素，需要分别表示他们，因此用二位数组dp[i][j]，它代表下标i-1和j-1的最长重复子数组
               * 状态转移方程：if(A[i-1]==B[j-1])dp[i][j]=dp[i-1][j-1]+1: else dp[i][j]=0;
               *
               */

              int max = 0;
              int[][] dp = new int[A.length+1][B.length+1];
              for (int i = 1; i <= A.length; i++) {
                  for (int j = 1; j <= B.length; j++) {
                      //当前面一个元素相等时才叠加上当前元素，否则直接是0
                      if (A[i - 1] == B[j - 1]) {
                          dp[i][j] = dp[i - 1][j - 1] + 1;
                      } else {
                          //这个else有必要么？初始值不就是0？先写着吧，思路熟悉之后就删掉
                          dp[i][j] = 0;
                      }
                      max = max > dp[i][j] ? max : dp[i][j];
                  }
              }

              return max;


              /**
               * 动态规划空间优化：
               * 动态规划好像都可以优化空间复杂度
               */

//              int max = 0;
//              int[] dp = new int[B.length + 1];
//              for (int i = 1; i <= A.length; i++) {
//                  for (int j = B.length; j >= 1; j--) {
//                      if (A[i - 1] == B[j - 1])
//                          dp[j] = dp[j - 1] + 1;
//                      else
//                          dp[j] = 0;
//                      max = Math.max(max, dp[j]);
//                  }
//              }
//              return max;


              /**
               * 滑动窗口
               *
               * Let’s keep A at one place and try to slide B such that it overlap with B.
               *
               * Let’s say length of A is m and B is n. Total sliding window is m+n-1.
               *
               * ia = starting position of overlap in A = max(0, i+1-m)
               * ib = starting position of overlap in B = max(0, n-1-i)
               * olap = overlap length = min(i+1, n) - ia
               *
               */
//              int m = A.length, n = B.length, result = 0;
//
//              for(int i = 0; i < m+n-1; i++){
//                  int ia = Math.max(0, i+1-m), ib = Math.max(0, n-i-1);
//                  int olap = Math.min(i+1, n) - ia, len = 0;
//
//                  if(olap <= result) return result;
//
//                  for(int j = 0; j < olap; j++){
//                      if(A[ia+j] == B[ib+j]){
//                          len++;
//                          result = Math.max(len, result);
//                      }else{
//                          len = 0;
//                      }
//                  }
//              }
//
//              return 0;





          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }