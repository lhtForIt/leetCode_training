//题号：11
//https://leetcode-cn.com/problems/container-with-most-water/
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2157 👎 0

  
package leetcode.editor.cn;
public class ContainerWithMostWater{
      public static void main(String[] args) {
           Solution solution = new ContainerWithMostWater().new Solution();
          solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] a) {


        int max = 0;
        for (int left = 0, right = a.length - 1; left < right; ) {
            int v = (right - left) * (a[left] < a[right] ? a[left++] : a[right--]);
            max = Math.max(max, v);
        }

        return max;






















        /**
         * 暴力法
         * 时间复杂度O(n^2)，空间复杂度O(1)
         *
         * 超时
         *
         */

//        int max = 0;
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                max = Math.max(max, (j - i) * Math.min(a[i], a[j]));
//            }
//        }
//
//        return max;


        /**
         * 双指针，数组链表都貌似有双指针的解法，
         * 没思路的时候可以往这边想
         */

//        /**
//         * 边界条件，i==j时宽度为0，因此边界是i<j
//         *
//         * Math.max(a,b)速度慢于三目运算
//         */
//        for (int left = 0, right = a.length - 1; left < right; ) {
//            int v = (right - left) * (a[left] < a[right] ? a[left++] : a[right--]);
//            max = max > v ? max : v;
//        }
//
//        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }