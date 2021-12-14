//题号：630
//这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDay
//i] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。 
//
// 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。 
//
// 返回你最多可以修读的课程数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//输出：3
//解释：
//这里一共有 4 门课程，但是你最多可以修 3 门：
//首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。 
//
// 示例 2： 
//
// 
//输入：courses = [[1,2]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：courses = [[3,2],[4,3]]
//输出：0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= courses.length <= 104 
// 1 <= durationi, lastDayi <= 104 
// 
// Related Topics 贪心 数组 堆（优先队列） 
// 👍 219 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class CourseScheduleIii{
      public static void main(String[] args) {
           Solution solution = new CourseScheduleIii().new Solution();
          solution.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          int max = Integer.MIN_VALUE;
    public int scheduleCourse(int[][] courses) {


        /**
         * 全球站高赞解法
         *
         * 贪心+优先级队列
         * 时间复杂度：0(n^2logN)  空间复杂度：O(n)
         *
          */

        //先处理最早截止日期的事情
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        //堆顶始终存储最大的元素，如果一旦有超的，就将其拿出来换另一个(贪心算法)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));


        int max = 0;
        for (int[] c : courses) {
            max += c[0];
            pq.offer(c[0]);
            if (max > c[1]) max -= pq.poll();//始终减去以前花费时间最大的那个
        }

        return pq.size();




        /**
         * DFS
         * 代码应该没问题，但是用例太大，会超时
         */

//        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
//        recur(0, courses,0,0);
//        return max;


    }


          //回溯会有放和不放两种场景，然后一般都是会先将不放的代码放前面，然后将放的代码放后面
          private void recur(int level, int[][] courses, int count, int days) {

              if (level == courses.length) {
                  max = Math.max(max, count);
                  return;
              }

//              if (days > courses[level][1]) {
//                  max = Math.max(max, count);
//                  return;
//              }


              recur(level + 1, courses, count, days);
              if (days + courses[level][0] <= courses[level][1]) {
                  recur(level + 1, courses, count + 1, days + courses[level][0]);
              }

          }
}


//leetcode submit region end(Prohibit modification and deletion)

  }