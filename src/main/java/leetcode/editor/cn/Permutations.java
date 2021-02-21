//题号：46
//https://leetcode-cn.com/problems/permutations/
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1142 👎 0

  
package leetcode.editor.cn;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.List;

public class Permutations{
      public static void main(String[] args) {
          Solution solution = new Permutations().new Solution();
          solution.permute(new int[]{1, 2, 3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recur(res, new ArrayList<>(), visited, nums);

        return res;

    }

          private void recur(List<List<Integer>> res, List<Integer> subRes, boolean[] visited,int[] nums) {

              if (subRes.size() == nums.length) {
                  //因为这个subRes会随着递归改变，因此需要copy一个当前的，所以用new ArrayList<>()
                  res.add(new ArrayList<>(subRes));
                  return;
              }

              for (int i = 0; i < nums.length; i++) {
                  //list.contains()这个是O(n)的时间复杂度,可以用数组或map优化为O(1)
//                  if (subRes.contains(nums[i])) continue;//存在元素则跳过
                  /**
                   * 这里的visited[]是记录已经使用过哪些元素，因为结果是不重复的，
                   * 因此访问过不需要在访问
                   * eg: 三个位置，第一个位置已经固定为1，那第二三个位置就不会是1，这个访问1的过程就可以省略
                   */
                  if (visited[i]) continue;
                  visited[i] = true;
                  subRes.add(nums[i]);
                  recur(res, subRes,visited,nums);
                  /**
                   * revert status 当递归的时候参数会进入到下层梦境会改变时，
                   * 它回到上层梦境需要删除下层梦境的改变。list的话需要删除最后一个元素
                   */
                  subRes.remove(subRes.size() - 1);
                  visited[i] = false;
              }






          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }