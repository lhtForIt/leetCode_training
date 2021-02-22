//题号：22
//https://leetcode-cn.com/problems/generate-parentheses/
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1565 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GenerateParentheses{
      public static void main(String[] args) {
          Solution solution = new GenerateParentheses().new Solution();
          solution.generateParenthesis(3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        recur2(0, 0, n, res, "");

        return res;

//        List<String> result = new LinkedList<>();
//
//        //第一层初始应该是空串，因为出口判断条件不一样，因此max也不一样
//        recur1(0, 0, n, result, "");
////        recur(0,2 * 3, result, "");
//
//
//        return result;
    }

          private void recur2(int left, int right, int n, List<String> res, String s) {

              //结束条件
              if (left == n && right == n) {
                  res.add(s);
                  return;
              }

              //当前逻辑
              //进入下一层，加上条件剪枝
              if (left<n) recur2(left + 1, right, n, res, s + "(");
              if (right<left) recur2(left, right + 1, n, res, s + ")");

              //重置状态，一般回溯会用到，这个不用



          }

          public void recur(int deep,int max,List<String> result,String str){


        if (deep == max) {
            result.add(str);
            System.out.println(str);
            return;
        }

        //current logic

        //drop down
        /**
         * 这儿对应递归两种可能，左分支和右分支
         */
        recur(deep + 1, max, result, str+ "(");
        recur(deep + 1, max, result, str+ ")");


    }


          /**
           * 条件判断可以直接在递归过程中判断，
           * 1、左括号可以随便加，只要不超过做大限制即可
           * 2、右括号必须在有左括号的时候才能加，右括号<左括号
           */
    public void recur1(int left, int right, int max, List<String> result, String str) {

        if (left == max && right == max) {
//        if (str.length() == max * 2) {
            result.add(str);
            System.out.println(str);
            return;
        }

        //current logic

        //drop down
        /**
         * 这儿对应递归两种可能，左分支和右分支
         * 可以加些条件进行剪枝
         */
        if (left < max)
            recur1(left + 1, right, max, result, str + "(");
        if (right < left)
            recur1(left, right + 1, max, result, str + ")");


    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }