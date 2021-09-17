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

import java.util.*;

public class NQueens{
      public static void main(String[] args) {
           Solution solution = new NQueens().new Solution();
          solution.solveNQueens(4);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private  Set<Integer> col = new HashSet<>();
    private  Set<Integer> diag1 = new HashSet<>();
    private  Set<Integer> diag2 = new HashSet<>();



    public List<List<String>> solveNQueens(int n) {


        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] pie = new boolean[2 * n - 1];
        boolean[] na = new boolean[2 * n - 1];
        char[] chess = new char[n];
        Arrays.fill(chess, '.');


        recuv(visited, pie, na, res, new ArrayList<>(), chess, 0, n);

        return res;





//        List<List<String>> res = new ArrayList<>();
//        char[] chess = new char[n];
//        Arrays.fill(chess, '.');
//
//        recurMap(0, res, new ArrayList<>(), chess, n);
//
//        return res;






//        char[][] chess = new char[n][n];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(chess[i], '.');
//        }
//
//        List<List<String>> res = new ArrayList<>();
//
//        recur(0, res, chess);
//        return res;




        /**
         * 直接递归
         */
//        char[][] chess = new char[n][n];
//
//        for (int i = 0; i < n; i++) {
////            Arrays.fill(chess[i], '.');
//            for (int j = 0; j < n; j++) {
//                chess[i][j] = '.';
//            }
//        }
//
//        List<List<String>> result = new ArrayList<>();
//
//        recurce(result, chess, 0);
//
//        return result;

        /**
         * 递归+Set缓存优化
         * 这个为啥还没不加缓存快啊？
         */
//        List<List<String>> res = new ArrayList<>();
//        char[] charArray = new char[n];
//        Arrays.fill(charArray, '.');
//        dfs(0, res, new ArrayList<>(), n, charArray);
//        return res;

        /**
         * 递归+数组缓存优化
         */
//        List<List<String>> res = new ArrayList<>();
//        boolean[] visited = new boolean[n];
//        //2*n-1个斜对角线
//        //因为数组下标会存在越界，比如row-i的时候可能为负，因此需要一些特殊处理，在row-i的时候扩大n-1，让所有保持一致
//        boolean[] dia1 = new boolean[2*n-1];
//        boolean[] dia2 = new boolean[2*n-1];
//        char[] charArray = new char[n];
//        Arrays.fill(charArray,'.');
//        dfsArray(0, visited, dia1, dia2, new ArrayList<>(), res, n, charArray);
//
//        return res;

    }

          private void recuv(boolean[] visited, boolean[] pie, boolean[] na, List<List<String>> res, ArrayList<String> subRes, char[] chess, int row, int n) {
              if (row == n) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < n; i++) {

                  if (visited[i] || pie[row + i] || na[row - i + n - 1]) {
                      continue;
                  }

                  chess[i] = 'Q';
                  subRes.add(new String(chess));
                  chess[i] = '.';

                  visited[i] = true;
                  pie[row + i] = true;
                  na[row - i + n - 1] = true;

                  recuv(visited, pie, na, res, subRes, chess, row + 1, n);

                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
                  pie[row + i] = false;
                  na[row - i + n - 1] = false;



              }






          }

          private void recurMap(int row, List<List<String>> res, ArrayList<String> list, char[] chess, int n) {

              if (row == n) {
                  res.add(new ArrayList<>(list));
                  return;
              }

              for (int i = 0; i < n; i++) {

                  if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) {
                      continue;
                  }

                  chess[i] = 'Q';
                  list.add(new String(chess));
                  chess[i] = '.';

                  col.add(i);
                  diag1.add(row + i);
                  diag2.add(row - i);

                  recurMap(row + 1, res, list, chess, n);

                  list.remove(list.size() - 1);
                  col.remove(i);
                  diag1.remove(row + i);
                  diag2.remove(row - i);
              }






          }




          private void recur(int row, List<List<String>> res, char[][] chess) {

              if (row == chess.length) {
                  res.add(buildBroad(chess));
                  return;
              }

              for (int i = 0; i < chess.length; i++) {
                  if (vadite(chess, row, i)) {
                      chess[row][i] = 'Q';
                      recur(row + 1, res, chess);
                      chess[row][i] = ',';
                  }
              }

          }

          private boolean vadite(char[][] chess, int row, int col) {

              for (int i = 0; i < row; i++) {

                  if (chess[i][col] == 'Q') {
                      return false;
                  }


                  //(x1-x2)=+-(y1-y2)
                  int rowDiff = row - i;

                  if (col + rowDiff < chess.length && chess[i][col + rowDiff] == 'Q') {
                      return false;
                  }

                  if (col - rowDiff >= 0 && chess[i][col - rowDiff] == 'Q') {
                      return false;
                  }

              }

              return true;
          }

          private List<String> buildBroad(char[][] chess) {

              List<String> list = new ArrayList<>();
              for (char[] c : chess) {
                  list.add(new String(c));
              }

              return list;



          }


          private void dfsArray(int rowIndex, boolean[] visited, boolean[] dia1, boolean[] dia2, ArrayList<String> list, List<List<String>> res, int n, char[] charArray) {
              if(rowIndex == n){
                  res.add(new ArrayList<>(list));
                  return;
              }

              for(int i=0;i<n;i++){
                  //列、正对角线、反对角线有皇后已经放了
                  if(visited[i] || dia1[rowIndex+i] || dia2[rowIndex-i+n-1])
                      continue;



                  charArray[i] = 'Q';
                  String stringArray = new String(charArray);
                  list.add(stringArray);
                  charArray[i] = '.';
                  visited[i] = true;
                  dia1[rowIndex+i] = true;
                  dia2[rowIndex-i+n-1] = true;

                  dfsArray(rowIndex + 1, visited, dia1, dia2, list, res, n, charArray);

                  //重置状态
                  list.remove(list.size()-1);
                  charArray[i] = '.';
                  visited[i] = false;
                  dia1[rowIndex+i] = false;
                  dia2[rowIndex-i+n-1] = false;
              }
          }

          private void dfs(int row, List<List<String>> res, List<String> list, int n, char[] charArray) {

              if (n == row) {
                  res.add(new ArrayList<>(list));
                  return;
              }


              for (int i = 0; i < n; i++) {
                  if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) {
                      continue;
                  }
                  charArray[i] = 'Q';
                  String rowString = new String(charArray);

                  list.add(rowString);
                  //要保证每次递归的charArray都是'....'这个
                  charArray[i] = '.';
                  col.add(i);
                  diag1.add(row + i);
                  diag2.add(row - i);

                  dfs(row + 1, res, list, n, charArray);

                  list.remove(list.size() - 1);
                  col.remove(i);
                  diag1.remove(row + i);
                  diag2.remove(row - i);

              }


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

          /**
           * 前提：x1-y1=x2-y2||x1+y1=x2+y2
           * 得到：x1-y1=x2-y2||x1-x2=-(y1-y2)
           * 进而推出：(x2-x1)/(y2-y1) == 1 or -1
           *
           * 因此在知道x1,y1,x2的情况下怎么得到y2?
           * 直接用y2=y1-(x1-x2)||y2=y1+(x1-x2)
           * 当前点：(row,col)=(x2,y2)
           * 以前的点：(i,y)=(x1,y1)
           * x2-x1=y2-y1||x2-x1=y1-y2
           * row-i=col-y||row-i=y-col
           * y=col-(row-i)||y=col+(row-i)
           */
          private boolean isValid(char[][] chess, int row,int col) {

              for (int i = 0; i < row; i++) {
                  //同一列有皇后
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