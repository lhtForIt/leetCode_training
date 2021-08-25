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
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new LinkedList<>();
//        if(p.length()> s.length()) return result;
//        Map<Character, Integer> map = new HashMap<>();
//        for(char c : p.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        int counter = map.size();
//
//        int begin = 0, end = 0;
//
//
//        while(end < s.length()){
//            char c = s.charAt(end);
//            if( map.containsKey(c) ){
//                map.put(c, map.get(c)-1);
//                if(map.get(c) == 0) counter--;
//            }
//            end++;
//
//            while(counter == 0){
//                char tempc = s.charAt(begin);
//                if(map.containsKey(tempc)){
//                    map.put(tempc, map.get(tempc) + 1);
//                    if(map.get(tempc) > 0){
//                        counter++;
//                    }
//                }
//                if(end-begin == p.length()){
//                    result.add(begin);
//                }
//                begin++;
//            }
//
//        }
//        return result;

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}