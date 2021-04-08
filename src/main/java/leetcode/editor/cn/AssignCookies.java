//题号：455
//https://leetcode-cn.com/problems/assign-cookies/description/
//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i
//]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
// 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 104 
// 0 <= s.length <= 3 * 104 
// 1 <= g[i], s[j] <= 231 - 1 
// 
// Related Topics 贪心算法 
// 👍 306 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {


            /**
             * 贪心思路：既然要让尽可能多的孩子满足，那我就优先满足胃口小的孩子，因为大小胃口在这里含义一样，
             * 然后在满足胃口大的，这里贪的就是胃口
             * 因为两个数组都拍过序减少了很多额外判断，就只需要根据步骤判断，一次遍历s,g里面数值，当g[i]<=s[j]时，
             * i++,j++,否则j++,最后返回i的值即可
             */

            Arrays.sort(g);
            Arrays.sort(s);

            int p = 0, q = 0;
            while (p < g.length && q < s.length) {
                if (g[p] <= s[q]) {
                    p++;
                }
                q++;
            }

            return p;











            //g是孩子胃口，s是饼干,排序时间复杂度是nlogn
//            Arrays.sort(g);
//            Arrays.sort(s);
//
//            //正常想到的是count,p,q三个参数，但是count和p的值一直是一样的，因此直接用p代表count就行
//            int child = 0, cookie = 0;
//
//            while (child < g.length && cookie < s.length) {
//                //一次遍历饼干值，如果大于孩子胃口则满足孩子+1
//                if (s[cookie] >= g[child]) {
//                    child++;
//                }
//                cookie++;
//            }
//
//            return child;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}