//题号：88
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 797 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
          solution.merge(new int[]{0}, 0, new int[]{1}, 1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int p = m - 1, q = n - 1, c = m + n - 1;
        while (p >=0 && q >=0) {
            if (nums1[p] < nums2[q]) {
                nums1[c--] = nums2[q--];
            } else {
                nums1[c--] = nums1[p--];
            }
        }

        while (q >= 0) {
            nums1[c--] = nums2[q--];
        }





















        /**
         * 正着赋值会覆盖nums1的值，所以我们反着赋值
         * 一个思路，我们遍历的思路有两种，从前到后和从后到前，如果新开数组的话其实都可以，
         * 但是如果是原地操作(在原数组上进行交换，就不能从前到后，这样可能会涉及到数据丢失)，因此要从后往前遍历，
         * 因为后面一开始是没数据的。
         */
//        int p = m - 1, q = n - 1, curr = m + n - 1;
//
//        while (p >= 0 && q >= 0) {
//            if (nums1[p] <= nums2[q]) {
//                nums1[curr--] = nums2[q--];
//            } else {
//                nums1[curr--] = nums1[p--];
//            }
//        }
//
//        //如果nums2有元素未挪过去，直接依次加到nums1前面,这里只需要考虑nums2不为null的情况，因为nums1是不需要动的，
//        //但是后面遇到的快排是两个数组都需要考虑的
//        while (q >= 0) {
//            nums1[curr--] = nums2[q--];
//        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }