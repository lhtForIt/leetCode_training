//题号：373
//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 104 
// -109 <= nums1[i], nums2[i] <= 109 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 
// 👍 281 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums{
      public static void main(String[] args) {
           Solution solution = new FindKPairsWithSmallestSums().new Solution();
          solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        /**
         * 全球站高赞解法
         *
         * 思路是用最小堆，但是不需要遍历所有数据，因为笛卡尔积展开太大，
         * 两个数组已经排序，所以我们只需要判断最前两个数据对是否最小，这样会极大程度降低遍历数量
         * 比如{1,7,11}和{2,4,6},1,2一定是最小的，但是次小的是1,4还是2,7不确定，所以都要放进去。
         * 因此有(a,b)和(a+1,b),(a,b+1)都需要放进去。
         *
         * 这里在初始化的时候把a和a+1都放进去了，所以在取数的时候直接将b+1放进去即可。
         *
         *
         */

        PriorityQueue<int[]> pri = new PriorityQueue<>((o1, o2) -> (o1[0] + o1[1] - o2[0] - o2[1]));

        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pri.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pri.isEmpty()) {
            int[] curr = pri.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            if (curr[2]== nums2.length - 1) continue;
            pri.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return res;















//        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums1.length==0 || nums2.length==0 || k==0) return res;
//        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
//        while(k-- > 0 && !que.isEmpty()){
//            int[] cur = que.poll();
//            res.add(Arrays.asList(cur[0], cur[1]));
//            if(cur[2] == nums2.length-1) continue;
//            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
//        }
//        return res;


        /**
         * 自己解法，超时，需要遍历所有数据对
         */
//        List<List<Integer>> res = new ArrayList<>();
//
//        PriorityQueue<int[]> pri = new PriorityQueue<>((o1, o2) -> ((o2[0] + o2[1]) - (o1[0] + o1[1])));
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j <nums2.length ; j++) {
//                if (pri.size() < k) {
//                    pri.offer(new int[]{nums1[i], nums2[j]});
//                } else if (nums1[i] + nums2[j] < pri.peek()[0] + pri.peek()[1]) {
//                    pri.poll();
//                    pri.offer(new int[]{nums1[i], nums2[j]});
//                }
//            }
//        }
//
//        for (int[] pq : pri) {
//            res.add(Arrays.asList(pq[0], pq[1]));
//        }
//
//        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }