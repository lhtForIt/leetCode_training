//1128
//https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
//给你一个由一些多米诺骨牌组成的列表 dominoes。
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 110 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
        solution.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

//        int[] num = new int[100];
//        int count = 0;
//        for (int[] domino : dominoes) {
//            if (domino[0] > domino[1]) {
//                int temp = domino[1];
//                domino[1] = domino[0];
//                domino[0] = temp;
//            }
//            int value = domino[0] * 10 + domino[1];
//            count += num[value];
//            //这里其实用的数组位数来计数，排序后符合条件的多米诺牌会到同一个下标，每次只需要对下标加一就可以.
//            num[value]++;
//        }
//        return count;





//        return 0;

        /**
         * 法一：运用hashMap统计符合条件个数，然后用公式求解
         * 时间复杂度O(n)，空间复杂度O(1)常数级
         */


//        Map<Pair, Integer> dominoMap = new HashMap<>(100);
//        for (int i = 0; i < dominoes.length; i++) {
//            Pair key = new Pair(dominoes[i][0], dominoes[i][1]);
//            dominoMap.put(key, dominoMap.getOrDefault(key, 0) + 1);
//        }
//
//        //根据公式求出排列组合可能性
//        int count = 0;
//        for (int f : dominoMap.values()) {
//            count += f * (f - 1) / 2;
//        }
//        return count;

        /**
         * 法二：暴力求解
         * 时间复杂度O(n2)，空间复杂度O(1)
         * 会超时
         */

//        int count = 0;
//        for (int i = 0; i < dominoes.length-1; i++) {
//            for (int j = i + 1; j < dominoes.length; j++) {
//                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1] || dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
//                    count++;
//                }
//            }
//        }
//
//        return count;


        /**
         * 法三：用数组代替哈希表，因为1 <= dominoes[i][j] <= 9，
         * 因此能重复的可能一定不会超过100，因此可以用数组代替
         */

        int[] freq = new int[100];


        int count = 0;
        for (int[] domino: dominoes) {
            if (domino[0] > domino[1]) {
                int temp = domino[0];
                domino[0] = domino[1];
                domino[1] = temp;
            }

            int num = domino[0] * 10 + domino[1];
            count += freq[num];
            freq[num]++;

        }

        return count;

    }


        class Pair {
            private int key;
            private int value;


            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || o.getClass() != this.getClass()) {
                    return false;
                }
                Pair pair = (Pair) o;
                return key == pair.key &&
                        value == pair.value || key == pair.value && value == pair.key;
            }

            @Override
            public int hashCode() {


                if (key < value) {
                    return key * 10 + value;
                }

                return value * 10 + key;
            }
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}