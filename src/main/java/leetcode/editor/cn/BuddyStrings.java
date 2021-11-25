//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 104 
// s 和 goal 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 201 👎 0

package leetcode.editor.cn;

import java.util.List;

public class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        solution.buddyStrings("aa", "aa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *
         * 是亲密字符串会有两种可能：
         * 1、两个字符串相同，只要里面有两个或以上相同的字符即可
         * 2、两个字符串不同，里面只有两个位置有不同的字符串，然后这两个位置的字符串刚好错位相等。
         * eg.i!==j&&s[i]!==g[i]&&s[j]!==g[j]&&s[i]==g[j]&&s[j]==g[i]
         *
         * 自己一开始做的时候少考虑了第一种情况，然后就一直没弄出来，思维还是有局限性。
         *
         */
        public boolean buddyStrings(String s, String goal) {

            if (s.length() != goal.length()) {
                return false;
            }

            //case 1
            if (s.equals(goal)) {
                int[] cs = new int[26];
                for (char c : s.toCharArray()) {
                    if (++cs[c - 'a'] > 1) {
                        return true;
                    }
                }
                return false;
            }

            //case 2
            int[] df = new int[2];
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                    df[count - 1] = i;
                }
            }

            if (s.charAt(df[0]) == goal.charAt(df[1]) && s.charAt(df[1]) == goal.charAt(df[0])) {
                return true;
            }

            return false;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}