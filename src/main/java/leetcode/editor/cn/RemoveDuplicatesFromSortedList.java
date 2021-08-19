//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 552 👎 0

package leetcode.editor.cn;
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {


        if (head == null) {
            return head;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;














        /**
         * 迭代
         * 迭代思路很简单，就是依次遍历，如果前后两个元素相等就直接指向下下个元素，
         * 否则直接往后走，这里需要注意while条件不要忽略了curr.next != null
         */

//        if (head == null) {
//            return head;
//        }
//        ListNode cur = head;
//        while (cur != null && cur.next != null) {
//            if (cur.val == cur.next.val) {
//                //将指针指向下下个节点
//                cur.next = cur.next.next;
//            } else {
//                //直接指针后移
//                cur = cur.next;
//            }
//        }
//
//        return head;

        /**
         * 递归
         *
         * 这里主要思想就是判断head和head.next值是否相等，相等则只返回head.next的值，相当于把head部分断掉了(可以理解不断取两个节点，如果相等就舍弃前面的节点)，
         * 如1(1)->1(2)->2->3(1)->3(2) 递归到最后一层时，head为3(1)->3(2)，第二行代码执行完head.next为3(2)，
         * 第三行代码会将3(1)和3(2)，比较最后返回3(2)，然后在1(1)和1(2)比较的时候返回1(2)->2->3(2)
         *
         */


//        if(head == null || head.next == null)return head;
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;


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