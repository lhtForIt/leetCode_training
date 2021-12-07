//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -100 <= nums[i] <= 100 
// 1 <= k <= 104 
// 
// Related Topics 贪心 数组 排序 
// 👍 154 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
        solution.largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

//        PriorityQueue<Integer> pri = new PriorityQueue<>();
//        for(int num:nums) pri.offer(num);
//
//        while (k-- > 0) {
//            pri.offer(-pri.poll());
//        }
//
//        int res = 0;
//        for (int num : pri) {
//            res += num;
//        }
//
//        return res;


        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                k--;
                nums[i] = -nums[i];
            }
        }

        //这里可以不同min这个变量，直接再sort一次，但是这样时间复杂度就变成O(nlogn)了
        int res = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            min = Math.min(nums[i], min);
        }

        return res - (k % 2) * min * 2;


















        /**
         * 优先级队列解法
         */
//        PriorityQueue<Integer> pri = new PriorityQueue<>();
//        for(int num:nums) pri.offer(num);
//
//        while (k-- > 0) {
//            pri.offer(-pri.poll());
//        }
//
//        int sum = 0;
//        for (int pq : pri) {
//            sum += pq;
//        }
//
//        return sum;


        /**
         * 数组解法
         */
//        Arrays.sort(nums);
//        int sum = 0;
////        for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; ++i, --k)
////            nums[i] = -nums[i];
//        for (int i = 0; i < nums.length; i++) {
//            if (k > 0) {
//                if (nums[i] < 0) {
//                    k--;
//                    nums[i] = -nums[i];
//                }
//            }
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            min = Math.min(nums[i], min);
//        }
//
//        //这里min减两次是因为min在正数的时候已经加了一次，然后现在变成负数要再减一次，所以就是两次。
//        return sum - (k % 2) * min * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}