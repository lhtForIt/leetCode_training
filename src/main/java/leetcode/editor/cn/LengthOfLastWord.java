//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 302 👎 0

package leetcode.editor.cn;
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {

        /**
         * 我这种写法其实也是调的api，时间复杂度是O(2n)
         */
        //这里会有后面有空格的情况，那么长度就会错误判断为0，需要提前去空格
//            String t = s.trim();
//            //这个从0开始的，要+1
//            int last = t.lastIndexOf(" ") + 1;
//            return t.length() - last;

        /**
         * 思路很简单，从后往前，找到非空格元素，然后从这个元素往前遍历知道遇到空格得到长度，需要注意下标是否越界。
         *
         * 比如"hello"这种需要加上end >= 0的条件。
         */
        int len = 0;
        int end = s.length() - 1;
        while (end >= 0&& s.charAt(end) == ' ') end--;
        while (end >= 0 && s.charAt(end) != ' ') {
            len++;
            end--;
        }
        return len;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}