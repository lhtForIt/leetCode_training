//题号：189
//https://leetcode-cn.com/problems/rotate-array/
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 912 👎 0

  
package leetcode.editor.cn;

import sun.rmi.transport.tcp.TCPEndpoint;

public class RotateArray{
      public static void main(String[] args) {
           Solution solution = new RotateArray().new Solution();
          solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {


        k = k % nums.length;
        myRotate(0, nums.length - 1, nums);
        myRotate(0, k-1, nums);
        myRotate(k, nums.length - 1, nums);

















        /**
         * 暴力法
         *
         * 时间复杂度O(n)，空间复杂度O(n)
         *
         */

//        int[] newNums = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            newNums[(i + k) % nums.length] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = newNums[i];
//        }


        /**
         * 翻转
         *
         * 如{1,2,3,4,5,6}
         * 翻转指将第一个和最后一个交换，然后双指针依次往中间靠拢，
         * 如果翻转nums.length个元素其实和不翻转是一样的，所以可以取余，避免不必要计算,
         * 注意是用k%nums.length而不是nums.length%k，因为k会比nums.length大，用大的那个当除数
         * {6,5,4,3,2,1}
         *
         *
         */


//        int length = nums.length;
//        k %= length;
//        reverse(nums, 0, length - 1);//先反转全部的元素
//        reverse(nums, 0, k - 1);//在反转前k个元素
//        reverse(nums, k, length - 1);//接着反转剩余的

        /**
         *
         */

//        int len = nums.length;
//        if(k>len)
//            k=k%len;
//        if(k!=0){
//            int arr[] = nums.clone();
//            for(int i=0;i<len;i++){
//                nums[i]=arr[(len+i-k)%len];
//            }
//        }



    }

          private void myRotate(int start, int end, int[] nums) {

              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }
























          }

          private void doRotate(int start, int end, int[] nums) {

              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }























          }

          private void revert(int start, int end, int[] nums) {

              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }





















          }

          private void reversTemp(int start, int end, int[] nums) {

              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }



          }

          private void revers(int[] nums, int start, int end) {
              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }
          }

















          private void reverse1(int[] nums, int start, int end) {
              while (start < end) {
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;
                  start++;
                  end--;
              }
          }












          private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }