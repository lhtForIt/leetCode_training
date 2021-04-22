//题号：49
//
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 652 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams{
      public static void main(String[] args) {
           Solution solution = new GroupAnagrams().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> keyMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = new String(chars);
            if (!keyMap.containsKey(key)) {
                keyMap.put(key, new ArrayList<>());
            }
            keyMap.get(key).add(str);
         }


        return new ArrayList<>(keyMap.values());









        /**
         * HashMap题型总结；
         * 1、字母异位：统计字母出现频次，第一个单词得到一个字母对应count，第二个单词在减去，最后看count是否为0
         * 2、字母异位分组：构建一个key，将字母异位词都转成同一个key，然后放入value中。
         * 可以sort，也可以自建char数组，然后根据char数组为key去判定
         */



        /**
         * 法一：排序+hashMap
         *
         * 时间复杂度O(nlogn)，空间复杂度O(n)
         *
         */

//        if (strs == null || strs.length == 0) {
//            return new ArrayList<>();
//        }
//
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String keyStr = String.valueOf(ca);
//            if (!map.containsKey(keyStr)) {
//                map.put(keyStr, new ArrayList<>());
//            }
//            map.get(keyStr).add(s);
//        }
//
//        return new ArrayList<>(map.values());


        /**
         * 法二：无排序，自建key值
         *
         * 时间复杂度O(n*26)，空间复杂度O(n)
         *
         */

//        if (strs == null || strs.length == 0) {
//            return new ArrayList<>();
//        }
//
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//
//            char[] ca = new char[26];
//            for (char c : s.toCharArray()) {
//                //这里统计的分别是'a'的次数一直到'z'的次数，因此即使位置不一样后面得到的字符串也是一样的
//                ca[c - 'a']++;
//            }
//
//            String keyStr = String.valueOf(ca);
//            if (!map.containsKey(keyStr)) {
//                map.put(keyStr, new ArrayList<>());
//            }
//            map.get(keyStr).add(s);
//        }
//
//        return new ArrayList<>(map.values());


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }