//题号：322
//https://leetcode-cn.com/problems/coin-change/
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1107 👎 0


package leetcode.editor.cn;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.security.auth.login.Configuration;
import java.util.*;
import java.util.logging.Level;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{2,4,6,8,10,12,14,16,18,20,22,24}, 9999);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int coinChange(int[] coins, int amount) {

            /**
             * BFS
             *
             * 很容易想到这个其实就是一颗递归树，要得到的答案
             * 就是递归树节点为amount对应的层数，因此直接遍历递归树就行，
             * 方法有两种,dfs和bfs，求最小层数首选bfs,对于相同amount的节点，
             * 没必要多次遍历，因此用个Set记录访问的值
             *
             */
//            if (amount == 0) {
//                return 0;
//            }
//            //这个queue里面存的就是钱
//            Deque<Integer> queue = new LinkedList<>();
//            Set<Integer> visitedSet = new HashSet<>();
//            queue.offer(0);
//            visitedSet.add(0);
//            int step = 0;
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    int money = queue.poll();
//                    for (int coin : coins) {
//                        int temp = money + coin;
//                        if (temp == amount) {
//                            return step + 1;
//                        }
//                        if (!visitedSet.contains(temp)&&temp < amount) {
//                            queue.offer(temp);
//                            visitedSet.add(temp);
//                        }
//                    }
//                }
//                step++;
//            }
//
//            return -1;

            /**
             * 双端BFS
             *
             * 纠正个误区，BFS不一定比双端BFS慢，如果不是每层没有比上一层增长的话，
             * 双端BFS的节点交换和其他操作可能比直接BFS还慢点
             *
             * 还有双端BFS的边界要考虑清楚，不然很容易导致死循环
             *
             * 比如这个题的下面这个测试用例，双端BFS会造成在进行交换之后一直使用endSet,
             * 有种还不如不交换的感觉
             * 测试用例:[2,4,6,8,10,12,14,16,18,20,22,24]
             * 9999
             *
             */

//            if (amount == 0) {
//                return 0;
//            }
//            Set<Integer> beginSet = new HashSet<>();
//            Set<Integer> endSet = new HashSet<>();
//            Set<Integer> visited = new HashSet<>();
//            beginSet.add(0);
//            endSet.add(amount);
//            visited.add(0);
//            boolean reverseFlag = false;
//            int count = 0;
//            while (!beginSet.isEmpty()) {
//                if (beginSet.size() > endSet.size()) {
//                    Set<Integer> set = beginSet;
//                    beginSet = endSet;
//                    endSet = set;
//                    reverseFlag = !reverseFlag;
//                }
//                Set<Integer> temp = new HashSet<>();
//                for (int money : beginSet) {
//                    for (int coin : coins) {
//                        int curr = reverseFlag ? money - coin : money + coin;
//                        if (endSet.contains(curr)) {
//                            return count + 1;
//                        }
//                        if (!visited.contains(curr) && curr < amount && curr >= 0) {
//                            temp.add(curr);
//                            visited.add(curr);
//                        }
//                    }
//                }
//                beginSet = temp;
//                count++;
//            }
//            return -1;



            /**
             * 这个很巧妙的一点是dp[n]里面的n代表amount的金额，然后dp[n]的值代表金币数量。
             * 因此状态转移方程就很简单了：
             * dp[n]=Math.min(dp[n-1],dp[n-2],dp[n-5])+1;这里是以coin={1,2,5}为例，
             * 因为要取最小，所以取的dp里面的最小值
             */

            int[] dp = new int[amount + 1];
//            Arrays.fill(dp, amount + 1);
//            dp[0] = 0;
            //因为下标代表金额，0是没有意义的，所以从1开始
            for (int i = 1; i <= amount; i++) {
                int min = amount + 1;
                for (int coin : coins) {
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        min = Math.min(min, dp[i - coin] + 1);
                    }
                }
                dp[i] = min;
            }

            return dp[amount] > amount ? -1 : dp[amount];


            /**
             * DFS
             *
             * 这里dfs可以用dfs+cache的方法，有点类似动态规划推导，自顶向下，然后在自顶向下的时候加上缓存，
             * 后面在查询的时候会查看缓存
             *
             * 需要牢记的一个点，递归是从上而下的，从下往上会有问题，这会我感觉从下往上都是动态规划的推导
             * 且如果有缓存的话，dfs都是会有返回值的，和一般的递归有点区别
             *
             * 动态规划是用的分治+记忆化缓存，这里的分治和递归是有一定区别的，分治一般会整合返回值，而递归不会，
             * 这个用电时间去理解下
             *
             *
             */

//            if (amount < 1) return 0;
//            return dfs(coins, amount, new HashMap<>());

            /**
             * dfs
             *
             * 将map替换成array，可以提升时间
             */

//            if (amount < 1) {
//                return 0;
//            }
//            return dfsArray(coins, amount, new int[amount]);










            /**
             * 动态规划：
             *
             * 最优子结构为f(n)=f(n-c)+1
             * 上面的1我是这么理解的，你从f(n-c)到f(n),会花费一枚硬币，因此要+1
             *
             * 这个很巧妙的一点是f(n)里面的n代表amount的金额，然后f(n)的值代表金币数量
             *
             *
             * 1、找重复性：program(i)=Math.min(subProgram(i-1),subProgram(i-3),subProgram(i-5))+1
             * 2、状态数组定义：dp[],这里dp存的是最少的硬币数,n代表的是金额数
             * 3、状态转移方程：dp[i]=Math.min(dp[i-1],dp[i-3],dp[i-5])+1;
             *
             * 时间复杂度O(m*n),空间复杂度O(n)
             *
             */

//            int[] dp = new int[amount + 1];
//            for (int i = 1; i <= amount; i++) {
//                int min = amount + 1;
//                for (int j = 0; j < coins.length; j++) {
//                    //下面这样写是为了保证dp[i]是dp[i-coin[j]]里最小的，两种写法都行，
//                    //还有种写法是先给数组赋值，然后在比，其实都是为了保证最小
//                    if (i - coins[j] >= 0 && dp[i - coins[j]] + 1 < min) {
//                        min = dp[i - coins[j]] + 1;
////                if (i - coins[j] >= 0) {
////                    min = Math.min(dp[i - coins[j]] + 1, min);
//                    }
//                }
//                dp[i] = min;
//            }
//
//            return dp[amount] > amount ? -1 : dp[amount];


//        int max = amount + 1;
//        int dp[] = new int[amount + 1];
//        Arrays.fill(dp, max);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];


        }

        private int dfsArray(int[] coins, int rem, int[] count) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = dfsArray(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];

        }

        private int dfs(int[] coins, int amount, Map<Integer, Integer> memo) {

            if (amount < 0) return -1;
            if (amount == 0) return 0;
            if (memo.containsKey(amount)) return memo.get(amount);

            int count = -1;
            for (int coin : coins) {
                int remCount = dfs(coins, amount - coin, memo);
                if (remCount == -1) continue;
                count = (count == -1) ? (remCount + 1) : Math.min(count, remCount + 1);
            }
            memo.put(amount, count);
            return count;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}