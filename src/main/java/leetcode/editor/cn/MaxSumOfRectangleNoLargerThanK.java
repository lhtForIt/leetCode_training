//题号：363
//给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 
//
// 示例: 
//
// 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
//输出: 2 
//解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 说明： 
//
// 
// 矩阵内的矩形区域面积必须大于 0。 
// 如果行数远大于列数，你将如何解答呢？ 
// 
// Related Topics 队列 二分查找 动态规划 
// 👍 159 👎 0

  
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxSumOfRectangleNoLargerThanK{
      public static void main(String[] args) {
           Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        /**
         * 第一种解法
         */
//        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
//        for (int l = 0; l < cols; l++) {
//            int[] rowSum = new int[rows];
//            for (int r = l; r < cols; r++) {
//                for (int i = 0; i < rows; i++) {
//                    rowSum[i] += matrix[i][r];
//                }
//                max = Math.max(max, dpmax(rowSum, k));
//                if (max == k) return k;
//            }
//        }
//        return max;

        /**
         * 全球站解法
         */

//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return 0;
//        int maxSum = Integer.MIN_VALUE;
//        for(int i = 0; i<matrix[0].length;i++){//left col
//            int[] sum = new int[matrix.length];
//            for(int m = i; m<matrix[0].length;m++){//right col
//                for(int j = 0; j<matrix.length;j++){
//                    sum[j]+=matrix[j][m];//add from left to right
//                    if(sum[j]==k)return  k;
//                    if(sum[j]<k)maxSum=Math.max(maxSum,sum[j]);
//                }
//                for(int j = 0; j<matrix.length;j++){//up row
//                    int summe=0;
//                    for(int n = j; n<matrix.length;n++){// down row
//                        summe+=sum[n];//add from  up to down
//                        if(summe==k)return k;
//                        if(summe<k)maxSum=Math.max(maxSum,summe);
//                    }
//                }
//            }
//        }
//
//        return maxSum;

        /**
         * 全球站法二
         */


        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sums = new int[rows];
        int ans = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            Arrays.fill(sums, 0);
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++)
                    sums[i] += matrix[i][r];

                int currentMax = 0;
                int totalMax = Integer.MIN_VALUE;
                // Use kadane algorithm to calculate maximum subarray sum in linear time O(rows)
                for (int i = 0; i < rows; i++) {
                    currentMax = Math.max(0, currentMax) + sums[i];
                    totalMax = Math.max(totalMax, currentMax);
                }

                if (totalMax <= k) {
                    // cut off sums from binary search which are less or equal to k
                    ans = Math.max(ans, totalMax);
                    continue;
                }

                // search to find subarrays with sums close to k
                // ideally this part should be replaced with something capable of doing search in O(rows^log(rows)) time instead of current O(rows^2)
                for (int i = 0; i < rows; i++) {
                    int runSum = 0;
                    for (int j = i; j < rows; j++) {
                        runSum += sums[j];
                        if (runSum <= k)
                            ans = Math.max(ans, runSum);
                    }
                }
            }
        }

        return ans;


    }

          private int dpmax(int[] arr, int k) {

              int rollSum = arr[0], rollMax = rollSum;
              for (int i = 1; i < arr.length; i++) {
                  if (rollSum > 0) rollSum += arr[i];
                  else rollSum = arr[i];
                  if (rollSum > rollMax) rollMax = rollSum;
              }
              if (rollMax <= k) return rollMax;

              int max = Integer.MIN_VALUE;
              for (int l = 0; l < arr.length; l++) {
                  int sum = 0;
                  for (int r = l; r < arr.length; r++) {
                      sum += arr[r];
                      if (sum > max && sum <= k) max = sum;
                      if (max == k) return k;
                  }
              }
              return max;

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }