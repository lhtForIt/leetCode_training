//给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。 
//
// 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,1,0]
//输出：1
//解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：-1
//解释：4 没有超过 3 的两倍大，所以返回 -1 。 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
//解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 0 <= nums[i] <= 100 
// nums 中的最大元素是唯一的 
// 
// Related Topics 数组 排序 
// 👍 118 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {

        /**
         * 全球站高赞解法
         *
         * 在遍历中找到最大和次大的数，然后比较最大的数是否是第二大的数的两倍，如果是那一定
         * 是其他数的两倍，否则返回-1
         *
         */

        int max = -1, second = -1, index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                second = max;
                max = nums[i];
                index = i;
            } else if (second < nums[i]) {
                second = nums[i];
            }
        }

        return max >= 2 * second ? index : -1;


        /**
         * 一开始的想法就是Arrays.sort,但是时间复杂度太高
         */
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i <nums.length ; i++) {
//            indexMap.put(nums[i], i);
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[nums.length - 1] < 2 * nums[i]) {
//                return -1;
//            }
//        }
//
//        return indexMap.get(nums[nums.length - 1]);

        /**
         * 然后两次遍历
         * 如果想写的常规点，直接将index赋值为-1会更好点
         */
//        int index=0;
//        for (int i = 1; i <nums.length ; i++) {
//            if (nums[index] < nums[i]) {
//                index = i;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (index != i && nums[index] < 2 * nums[i]) {
//                return -1;
//            }
//        }
//
//        return index;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}