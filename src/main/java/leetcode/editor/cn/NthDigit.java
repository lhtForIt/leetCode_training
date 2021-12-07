//题号：400
//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。 
// 
// Related Topics 数学 二分查找 
// 👍 253 👎 0

  
package leetcode.editor.cn;
public class NthDigit{
      public static void main(String[] args) {
           Solution solution = new NthDigit().new Solution();
           solution.findNthDigit(250);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        long base = 9, digits = 1;
        while (n - base * digits > 0)
        {
            n -= base * digits;
            base *= 10;
            digits ++;
        }

        // step 2. calculate what the number is.
        long index = n % digits;
        if (index == 0)
            index = digits;
        long num = 1;
        for (int i = 1; i < digits; i ++)
            num *= 10;
        num += (index == digits) ? n / digits - 1 : n / digits;

        // step 3. find out which digit in the number is we wanted.
        for (long i = index; i < digits; i ++)
            num /= 10;
        return (int) (num % 10);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }