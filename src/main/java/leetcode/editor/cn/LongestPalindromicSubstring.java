//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4004 👎 0

package leetcode.editor.cn;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //我一开始以为需要最低位，最高位和最大长度三个变量，其实最高位是不需要使用的，直接只要最低位和最大长度即可。
        int low, max = 0;
        public String longestPalindrome(String s) {
            /**
             * dp 时间复杂度O(n^2)，空间复杂度O(n)
             */
//            String result = "";
//            int len = 0;
//            boolean[][] isPali = new boolean[s.length()][s.length()];
//            for (int i = s.length() - 1; i >= 0; i--) {
//                for (int j = i; j < s.length(); j++) {
//                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPali[i + 1][j - 1])) {
//                        isPali[i][j] = true;
//                        if (j - i + 1 > len) {
//                            result = s.substring(i, j + 1);
//                            len = j - i + 1;
//                        }
//                    }
//                }
//            }
//            return result;
            /**
             * 分奇偶数，分别向外扩展
             */
            if (s.length() < 2) return s;
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                //奇数验证,第一个参数是左边位置，第二个参数是右边位置
                doValid(chars, i, i);
                //偶数验证
                doValid(chars, i, i + 1);
            }
            return s.substring(low, low + max);
            /**
             * 全球站另一种解法，不再判断奇偶数
             */
//            if (s == null || s.trim().equals("")) {
//                return s;
//            }
//            int len = s.length();
//            int begin = 0;
//            int maxLen = 0;
//            for (int i = 0; i < len - maxLen / 2; i++) {
//                int j = i;
//                int k = i;
//                while (k < len - 1 && s.charAt(k) == s.charAt(k + 1)) { // Skip duplicated characters to the right
//                    k++;
//                }
//                while (j > 0 && k < len - 1 && s.charAt(j-1) == s.charAt(k+1)) { // Expand both left and right
//                    j--;
//                    k++;
//                }
//                int newLen = k - j + 1;
//                if (newLen > maxLen) {
//                    begin = j;
//                    maxLen = newLen;
//                }
//            }
//            return s.substring(begin, begin + maxLen);
        }
        private void doValid(char[] chars, int start, int end) {
            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                start--;
                end++;
            }
            /**
             * 上面遍历出来的是的start和end意味着越界或者不相等的字符，但是我们要的其实是相等的或者不越界的字符，那么最左边就是start+1,最右边就是end-1，最大长度就是
             * end-1-start。
             */
            if (max < end - start - 1) {
                low = start + 1;
                max = end - start - 1;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}