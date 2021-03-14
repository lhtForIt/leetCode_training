//题号：206
//https://leetcode-cn.com/problems/reverse-linked-list/
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1541 👎 0

  
package leetcode.editor.cn;

import java.util.List;

public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
          solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {


        /**
         * 递归 时间复杂度O(n)，空间复杂度O(n)
         */
        if (head == null || head.next == null) {
            return head;
        }
        //这儿是反转之后的结果，之前的head.next是链表最后一个节点
        ListNode p = reverseList(head.next);
        //将head.next指向head
        head.next.next = head;
        //将head置空，作为最后一个节点
        head.next = null;
        return p;


        /**
         * 迭代 时间复杂度O(n)，空间复杂度O(1)
         *
         * 构造一个pre和curr，然后将curr指向pre，
         * 依次重复，只需记着第一步将head指向null==pre就行
         *
         */

//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            //1->2变成1<-2，反转链表
//            curr.next = pre;
//            //将curr和next像后移
//            pre = curr;
//            curr = next;
//        }
//        return pre;


        /**
         * 全球站解法
         */
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//        return newHead;





    }
}
    //leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 }