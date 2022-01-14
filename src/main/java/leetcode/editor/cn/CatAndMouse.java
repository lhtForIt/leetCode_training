//题号：913
//两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。 
//
// 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。 
//
// 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。 
//
// 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。 
//
// 此外，猫无法移动到洞中（节点 0）。 
//
// 然后，游戏在出现以下三种情形之一时结束： 
//
// 
// 如果猫和老鼠出现在同一个节点，猫获胜。 
// 如果老鼠到达洞中，老鼠获胜。 
// 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。 
// 
//
// 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏： 
//
// 
// 如果老鼠获胜，则返回 1； 
// 如果猫获胜，则返回 2； 
// 如果平局，则返回 0 。 
// 
// 
//
// 示例 1： 
//
// 
//输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
//输出：0
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,3],[0],[3],[0,2]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= graph.length <= 50 
// 1 <= graph[i].length < graph.length 
// 0 <= graph[i][j] < graph.length 
// graph[i][j] != i 
// graph[i] 互不相同 
// 猫和老鼠在游戏中总是移动 
// 
// Related Topics 广度优先搜索 图 记忆化搜索 数学 动态规划 博弈 
// 👍 150 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CatAndMouse{
      public static void main(String[] args) {
           Solution solution = new CatAndMouse().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        // (cat, mouse, mouseMove = 0)
        int[][][] color = new int[n][n][2];
        int[][][] outdegree = new int[n][n][2];
        for (int i = 0; i < n; i++) { // cat
            for (int j = 0; j < n; j++) { // mouse
                outdegree[i][j][0] = graph[j].length;
                outdegree[i][j][1] = graph[i].length;
                for (int k : graph[i]) {
                    if (k == 0) {
                        outdegree[i][j][1]--;
                        break;
                    }
                }
            }
        }
        Deque<int[]> q = new LinkedList<>();
        for (int k = 1; k < n; k++) {
            for (int m = 0; m < 2; m++) {
                color[k][0][m] = 1;
                q.offer(new int[]{k, 0, m, 1});
                color[k][k][m] = 2;
                q.offer(new int[]{k, k, m, 2});
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cat = cur[0], mouse = cur[1], mouseMove = cur[2], c = cur[3];
            if (cat == 2 && mouse == 1 && mouseMove == 0) {
                return c;
            }
            int prevMouseMove = 1 - mouseMove;
            for (int prev : graph[prevMouseMove == 1 ? cat : mouse]) {
                int prevCat = prevMouseMove == 1 ? prev : cat;
                int prevMouse = prevMouseMove == 1 ? mouse : prev;
                if (prevCat == 0) {
                    continue;
                }
                if (color[prevCat][prevMouse][prevMouseMove] > 0) {
                    continue;
                }
                if (prevMouseMove == 1 && c == 2 || prevMouseMove == 0 && c == 1
                        || --outdegree[prevCat][prevMouse][prevMouseMove] == 0) {
                    color[prevCat][prevMouse][prevMouseMove] = c;
                    q.offer(new int[]{prevCat, prevMouse, prevMouseMove, c});
                }
            }
        }
        return color[2][1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }