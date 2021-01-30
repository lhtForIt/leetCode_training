//题号：24
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
// 👍 794 👎 0


package leetcode.editor.cn;
public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {

            //没有可以交换的节点，直接返回参数
            if (head == null || head.next == null) {
                return head;
            }

            //定义该单元返回的头结点
            ListNode next = head.next;
            //将该单元第二个节点原先指向下一节点的指针断掉，指向下一单元的头结点
            head.next = swapPairs(next.next);
            //反转该单元节点指向
            next.next = head;


            return next;
        }

//    public ListNode swapPairs(ListNode head) {
////
////        ListNode pre = new ListNode();
////        pre.next = head;
////        ListNode temp = pre;
////
////        while (temp.next != null && temp.next.next != null) {
////            //记录两个节点位置
////            ListNode start = temp.next;
////            ListNode end = temp.next.next;
////            //确定第一个节点
////            temp.next = end;
////            //将第二个节点指向下一组头结点
////            start.next = end.next;
////            //反转两个节点
////            end.next = start;
////            //将节点赋值给temp
////            temp = start;
////        }
////
////        return pre.next;
////    }

    }


    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}