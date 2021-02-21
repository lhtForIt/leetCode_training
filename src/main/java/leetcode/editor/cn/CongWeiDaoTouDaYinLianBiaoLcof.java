//题号：剑指 Offer 06
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 97 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof{
      public static void main(String[] args) {
           Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
          solution.reversePrint(new ListNode(1, new ListNode(3, new ListNode(2))));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    ArrayList<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {


        /**
         * 法一：运用栈先进后出的特性
         */

//        Stack<Integer> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head.val);
//            head = head.next;
//        }
//
//        int[] res = new int[stack.size()];
//        //note这里如果用stack.size()作为边界会有问题，因为stack.pop()会改变size()大小
//        for (int i = 0; i < res.length; i++) {
//            res[i] = stack.pop();
//        }
//
//        return res;

        /**
         * 法二：递归
         */
        recur(head);
        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;


    }

    private void recur(ListNode head) {

        if (head == null) {
            return;
        }

        recur(head.next);
        temp.add(head.val);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode(int x,ListNode next){val=x;
         this.next = next;}
 }
}