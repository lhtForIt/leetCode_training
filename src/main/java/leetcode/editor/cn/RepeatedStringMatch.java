//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 104 
// 1 <= b.length <= 104 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 
// 👍 194 👎 0

package leetcode.editor.cn;
public class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int count=0;
//        while(sb.length()<=b.length()+a.length()){
//            count++;
//            sb.append(a);
//            if(sb.indexOf(b) != -1){return count;}
//        }
//        return -1;


        /**
         * KMP算法
         */
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        if(KMP(sb.toString(), b)) return count;

        if(KMP(sb.append(a).toString(), b)) return count+1;
        return -1;
    }

        private boolean KMP(String s1, String s2) {
            int[] index = new int[s2.length()];
            int left = 0, right = 1;

            while(right < s2.length()){
                if(s2.charAt(left) == s2.charAt(right)){
                    index[right] = left + 1;
                    left++;
                    right++;
                }
                else if(left == 0) {
                    right++;
                }
                else{
                    left = index[left-1];
                }
            }
            int i = 0, j = 0;

            while(i < s1.length()){
                if(s1.charAt(i) == s2.charAt(j)){
                    j++;
                    i++;
                }
                else if(j==0){
                    i++;
                }
                else{
                    j = index[j-1];
                }
                if(j==s2.length()) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}