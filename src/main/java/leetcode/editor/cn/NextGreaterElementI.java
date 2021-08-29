//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 数组 哈希表 单调栈 
// 👍 477 👎 0

package leetcode.editor.cn;

import java.util.*;

public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        /**
         * 思路，维护一个单调递增栈，其实每个栈元素后一个元素就是Nums1,对应的答案，然后在压栈的时候记录该答案。
         * 这里while处必须stack.pop()，而不能stack.peek()，因为只有栈空才能走到while外面，如果是peek()会导致栈里一直
         * 有元素，导致死循环，这个单调栈里一直只有一个元素。
         * 后续在遍历整个nums1，取出答案赋值即可
         */
//        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
//        Stack<Integer> stack = new Stack<>();
//        for (int num : nums2) {
//            while (!stack.isEmpty() && stack.peek() < num)
//                map.put(stack.pop(), num);
//            stack.push(num);
//        }
//        for (int i = 0; i < nums1.length; i++)
//            nums1[i] = map.getOrDefault(nums1[i], -1);
//        return nums1;

        /**
         * 优化，将Map改为Array，但是这题应该测试用例不大，差别不是很明显，只提升了2%
         */
        int[] cacheArray = new int[10001];
        Deque<Integer> stack = new LinkedList<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                cacheArray[stack.pop()] = num;
            }
            stack.push(num);
        }

        //这里没必要新弄一个数组，直接用nums1修改即可。
//        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
                nums1[i] = cacheArray[nums1[i]] == 0 ? -1 : cacheArray[nums1[i]];
        }

        return nums1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}