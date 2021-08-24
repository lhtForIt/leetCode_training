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
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int lo, maxLen;
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);

//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            //StringBuffer sb = new StringBuffer();
//            //sb.append(s.charAt[i]);
//            char c = s.charAt(i);
//            int left = i;
//            int right = i;
//
//            while (left >= 0 && s.charAt(left) == c) {
//                left--;
//            }
//
//            while (right < s.length() && s.charAt(right) == c) {
//                right++;
//            }
//
//            while (left >= 0 && right < s.length()) {
//                if (s.charAt(left) != s.charAt(right)) {
//                    break;
//                }
//                left--;
//                right++;
//            }
//
//
//            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
//            // we don't set "right" because String.substring function required end index exclusively
//            left = left + 1;
//            if (end - start < right - left) {
//                start = left;
//                end = right;
//            }
//        }
//
//        return s.substring(start, end);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }




}
//leetcode submit region end(Prohibit modification and deletion)

}