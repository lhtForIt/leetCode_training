//题号：221
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 770 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class MaximalSquare{
      public static void main(String[] args) {
           Solution solution = new MaximalSquare().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 动态规划:二维
         */
//        if(matrix.length == 0)
//            return 0;
//        int[] prev = new int[matrix[0].length + 1];
//        int[] curr = new int[matrix[0].length + 1];
//        int res = 0;
//        for(int i = 1 ;i <= matrix.length; i++){
//            for(int j = 1; j <= matrix[0].length; j++) {
//                if(matrix[i-1][j-1] == '1') {
//                    curr[j] = Math.min(Math.min(curr[j-1],prev[j - 1]), prev[j]) + 1;
//                    res = Math.max(res,curr[j]);
//                }
//                else
//                    curr[j] = 0;
//            }
//            prev = Arrays.copyOf(curr, curr.length);
//            Arrays.fill(curr,0);
//        }
//        return res*res;


        /**
         * 动态规划：一维
         */

//        if(matrix.length == 0)
//            return 0;
//        int[] curr = new int[matrix[0].length + 1];
//        int upperLeft = 0;
//        int res = 0;
//        int temp = 0;
//        for(int i = 1 ;i <= matrix.length; i++){
//            for(int j = 1; j <= matrix[0].length; j++) {
//                temp = curr[j];
//                if(matrix[i-1][j-1] == '1') {
//                    curr[j] = Math.min(Math.min(curr[j-1],upperLeft), curr[j]) + 1;
//                    res = Math.max(res,curr[j]);
//                }
//                else
//                    curr[j] = 0;
//                upperLeft = temp;
//
//            }
//        }
//        return res*res;


        /**
         * 另一种解法
         */

        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;


    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }