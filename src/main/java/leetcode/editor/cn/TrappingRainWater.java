//题号：42
//https://leetcode-cn.com/problems/trapping-rain-water/
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2148 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        /**
         * 栈
         * 时间复杂度O(n),空间复杂度O(n)
         *
         *
         * 这里和柱状图最大面积有点区别，首先这里维护的单调递减栈而不是单调递增栈，
         * 再来就是计算的高度不是Math(height[left],height[right])，而是
         * Math(height[i],height[left])-height[top],i指的当前大于栈顶元素的右边位置，
         * left指的是栈顶元素下一个元素,top指的是栈顶元素。
         *
         * 然后宽度是i-1-left.和柱状图不一样的是不需要+1了。
         *
         * 由于递增，因此也不需要用一个元素去把最后的元素拿出来，所以也就没有i==height.length的情况
         *
         *
         */

        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < height.length;) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int cur = stack.pop();
                int water = stack.isEmpty() ? 0 : (Math.min(height[i], height[stack.peek()]) - height[cur]) * (i - stack.peek() - 1);
                sum += water;
            }
        }

        return sum;


        /**
         * 双指针
         * 时间复杂度O(n),空间复杂度O(1)
         */

//        int total = 0, lMax = 0, rMax = 0, l = 0, r = height.length - 1;
//        while (l < r) {
//            lMax = Math.max(lMax, height[l]);
//            rMax = Math.max(rMax, height[r]);
//            if (height[l] < height[r]) {
//                if (height[l] < lMax) total += lMax - height[l];
//                l++;
//            } else {
//                if (height[r]<rMax) total += rMax - height[r];
//                r--;
//            }
//        }
//
//        return total;







    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }