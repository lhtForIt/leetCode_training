//题号：剑指 Offer 59 - I
//https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 178 👎 0

  
  package leetcode.editor.cn;

import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof{
      public static void main(String[] args) {
           Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
          solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        /**
         * 暴力法
         */
//        if (nums == null || nums.length == 0) {
//            return nums;
//        }
//
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < k + i; j++) {
//                max = Math.max(nums[j], max);
//            }
//            result[i] = max;
//        }
//
//        return result;

        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.addLast(i);

            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }