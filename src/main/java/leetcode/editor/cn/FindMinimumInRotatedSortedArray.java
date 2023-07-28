//题号：153
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 357 👎 0

  
package leetcode.editor.cn;
public class FindMinimumInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
          solution.findMin(new int[]{11,13,15,17});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {


        /**
         * 这里其实找最大或者最小的数思路都是一样的，就是找到旋转的位置，如果数组升序,
         * 旋转位置本身就是最大的数，右边就是最小的数
         * left<=right这个条件会将所有可能全部列举玩，但是会忽略一种情况，就是在while里面分支的mid+1<nums.length
         * 这个限制，导致进不去，因此单个元素的情况需要特殊考虑
         */
//        if (nums[nums.length - 1] > nums[0] || nums.length == 1) {
//            return nums[0];
//        }
//
//        int left = 0, right = nums.length - 1, mid;
//        while (left <= right) {
//            mid = left + ((right - left) >> 1);
//            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
//                return nums[mid + 1];
//            } else if (nums[mid] >= nums[left]) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;

        /**
         * 全球站最高赞解法
         *
         * 如果当前元素比右边大就往右走，否则保持原位。
         */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];





        /**
         * 这个方法写的不好，不推荐
         */
//        if (nums[nums.length - 1] > nums[0]) {
//            return nums[0];
//        }
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int mid = left + ((right - left) >> 1);
//            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
//                return nums[mid + 1];
//            } else if (nums[mid] >= nums[left]) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }