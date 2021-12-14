//题号：807
//在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认
//为是建筑物。 
//
// 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的
//外部轮廓。 请看下面的例子。 
//
// 建筑物高度可以增加的最大总和是多少？ 
//
// 
//例子：
//输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
//输出： 35
//解释： 
//The grid is:
//[ [3, 0, 8, 4], 
//  [2, 4, 5, 7],
//  [9, 2, 6, 3],
//  [0, 3, 1, 0] ]
//
//从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
//从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
//
//在不影响天际线的情况下对建筑物进行增高后，新数组如下：
//
//gridNew = [ [8, 4, 8, 7],
//            [7, 4, 7, 7],
//            [9, 4, 8, 7],
//            [3, 3, 3, 3] ]
// 
//
// 说明: 
//
// 
// 1 < grid.length = grid[0].length <= 50。 
// grid[i][j] 的高度范围是： [0, 100]。 
// 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。 
// 
// Related Topics 贪心 数组 矩阵 
// 👍 150 👎 0

  
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxIncreaseToKeepCitySkyline{
      public static void main(String[] args) {
           Solution solution = new MaxIncreaseToKeepCitySkyline().new Solution();
          solution.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 先理解题意，其实就是在一个二维数组里面找最大值，所谓的“天际线”其实就是
           * 在二维数组的行或者列里的最大值
           *
           * 这个题最麻烦的就是读题，我一开始题都没看懂啥意思。读懂之后解就简单了
           *
           * 其实就是求出每组数的行列最大值中小的那个，然后直接将当前值变成行列最小值
           *
           * 可以很明显的看出这道题其实考得就是简单贪心算法的运用
           *
           */
    public int maxIncreaseKeepingSkyline(int[][] grid) {


        /**
         * 其实很简单的，你要知道每行列的最大值，其实只需要先将行的最大值和列的最大值求出来，然后再求交叉点就行
         * 我一开始有个误区，以为要分开求，没法放在一起求，其实不然，直接放在一起一个循环就能搞定，两者其实没有任何
         * 冲突的
         */
        int[] row = new int[grid.length];
        int[] cols = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                cols[j] = Math.max(cols[j], grid[i][j]);
            }
        }


        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += Math.min(row[i], cols[j]) - grid[i][j];
            }
        }

        return res;







        /**
         * 自己解法，可以AC，但是又提升空间，比如两个循环可以放一起
         *
         * 很奇怪的是我自己的解法打败100%，而全球站只有80%+..
         *
         * 看来测试用例其实很小
         *
         */

//        int[] maxArr = new int[grid.length];
//
//        //列最大值
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                maxArr[i] = Math.max(maxArr[i], grid[i][j]);
//            }
//        }
//
//        int[] maxArr1 = new int[grid.length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                maxArr1[i] = Math.max(maxArr1[i], grid[j][i]);
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < maxArr.length; i++) {
//            for (int j = 0; j < maxArr1.length; j++) {
//                res += Math.min(maxArr[i], maxArr1[j]) - grid[i][j];
//            }
//        }
//
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }