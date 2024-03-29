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
          solution.permuteUnique(new int[]{1, 1, 2});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

          /**
           * 避免重复（如果是数字）的一个常用方法是对数据进行排序，然后在进行操作。
           * 在递归的时候难点就是避免结果重复，如何避免重复呢？在没有重复元素的时候避免重复可以
           * 很简单的用一个缓存数组记录已经访问的节点，但是如果是有重复数据就需要避免如：
           * (1a,1b,2)和(1b,1a,2)这种情况，虽然是重复的，但是只算一种结果。
           * 这时候需要加上1a必须在1b之前访问的限制。
           */
          public List<List<Integer>> permuteUnique(int[] nums) {

              List<List<Integer>> res = new ArrayList<>();
              if (nums == null || nums.length == 0) {
                  return res;
              }

              Arrays.sort(nums);
              boolean[] visited = new boolean[nums.length];
              recu(res, new ArrayList<>(), visited, nums);
              return res;











//              List<List<Integer>> res = new ArrayList<>();
//              if (nums == null || nums.length == 0) {
//                  return res;
//              }
//
//              Arrays.sort(nums);
//
//              boolean[] visited = new boolean[nums.length];
//
//              recursion(visited, res, new ArrayList<>(), nums);
//
//
//              return res;








//              List<List<Integer>> res = new ArrayList<>();
//              //这里排序的唯一目的是为了让相同的元素相邻，便于后面i>0&&nums[i]==nums[i-1]&&!visited[i-1]这个判断生效
//              Arrays.sort(nums);
//              boolean[] visited = new boolean[nums.length];
//              recur(res, new ArrayList<>(), visited, nums);
//
//              return res;
          }

          private void recu(List<List<Integer>> res, ArrayList<Integer> subRes, boolean[] visited, int[] nums) {

              if (subRes.size() == nums.length) {
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  if (visited[i]||i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
                  subRes.add(nums[i]);
                  visited[i] = true;
                  recu(res, subRes, visited, nums);
                  visited[i] = false;
                  subRes.remove(subRes.size() - 1);
              }




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