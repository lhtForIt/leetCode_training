//题号：239
//https://leetcode-cn.com/problems/sliding-window-maximum/
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 869 👎 0

  
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
          solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        if (nums.length < k) {
            return new int[1];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }

        }


        return res;






        /**
         * 暴力
         * 时间复杂度O(n*k),空间复杂度O(1)
         * 超时
         */


//        int[] res = new int[nums.length - k + 1];
//        int index = 0;
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            res[index++] = max;
//        }
//
//        return res;


        /**
         * 双端队列
         * 时间复杂度O(n+k)，空间复杂度O(n)
         * 始终保持双端队列头一个元素为最大值
         */
//        if (nums == null || nums.length == 0) {
//            return nums;
//        }
//        int[] res = new int[nums.length - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            //窗口已经占满了
//            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
////            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
//                deque.pollFirst();
//            }
//            //始终保持队列按从大到小排列,且会一直移除新加元素小的元素，如果
//            //nums[i]大于队列所有值，会移除队列所有值
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//            //当窗口满了k个元素，将其一个个放入res[]数组中
//            if (i >= k - 1) {
//                //第一个元素始终是最大的元素
//                res[i + 1 - k] = nums[deque.peekFirst()];
//            }
//        }
//        return res;

        /**
         * 堆
         * 时间复杂度O(nlogn),空间复杂度O(n)
         *
         *
         * 这个堆和topk的思路还不太一样，那个是n个数里面求最小k个，
         * 所以用大顶堆将时间复杂度弄成O(nlogk),
         * 这儿是k里面最大的数，所以直接就是logk，直接用大顶堆即可
         *
         *
         *
         */

//        int n = nums.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            public int compare(int[] pair1, int[] pair2) {
//                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
//            }
//        });
//        for (int i = 0; i < k; ++i) {
//            pq.offer(new int[]{nums[i], i});
//        }
//        int[] ans = new int[n - k + 1];
//        ans[0] = pq.peek()[0];
//        for (int i = k; i < n; ++i) {
//            pq.offer(new int[]{nums[i], i});
//            while (pq.peek()[1] <= i - k) {
//                pq.poll();
//            }
//            ans[i - k + 1] = pq.peek()[0];
//        }
//        return ans;




    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }