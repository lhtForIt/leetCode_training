//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3621 👎 0


package leetcode.editor.cn;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            /**
             * 匹配0个或多个前面的元素，所以a*可以和""匹配
             */
            if (p == null || p.length() == 0) return (s == null || s.length() == 0);
            boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int j = 2; j <= p.length(); j++) {
                dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
            }
            for (int j = 1; j <= p.length(); j++) {
                for (int i = 1; i <= s.length(); i++) {
                    //因为从1开始，所以j-1,i-1其实是当前位置
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (p.charAt(j - 1) == '*')
                        dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
            return dp[s.length()][p.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
