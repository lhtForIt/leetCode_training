//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 892 👎 0


package leetcode.editor.cn;


public class ReverseWordsInAString {
    public static void main(String[] args) {
        ReverseWordsInAString.Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            /**
             * 法一，先翻转整个，然后翻转每个单词，最后去掉空格
             */
//        char[] chars = s.toCharArray();
//        revert(chars, 0, s.length() - 1);
//        int idx = 0;
//        while (idx < s.length()) {
//            while (idx<s.length()&&chars[idx]==' ') idx++;
//            int len = idx;
//            while (len<s.length()&&chars[len]!=' ') len++;
//            revert(chars, idx, len - 1);
//            idx = len;
//        }
//
//        return cleanSpaces(chars, chars.length);
            /**
             * 法二：先翻转整个字符串，在翻转每个单词时去掉空格
             */
            char[] chars = s.toCharArray();
            revert(chars, 0, s.length() - 1);
            int startIdx = 0;
            for (int i = 0; i < chars.length; i++) {
                //是空格直接不做任何处理
                if (chars[i] != ' ') {
                    //如果不是第一位，那么表示单词已经遍历完至少一次，添加空格，你可能疑惑为啥能这么写，比如"  hs sdsd "这个不会出问题么？不会的
                    //因为startIdx只有在遍历了单词(非空字符)之后才会不为0。
                    if (startIdx != 0) chars[startIdx++] = ' ';
                    //设置起止点，i代表起始点，j代表每个字符终点
                    int j = i;
                    //将字符交换到最前面位置(相当于去空格)
                    while (j < chars.length && chars[j] != ' ')
                        chars[startIdx++] = chars[j++];
                    //交换每个字符，因为startIdx其实在交换的时候移动了字符长度位数，所以在翻转的时候起点应该去掉字符长度，即（j-i）
                    revert(chars, startIdx - (j - i), startIdx - 1); // startIdx - 1, NOT startIdx;
                    //将i移动到j的位置开始遍历，避免重复遍历
                    i = j;
                }
            }
            //这个API还真没见过，感觉挺有用的，以后可以多用用
            return new String(chars, 0, startIdx);
            /**
             * 法三：法二的forloop改成whileloop
             */
//        char[] chars = s.toCharArray();
//        revert(chars, 0, s.length() - 1);
//        int startIdex = 0, i = 0, j = 0;
//        while (i < s.length()) {
//            if (chars[i] != ' ') {
//                if (startIdex != 0) chars[startIdex++] = ' ';
//                j = i;
//                while (j<s.length()&&chars[j]!=' ') chars[startIdex++] = chars[j++];
//                revert(chars, startIdex - (j - i), startIdex - 1);
//                i = j;
//            }
//            i++;
//        }
//        return new String(chars, 0, startIdex);
        }

        /**
         * 这里其实是用的两个指针将返回的数组和原始数组构建出来了。
         * <p>
         * i其实代表返回的数组下标，j代表遍历的原始数组下标。
         */
        String cleanSpaces(char[] a, int n) {
            int i = 0, j = 0;
            while (j < n) {
                //跳过前面空格
                while (j < n && a[j] == ' ') j++;
                //交换非空格数据
                while (j < n && a[j] != ' ') a[i++] = a[j++];
                //跳过后面空格，这里不写这个有多个空格的情况下会出问题
                while (j < n && a[j] == ' ') j++;
                //保证只有一个空格，在后面加一个空格
                if (j < n) a[i++] = ' ';
            }
            return new String(a).substring(0, i);
        }

        private void revert(char[] chars, int start, int end) {
            while (start < end) {
                char c = chars[start];
                chars[start++] = chars[end];
                chars[end--] = c;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
