//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 104 
// 1 <= houses[i], heaters[i] <= 109 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 286 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class Heaters {
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        /**
         * 全球站高赞解法
         * 二分
         */
//        Arrays.sort(heaters);
//        int result = Integer.MIN_VALUE;
//
//        for (int house : houses) {
//            int index = Arrays.binarySearch(heaters, house);
//            if (index < 0) {
//                index = -(index + 1);
//            }
//            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
//            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
//
//            result = Math.max(result, Math.min(dist1, dist2));
//        }
//
//        return result;

        /**
         * 全球站高赞解法
         * 排序+双指针
         */

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}