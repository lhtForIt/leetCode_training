//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4856 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        /**
         * 这里用双指针代表滑动窗口边界，left代表左指针，i代表右指针，因为会存在重复，
         * 为了减去再次遍历操作，用一个map将以前的char字符存储起来，当在滑动窗口右边界的时候如果
         * 发现刚进来的char是以前含有的，就将左边界变为以前char的index+1(其实你想想就是移除重复的char字符)，
         * 最后i-left+1就是i为右指针时的最大值(这里+1是因为i是0开始的，如果是1开始可以不用+1)，然后不断更新left和i遍历整个数组找到最大值即可。
         */

        if (s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        //这里的i代表右指针的位置
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

        /**
         * 直接用双端队列，碰到重复的char直接将重复char和前面的所有元素移除即可。
         * 然后队列的长度就是最长子序列。
         *
         * 时间复杂度：O(nm) m为字符串中重复key个数,空间复杂度：O(n)
         */

//        if (s.length() == 0) {
//            return 0;
//        }
//
//        int max = 0;
//        Deque<Character> deque = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//
////            while(deque.contains(s.charAt(i))) {
////                deque.pollFirst();
////            }
//            if (deque.contains(s.charAt(i))) {
//                while (deque.peekFirst() != s.charAt(i)) {
//                    deque.pollFirst();
//                }
//                deque.pollFirst();
//            }
//
//            deque.offerLast(s.charAt(i));
//
//            max = max < deque.size() ? deque.size() : max;
//
//        }
//
//        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}