//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 
// 👍 126 👎 0

package leetcode.editor.cn;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            /**
             * 时间复杂度O(n),空间复杂度O(n)
             */
            char[] chars = s.toCharArray();
            revert(chars, 0, s.length() - 1);
            return new String(chars);
        }

        private void revert(char[] chars, int start, int end) {
            while (start < end) {
                while (start < end && !Character.isLetter(chars[start])) start++;
                while (start < end && !Character.isLetter(chars[end])) end--;
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}