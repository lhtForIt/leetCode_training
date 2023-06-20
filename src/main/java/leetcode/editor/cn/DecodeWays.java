//题号：91
//https://leetcode-cn.com/problems/decode-ways/
//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。 
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 641 👎 0

  
package leetcode.editor.cn;
public class DecodeWays{
      public static void main(String[] args) {
           Solution solution = new DecodeWays().new Solution();
          solution.numDecodings("226");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
            /**
             * 递归换一种解法+缓存
             */
//            Integer[] mem = new Integer[s.length()];
//            return recur2(0, s, mem);
            /**
             * 缓存+递归 用数组遍历
             */
            Integer[] mem = new Integer[s.length()];
            return recur(0, s.toCharArray(), mem);
            /**
             * 递归+缓存 直接用string
             */
//            Integer[] mem = new Integer[s.length()];
//            return recur1(0, s, mem);
            /**
             * DP 正推 比较符合思维
             *
             * 思路：DP(0)代表空串(但是因为题目已经非空了，这里初始化为1是为了使后面的dp(i-2)有效)，
             * dp(1)代表只有一个字符
             *
             * 然后再遍历的时候我需要按照一个字符和两个字符去判断。
             *
             * 一个字符是只要不为0就行，两个字符需要这两位在1~26范围内，包括两边。
             *
             *
             * 所以状态转移方程为：
             *
             * if（char(i-1)!='0'） dp[i]+=dp[i-1];
             * if(char(i-2)=='1'||char(i-2)=='2'&&char(i-1)<'7') dp[i]+=dp[i-2];
             */
//            if (s == null || s.length() == 0) {
//                return 0;
//            }
//            int n = s.length();
//            int[] dp = new int[n + 1];
//            dp[0] = 1;
//            dp[1] = s.charAt(0) != '0' ? 1 : 0;
//            for (int i = 2; i <= n; i++) {
//                if (s.charAt(i - 1) != '0') {
//                    dp[i] += dp[i - 1];
//                }
//                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') {
//                    dp[i] += dp[i - 2];
//                }
//            }
//            return dp[n];
            /**
             * DP 反推
             *
             * 不太符合我的思维，只看正推即可
             *
             */
//            int n = s.length();
//            int[] dp = new int[n + 1];
//            dp[n] = 1;
//            for (int i = n - 1; i >= 0; i--)
//                if (s.charAt(i) != '0') {
//                    dp[i] = dp[i + 1];
//                    if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
//                        dp[i] += dp[i + 2];
//                }
//            return dp[0];
        }
        private int recur2 ( int index, String s, Integer[]mem){
            if (index == s.length()) return 1;
            if (s.charAt(index) == '0') return 0;
            if (mem[index] != null) return mem[index];
            int res = recur2(index + 1, s, mem);
            if (index < s.length() - 1 && ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') < 27)) {
                res += recur2(index + 2, s, mem);
            }
            return mem[index] = res;
        }

        private int recur1 ( int level, String s, Integer[]mem){
            if (level == s.length()) return 1;
            if (s.charAt(level) == '0') return 0;
            if (mem[level] != null) return mem[level];
            int res = recur1(level + 1, s, mem);
            if (level < s.length() - 1 && (s.charAt(level) == '1' || (s.charAt(level) == '2' && s.charAt(level + 1) < '7'))) {
                res += recur1(level + 2, s, mem);
            }
            return mem[level] = res;
        }
        private int recur ( int level, char[] cs, Integer[] mem){
            if (level == cs.length) return 1;
            if (cs[level] == '0') return 0;
            if (mem[level] != null) return mem[level];
            int res = recur(level + 1, cs, mem);
            if (level < cs.length - 1 && (cs[level] == '1' || cs[level] == '2' && cs[level + 1] < '7')) {
                res += recur(level + 2, cs, mem);
            }
            return mem[level] = res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }