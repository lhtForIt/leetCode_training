//题号：219
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 392 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class ContainsDuplicateIi{
      public static void main(String[] args) {
           Solution solution = new ContainsDuplicateIi().new Solution();
          solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        /**
         * 一开始我有一种错觉觉得map里面的index被后面的覆盖之后会影响最终结果，
         * 其实完全不会，因为是要<=k,如果前面的能满足条件，后面的肯定能满足条件，
         * 所以完全没有必要用一个list去装value。
         */

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
//                return true;
//            }
//            map.put(nums[i], i);
//        }
//        return false;


        /**
         * 滑动窗口
         * 维护一个大小为k的滑动窗口，依次往右移，当超过k时将前面的数拿出去，
         * 如果在滑动窗口范围内且当前nums[i]不能放进滑动窗口，则代表该元素已经在里面了，
         * 且由于这个数是在大小为k的窗口内，一定满足abs(i-index)<=k.直接返回true即可。
         */
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }