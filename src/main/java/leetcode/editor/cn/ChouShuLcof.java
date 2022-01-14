//题号：剑指 Offer 49
//https://leetcode-cn.com/problems/chou-shu-lcof/
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 123 👎 0

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ChouShuLcof{
      public static void main(String[] args) {
           Solution solution = new ChouShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] uglyNumber = {2, 3, 5};

    public int nthUglyNumber(int n) {

        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i]==n2) a++;
            if (dp[i]==n3) b++;
            if (dp[i]==n5) c++;

        }

        return dp[n - 1];




















        /**
         * 利用堆的特性
         *
         * 依次将curr*2,3,5加入堆中，这里需要注意的是会存在不同数相乘的积
         * 相等的情况，因此需要用一个Set去判重，
         * 当出堆的个数等于n时，
         * 返回结果
         *
         */
//        Set<Long> set = new HashSet<>();
//        PriorityQueue<Long> priQueue = new PriorityQueue<>();
//        priQueue.offer(1L);
//        //记录出堆的个数
//        int count = 0;
//        while (!priQueue.isEmpty()) {
//
//            long curr = priQueue.poll();
//            if (++count == n) {
//                return (int)curr;
//            }
//
//            for (int num : uglyNumber) {
//                //非重复数据才放入队列中
//                if (!set.contains(num * curr)) {
//                    priQueue.offer(num * curr);
//                    set.add(num * curr);
//                }
//
//            }
//        }
//
//        return -1;


        /**
         * 动态规划
         */

//        int a = 0, b = 0, c = 0;
//        int[] dp = new int[n];
//        dp[0] = 1;
//
//        for (int i = 1; i < n; i++) {
//            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
//            dp[i] = Math.min(Math.min(n2, n3), n5);
//            if (dp[i]==n2) a++;
//            if (dp[i]==n3) b++;
//            if (dp[i]==n5) c++;
//        }
//
//        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }