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

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.lang.reflect.Array;
import java.util.*;


public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
          solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});



      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            //只能和过去的比，和没比过的比会出问题
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[left] + nums[right] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }


        return res;












         /**
         * 暴力
         * 时间复杂度O(n^4logn)=循环O(n^3)*ArrayList.contain() O(n)时间复杂度
         * 超时
         */

//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
//                        if (!res.contains(tempList)) {
//                            res.add(tempList);
//                        }
//                    }
//                }
//            }
//        }
//
//        return res;


        /**
         * 两层循环+Map
         */

//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] > 0) break;
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            Set<Integer> set = new HashSet<>();
//            for (int j = i + 1; j < nums.length; ++j) {
//                Integer value = -nums[i] - nums[j];
//                if (set.contains(value)) {
//                    ans.add(Arrays.asList(nums[i], value, nums[j]));
//                    while ((j + 1) < nums.length && nums[j] == nums[j + 1]) ++j;
//                }
//                else set.add(nums[j]);
//            }
//        }
//        return ans;



        /**
         * 排序+双指针 数组双指针很多时候会和排序放一起
         *
         * 时间复杂度O(n^2*nlogn),空间复杂度O(n)
         *
         *
         */

//        List<List<Integer>> res = new ArrayList<>();
//
//        if (nums == null || nums.length < 3) {
//            return res;
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//
//            if (nums[i] > 0) break;
//
//            //避免重复，将重复元素跳过
//            //因为有i-1，所以要加上i>0的限制，防止下标越界
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//
//            int left = i + 1, right = nums.length - 1;
//
//            while (left < right) {
//                if (nums[left] + nums[right] == -nums[i]) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    //避免重复，将重复元素跳过
//                    //这里要范围要是left->right之间,不然会下标越界
//                    while (left < right && nums[left] == nums[left + 1]) left++;
//                    while (left < right && nums[right] == nums[right - 1]) right--;
//                    left++;
//                    right--;
//                } else if (nums[left] + nums[right] < -nums[i]) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//
//        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }