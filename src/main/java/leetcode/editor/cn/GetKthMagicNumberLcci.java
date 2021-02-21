//题号：面试题 17.09
//https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 43 👎 0

  
  package leetcode.editor.cn;
  public class GetKthMagicNumberLcci{
      public static void main(String[] args) {
           Solution solution = new GetKthMagicNumberLcci().new Solution();
          System.out.println(solution.getKthMagicNumber(9));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 这个题的意思其实是需要我们构造一个丑数，然后找到丑数序列的第K个数
     */

    public int getKthMagicNumber(int k) {

        int p3 = 0, p5 = 0, p7 = 0;
        int[] dp = new int[k];
        dp[0] = 1;

        //0已经赋值，从1开始，初始化丑数，
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
            if (dp[i]==dp[p3]*3) p3++;
            if (dp[i]==dp[p5]*5) p5++;
            if (dp[i]==dp[p7]*7) p7++;
        }

        return dp[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }