//题号：25
//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// 示例 1：
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 931 👎 0

  
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNodesInKGroup{
      public static void main(String[] args) {
           Solution solution = new ReverseNodesInKGroup().new Solution();
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
    public ListNode reverseKGroup(ListNode head, int k) {

        /**
         * 法一：用栈先进后出的特性，
         * 需要额外判断最后一个是否够k个元素
         *
         */

        /**
         * 什么情况下需要一个新的链表指针，
         * 当你当前的节点会一直往后移的时候，
         * 如果在原指针上后移原指针位置就会丢失，
         * 因此需要一个新的指针代替原指针后移，这样原指针
         * 位置不会有影响
         */


//        Deque<ListNode> stack = new LinkedList<>();
//
//        ListNode dummy = new ListNode(0);
//        //这个p会一直移动，需要另起一个指针
//        ListNode p = dummy;
//        while (true) {
//            int count = 0;
//            //这儿不能直接head移动，因为如果不足k个，head指针将找不到，因此另起一个指针
//            ListNode temp = head;
//            //k个一组放进栈中
//            while (temp != null && count < k) {
//                stack.push(temp);
//                temp = temp.next;
//                count++;
//            }
//            //当不足k个不用反转
//            if (count != k) {
//                p.next = head;
//                break;
//            }
//            while (!stack.isEmpty()) {
//                p.next = stack.pop();
//                p = p.next;
//            }
//
//            head = temp;
//        }
//
//        return dummy.next;


        /**
         * 法二：迭代
         */

//        int n = 0;
        //统计链表长度
//        for (ListNode i = head; i != null; n++, i = i.next);
//
//        ListNode dmy = new ListNode(0);
//        dmy.next = head;
//        for(ListNode prev = dmy, tail = head; n >= k; n -= k) {
//            for (int i = 1; i < k; i++) {
//                ListNode next = tail.next.next;
//                tail.next.next = prev.next;
//                prev.next = tail.next;
//                tail.next = next;
//            }
//
//            prev = tail;
//            tail = tail.next;
//        }
//        return dmy.next;


        /**
         * 法三：递归
         */

        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
//        只有第一步是head指向curr会跨多个节点，后面只要一次把head和curr后移，每次反转就行
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;

    }

}




//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 }