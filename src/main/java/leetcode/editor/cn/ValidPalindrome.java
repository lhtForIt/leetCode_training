//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 364 👎 0

package leetcode.editor.cn;
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {

        /**
         * 时间复杂度O(n)，空间复杂度O(n)多了一个char数组
         */
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left<right&&!Character.isLetterOrDigit(chars[left])) left++;
            while (left<right&&!Character.isLetterOrDigit(chars[right])) right--;
            if (chars[left] <= 90 && chars[left] >= 65) {
                chars[left] |= 32;
            }
            if (chars[right] <= 90 && chars[right] >= 65) {
                chars[right] |= 32;
            }
            if (chars[left++]!=chars[right--]) return false;
        }
        return true;

        /**
         * 双指针
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         */
//        if (s.isEmpty()) {
//            return true;
//        }
//
//        int left = 0, right = s.length() - 1;
//
//        while (left <= right) {
//
//            if (!Character.isLetterOrDigit(s.charAt(left))) {
//                left++;
//            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
//                right--;
//            } else {
//                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
//                    return false;
//                }
//                left++;
//                right--;
//            }
//        }
//
//        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}