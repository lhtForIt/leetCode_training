//题号：350
//https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/submissions/
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 442 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysIi{
      public static void main(String[] args) {
          Solution solution = new IntersectionOfTwoArraysIi().new Solution();
          solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int f1 = 0;
        int f2 = 0;
        int f = 0;
        while (f1 < nums1.length && f2 < nums2.length) {
            if (nums1[f1] < nums2[f2]) {
                f1++;
            } else if (nums1[f1] > nums2[f2]) {
                f2++;
            } else {
                intersection[f] = nums1[f1];
                f1++;
                f2++;
                f++;
            }
        }


        return Arrays.copyOfRange(intersection, 0, f);
    }




}
//leetcode submit region end(Prohibit modification and deletion)

  }