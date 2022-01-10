//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 104 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 
// 👍 193 👎 0

package leetcode.editor.cn;

import java.util.*;

import static java.util.Objects.hash;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestDuplicateSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * hash() : computes hash for a given string
         * nextHash() : computes next hash by removing first letter and adding next letter
         * getDup() : returns a duplicate string for a given window size
         *
         * Here i chose 31 as the prime number for helping with hash
         */
    public String longestDupSubstring(String s) {
        String ans = "";

        int left = 1;
        int right = s.length()-1;

        while(left <= right){
            int m = left + (right - left)/2;

            String dup = getDup(m,s);

            if(dup != null){
                ans = dup;
                left = m+1;
            }else{
                right = m-1;
            }
        }

        return ans;
    }

        private String getDup(int size, String s) {
            long H = hash(s.substring(0,size));

            HashSet<Long> set = new HashSet();
            set.add(H);

            long pow = 1;
            for(int i=1;i<size;i++)
                pow = (pow * 31);

            int n = s.length();
            for(int i=size;i < n;i++){
                H = nextHash(pow, H, s.charAt(i-size), s.charAt(i));
                if(!set.add(H)){
                    return s.substring(i-size+1, i+1);
                }
            }

            return null;
        }

        private long hash(String s){
            long h = 0;
            long a = 1;

            int n = s.length();
            for(int k=n;k>=1;k--){
                char ch = s.charAt(k-1);
                h += (ch - 'a' + 1) * a;
                a = (a*31);
            }

            return h;
        }

        private long nextHash(long pow,long hash,char left,char right) {
            return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}