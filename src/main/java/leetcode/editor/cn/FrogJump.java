//题号：403
//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。 
//
// 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。 
//
// 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。 
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [0,1,3,5,6,8,12,17]
//输出：true
//解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然
//后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。 
//
// 示例 2： 
//
// 
//输入：stones = [0,1,2,3,4,8,9,11]
//输出：false
//解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。 
//
// 
//
// 提示： 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 231 - 1 
// stones[0] == 0 
// 
// Related Topics 动态规划 
// 👍 340 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump{
      public static void main(String[] args) {
           Solution solution = new FrogJump().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
           int[] increment = {1, 0, -1};
    public boolean canCross(int[] stones) {

//        if(stones == null || stones.length == 0 || stones[1] != 1 ||
//                stones[stones.length - 1] > (stones.length * (stones.length - 1)) / 2) return false;
//
//        if (stones.length == 0) {
//            return true;
//        }
//
//        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
//        map.put(0, new HashSet<Integer>());
//        map.get(0).add(1);
//        for (int i = 1; i < stones.length; i++) {
//            map.put(stones[i], new HashSet<Integer>() );
//        }
//
//        for (int i = 0; i < stones.length - 1; i++) {
//            int stone = stones[i];
//            for (int step : map.get(stone)) {
//                int reach = step + stone;
//                if (reach == stones[stones.length - 1]) {
//                    return true;
//                }
//                HashSet<Integer> set = map.get(reach);
//                if (set != null) {
//                    set.add(step);
//                    if (step - 1 > 0) set.add(step - 1);
//                    set.add(step + 1);
//                }
//            }
//        }
//
//        return false;


        /**
         * 动态规划
         */
//        int N = stones.length;
//        boolean[][] dp = new boolean[N][N + 1];
//        dp[0][1] = true;
//
//        for(int i = 1; i < N; ++i){
//            for(int j = 0; j < i; ++j){
//                int diff = stones[i] - stones[j];
//                if(diff < 0 || diff > N || !dp[j][diff]) continue;
//                dp[i][diff] = true;
//                if(diff - 1 >= 0) dp[i][diff - 1] = true;
//                if(diff + 1 <= N) dp[i][diff + 1] = true;
//                if(i == N - 1) return true;
//            }
//        }
//
//        return false;

        /**
         * dfs
         */

        if (stones.length == 1) return true;
        if (stones[1] != stones[0] + 1) return false;

        Set<Integer> set = new HashSet<>();
        int n = stones.length;

        for (int i = 0; i < n; i++) {
            set.add(stones[i]);
        }

        return dfs(stones[0], stones[n - 1], set, 1, new HashSet<String>());

    }

          private boolean dfs(int pos, int dest, Set<Integer> set, int dist, HashSet<String> checked) {
              String posDist = pos + "," + dist;
              if (checked.contains(posDist)) return false;
              checked.add(posDist);
              if (pos + dist == dest) return true;
              if (set.contains(pos + dist)) {
                  for (int inc : increment) {
                      if (dist + inc > 0) {
                          boolean canReach = dfs(pos + dist, dest, set, dist + inc, checked);
                          if (canReach) return true;
                      }
                  }
              }
              return false;
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }