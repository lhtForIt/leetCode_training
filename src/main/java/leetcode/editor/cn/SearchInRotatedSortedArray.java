//题号：33
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1199 👎 0


package leetcode.editor.cn;

import java.awt.event.HierarchyBoundsAdapter;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
//        solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        solution.search1(new int[]{1, 2, 4, 5, 6, 7, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = left + ((right - left) >> 1);
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    if (nums[left] <= nums[mid] && nums[left] > target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid] <= nums[right] && nums[right] < target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return -1;







            /**
             * 正常的二分
             * 有很多解法会先去判断左边还是右边有序，这样其实会比较难理解，因为
             * 和正常的二分模板匹配不上，其实还是可以直接套用二分的模板，然后在里面
             * 进行判断，如下所示
             */

//            int left = 0, right = nums.length - 1;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//                if (nums[mid] == target) {
//                    return mid;
//                } else if (nums[mid] > target) {
//                    //进来判断特殊情况，target比nums[mid]小，但是当发生旋转后，target比nums[left]都小，
//                    //这时target就跑到右边去了，否则直接按正常逻辑走
//                    if (nums[left] <= nums[mid] && nums[left] > target) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                } else {
//                    //进来判断特殊情况，target比nums[mid]大，但是当发生旋转后，target比nums[right]都大，
//                    //这时target就跑到左边去了，否则直接按正常逻辑走
//                    if (nums[right] >= nums[mid] && nums[right] < target) {
//                        right = mid - 1;
//                    } else {
//                        left = mid + 1;
//                    }
//                }
//            }
//            return -1;


            /**
             * 中国站解法
             */
//            int left = 0, right = nums.length - 1;
//            while (left < right) {
//                int mid = left + (right - left) / 2;
//                //0到mid有序,且target大于有序部分最大值或者小于最小值，target在另一半里，left=mid+1
//                if (nums[0] <= nums[mid] && (nums[mid] < target || target < nums[0])) {
//                    left = mid + 1;
//                } else if (target > nums[mid] && target < nums[0]) {//这儿0到mid有旋转，判断升序部分，target > nums[mid] && target < nums[0]满足这个条件target在另一部分
//                    left = mid + 1;
//                } else {
//                    right = mid;//否则在前半部分
//                }
//            }
//            //这儿left==right是一定的吧，有不是的情况么
//            return left == right && nums[left] == target ? left : -1;


            /**
             * 双指针往中间找
             * 时间复杂度O(n)
             */
//            if(nums.length == 0) return -1;
//            for(int i = 0, j = nums.length-1; i < nums.length/2 + 1 || j > nums.length/2; i++, j--){
//
//                if(nums[i] == target) return i;
//                else if (nums[j] == target) return j;
//            }
//            return -1;


            /**
             * 这道题的测试用例规模太小，因此直接遍历都能打败100%
             */
//            if (nums.length == 0) {
//                return -1;
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (target == nums[i]) {
//                    return i;
//                }
//            }
//            return -1;


            /**
             * 常规二分
             */
//            int left = 0;
//            int right = nums.length - 1;
//            while (left <= right){
//                int mid = left + ((right - left) >> 1);
//                if (nums[mid] == target) {
//                    return mid;
//                }else if (nums[left] <= nums[mid]){
//                    if (target < nums[mid] && target >= nums[left])
//                        right = mid - 1;
//                    else
//                        left = mid + 1;
//                } else if (nums[mid] <= nums[right]) {
//                    if (target > nums[mid] && target <= nums[right])
//                        left = mid + 1;
//                    else
//                        right = mid - 1;
//                }
//            }
//            return -1;

            /**
             * 全球站高赞答案
             */
//            int lo=0,hi=nums.length-1;
//            // find the index of the smallest value using binary search.
//            // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
//            // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
//            while(lo<hi){
//                int mid=(lo+hi)/2;
//                if(nums[mid]>nums[hi]) lo=mid+1;
//                else hi=mid;
//            }
//            // lo==hi is the index of the smallest value and also the number of places rotated.
//            int rot=lo;
//            lo=0;hi=nums.length-1;
//            // The usual binary search and accounting for rotation.
//            while(lo<=hi){
//                int mid=(lo+hi)/2;
//                int realmid=(mid+rot)%nums.length;
//                if(nums[realmid]==target)return realmid;
//                if(nums[realmid]<target)lo=mid+1;
//                else hi=mid-1;
//            }
//            return -1;








        }

        public int search1(int[] nums) {

            int left = 0, right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                    return mid + 1;
                } else if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }



            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}