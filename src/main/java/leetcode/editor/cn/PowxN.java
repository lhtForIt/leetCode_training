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
        solution.myPow(2, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {

            long N = n;
            return n > 0 ? pow3(x, N) : 1 / pow3(x, -N);









            /**
             * 递归
             * 这里只是借用二分的思维，每次将n变为n/2而已，但是和二分查找其实没多大关系，因为
             * 整个过程中没有查找的情况
             */
//            long N = n;
//            return N >= 0 ? pow(x, N) : 1 / pow(x, -N);

            /**
             * 迭代
             */
//        long N = n;
//        return N >= 0 ? pow1(x, N) :1/pow1(x,-N);

            /**
             * 在原函数上递归,并且不需要将n改为Long型
             */

//        if (n == 0) {
//            return 1;
//        }
//
//        //当为负数时，其实求得1/x的n次
//        if (n < 0) {
//            //这里要考虑溢出的问题
//            if(n == Integer.MIN_VALUE) {
//                n += 2;
//            }
//            n = -n;
//            x = 1 / x;
//        }
//
//        //这里思路是每次将pow的x扩大为原来的平方，且n/2，当n不为奇数时，结果为x*x，当n为奇数时，需要在乘以个x
//        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
//
//
        }

        private double pow3(double x, long n) {

            if (n == 0) {
                return 1;
            }

            double y = pow3(x, n / 2);

            return n % 2 == 0 ? y * y : y * y * x;



















        }

        private double pow2(double x, long n) {

            if (n == 0) {
                return 1d;
            }

            double y = pow2(x, n / 2);

            return n % 2 == 0 ? y * y : y * y * x;

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