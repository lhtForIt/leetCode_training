//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 
// s 包含可打印的 ASCII 字符。 
// 
// s 不包含任何开头或结尾空格。 
// 
// s 里 至少 有一个词。 
// 
// s 中的所有单词都用一个空格隔开。 
// 
//
// Related Topics 双指针 字符串 👍 549 👎 0


package leetcode.editor.cn;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("Let's take LeetCode contest");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            /**
             * 时间复杂度O(n)，空间复杂度O(n)
             */
            int start = 0, end = 0;
            char[] chars = s.toCharArray();
            while (end < s.length()) {
                end = start;
                while (end < s.length() && chars[end] != ' ') end++;
                revert(chars, start, end - 1);
                start = end + 1;
            }
            return new String(chars);
        }

        private void revert(char[] chars, int start, int end) {
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
