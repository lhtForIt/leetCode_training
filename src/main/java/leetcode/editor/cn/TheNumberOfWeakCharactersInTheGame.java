//题号：1996
//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [
//attacki, defensei] 表示游戏中第 i 个角色的属性。 
//
// 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j
// ，那么 attackj > attacki 且 defensej > defensei 。 
//
// 返回 弱角色 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：properties = [[5,5],[6,3],[3,6]]
//输出：0
//解释：不存在攻击和防御都严格高于其他角色的角色。
// 
//
// 示例 2： 
//
// 
//输入：properties = [[2,2],[3,3]]
//输出：1
//解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 示例 3： 
//
// 
//输入：properties = [[1,5],[10,4],[4,3]]
//输出：1
//解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= properties.length <= 105 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 105 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 
// 👍 73 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame{
      public static void main(String[] args) {
           Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // sorting
//        int n = properties.length;
//        int count = 0;
//
//        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
//
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            if (properties[i][1] < max) {
//                count++;
//            }
//            max = Math.max(max, properties[i][1]);
//        }
//        return count;


        int[] maxH = new int[100002];
        int count = 0;
        for(int[] point:properties){
            maxH[point[0]] = Math.max(point[1],maxH[point[0]]);
        }
        for(int i=100000;i>=0;i--){
            maxH[i] = Math.max(maxH[i+1],maxH[i]);
        }

        for(int[] point:properties){
            if(point[1]<maxH[point[0]+1])
                count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }