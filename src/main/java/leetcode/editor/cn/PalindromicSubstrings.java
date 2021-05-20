//题号：647
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 582 👎 0

  
package leetcode.editor.cn;
public class PalindromicSubstrings{
      public static void main(String[] args) {
           Solution solution = new PalindromicSubstrings().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        /**
         * 动态规划
         */

//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int ans = 0;
//
//        for (int j = 0; j < s.length(); j++) {
//            for (int i = 0; i <= j; i++) {
//                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
//                    dp[i][j] = true;
//                    ans++;
//                }
//            }
//        }
//
//        return ans;

        /**
         * 遍历每个字符，然后从奇数和偶数长度延伸回文（自身和自身+1位）
         */
        int count = 0;
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count+=extendPalindrome(s, i, i); // odd length;
            count+=extendPalindrome(s, i, i + 1); // even length
        }

        return count;


    }

          private int extendPalindrome(String s, int left, int right) {
              int count = 0;
              while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  count++;
                  left--;
                  right++;
              }
              return count;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }