//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 596 👎 0

package leetcode.editor.cn;

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("aa", "bb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 时间复杂度O((m-n)*n),空间复杂度O(26*2+s.len/p.len)
         */
//        List<Integer> res = new ArrayList<>();
//        if (s.length()<p.length()) return res;
//        char[] chars = new char[26];
//        for (char c : p.toCharArray()) {
//            chars[c - 'a']++;
//        }
//        char[] chars1 = s.toCharArray();
//        for (int i = 0; i <= s.length() - p.length(); i++) {
//            char[] chars2 = new char[26];
//            for (int j = i; j < i + p.length(); j++) {
//                chars2[chars1[j] - 'a']++;
//            }
//            if (Arrays.equals(chars,chars2)) res.add(i);
//        }
//        return res;
        /**
         * 我想的是每个去给它构建一个状态数组然后比较，但是其实没必要每个构建一个，我可以只用一个，
         * 只要在下次使用前把前面的状态清掉就可以了。
         *
         * 时间复杂度O(n)，空间复杂度O(26)->O(1)
         */
        List<Integer> res = new ArrayList<>();
        if (s.length()<p.length()) return res;
        char[] pWin = new char[26];
        char[] sWin = new char[26];
        for (int i = 0; i < p.length(); i++) {
            pWin[p.charAt(i) - 'a']++;
            sWin[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pWin,sWin)) res.add(0);
        char[] chars = s.toCharArray();
        for (int i = p.length(); i < s.length(); i++) {
            //清除状态
            sWin[chars[i - p.length()] - 'a']--;
            //重新计算
            sWin[chars[i] - 'a']++;
            if (Arrays.equals(pWin,sWin)) res.add(i - p.length() + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}