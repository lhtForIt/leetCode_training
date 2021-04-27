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

import java.util.*;

public class TopKFrequentElements{
      public static void main(String[] args) {
           Solution solution = new TopKFrequentElements().new Solution();
          solution.topKFrequent(new int[]{1}, 1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        /**
         * 整个题的思路分两部分：
         * 1、先统计每个数字出现的频率，这个一般用map去实现。
         * 2、对map中统计的元素进行排序，这个实现有很多，各种排序都可以，
         * 但是题目进阶要求是小于nlogn，因此大部分排序都不可行，就只有堆排序O(nlogk)和线性排序O(n)了，
         * 这里可以用桶排序。
         */

        /**
         * 桶排序
         */

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        //不能直接用数组记录，因为会存在多个数字出现次数一样，这种用数组会被覆盖
        //因此直接在每个数组位置放一个list。
        //桶的含义是每个出现次数包含的数字，桶里的元素是多个
        //一个桶里会包含所有出现次数为该桶下标的数字
        List<Integer>[] tong = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> num : countMap.entrySet()) {
            if (tong[num.getValue()]==null) tong[num.getValue()] = new ArrayList<>();
            tong[num.getValue()].add(num.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        //因为数组元素赋值是到了nums.length,因此是从nums.length而不是nums.length-1
        for (int i = nums.length; i >= 0; i--) {
            if (tong[i] == null) continue;
            for (int n : tong[i]) {
                res[index++] = n;
                if (index == k) return res;
            }
        }

        return res;

        /**
         * 对在nlogk的复杂度下实现有两种，找最小k个数，这种就没必要维护一个小根堆,因为小根堆的时间复杂度出来是O(nlogn),
         * 而是维护一个大根堆，堆里只有k个元素，每次超过k个，然后用堆顶元素和入堆元素比较，如果比堆顶小，对顶元素出堆，该元素入堆，
         * 这样时间复杂度是O(nlogk)。
         *
         *
         */

//        if (nums.length == 0 || nums.length < k) {
//            return new int[]{};
//        }
//
//        Map<Integer, Integer> numsMap = new HashMap<>();
//        for (int num : nums) {
//            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Integer, Integer>> pri = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
//        for (Map.Entry<Integer, Integer> num : numsMap.entrySet()) {
//            if (pri.size() < k) {
//                pri.offer(num);
//            } else if (pri.peek().getValue() < num.getValue()) {
//                pri.poll();
//                pri.offer(num);
//            }
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = pri.poll().getKey();
//        }
//
//
//        return res;


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
//        int[] topK = new int[k];
//        Map<Integer, Integer> countMap = new HashMap<>();
//        //第一个为数组值，第二个为出现次数
//        PriorityQueue<int[]> priQueue = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
//
//        for (int num : nums) {
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            int value = entry.getKey(), count = entry.getValue();
//
//            //始终保持堆里只有k个元素，这样logk速度会快点
//            if (priQueue.size() < k) {
//                priQueue.offer(new int[]{value, count});
//            } else {
//                if (priQueue.peek()[1] < count) {
//                    priQueue.poll();
//                    priQueue.offer(new int[]{value, count});
//                }
//            }
//        }
//
//        for (int i = 0; i < k; i++) {
//            topK[i] = priQueue.poll()[0];
//        }
//
//        return topK;

//        Map<Integer, Integer> map = new HashMap();
//        for(int n : nums) {
//            int freq = map.getOrDefault(n, 0) + 1;
//            map.put(n, freq);
//        }
//        //这里是直接将map的entry做比较，这样就能有多个元素了，不用新建数组或者实体类
//        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
//        /**
//         * 这里也是维护一个小根堆，但是这里思路和正常有点区别，正常思路是会在k个元素满之后判断元素是否比堆顶大，然后出堆入堆，
//         * 这里实现有点不一样，是先入堆，然后在出堆堆顶元素，这里时间复杂度是O(nlog(k+1))，理论上说应该比O(nlogk)慢，
//         */
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
//            heap.offer(entry);
//            if(heap.size() > k) {
//                heap.poll();
//            }
//        }
//        int[] res = new int[k];
//        for(int i = 0; i < k; i++) {
//            res[i] = heap.poll().getKey();
//        }
//        return res;


        /**
         * 桶排序
         */

//        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int currNum : nums) freqMap.put(currNum, freqMap.getOrDefault(currNum, 0) + 1);
//
//        List<Integer>[] buckets = new ArrayList[nums.length + 1];   // Number of occurrences of all elements must be in [0, nums.length].
//        for (int key : freqMap.keySet()) {
//            if (buckets[freqMap.get(key)] == null) buckets[freqMap.get(key)] = new ArrayList<>();
//            buckets[freqMap.get(key)].add(key);
//        }
//
//        int[] result = new int[Math.min(freqMap.size(), k)];        // In case we want to return less than k elements, k could be greater than the number of distinct elements in nums.
//        int resIdx = 0;
//        for (int i = buckets.length - 1; i >= 0; --i) {
//            if (buckets[i] == null) continue;                       // Because we only initialized buckets that we inserted elements into, empty buckets are null values.
//            for (int currNum : buckets[i]) {
//                result[resIdx++] = currNum;
//                if (resIdx == result.length) return result;
//            }
//        }
//        return result;

//        // since the range of count is fixed (0, nums), we can use buckt sort
//        // count frequency
//        Map<Integer, Integer> counts = new HashMap<>();
//        for (int n : nums) {
//            counts.put(n, counts.getOrDefault(n, 0) + 1);
//        }
//
//        // create one bucket for each frequency
//        // each bucket is a list of n for that frequency
//        // NOTE: no <> after new List[]
//        List<Integer>[] bucket = new List[nums.length + 1];
//        for (int n : counts.keySet()) {
//            int count = counts.get(n);
//            // default vaule for object is null
//            if (bucket[count] == null) bucket[count] = new ArrayList<>();
//            bucket[count].add(n);
//        }
//
//        // scan each bucket and add to res
//        int[] res = new int[k];
//        int j = 0;
//        for (int i = nums.length; i >= 0; i--) {
//            if (bucket[i] == null) continue;
//            for (int n : bucket[i]) {
//                res[j++] = n;
//                if (j == k) return res;
//            }
//        }
//
//        return res;






    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }