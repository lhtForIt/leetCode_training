//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1431 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //动态规划
        //        public int climbStairs(int n) {
//
//            if (n <= 2) {
//                return n;
//            }
//
//            //+1是因为有f[0]
//            int[] f = new int[n + 1];
//
//            f[1] = 1;
//            f[2] = 2;
//
//            for (int i = 3; i <= n; i++) {
//                f[i] = f[i - 1] + f[i - 2];
//            }
//
//
//            return f[n];
//
//        }


        //公式求解
//        public int climbStairs(int n) {
//
//            double sqrt5 = Math.sqrt(5);
//            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
//
//            return (int) (fibn/sqrt5);
//        }

        /**
         * 动态规划优化
         */
//        public int climbStairs(int n) {
//
//            if (n <= 2) {
//                return n;
//            }
//
//            int one_step = 2;
//            int two_step = 1;
//            int all_way = 0;
//
//            for (int i = 3; i <= n; i++) {
//                all_way = one_step + two_step;
//                two_step = one_step;
//                one_step = all_way;
//            }
//
//            return all_way;
//        }

        /**
         * 递归加缓存优化
         */
        Map<Integer, Integer> dpMap = new HashMap<>();
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            if (dpMap.containsKey(n)) {
                return dpMap.get(n);
            }
            int temp = climbStairs(n - 1) + climbStairs(n - 2);
            dpMap.put(n, temp);
            return temp;

        }


}
//leetcode submit region end(Prohibit modification and deletion)

}