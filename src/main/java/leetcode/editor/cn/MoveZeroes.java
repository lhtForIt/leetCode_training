//题号：283
//https://leetcode-cn.com/problems/move-zeroes/
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//[1,0,2,0,3]
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 935 👎 0

/**
 * 2021-02-03 1
 */
  
package leetcode.editor.cn;
public class MoveZeroes{
      public static void main(String[] args) {
           Solution solution = new MoveZeroes().new Solution();
           solution.moveZeroes(new int[]{1,0, 3, 0, 12});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public void moveZeroes(int[] nums) {


              if (nums == null || nums.length == 0) {
                  return;
              }

              int j = 0;
              for (int i = 0; i < nums.length; i++) {
                  if (nums[i] != 0) {
                      if (i != j) {
                          nums[j] = nums[i];
                          nums[i] = 0;
                      }
                      j++;
                  }
              }

























              /**
               * 法一：两次循环
               * 时间复杂度O(n+m)m是0的数量，空间复杂度O(1)
               */


//              if (nums == null) {
//                  return;
//              }
//
//              int j = 0;
//              for (int i = 0; i < nums.length; i++) {
//                  if (nums[i]!=0) {
//                      //这儿可以直接写成nums[j++]=nums[i]，下面这种好理解点
//                      nums[j++] = nums[i];
//                  }
//              }
//
//              //初始值j为0是没用的，因此++之后j也是没有使用的，直接用j
//              for (int i = j; i < nums.length; i++) {
//                  nums[i] = 0;
//              }


              /**
               * 法二：双指针
               *
               * 思路：j代表0的位置，i代表数组的指针，用i遍历数组会发生两种情况，i==0和i!=0，
               * 当nums[i]==0时，可以不管，因为我们是靠j指针移动的0
               * 当nums[i]!=0时，看i==j是否成立，如果成立，仅j++，因为i自动会+1，如果i!=j，说明i不为0，j为0，交换两者的位置即可
               *
               * 总结，当nums[i]！=0时，都会执行j++，而在i!=j时，nums[i]和nums[j]需要交换，而由于一直nums[j]一定为0，所以在将nums[i]值
               * 赋给nums[j]后，直接将nums[i]赋值为0即可。
               *
               *
               */


//              if (nums == null) {
//                  return;
//              }
//
//              //用j记录0的位置，默认第一个为0，当不为0时，用nums[j]=nums[i]
//              int j = 0;
//              for (int i = 0; i < nums.length; i++) {
//                  //因为i,j起点一样，i会一直往前走，当nums[i]不等于0，j才会加1，因此j一定是在0的位置
//                  if (nums[i] != 0) {
//                      //只有不同位置才需要交换,如去掉这个判断，当只有一个元素[1]时，会输出[0]
//                      if (i != j) {
//                          nums[j] = nums[i];
//                          nums[i] = 0;
//                      }
//                      j++;
//                  }
//              }

          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }