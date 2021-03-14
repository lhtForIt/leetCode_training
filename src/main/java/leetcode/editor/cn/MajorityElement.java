//题号：169
//https://leetcode-cn.com/problems/majority-element/description/
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 887 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            /**
             * 法一：Map记录每个数出现次数，遍历map得到count>n/2的即可
             *
             * 时间复杂度O(2n)，空间复杂度O(n)
             *
             */

//            Map<Integer, Integer> numMap = new HashMap<>();
//            for (int num : nums) {
//                numMap.put(num, numMap.getOrDefault(num, 0) + 1);
//            }
//            int count = nums.length / 2;
//            for (Map.Entry<Integer, Integer> map : numMap.entrySet()) {
//                if (map.getValue() > count) {
//                    return map.getKey();
//                }
//            }
//
//            return -1;


            /**
             * 法二：数组排序之后，相同元素相邻，中间的数个数一定大于n/2
             *
             * 时间复杂度O(nlogn)，空间复杂度O(1)
             *
             */

//            Arrays.sort(nums);
//            return nums[nums.length / 2];

            /**
             * 法三：摩尔投票法
             * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
             * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
             * 当票数count为0时，更换候选人，并将票数count重置为1。
             * 遍历完数组后，cand_num即为最终答案。
             *
             * 时间复杂度O(n)，空间复杂度O(1)
             *
             */

            //这个思路其实很简单，拿第一个数，然后初始化为1，每次碰到这个数+1，
            // 其他数就-1，当所有数都走完，最后剩下的那个一定是多数
            int cand_num = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (cand_num == nums[i]) {
                    ++count;
                } else if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }

            }

            return cand_num;




        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}