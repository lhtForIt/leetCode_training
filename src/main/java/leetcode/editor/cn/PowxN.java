//题号：50
//https://leetcode-cn.com/problems/powx-n/
//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 583 👎 0


package leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {

            /**
             * 递归
             */
            long N = n;
            return N >= 0 ? pow(x, N) : 1 / pow(x, -N);

            /**
             * 迭代
             */
//        long N = n;
//        return N >= 0 ? pow1(x, N) :1/pow1(x,-N);

            /**
             * 非递归,有问题
             */

//        if (n == 0) {
//            return 1;
//        }
//
//        if (n < 0) {
//            n = -n;
//            x = 1 / x;
//        }
//
//        long N = n;
//        double ans = 1;
//
//        while (N > 0) {
//            //n&1==1为奇数，否则为偶数
//            if ((N&1)==1) {
//                ans *= x;
//            }
//            x *= x;
//            N >>= 1;
//        }
//
//
//        return ans;


        }

        private double pow(double x, long N) {
            if (N == 0L) {
                return 1.0;
            }

            double y = pow(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;

        }

        private double pow1(double x, long N) {
            double ans = 1.0;
            double temp = x;
            while (N > 0) {
                if (N % 2 == 1) {
                    ans *= temp;
                }
                temp *= temp;
                N /= 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}