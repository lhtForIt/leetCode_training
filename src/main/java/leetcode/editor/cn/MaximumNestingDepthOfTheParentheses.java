//题号：1614
//如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）： 
//
// 
// 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。 
// 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。 
// 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。 
// 
//
// 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)： 
//
// 
// depth("") = 0 
// depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")" 
// depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串 
// depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串 
// 
//
// 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
// 
//
// 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(1+(2*3)+((8)/4))+1"
//输出：3
//解释：数字 8 在嵌套的 3 层括号中。
// 
//
// 示例 2： 
//
// 
//输入：s = "(1)+((2))+(((3)))"
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "1+(2*3)/(2-1)"
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：s = "1"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成 
// 题目数据保证括号表达式 s 是 有效的括号表达式 
// 
// Related Topics 栈 字符串 
// 👍 57 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumNestingDepthOfTheParentheses{
      public static void main(String[] args) {
           Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
          solution.maxDepth("(1+(2*3)+((8)/4))+1");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 思路：
           * 我一开始以为直接要用栈去装和取，因为一看到括号会本能的用栈去弄，
           * 但是其实这个只是和栈的深度相关，可以完全不用管栈里面装的啥，直接
           * 用两个变量显示即可。
           *
           *
           */
    public int maxDepth(String s) {


        Deque<Character> stack = new LinkedList<>();
        int max = 0, size = 0;
        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(')');
                max = Math.max(max, ++size);
            } else if (!stack.isEmpty() && c == ')') {
                stack.pop();
                size--;
            }


        }


        return max;


//        int[] stack = new int[s.length()];
//        int top = -1;
//
//        int max = 0, size = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack[++top] = ')';
//                max = Math.max(max, ++size);
//            } else if (top != -1 && c == ')') {
//                top--;
//                size--;
//            }
//        }
//
//        return max;




    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }