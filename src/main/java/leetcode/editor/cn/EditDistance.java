//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1524 👎 0

package leetcode.editor.cn;
public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {


        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[n1][n2];


        /**
         *
         * 子问题：if charAt(i)==charAt(j) S(i,j)=S(i-1,j-1)
         *         else S(i,j)=min(S(i-1,j-1), S(i-1,j), S(i,j-1)) + 1
         *  状态转移数组：dp[i][j] 代表word1 i位置转为word2 j位置所需的最小步数
         *  状态转移方程：
         *         if charAt(i)==charAt(j) dp[i][j]=dp[i-1][j-1]
         *         else dp[i][j]=min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
         *
         * 时间复杂度 ：O(mn)
         *
         * 空间复杂度 ：O(mn)
         *   ''  r o s
         * '' 0  1 2 3
         * h  1  1      //h转换成r只需要替换一个字符即可
         * o  2
         * r  3
         * s  4
         * e  5
         *
         */

//        int n1 = word1.length();
//        int n2 = word2.length();
//        int[][] dp = new int[n1 + 1][n2 + 1];
//
//        for (int i = 1; i <= n1; i++) {
//            dp[i][0] = i;
//        }
//
//        for (int j = 1; j <= n2; j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i <= n1; i++) {
//            for (int j = 1; j <= n2; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
//                }
//            }
//        }
//
//
//        return dp[n1][n2];

        /**
         *
         * 其实每一层的状态可以由上一层推导出来，因此可以直接用以为数据进行dp，
         * 提高了空间复杂度
         */

//        int m = word1.length(), n = word2.length(), prev;
//        int[] cur = new int[n + 1];
//        for (int j = 1; j <= n; j++) {
//            cur[j] = j;
//        }
//        for (int i = 1; i <= m; i++) {
//            prev = cur[0];
//            cur[0] = i;
//            for (int j = 1; j <= n; j++) {
//                int temp = cur[j];
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    cur[j] = prev;
//                } else {
//                    cur[j] = Math.min(prev, Math.min(cur[j - 1], cur[j])) + 1;
//                }
//                prev = temp;
//            }
//        }
//        return cur[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}