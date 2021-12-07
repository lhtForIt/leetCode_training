//题号：506
//给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。 
//
// 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况： 
//
// 
// 名次第 1 的运动员获金牌 "Gold Medal" 。 
// 名次第 2 的运动员获银牌 "Silver Medal" 。 
// 名次第 3 的运动员获铜牌 "Bronze Medal" 。 
// 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。 
// 
//
// 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：score = [5,4,3,2,1]
//输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。 
//
// 示例 2： 
//
// 
//输入：score = [10,3,8,9,4]
//输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
// 
//
// 
//
// 提示： 
//
// 
// n == score.length 
// 1 <= n <= 104 
// 0 <= score[i] <= 106 
// score 中的所有值 互不相同 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 121 👎 0

  
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.*;

public class RelativeRanks{
      public static void main(String[] args) {
           Solution solution = new RelativeRanks().new Solution();
          solution.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 这个题要解决的问题就是需要将sort之后的新数组和以前的数组之间建立起一个mapping关系，然后直接赋值就行，
           * 而且想到mapping关系我们很容易想到哈希表，但是其实我们可以自己底层建立一个二维数组来模仿哈希表，在进一步
           * 我们也可以用一个以为数组去实现。
           */
          public String[] findRelativeRanks(int[] score) {

              Integer[] index = new Integer[score.length];
              for (int i = 0; i < score.length; i++) index[i] = i;

              Arrays.sort(index, (a, b) -> (score[b] - score[a]));
              String[] res = new String[score.length];
              for (int i = 0; i < score.length; i++) {
                  if (i == 0) {
                      res[index[i]] = "Gold Medal";
                  } else if (i == 1) {
                      res[index[i]] = "Silver Medal";
                  } else if (i == 2) {
                      res[index[i]] = "Bronze Medal";
                  } else {
                      res[index[i]] = i + 1 + "";
                  }
              }

              return res;















              /**
               * 法一
               */
//              Integer[] index = new Integer[score.length];
//              for (int i = 0; i < score.length; i++) {
//                  index[i] = i;
//              }
//              Arrays.sort(index, (a, b) -> (score[b] - score[a]));
//
//              String[] res = new String[score.length];
//              for (int i = 0; i < score.length; i++) {
//                  if (i == 0) {
//                      res[index[i]] = "Gold Medal";
//                  } else if (i == 1) {
//                      res[index[i]] = "Silver Medal";
//                  } else if (i == 2) {
//                      res[index[i]] = "Bronze Medal";
//                  } else {
//                      res[index[i]] = i + 1 + "";
//                  }
//              }
//
//              return res;


              /**
               * 法二
               */
//              int[] ranks = score.clone();
//              Arrays.sort(ranks);
//              Map<Integer, Integer> map = new HashMap<>();
//              for(int i = 0; i<ranks.length; i++){
//                  map.put(ranks[i], score.length-i);
//              }
//              String[] res = new String[score.length];
//              for(int i = 0; i<score.length; i++){
//                  int rank = map.get(score[i]);
//                  String rankStr = rank+"";
//                  if(rank==1) rankStr = "Gold Medal";
//                  else if(rank==2) rankStr = "Silver Medal";
//                  else if(rank==3) rankStr = "Bronze Medal";
//                  res[i] = rankStr;
//              }
//              return res;


              /**
               * 法三：自己用优先级队列实现的
               */
//              Map<Integer, Integer> indexMap = new HashMap<>();
//              for (int i = 0; i < score.length; i++) indexMap.put(score[i], i);
//              PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
//              for (int i = 0; i < score.length; i++) {
//                  pq.offer(score[i]);
//              }
//              String[] res = new String[score.length];
//              int i = 0;
//              while (!pq.isEmpty()) {
//                  int index = pq.poll();
//                  int order = indexMap.get(index);
//                  switch (i) {
//                      case 0:
//                          res[order] = "Gold Medal";
//                          break;
//                      case 1:
//                          res[order] = "Silver Medal";
//                          break;
//                      case 2:
//                          res[order] = "Bronze Medal";
//                          break;
//                      default:
//                          res[order] = i + 1 + "";
//                          break;
//                  }
//                  i++;
//              }
//              return res;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }