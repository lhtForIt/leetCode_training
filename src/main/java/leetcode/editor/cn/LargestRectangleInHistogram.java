//题号：84
//https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1213 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram{
      public static void main(String[] args) {
           Solution solution = new LargestRectangleInHistogram().new Solution();
          solution.largestRectangleArea(new int[]{0});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {

        /**
         * 思路，因为栈压入是递增的，所以我可以从大到小一个一个的去计算每个index的最大值，
         * 如[2,1,5,6,2,3]，当1,5,6压入栈中后，遍历到2的时候，会把6拿出来，然后算出以6为最大高度的面积，然后会把5拿出来，
         * 算出以5为最大高度的面积，这里可能会有疑问，为什么5拿出来能算出来，有两点：
         * 1、栈里前一个元素一定比后一个元素小，所以，前一个元素的最右边值一定是能到当前i-1的位置的，而且只要没有入栈，i值就不会变，可以把栈里每个元素都拿出来计算。
         * 2、高度和右边界知道了，现在只要知道左边界了，左边界其实就是存储的index，这里需要分情况，如果栈里有元素，就是栈顶元素+1,否则就是0，因为没有比当前元素大的元素，就是0.
         *
         * 这个想通之后真的觉得思路太巧妙了
         *
         */

        int maxArea = 0;
        int[] stack = new int[heights.length + 1];
        int top = -1;

        for (int i = 0; i <= heights.length; ) {
            int h = i == heights.length ? 0 : heights[i];
            if (top == -1 || h >= heights[stack[top]]) {
                stack[++top] = i++;
            } else {
                int high = heights[stack[top--]];
                int left = top == -1 ? 0 : stack[top] + 1;
                int right = i - 1;
                int v = (right - left + 1) * high;
                maxArea = Math.max(maxArea, v);
            }
        }

        return maxArea;








        /**
         * 用数组代替栈，下面这种写法比较符合我的思维，会比while这种写法好很多
         */
//        int n = heights.length;
//        int max = 0;
//        int[] stack = new int[n + 1];
//        //记录栈顶元素的下标,因为系统的stack是封装好的，stack.pop()和stack.peek()会自动拿栈顶元素
//        //而我们自己实现的时候需要去用一个变量记录栈顶元素下标，初始值为-1，代表栈为null
//        int top = -1;
//        for (int i = 0; i <= n; ) {
//            int h = i == n ? 0 : heights[i];
//            if (top == -1 || h >= heights[stack[top]]) {
//                stack[++top] = i;
//                i++;
//            } else {
//                int high = heights[stack[top--]];
//                int right = i - 1;
//                int left = top == -1 ? 0 : stack[top] + 1;
//                int v = high * (right - left + 1);
//                max = max < v ? v : max;
//            }
//        }
//
//        return max;



        /**
         * 这个有高度限制，和最大面积那个还不一样
         *
         * 暴力法：超时
         *
         */

//        if (heights == null || heights.length == 0) {
//            return 0;
//        }
//
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            //分别以当前位起始点，找左右高度大于他的柱子
//
//            if (heights[i]==0) continue;
//            int left = i, right = i;
//            while (left > 0 && heights[i] <= heights[left - 1]) {
//                left--;
//            }
//
//            while (right < heights.length - 1 && heights[i] <= heights[right + 1]) {
//                right++;
//            }
//
//            int v = (right - left + 1) * heights[i];
//            max = max < v ? v : max;
//
//        }
//
//        return max;


        /**
         * 借助栈
         */

//        int max = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        int[] new_heigths = new int[heights.length + 2];
//        for (int i = 1; i < heights.length + 1; i++) {
//            new_heigths[i] = heights[i - 1];
//        }
//
//        for (int i = 0; i < new_heigths.length; i++) {
//            while (!stack.isEmpty() && new_heigths[stack.peek()] > new_heigths[i]) {
//                int curr = stack.pop();
//                max = Math.max(max, (i - stack.peek() - 1) * new_heigths[curr]);
//            }
//            stack.push(i);
//        }
//
//        return max;


        /**
         * 数组代替栈
         */
//        int n = heights.length;
//        int max = 0;
//        int[] stack = new int[n + 1];
//        int is = -1;
//        for (int i = 0; i <= n; i++) {
//            int height = (i == n) ? 0 : heights[i];
//            while (is != -1 && height < heights[stack[is]]) {
//                int hh = heights[stack[is--]];
//                int width = (is == -1) ? i : i - 1 - stack[is];
//                max = Math.max(max, hh * width);
//            }
//            stack[++is] = i;
//        }
//        return max;

        /**
         * 思路：
         * 维护一个单调递增栈，
         * 1、当压栈元素>=栈顶元素，那其实就还没有到右边界，因此将其压入栈中，指针右移i++;
         * 2、当压栈元素<栈顶元素，这时候已经到达右边界，右边界下标为i-1,这时候将栈中每个
         * 元素拿出来，计算其最大面积，左边界其实就很清晰了，因为栈递增，所以栈里元素一定比栈顶小，下一个栈顶元素下标的下一个
         * 元素一定是>=栈顶元素的，所以左边界就是下一个栈顶元素下标+1，这里左边界不能直接取栈顶元素下标，会有{0,3,2}这种中
         * 间隔了一个递增的场景，这时候直接拿栈顶元素下标算出来就是2，但是其实应该是3，所以一定要用下一个栈顶元素下标+1，然
         * 后重复上述操作，依次把当前右边界确定的元素的面积计算出来。这个思路可以总结，由于维护单调栈，因此左边界可以直接根
         * 据栈中元素确定，现在主要确定右边界，右边界其实就是第一个小于栈顶元素，这样左右边界确定，就可以直接计算面积了
         */
//        int len = heights.length;
//        int maxArea = 0;
//        Stack<Integer> stack = new Stack<>();
//        //这里能等于n的原因是当i=n-1的时候栈里还会有最后一个元素，因此需要构造一个最小的n把栈里剩余其他元素拿出来
//        for (int i = 0; i <= len;) {
//            //等于n需要特殊处理
//            int h = (i == len ? 0 : heights[i]);
//            //维护一个单调递增栈，如果压栈元素比栈顶元素大，直接压入栈中，否则依次将比它大的元素取出
//            if (stack.isEmpty() || h >= heights[stack.peek()]) {
//                stack.push(i);
//                i++;
//            }else {
//                int curHeight = heights[stack.pop()];
//                int rightBoundary = i - 1;
//                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
//                int width = rightBoundary - leftBoundary + 1;
//                maxArea = Math.max(maxArea, (curHeight * width));
//            }
//        }
//        return maxArea;



    }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }