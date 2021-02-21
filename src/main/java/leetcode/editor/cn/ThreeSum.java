//题号：15
//https://leetcode-cn.com/problems/3sum/
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2973 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});



      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 排序+双指针 数组双指针很多时候会和排序放一起
         */
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        /**
         * 这儿需要一层循环去遍历target的值
         */
        for (int target = 0; target < nums.length - 2; target++) {

            if (nums[target] > 0) break;
            if (target>0 && nums[target]==nums[target-1]) continue;

            int left = target + 1;
            int right = nums.length - 1;

            while (left < right) {

                if (nums[left] + nums[right] + nums[target] == 0) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[target]));
                    //判断该哪个指针移动
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[target] < 0) {
                    //比0小说明数不够大，需将排序后的左指针右移
                    left++;
                } else {
                    //比0大说明数小，需将排序后的右指针左移
                    right--;
                }



            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }