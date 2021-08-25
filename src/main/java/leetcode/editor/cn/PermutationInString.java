//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 418 👎 0

package leetcode.editor.cn;
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

//        if(s1.length()==0){return false;}
//        int ref[]=new int[26];
//        for(int i=0;i<s1.length();i++){
//            ref[s1.charAt(i)-'a']++;
//        }
//        int curr[]=new int[26]; int total=0,l=0;
//        for(int i=0;i<s2.length();i++){
//            char c=s2.charAt(i);
//            curr[c-'a']++;total++;
//            while(curr[c-'a']>ref[c-'a']){
//                curr[s2.charAt(l)-'a']--;
//                l++;total--;
//            }
//            if(total==s1.length()){return true;}
//        }
//        return false;

//        int len1 = s1.length(), len2 = s2.length();
//        if (len1 > len2) return false;
//
//        int[] count = new int[26];
//        for (int i = 0; i < len1; i++) {
//            count[s1.charAt(i) - 'a']++;
//            count[s2.charAt(i) - 'a']--;
//        }
//        if (allZero(count)) return true;
//
//        for (int i = len1; i < len2; i++) {
//            count[s2.charAt(i) - 'a']--;
//            count[s2.charAt(i - len1) - 'a']++;
//            if (allZero(count)) return true;
//        }
//
//        return false;

        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;


    }

        private boolean allZero(int[] count) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) return false;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}