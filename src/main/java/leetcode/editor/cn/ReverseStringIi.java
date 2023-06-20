//题号：541
//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 118 👎 0


package leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        solution.reverseStr("abcdefg", 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            /**
             * 这SB题给那么多条件，其实总结起来就一句话，在2k的数组里，一直翻转前k个数组，有就翻转，没有就不管。
             *
             * 那么多题设全是屁话，没一点用
             *
             * 所以我们只要知道左右边界做翻转就行，如果没有达到k，就拿size去翻转，否则用k翻转
             */
            int l = 0, r = 0;
            char[] chars = s.toCharArray();
            while (l < s.length()) {
                r = l + k - 1;
                revert(chars, l, Math.min(r, s.length() - 1));
                l += 2 * k;
            }
            return new String(chars);
        }

        private void revert(char[] c, int l, int r) {
            while (l < r) {
                char temp = c[l];
                //因为这个元素后面不会用了，所以可以直接++和--
                c[l++] = c[r];
                c[r--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}