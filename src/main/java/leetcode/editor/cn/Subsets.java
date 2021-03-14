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

import java.util.ArrayList;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        /** 递归
         * 回溯法：
         * 特征：会有加入和不加入两种递归
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
         * 迭代
         */

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }

        return res;

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