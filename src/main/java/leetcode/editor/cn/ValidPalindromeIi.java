//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 336 👎 0

package leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("abca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            /**
             * 时间复杂度O(2m+(m-n))m是删除之后的字符串长度，空间复杂度O(1)
             * 这个我一直觉得像以前字符串处理一样，一个循环可以搞定，
             * 确实是一个循环可以，但是这种其实明显拆成了子问题，可以直接拆成两个简答的子问题解。
             *
             * 如果不等，左边+1或者右边-1分别去比对就好。
             */
            char[] chars = s.toCharArray();
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return vilid(chars, left + 1, right) || vilid(chars, left, right - 1);
                }
                left++;
                right--;
            }
            return true;
        }

        private boolean vilid(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left++] != chars[right--]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}