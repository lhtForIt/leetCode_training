//题号：874
//https://leetcode-cn.com/problems/walking-robot-simulation/description/
//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ： 
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
//
// 
// 北表示 +Y 方向。 
// 东表示 +X 方向。 
// 南表示 -Y 方向。 
// 西表示 -X 方向。 
// 
// 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65 
//
// 
//
// 提示： 
//
// 
// 1 <= commands.length <= 104 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 104 
// -3 * 104 <= xi, yi <= 3 * 104 
// 答案保证小于 231 
// 
// Related Topics 贪心算法 
// 👍 123 👎 0


package leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
        solution.robotSim(new int[]{-2, -1, 8, 9, 6}, new int[][]{{-1, 3}, {0, 1}, {-1, 5}, {-2, -4}, {5, 4}, {-2, -3}, {5, -1}, {1, -1}, {5, 5}, {5, 2}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {


            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = 0, y = 0, di = 0, max = 0;

            Set<Long> obstacleSet = new HashSet<>();

            for (int[] obstacle:obstacles) obstacleSet.add((long) (((obstacle[0]+30000) << 16) + (obstacle[1]+30000)));

            for (int c : commands) {
                if (c == -1) {
                    di = (di + 1) % 4;
                } else if (c == -2) {
                    di = (di + 3) % 4;
                } else {
                    for (int i = 0; i < c; i++) {
                        int tempX = x + dx[di];
                        int tempY = y + dy[di];
                        if (obstacleSet.contains((((long)tempX+30000)<<16)+((long) tempY+30000))) break;

                        x = tempX;
                        y = tempY;
                        max = max < (x * x + y * y) ? (x * x + y * y) : max;
                    }
                }
            }

            return max;
































            /**
             *  这个问题主要是需要知道向量的概念。
             *  当在一个坐标系中，我们怎么根据一个命令让机器人转弯，这个就需要一个协议(约定俗称的条例)，
             *  这里面就是用的-2左转90度，-1右转90度，那怎么让指令和这个关联上呢？
             *  用两个一维数组就可以，dx,dy的一维数组，(dx,dy)分别代表坐标里的一个点，
             *  int[] dx = {0, 1, 0, -1};
             *  int[] dy = {1, 0, -1, 0};
             *  不难看出这两个一维数组同一下标下代表的是不同方向，下标0是北，1是东，2是南，3是西。
             *  所以我们需要将下标和-1,-2指令关联，于是就自己制定一个算法，di一开始是0，然后顺时针转动，
             *  -2左转的话就是顺时针转3个，由于可能转多圈，变为4的倍数，下标越界，所以需要%4.
             *  -1右转的话就是顺时针转1个，同上需要%4.
             *
             *  如果没有旋转就直接一步一步走即可，因为如果没旋转就是在原方向上走，直接每次走一步，走够指令大小的次数即可。
             *  碰到障碍点就跳过就好。
             *
             *
             */

//            int[] dx = {0, 1, 0, -1};
//            int[] dy = {1, 0, -1, 0};
//
//            int x = 0, y = 0, di = 0, max = 0;
//
//            Set<String> obstaclesSet = new HashSet<>();
//            for (int[] obstacle : obstacles) obstaclesSet.add(obstacle[0] + ":" + obstacle[1]);
//
//            for (int c : commands) {
//                if (c == -2) {
//                    di = (di + 3) % 4;
//                } else if (c == -1) {
//                    di = (di + 1) % 4;
//                } else {
//                    for (int i = 0; i < c; i++) {
//                        int tempX = x + dx[di];
//                        int tempY = y + dy[di];
//                        if (obstaclesSet.contains(tempX+":"+tempY)) break;
//
//                        x = tempX;
//                        y = tempY;
//
//                        max = max < (x * x + y * y) ? (x * x + y * y) : max;
//
//                    }
//                }
//            }
//
//            return max;


            /**
             * 为什么long?
             * 因为-30000 <= obstacle[i][0] <= 30000 -30000 <= obstacle[i][1] <= 30000，
             * 而2^16=65536,所以obstacle[0] + 30000用16位存储足矣，
             * 高16位存储obstacle[0] + 30000，低16位存储obstacle[1] + 30000
             * Java int是32位，最高位是符号位，显然存不下两个16位，所以用long
             */
//            int[] dx = new int[]{0, 1, 0, -1};
//            int[] dy = new int[]{1, 0, -1, 0};
//            int x = 0, y = 0, di = 0;
//
//            // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
//            Set<Long> obstacleSet = new HashSet();
//            for (int[] obstacle: obstacles) {
//                long ox = (long) obstacle[0] + 30000;
//                long oy = (long) obstacle[1] + 30000;
                  //这里是将ox向前移动了16位，即用低16位装oy
//                obstacleSet.add((ox << 16) + oy);
//            }
//
//            int ans = 0;
//            for (int cmd: commands) {
//                if (cmd == -2)  //left
//                    di = (di + 3) % 4;
//                else if (cmd == -1)  //right
//                    di = (di + 1) % 4;
//                else {
//                    for (int k = 0; k < cmd; ++k) {
//                        int nx = x + dx[di];
//                        int ny = y + dy[di];
//                        long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
//                        if (!obstacleSet.contains(code)) {
//                            x = nx;
//                            y = ny;
//                            ans = Math.max(ans, x*x + y*y);
//                        }
//                    }
//                }
//            }
//
//            return ans;


            //这里的dx,dy代表的方向, 0123 表 北东南西
            //dx[i],dy[i]分别代表北东南西方向走
//            int[] dx = new int[]{0, 1, 0, -1};
//            int[] dy = new int[]{1, 0, -1, 0};
//            int x = 0, y = 0, di = 0;
//
//            Set<String> obstacleSet = new HashSet<>();
//            for (int i=0;i<obstacles.length;i++) {
//                obstacleSet.add(obstacles[i][0] + "," + obstacles[i][1]);
//            }
//            //这里ans不能初始位Integer.MIN_VALUE,因为如果一步都不能走，比如向北障碍为为(0,1),那返回就是Integer.MIN_VALUE，但实际应该是0，所以初始值应该为0
//            int ans = 0;
//            for (int cmd : commands) {
//                if (cmd == -2) {//左转
//                    //4代表四个方向
//                    //di=(di-1+4)%4由这个转过来的
//                    di = (di + 3) % 4;
//                } else if (cmd == -1) {//右转
//                    di = (di + 1) % 4;
//                } else {
//                    //这里的dx[i],dy[j]分别能表示在坐标轴y,x,-y,-x方向移动一步，这个就代表的方向，然后指令能让其移动n步，怎么实现这个移动n步呢
//                    //在我不知道方向的前提下？就是用dx[di],dy[di]这两个变量表示某个方向偏移量1的变量，如向东，di=1,dx[di]=1,dy[di]=0,然后向东移动一步就是
//                    //x+dx[di],y+dy[di]，那多步怎么弄呢，重复上述步骤n次即可,所以机器人移动顺序是每次走一步重复n次
//                    for (int k = 0; k < cmd; k++) {
//                        int nx = x + dx[di];
//                        int ny = y + dy[di];
//                        if (obstacleSet.contains(nx + "," + ny)) {
//                            break;
//                        }
//
//                        x = nx;
//                        y = ny;
//                        ans = Math.max(ans, x * x + y * y);
//                    }
//                }
//            }
//
//            return ans;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}