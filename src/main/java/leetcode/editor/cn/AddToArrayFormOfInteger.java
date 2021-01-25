//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
//
//
// 示例 2：
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
//
//
// 示例 3：
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
//
//
// 示例 4：
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// 0 <= A[i] <= 9
// 0 <= K <= 10000
// 如果 A.length > 1，那么 A[0] != 0
//
// Related Topics 数组
// 👍 136 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        LinkedList result = new LinkedList();
        int i = A.length - 1, sum = 0, carry = 0;
        while (i >= 0 || K > 0) {
            int a = i >= 0 ? A[i] : 0;
            int b = (K > 0 ? K : 0) % 10;
            sum = a + b + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
            i--;
            K /= 10;
        }

        if (carry != 0) {
            result.addFirst(carry % 10);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}