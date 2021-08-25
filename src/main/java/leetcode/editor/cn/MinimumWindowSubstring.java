//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1307 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        /**
         * 滑动窗口通用思路，双指针，用右指针找到符合条件的字符，然后缩小左指针找到最小的字符。
         */
        /**
         * 解法一
         */
//        if(s == null || s.length() < t.length() || s.length() == 0){
//            return "";
//        }
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(char c : t.toCharArray()){
//            if(map.containsKey(c)){
//                map.put(c,map.get(c)+1);
//            }else{
//                map.put(c,1);
//            }
//        }
//        int left = 0;
//        int minLeft = 0;
//        int minLen = s.length()+1;
//        int count = 0;
//        for(int right = 0; right < s.length(); right++){
//            if(map.containsKey(s.charAt(right))){
//                map.put(s.charAt(right),map.get(s.charAt(right))-1);
//                if(map.get(s.charAt(right)) >= 0){
//                    count ++;
//                }
//                while(count == t.length()){
//                    if(right-left+1 < minLen){
//                        minLeft = left;
//                        minLen = right-left+1;
//                    }
//                    if(map.containsKey(s.charAt(left))){
//                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
//                        if(map.get(s.charAt(left)) > 0){
//                            count --;
//                        }
//                    }
//                    left ++ ;
//                }
//            }
//        }
//        if(minLen>s.length()){
//            return "";
//        }
//
//        return s.substring(minLeft,minLeft+minLen);

        /**
         * 解法二
         */
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c] += 1;
        }
        int begin = 0;
        int len = Integer.MAX_VALUE;
        int count = t.length();
        for (int left=0, right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            map[c]--;
            if(map[c]>=0) count--;
            while (count == 0) {
                char lc = s.charAt(left);
                map[lc]++;
                if (map[lc]>0) {
                    if (right-left+1<len) {
                        begin = left;
                        len = right-left+1;
                    }
                    count++;
                }
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(begin, begin+len);



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}