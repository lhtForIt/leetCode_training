//题号：26
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1805 👎 0

  
package leetcode.editor.cn;
public class RemoveDuplicatesFromSortedArray{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
          solution.removeDuplicates(new int[]{1,1,2});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {

        /**
         * 默认第一位不管，比较后面
         * 时间复杂度O(n)，空间复杂度O(1)
         */
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[j-1]) nums[j++] = nums[i];
        }
        return j;
        /**
         * 从第零位开始比较，注意这里j是从第一位到最后一位，所以需要加上第零位的数，需要+1
         * 时间复杂度O(n),空间复杂度O(1)
         */
//        int j = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i]!=nums[j]) nums[++j] = nums[i];
//        }
//        return j + 1;
        /**
         * 这里用的nums[i]和nums[i-1]去对比
         * 时间复杂度O(n),空间复杂度O(1)
         */
//        int j = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i]!=nums[i-1]) nums[j++] = nums[i];
//        }
//        return j;






        /**
         * 这是个排好序的数组，因此当下一次nums[i]!=nums[j]时，
         * 第一组相等的所有元素都已经走完，所以直接将nums[i]换到nums[j+1]处即
         * nums[j+1]=nums[i]，简便点可以写成nums[++j]=nums[i]
         * 这里必须是++j,因为后面会返回j的值，所以j需要自加1，而不能直接j+1
         */
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int j = 0;
//        //这里0一定是相等的，优化一下从1开始
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[j] != nums[i]) {
//                nums[++j] = nums[i];
//            }
//        }
//        //j=0时也算一个，因此要+1
//        return j + 1;


        /**
         * 这种解法会比上面的好
         */
//        int j = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i]!=nums[i-1]) nums[j++] = nums[i];
//        }
//
//        return j;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }