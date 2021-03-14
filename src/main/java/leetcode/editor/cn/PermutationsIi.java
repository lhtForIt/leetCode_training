//题号：47
//https://leetcode-cn.com/problems/permutations-ii/
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 593 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
      public static void main(String[] args) {
          Solution solution = new PermutationsIi().new Solution();
          solution.permuteUnique(new int[]{1, 1, 1});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          public List<List<Integer>> permuteUnique(int[] nums) {

              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(nums);
              boolean[] visited = new boolean[nums.length];
              recur(res, new ArrayList<>(), visited, nums);

              return res;
          }

          private void recur(List<List<Integer>> res, List<Integer> subRes, boolean[] visited, int[] nums) {
              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  /**
                   * !visited[i-1]有点没搞懂，先默写吧，后面看看
                   * 猜想，不知道对不对：{1,1,2} {false,false,true}
                   * 这时候是访问不了的，只有访问了第一个才行，但是访问第一个之后也会continue
                   * 试了下visited[i]也可以通过，但是好像执行时间会慢点，是因为递归是反着的原因，符合程序调用？
                   *
                   * note at 2021-12-26 比如{3,,2,1,1}这种
                   *
                   * 因为递归是下从往上的，因此当前一个没有被选上时，直接筛掉，默认去访问第一个
                   */
                  if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                  visited[i] = true;
                  subRes.add(nums[i]);
                  recur(res, subRes, visited, nums);
                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }