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

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combinations{
      public static void main(String[] args) {
           Solution solution = new Combinations().new Solution();
          solution.combine(4, 2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {


        List<List<Integer>> res = new ArrayList<>();

        if (k <= 0 || n < k) {
            return res;
        }

        recursion(1, res, new ArrayList<Integer>(), n, k);

        return res;












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

          private void recursion(int level, List<List<Integer>> res, ArrayList<Integer> subRes, int n, int k) {

              if (k == 0) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = level; i <= n - k + 1; i++) {
                  subRes.add(i);
                  recursion(i + 1, res, subRes, n, k - 1);
                  subRes.remove(subRes.size() - 1);
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
               */
              for (int i = deep; i <= n - k + 1; i++) {
                  subRes.add(i);
                  //deep代表从几开始，k代表还剩几个数
                  //这里参数i+1代表是否放入第i个数
                  //这个下探的参数代表下一层能添加的数字，不能是deep+1下探，不然可以加到自身，导致重复，需要是i+1下探
                  recur2(res, subRes, i + 1, n, k-1);
                  System.out.println("当前第" + deep + "层，k的值：" + k + "subRes: " + subRes);
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