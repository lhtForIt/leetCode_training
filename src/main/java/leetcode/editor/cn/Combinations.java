//题号：77
//https://leetcode-cn.com/problems/combinations/
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 499 👎 0

  
package leetcode.editor.cn;

import org.springframework.cglib.beans.BeanGenerator;

import java.util.*;

public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
          solution.combine(5, 3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /**
           * 递归里面的n-k+1其实是为了剪枝，比如在10位数里找5位，
           * 那你第一层即第一位数就只有到6，第一层如果是7就不需要遍历了，
           * 因为7后面都不够5个数。
           * 所以n-k+1是6，即最多只能到6
           *
           * 对于访问的数据用map或者数组去记录是否访问过，其实就是为了剪枝，降低多余的遍历
           * 但是加它或者不加它其实不会对整个递归的结果造成任何更改，唯一作用就是降低时耗。
           *
           */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        recu(1, n, k, new ArrayList<>(), res);
        return res;










//        List<List<Integer>> res = new ArrayList<>();
//
//        if (k <= 0 || n < k) {
//            return res;
//        }
//        boolean[] visited = new boolean[n + 1];
//        recursion(visited, res, new ArrayList<Integer>(), n, k);
//
//        return res;












        /**
         * 递归法一
         */
//        List<List<Integer>> res = new LinkedList<>();
//        if (k <= 0 || n < k) {
//            return res;
//        }
//
//        Deque<Integer> path = new LinkedList<>();
//
//
//        recur(1,n, k, path,res);
//
//
//        return res;

        /**
         * 递归法二：
         */

//        List<List<Integer>> res = new ArrayList<>();
//        recur2(res, new ArrayList<>(), 1, n, k);
//
//        return res;

        /**
         * 法三
         */

//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (k > n || k < 0) {
//            return result;
//        }
//        if (k == 0) {
//            result.add(new ArrayList<>());
//            return result;
//        }
//        result = combine(n - 1, k - 1);
//        for (List<Integer> list : result) {
//            list.add(n);
//        }
//        result.addAll(combine(n - 1, k));
//        return result;










    }


          private void recu1(int level, boolean[] visited, int n, int k, ArrayList<Integer> subRes, List<List<Integer>> res) {

              if (subRes.size() == k) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = level; i <= n; i++) {
                  if (visited[i]) {
                      continue;
                  }
                  subRes.add(i);
                  visited[i] = true;
                  recu1(i + 1, visited, n, k, subRes, res);
                  visited[i] = false;
                  subRes.remove(subRes.size() - 1);
              }


          }

          private void recu(int level, int n, int k, List<Integer> subRes, List<List<Integer>> res) {


              if (k == 0) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = level; i <= n - k + 1; i++) {
                  subRes.add(i);
                  recu(i + 1, n, k - 1, subRes, res);
                  subRes.remove(subRes.size() - 1);
              }


          }


          private void rec(List<List<Integer>> res, int n, int k, int level, ArrayList<Integer> subRes) {

              if (subRes.size() == k) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = level; i <= n - (k - subRes.size()) + 1; i++) {
                  subRes.add(i);
                  rec(res, n, k, i + 1, subRes);
                  subRes.remove(subRes.size() - 1);
              }
















          }

          private void recurtion(List<List<Integer>> res, ArrayList<Integer> subRes, int n, int k, int level) {

              if (k == 0) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = level; i <= n - k + 1; i++) {

                  subRes.add(i);
                  recurtion(res, subRes, n, k - 1, i + 1);
                  subRes.remove(subRes.size() - 1);

              }


          }

          //dfs解法，会慢很多，不推荐，如果是有序的情况下,直接i==level，会快特别多
          private void recursion(boolean[] visited, List<List<Integer>> res, ArrayList<Integer> subRes, int n, int k) {

              if (subRes.size() == k) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 1; i <= n; i++) {
                  if (visited[i]) continue;
                  if(subRes.isEmpty()||subRes.get(subRes.size() - 1) < i) {
                      visited[i] = true;
                      subRes.add(i);
                      recursion(visited, res, subRes, n, k);
                      subRes.remove(subRes.size() - 1);
                      visited[i] = false;
                  }
              }

          }


          private void recur2(List<List<Integer>> res, ArrayList<Integer> subRes,int deep, int n, int k) {

              //终止条件
              //这里不能用subRes.size() == k的原因是因为K在递归的时候会变，终止条件会出问题
              if (k == 0) {
                  res.add(new ArrayList(subRes));
                  return;
              }


              /**
               * 当前逻辑每次递归我们需要调整开始位置，不然会导致数据重复,而且需要记录还有几个数需要添加，这里用k表示
               * 这儿数字是从1到n的，所以层数是从1开始，和一般从0开始的可能稍微有点不一样，多想下就明白了
               * 因为从1开始，所以有判定条件能取到=，类比i=1;i<=n
               * i<=n-(k-1)
               *
               * 这儿的循环可以这么理解，如果是n=4,k=2的话
               * 当第一层下探，如果没有循环就需要
               * recur2(res, subRes, 2, n, k-1);
               * recur2(res, subRes, 3, n, k-1);
               * recur2(res, subRes, 4, n, k-1);
               * 这样写多行去试，因此直接写一个循环会方便很多
               * 你看这个其实也能想清楚为什么下探是i+1而不是level+1，因此level+1可能会和加入的i重复，
               * 而i+1比i大一定不会重复
               *
               * 这里其实也可以用visited数组保存访问元素，但是没必要，可以直接用i=level巧妙的代替visited数组，
               * 而且这里能用i=level替代visited数组的最主要原因是因为n是有序的，如果是一个数组，也不行，
               * 比如[1,2,3],当第一层取了1，第二层只能是2，第三层只能是3，你想要的1,3,2，对不起不行，因为当你取到3时
               * 这时候i已经是2了，不可能在取小于2的数据了
               *
               * note at 2021-11-24
               * 这里递归传递的k是指还剩多少数可以取，
               * n-k+1其实是判断后续还有多少个数能拿到，比如n=10,k=5，当deep=7时，后续的8,9,10其实已经不够了，这时候就没必要遍历了
               * 用这种写法可以避免遍历。
               *
               * note at 2023-04-24
               * 上面说的有点问题，这个k其实是为了剪枝，用k来表示还可以选几个元素，k-1代表已经选了一个元素，能选的元素-1。然后比如说10里面你要选5个元素，又因为是递增的，那你第一个元素其实最多只能选到6，你选7后面就789104个元素不够5个，就不用选了。
               * 所以每层最大值其实是n-(k-1)=n-k+1,所以这儿其实就是一个剪枝优化。
               *
               */
              for (int i = deep; i <= n - k + 1; i++) {
                  subRes.add(i);
                  //deep代表从几开始，k代表还剩几个数
                  //因为每次添加的数要比以前的大，所以这一层加的i，所以下一层必须是i+1,deep+1会有重复
                  //这个下探的参数代表下一层能添加的数字，不能是deep+1下探，不然可以加到自身，导致重复，需要是i+1下探
                  recur2(res, subRes, i + 1, n, k-1);
                  System.out.println("当前第" + deep + "层，k-1的值：" + (k - 1) + "subRes: " + subRes);
                  /**
                   *
                   *这里remove代表的是将一种可能移除，换另外一种可能
                   * eg. 当n=4,k=2时
                   * subRes里面有1,2这时候已经满足条件放入res里，当该层递归返回时，
                   * 移除刚放进去的元素，这时候subRes就是1，后续递归就能是[1,3],[1,4]
                   * 我理解这个remove是回溯各种条件重试的关键
                   */

                  subRes.remove(subRes.size() - 1);
              }

          }

          private void recur(int deep, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
              if (k == 0) {
                  res.add(new ArrayList<>(path));
                  return;
              }
              if (deep > n - k + 1) {
                  return;
              }

              // 不选当前考虑的数 begin，直接递归到下一层
              recur(deep + 1, n, k, path, res);

              // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
              path.addLast(deep);
              recur(deep + 1, n, k - 1, path, res);

              //清楚状态
              path.removeLast();
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }