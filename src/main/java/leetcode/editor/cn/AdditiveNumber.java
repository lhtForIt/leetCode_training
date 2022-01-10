//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
// Related Topics 字符串 回溯 
// 👍 242 👎 0

package leetcode.editor.cn;


import java.math.BigInteger;

public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        solution.isAdditiveNumber("112358");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            /**
             * 递归
             */
            int n = num.length();
            for (int i = 1; i <= n / 2; ++i) {
                if (num.charAt(0) == '0' && i > 1) return false;
                Long x1 = new Long(num.substring(0, i));
                for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                    if (num.charAt(i) == '0' && j > 1) break;
                    Long x2 = new Long(num.substring(i, i + j));
                    if (isValid(x1, x2, j + i, num)) return true;
                }
            }
            return false;

            /**
             * 迭代
             */

//            int n = num.length();
//            for (int i = 1; i <= n / 2; ++i)
//                for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
//                    if (isValid1(i, j, num)) return true;
//            return false;



        }

        private boolean isValid(Long x1, Long x2, int start, String num) {
            if (start == num.length()) return true;
            x2 = x2 + x1;
            x1 = x2 - x1;
            String sum = x2.toString();
            return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
        }

        private boolean isValid1(int i, int j, String num) {
            if (num.charAt(0) == '0' && i > 1) return false;
            if (num.charAt(i) == '0' && j > 1) return false;
            String sum;
            Long x1 = Long.parseLong(num.substring(0, i));
            Long x2 = Long.parseLong(num.substring(i, i + j));
            for (int start = i + j; start != num.length(); start += sum.length()) {
                x2 = x2 + x1;
                x1 = x2 - x1;
                sum = x2.toString();
                if (!num.startsWith(sum, start)) return false;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}