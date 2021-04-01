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
              if (nums == null || nums.length == 0) {
                  return res;
              }

              Arrays.sort(nums);

              boolean[] visited = new boolean[nums.length];

              recursion(visited, res, new ArrayList<>(), nums);


              return res;








//              List<List<Integer>> res = new ArrayList<>();
//              Arrays.sort(nums);
//              boolean[] visited = new boolean[nums.length];
//              recur(res, new ArrayList<>(), visited, nums);
//
//              return res;
          }

          private void recursion(boolean[] visited, List<List<Integer>> res, ArrayList<Integer> subRes, int[] nums) {

              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }


              for (int i = 0; i < nums.length; i++) {

                  if (visited[i]||i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
                  subRes.add(nums[i]);
                  visited[i] = true;
                  recursion(visited, res, subRes, nums);
                  visited[i] = false;
                  subRes.remove(subRes.size() - 1);

              }











          }

          private void recur(List<List<Integer>> res, List<Integer> subRes, boolean[] visited, int[] nums) {
              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  /**
                   * 这里visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i-1]
                   * 和visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i-1]
                   * 都是可以的，只是!visited[i-1]会更高效点
                   * 原因是!visited[i-1]会少走几条分支，相当于进行了剪枝
                   * 而visited[i-1]由于当nums[i-1]=nums[i]且visited[i-1]为true时不会把nums[i]加进去，
                   * 导致本来可以直接添加的[1,2a,2b]这种情况，需要等到[1,2b,2a]才能查出来，所有相同元素
                   * 都只有最后一个为true才能添加，相当于重新遍历了另一条子树路径，这种情况相同数据量越大，时间差异越明显
                   */
                  if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                  visited[i] = true;
                  subRes.add(nums[i]);
                  System.out.println("当前包含元素： "+Arrays.toString(subRes.toArray(new Integer[subRes.size()]))+"，已访问元素："+Arrays.toString(visited));
                  recur(res, subRes, visited, nums);
                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }