//题号：825
//在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。 
//
// 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求： 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// 否则，x 将会向 y 发送一条好友请求。 
//
// 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。 
//
// 返回在该社交媒体网站上产生的好友请求总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：ages = [16,16]
//输出：2
//解释：2 人互发好友请求。
// 
//
// 示例 2： 
//
// 
//输入：ages = [16,17,18]
//输出：2
//解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
// 
//
// 示例 3： 
//
// 
//输入：ages = [20,30,100,110,120]
//输出：3
//解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
// 
//
// 
//
// 提示： 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 104 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 109 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges{
      public static void main(String[] args) {
           Solution solution = new FriendsOfAppropriateAges().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        /**
         * 法一
         */
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int age : ages)
//            count.put(age, count.getOrDefault(age, 0) + 1);
//        int res = 0;
//        for (Integer a : count.keySet())
//            for (Integer b : count.keySet())
//                if (request(a, b)) res += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
//        return res;

        /**
         * 法二
         * Three conditions could be merged to one:
         * The Person with age A can request person with age B if
         *
         * B is in range ( 0.5 * A + 7, A ]
         */

        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];

        for(int i : ages)
            numInAge[i] ++;

        for(int i = 1; i <= 120; ++i)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];

        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;

        /**
         * 法三
         */

//        int[] ageCount = new int[121];
//        int[] ageSum = new int[121];
//        for (int i = 0; i < ages.length; i++) {
//            ageCount[ages[i]]++;
//        }
//        int sum = 0;
//        int res = 0;
//        for (int i = 15; i <= 120; i++) {
//            sum += ageCount[i];
//            ageSum[i] = sum;
//            if (ageCount[i] > 0) {
//                res += ((ageSum[i] - ageSum[(int)(i * .5 + 7)] - 1) * ageCount[i]);
//            }
//        }
//        return res;
    }

          private boolean request(Integer a, Integer b) {
              return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }