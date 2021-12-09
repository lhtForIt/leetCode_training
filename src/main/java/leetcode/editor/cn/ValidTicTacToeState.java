//题号：794
//给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。 
//
// 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（' '）中。 
// 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。 
// 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["O  ","   ","   "]
//输出：false
//解释：玩家 1 总是放字符 "X" 。
// 
//
// 示例 2： 
//
// 
//输入：board = ["XOX"," X ","   "]
//输出：false
//解释：玩家应该轮流放字符。 
//
// 示例 3： 
//
// 
//输入：board = ["XXX","   ","OOO"]
//输出：false
// 
//
// Example 4: 
//
// 
//输入：board = ["XOX","O O","XOX"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] 为 'X'、'O' 或 ' ' 
// 
// Related Topics 数组 字符串 
// 👍 66 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ValidTicTacToeState{
      public static void main(String[] args) {
           Solution solution = new ValidTicTacToeState().new Solution();
          solution.validTicTacToe(new String[]{"O  ", "   ", "   "});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 其实我一开始以为要用递归解，但是看了全球站的高赞解法之后其实就是一个按输入字符在重新校验一次而已，
           * 所以我的思维还有有问题的
           *
           * 这里其实可以看做是n皇后题的简化，因为n皇后需要考虑斜率判断撇捺是否有冲突，
           * 但是这里面只有在对角线还会有问题，因此直接考虑就可以。
           * 撇就是y==x,捺就是x+y=2。
           * 用几个标志位去判断是否符合条件，eg.turns如果是1代表x在移动，如果是0代表O在移动。
           * xWin和oWin代表x赢还是o赢。
           * rows和cols数组或者diag和antidiag每一位如果等于3或者-3代表x和o获得胜利。
           *
           */
    public boolean validTicTacToe(String[] board) {

        int turns = 0;
        boolean xWin;
        boolean oWin;
        int[] row = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antidiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    row[i]++;
                    cols[j]++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        antidiag++;
                    }
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                    row[i]--;
                    cols[j]--;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        antidiag--;
                    }
                }
            }
        }


        xWin = row[0] == 3 || row[1] == 3 || row[2] == 3 || cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || diag == 3 || antidiag == 3;
        oWin = row[0] == -3 || row[1] == -3 || row[2] == -3 || cols[0] == -3 || cols[1] == -3 || cols[2] == -3 || diag == -3 || antidiag == -3;

        if (xWin && turns != 1 || oWin && turns != 0) {
            return false;
        }

        //这里可能会出现O先走或者X或者O走多步的情况，这种时候turns会出现<0或者>1的情况
        return turns == 0 || turns == 1;



















//        int turns = 0;
//        boolean xWin;
//        boolean oWin;
//        int[] rows = new int[3];
//        int[] cols = new int[3];
//        int diag = 0;
//        int antidiag = 0;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[i].charAt(j) == 'X') {
//                    turns++; rows[i]++; cols[j]++;
//                    if (i == j) diag++;
//                    if (i + j == 2) antidiag++;
//                } else if (board[i].charAt(j) == 'O') {
//                    turns--; rows[i]--; cols[j]--;
//                    if (i == j) diag--;
//                    if (i + j == 2) antidiag--;
//                }
//            }
//        }
//
//        xWin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
//                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
//                diag == 3 || antidiag == 3;
//        oWin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
//                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
//                diag == -3 || antidiag == -3;
//
//        //这里判定是否存在x或者o走多步的情况
//        if (xWin && turns == 0 || oWin && turns == 1) {
//            return false;
//        }
//        return turns == 0 || turns == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }