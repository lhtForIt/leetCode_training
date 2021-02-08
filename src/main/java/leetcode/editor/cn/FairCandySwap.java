//题号：888
//https://leetcode-cn.com/problems/fair-candy-swap/
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 141 👎 0

  
  package leetcode.editor.cn;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.of;

public class FairCandySwap{
      public static void main(String[] args) {
           Solution solution = new FairCandySwap().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {

        /**
         * dif = (sum(A) - sum(B)) / 2
         * 实际上是要找到int[a,b]
         * a=dif+b
         */

//        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
//        HashSet<Integer> set = new HashSet<>();
//        for (int a : A) {
//            set.add(a);
//        }
//
//        for (int b : B) {
//            if (set.contains(b + dif)) {
//                return new int[]{b + dif, b};
//            }
//        }

        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
//        Arrays.sort(A);
//        Arrays.sort(B);
//        int i = 0, j = 0;
//        while (i < A.length && j < B.length) {
//            if (A[i] - B[j] == dif) {
//                return new int[]{A[i], B[j]};
//            } else if (A[i] - B[j] > dif) {
//                j++;
//            } else {
//                i++;
//            }
//        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == dif) {
                    return new int[]{A[i], B[j]};
                }
            }
        }


        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }