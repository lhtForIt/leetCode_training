//题号：142
//https://leetcode-cn.com/problems/linked-list-cycle-ii/
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 882 👎 0

  
package leetcode.editor.cn;

import javafx.beans.binding.ListBinding;

import javax.swing.text.html.HTMLWriter;

public class LinkedListCycleIi{
      public static void main(String[] args) {
           Solution solution = new LinkedListCycleIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {


        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;








        /**
         * 设链表共有 a+b 个节点，其中 链表头部到链表入口 有 a 个节点（不计链表入口节点），
         * 链表环 有 b 个节点（这里需要注意，a 和 b 是未知数，例如图解上链表 a=4, b=5）
         * 现在slow和fast两个指针分别走s,f步。
         * 1、f=2s;2、f=s+nb; 得到s=nb;
         * s现在在nb的位置，我们让一个指针在head位置，当走a+kb步后会在a位置,这时候让s和它一起走，
         * 最后会在a位置相遇
         */

        //这而不能反回head，因为如果只有一个节点即head.next==null,这样会以为head为环起始点，其实不是，因此必须反回null
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode slow = head, fast = head;
//        while (true) {
//            if (fast == null || fast.next == null) {
//                return null;
//            }
//
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow) {
//                break;
//            }
//        }
//        //这儿slow和fast=head都可以，没区别
//        fast = head;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//
//        return fast;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 }