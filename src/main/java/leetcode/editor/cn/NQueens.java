//题号：51
//https://leetcode-cn.com/problems/n-queens/
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 753 👎 0

  
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
      public static void main(String[] args) {
           Solution solution = new NQueens().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][] chess = new char[n][n];

        for (int i = 0; i < n; i++) {
//            Arrays.fill(chess[i], '.');
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();

        recurce(result, chess, 0);

        return result;
    }

          private void recurce(List<List<String>> res, char[][] chess, int row) {
              if (row == chess.length) {
                  res.add(construct(chess));
                  return;
              }

              for (int i = 0; i < chess.length; i++) {
                  if (isValid(chess,row,i)) {
                      chess[row][i] = 'Q';
                      recurce(res, chess, row + 1);
                      chess[row][i] = '.';
                  }
              }


          }

          private boolean isValid(char[][] chess, int row,int col) {

              for (int i = 0; i < row; i++) {

                  if (chess[i][col] == 'Q') {
                      return false;
                  }

                  int rowDiff = row - i;
                  if (col + rowDiff < chess.length && chess[i][col + rowDiff] == 'Q') {
                      return false;
                  }

                  if (col - rowDiff >= 0 && chess[i][col - rowDiff] == 'Q') {
                      return false;
                  }

//                  if (chess[i][col] == 'Q') {
//                      return false;
//                  }
//                  for (int j = 0; j < chess.length; j++) {
//                      //斜率相等
//                      if (chess[i][j] == 'Q' && (i + j == row + col || i - j == row - col)) {
//                          return false;
//                      }
//                  }

              }




              return true;
          }

          private List<String> construct(char[][] chess) {
              List<String> path = new ArrayList<>();
              for (int i = 0; i < chess.length; i++) {
                  path.add(new String(chess[i]));
              }
              return path;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }