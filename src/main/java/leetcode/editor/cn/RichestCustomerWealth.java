//1672
//https://leetcode-cn.com/problems/richest-customer-wealth/
//给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥
//有的 资产总量 。 
//
// 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。 
//
// 
//
// 示例 1： 
//
// 输入：accounts = [[1,2,3],[3,2,1]]
//输出：6
//解释：
//第 1 位客户的资产总量 = 1 + 2 + 3 = 6
//第 2 位客户的资产总量 = 3 + 2 + 1 = 6
//两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
// 
//
// 示例 2： 
//
// 输入：accounts = [[1,5],[7,3],[3,5]]
//输出：10
//解释：
//第 1 位客户的资产总量 = 6
//第 2 位客户的资产总量 = 10 
//第 3 位客户的资产总量 = 8
//第 2 位客户是最富有的，资产总量是 10 
//
// 示例 3： 
//
// 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// m == accounts.length 
// n == accounts[i].length 
// 1 <= m, n <= 50 
// 1 <= accounts[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 18 👎 0

package leetcode.editor.cn;
public class RichestCustomerWealth {
    public static void main(String[] args) {
        Solution solution = new RichestCustomerWealth().new Solution();
        solution.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWealth(int[][] accounts) {

        /**
         * 法一：暴力法，时间复杂度为O(n2),空间复杂度为O(1)
         */
//        int max = 0;
//        for (int i = 0; i < accounts.length; i++) {
//            int sum = 0;
//            for (int j = 0; j < accounts[i].length; j++) {
//                sum += accounts[i][j];
//            }
//            max = max < sum ? sum : max;
//        }
//        return max;

        /**
         * 法二：直接用第一位记录最大值,
         * 但是这样会改变原始数据，只能用于一些特殊场景，如这些数据只会使用一次的情况
         */
        for (int i = 0; i < accounts.length; i++) {
            //因为第一位不能重复加，因此下标要从1开始
            for (int j = 1; j < accounts[i].length; j++) {
                accounts[i][0] += accounts[i][j];
            }
            accounts[0][0] = accounts[0][0] < accounts[i][0] ? accounts[i][0] : accounts[0][0];
        }

        return accounts[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}