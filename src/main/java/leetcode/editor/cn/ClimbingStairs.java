//70
//https://leetcode-cn.com/problems/climbing-stairs/
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

        Map<Integer, Integer> dpMap = new HashMap<>();
        public int climbStairs(int n) {

            /**
             * 法一：动态规划
             */
            if (n <= 2) {
                return n;
            }

            //这里用数组缓存了算出来的数据，不用每次零时计算
            int[] f = new int[n + 1];
            f[1] = 1;
            f[2] = 2;

            for (int i = 3; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }

            return f[n];

            /**
             * 法二：公式求解，不推荐
             */

//            double sqrt5 = Math.sqrt(5);
//            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
//
//            return (int) (fibn/sqrt5);
            /**
             * 法三：动态规划优化
             * 实际上我们不需要缓存所有情况，只需要缓存三个结果即可
             * f(3)=f(2)+f(1)
             * f(4)=f(3)+f(2)
             *
             * f(4)我们只需要知道前两个状态即可，前两个状态可以根据
             * 上一次计算得到
             * int one_step=1;
             * int two_step=2;
             * int all_way=one_step+two_step;
             *
             * 存储倒退两步的结果
             * one_step=two_step;
             * 存储倒退一步的结果
             * two_step=all_way;
             * 进而用这两个变量得到下一步的结果
             *
             * 可以理解有f(1),f(2),f(3)结果，然后要得到f(4)，
             * 将f(1)=f(2),f(2)=f(3),f(4)=f(1)+f(2),这样循环，所有都能由f(1)+f(2)得到
             * 然后将这里的f(1)，f(2)换成one_step,two_step
             *
             */

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


            /**
             * 法四：递归加hashMap缓存
             */

//            if (n <= 2) {
//                return n;
//            }
//
//            if (dpMap.containsKey(n)) {
//                return dpMap.get(n);
//            }
//
//            int temp = climbStairs(n - 1) + climbStairs(n - 2);
//            dpMap.put(n, temp);
//
//            return temp;

        }


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
//        Map<Integer, Integer> dpMap = new HashMap<>();
//        public int climbStairs(int n) {
//            if (n <= 2) {
//                return n;
//            }
//
//            if (dpMap.containsKey(n)) {
//                return dpMap.get(n);
//            }
//            int temp = climbStairs(n - 1) + climbStairs(n - 2);
//            dpMap.put(n, temp);
//            return temp;
//
//        }


}
//leetcode submit region end(Prohibit modification and deletion)

}