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
         */

//        int sum = 0;
//        Deque<Integer> stack = new LinkedList<>();
//
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
//                int cur = stack.pop();
//                if (stack.isEmpty()) {
//                    break;
//                }
//                sum += (Math.min(height[i], height[stack.peek()]) - height[cur]) * (i - stack.peek() - 1);
//            }
//            stack.push(i);
//        }
//
//        return sum;


        /**
         * 双指针
         * 时间复杂度O(n),空间复杂度O(1)
         */

        int total = 0, lMax = 0, rMax = 0, l = 0, r = height.length - 1;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (height[l] < height[r]) {
                if (height[l] < lMax) total += lMax - height[l];
                l++;
            } else {
                if (height[r]<rMax) total += rMax - height[r];
                r--;
            }
        }

        return total;







    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }