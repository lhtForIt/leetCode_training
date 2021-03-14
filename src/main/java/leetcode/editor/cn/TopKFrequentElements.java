//题号：347
//https://leetcode-cn.com/problems/top-k-frequent-elements/
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 655 👎 0

  
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements{
      public static void main(String[] args) {
           Solution solution = new TopKFrequentElements().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        /**
         * 最大堆，时间复杂度O(nlogn)，空间复杂度O(n)
         */
//        int[] topK = new int[k];
//        Map<Integer, Integer> countMap = new HashMap<>();
//        //第一个为数组值，第二个为出现次数
//        PriorityQueue<int[]> priQueue = new PriorityQueue<>((o1,o2)->(o2[1]-o1[1]));
//
//        for (int num : nums) {
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            int value = entry.getKey(), count = entry.getValue();
//
//            priQueue.offer(new int[]{value, count});
//        }
//
//        for (int i = 0; i < k; i++) {
//            topK[i] = priQueue.poll()[0];
//        }
//
//        return topK;

        /**
         * 最小堆 时间复杂度O(nlogk),空间复杂度O(n)
         */
        int[] topK = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        //第一个为数组值，第二个为出现次数
        PriorityQueue<int[]> priQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int value = entry.getKey(), count = entry.getValue();

            //始终保持堆里只有k个元素，这样logk速度会快点
            if (priQueue.size() < k) {
                priQueue.offer(new int[]{value, count});
            } else {
                if (priQueue.peek()[1] < count) {
                    priQueue.poll();
                    priQueue.offer(new int[]{value, count});
                }
            }
        }

        for (int i = 0; i < k; i++) {
            topK[i] = priQueue.poll()[0];
        }

        return topK;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }