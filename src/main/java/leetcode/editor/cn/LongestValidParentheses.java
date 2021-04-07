//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1252 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        /**
         * 直接用栈排序
         *
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */

//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(-1);
//
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    res = Math.max(res, i - stack.peek());
//                }
//            }
//        }
//
//        return res;

        /**
         * 动态规划
         *
         * 我们用 dp[i] 表示以 i 结尾的最长有效括号；
         *
         * 当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
         *
         * 那么 s[i] 为 )
         *
         * 2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
         *
         * 2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；
         *
         *
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */


        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}