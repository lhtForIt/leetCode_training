//题号：剑指 Offer 40
//https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 204 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class ZuiXiaoDeKgeShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
          solution.getLeastNumbers(new int[]{3, 2, 1}, 2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        /**
         * sort 然后直接取前四个数
         * 时间复杂度O(nlogn),空间复杂度O(logn)排序需要额外logn空间
         */

        /**
         * 快排变形
         * 时间复杂度O(n)，空间复杂度O(1)
         */


        /**
         * 运用堆
         * 堆的插入删除操作都是logn的
         *
         * 注意，这里不能直接维护小顶堆，虽然写着简单，但是时间复杂度就是nlogn，而不是nlogk，
         * 当n和k差别很大的时候时间差距会很明显
         * 正确做法是维护一个大顶堆（大根堆），对里只有k个元素，当堆满了且遇到大于顶部元素时，
         * 将堆顶元素拿出并将改元素放入堆中
         *
         * 时间复杂度O(n * logk),空间复杂度O(n)
         */
        if (arr.length == 0 || k == 0 || arr == null) {
            return new int[]{};
        }

        PriorityQueue<Integer> pri = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        int[] res = new int[k];

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pri.offer(arr[i]);
            } else if (arr[i] < pri.peek()) {
                pri.poll();
                pri.offer(arr[i]);
            }
        }


        for (int i = 0; i < k; i++) {
            res[i] = pri.poll();
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }