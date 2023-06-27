//题号：20
//https://leetcode-cn.com/problems/valid-parentheses/
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2201 👎 0

  
package leetcode.editor.cn;

import java.io.CharConversionException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
          solution.isValid("()");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {


        if (s.length() % 2 == 1) {
            return false;
        }


        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();







        /**
         * 暴力法：不断replace括号，直到字符串为"",
         * 时间复杂度O(n^2)，空间复杂度O(1)
         */
//        if (s.isEmpty() || s.length() % 2 == 1) {
//            return false;
//        }
//
//        while (!s.isEmpty()) {
//            int length = s.length();
//            s = s.replace("()", "");
//            s = s.replace("[]", "");
//            s = s.replace("{}", "");
//            if (s.length() == length) {
//                break;
//            }
//        }
//
//        return s.isEmpty();

        /**
         * 借助栈，如果是左括号就压入栈中，右括号就和栈顶元素比，
         * 如果匹配就栈顶元素弹出
         *
         * 时间复杂度O(n),空间复杂度O(n)
         *
         */

//        if (s.isEmpty() || s.length() % 2 == 1) {
//            return false;
//        }
//        Deque<Character> stack = new LinkedList<>();
//        for (char c : s.toCharArray()) {
//
//            if (c == '(') {
//                //加入这种省去了一个map装数据
//                stack.push(')');
//            }else if (c == '[') {
//                stack.push(']');
//            }else if (c == '{') {
//                stack.push('}');
//            }else if (stack.isEmpty() || stack.pop() != c) {
//                return false;
//            }
//
//        }
//        //"(("这种情况要判断栈是否为空
//        return stack.isEmpty();

        /**
         * 自己用数组实现栈，jdk的栈现在不能打败100%了
         *
         * 时间复杂度O(n),空间复杂度O(n)
         */
//        if ((s.length() & 1) == 1) {
//            return false;
//        }
//        char[] stack = new char[s.length()];
//        int top = -1;
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack[++top] = ')';
//            } else if (c == '[') {
//                stack[++top] = ']';
//            } else if (c == '{') {
//                stack[++top] = '}';
//            } else {
//                if (top == -1 || stack[top--] != c) {
//                    return false;
//                }
//            }
//        }
//        return top == -1;
    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }