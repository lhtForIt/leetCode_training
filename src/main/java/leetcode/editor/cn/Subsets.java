//题号：78
//https://leetcode-cn.com/problems/subsets/
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1037 👎 0

  
package leetcode.editor.cn;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
          solution.subsets(new int[]{1, 2, 3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        recv(res, new ArrayList<Integer>(), nums, 0);

        return res;









        /** 递归
         * 回溯法：
         * 特征：会有加入和不加入两种递归
         * 这种回溯实现你可以理解成两种递归，放进去和不放进去
         *
         */
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        List<Integer> subRes = new ArrayList<>();
//        recur(res, 0, subRes, nums);
//
//        return res;

        /**
         * 递归 法二
         * 实质是根据状态树进行dfs
         *
         * 里面用循环代替递归出口判定用的特别妙
         *
         */

//        List<List<Integer>> list = new ArrayList<>();
////        排序主要看是否有重复元素
////        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;



        /**
         * 迭代
         */

//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        for (int n : nums) {
//            int size = res.size();
//            for (int i = 0; i < size; i++) {
//                List<Integer> newSub = new ArrayList<>(res.get(i));
//                newSub.add(n);
//                res.add(newSub);
//            }
//        }
//
//        return res;

    }

          private void recv(List<List<Integer>> res, ArrayList<Integer> subRes, int[] nums, int level) {

              res.add(new ArrayList<>(subRes));

              for (int i = level; i < nums.length; i++) {
                  subRes.add(nums[i]);
                  recv(res, subRes, nums, i + 1);
                  subRes.remove(subRes.size() - 1);
              }

          }

          private void rec(int level, List<List<Integer>> res, List<Integer> subRes, int[] nums) {

              if (level == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }


              rec(level + 1, res, subRes, nums);

              subRes.add(nums[level]);

              rec(level + 1, res, subRes, nums);

              subRes.remove(subRes.size() - 1);













          }


          private void dfs(int level, List<List<Integer>> res, ArrayList<Integer> subRes, int[] nums) {

              res.add(new ArrayList<>(subRes));

              for (int i = level; i < nums.length; i++) {
                  subRes.add(nums[i]);
                  dfs(i + 1, res, subRes, nums);
                  subRes.remove(subRes.size() - 1);
              }
















          }


          private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
              System.out.println("当前第" + start + "层梦境，加入List为：" + Arrays.toString(tempList.toArray()));
              list.add(new ArrayList<>(tempList));
              //这个循环真的用的妙，他能很好的避免重复遍历，这儿的递归出口在for循环里，其实就是start>=nums.length
              for(int i = start; i < nums.length; i++){
                  tempList.add(nums[i]);
                  backtrack(list, tempList, nums, i + 1);
                  tempList.remove(tempList.size() - 1);
              }
          }

          private void recur(List<List<Integer>> res, int level, List<Integer> subRes, int[] nums) {

              if (level == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              //不加入这个元素
              recur(res, level + 1, subRes, nums);

              //加入这个元素
              subRes.add(nums[level]);
              recur(res, level + 1, subRes, nums);

              subRes.remove(subRes.size() - 1);



          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }