//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 405 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length - 1, visited, sum / k, k);
    }

        public boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int round) {
            if (round == 0) return true;
            if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
                return true;
            for (int i = st; i >= 0; i--) {
                if (!visited[i] && sum + A[i] <= target) {
                    visited[i] = true;
                    if (dfs(A, sum + A[i], i - 1, visited, target, round))
                        return true;
                    visited[i] = false;
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}