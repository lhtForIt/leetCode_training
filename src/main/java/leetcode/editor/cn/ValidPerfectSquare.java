//题号：367
//https://leetcode-cn.com/problems/valid-perfect-square/solution/
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 194 👎 0

  
package leetcode.editor.cn;
public class ValidPerfectSquare{
      public static void main(String[] args) {
           Solution solution = new ValidPerfectSquare().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {

        /**
         * 二分：时间复杂度O(logN),空间复杂度O(1)
         */

//        long left = 0, right = num, mid;
//
//        while (left <= right) {
//            mid = left + ((right - left) >> 1);
//            if (mid * mid == num) {
//                return true;
//            } else if (mid * mid < num) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return false;



        /**
         * 牛顿迭代法
         * 时间复杂度O(logN)，空间复杂度O(1)
         */

        //这个if判断可有可无，基本没啥必要
//        if (num < 2) {
//            return true;
//        }

        long t = num;
        while (t * t > num) {
              t = ((t + num / t) >> 1);
          }

        return t * t == num;

    }
      }

//leetcode submit region end(Prohibit modification and deletion)

}