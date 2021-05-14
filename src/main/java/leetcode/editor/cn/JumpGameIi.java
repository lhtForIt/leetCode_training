//题号：45
//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 839 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class JumpGameIi{
      public static void main(String[] args) {
           Solution solution = new JumpGameIi().new Solution();
          solution.jump(new int[]{2, 3, 1, 1, 4});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {


        /**
         * 动态规划
         */
        int n = nums.length;
        int[] f = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j + nums[j] < i) j++;
            f[i] = f[j] + 1;
        }
        return f[n - 1];




        /**
         * 贪心算法
         *
         * curFarthest代表范围在[currBegin(i),currEnd]之间所有点能达到的最远距离，
         * 然后我们当前只要跳跃这个最远距离，就一定是当前最小步骤
         * i是不会到达nums.length-1的，因为最后一个位置，我只需要跳到最后一个位置即可。
         * 这里的贪心体现在我们每步都跳的最远距离
         *
         */
//        int step = 0;
//        int curEnd = 0;
//        int curFarthest = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            curFarthest = Math.max(nums[i] + i, curFarthest);
//            if (i == curEnd) {
//                step++;
//                curEnd = curFarthest;
//            }
//        }
//
//        return step;


        /**
         * BFS，
         * 有的也说这是个BFS方案：i==curEnd代表访问完当前层所有节点，
         * step++代表进入下一级，curEnd = curFarthest代表获得下一级你访问的queue的大小
         */
//        if(nums.length<2)return 0;
//        int level=0,currentMax=0,i=0,nextMax=0;
//
//        while(currentMax-i+1>0){		//nodes count of current level>0
//            level++;
//            for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
//                nextMax=Math.max(nextMax,nums[i]+i);
//                if(nextMax>=nums.length-1)return level;   // if last element is in level+1,  then the min jump=level
//            }
//            currentMax=nextMax;
//        }
//        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }