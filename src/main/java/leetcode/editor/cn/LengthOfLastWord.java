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
         * 调api，很低效
         */
//        String[] strs = s.split(" ");
//        if (strs.length == 0) {
//            return 0;
//        }
//        return strs[strs.length - 1].length();

        /**
         * 从字符串末尾开始向前遍历，其中主要有两种情况
         * 第一种情况，以字符串"Hello World"为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词"World"的长度5
         * 第二种情况，以字符串"Hello World "为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为"World"，长度为5
         * 所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
         * 时间复杂度：O(n)，n为结尾空格和结尾单词总体长度
         */
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;

        //只有一个空格的情况" "
        if (end<0) return 0;

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;

        return end - start;






    }

}
//leetcode submit region end(Prohibit modification and deletion)

}