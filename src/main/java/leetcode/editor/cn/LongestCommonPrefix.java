//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2811 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /**
         * 直接写
         */
//        char[] chars = strs[0].toCharArray();
//        if (chars.length == 0) return "";
//        int max = chars.length;
//        for (int j = 1; j < strs.length; j++) {
//            char[] chars1 = strs[j].toCharArray();
//            int length = 0;
//            for (int i = 0; i < chars1.length&&i<chars.length; i++) {
//                if (chars[i] != chars1[i]) {
//                    break;
//                }
//                length++;
//            }
//            max = Math.min(max, length);
//        }
//        return strs[0].substring(0, max);
        /**
         * 先排序，然后用最前和最后两个字符串比较,
         * 因为sort之后，前后两个字符串就会变得不一样，这样就能很快找出来
         * 比如"faower","flow","flight" sort之后是 "faower","flight","flow"
         */
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) != s2.charAt(idx)) {
                break;
            }
            idx++;
        }
        return s1.substring(0, idx);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
