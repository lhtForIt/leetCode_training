//题号：155
//https://leetcode-cn.com/problems/min-stack/
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 822 👎 0

  
package leetcode.editor.cn;

class Solution{
      public static void main(String[] args) {
           Solution solution = new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 全球站解法
      */
class MinStack {

        /**
         * 这个有两种解法，一个是用系统自带的数据结构-栈，然后用一个变量
         * 记录最小值，这样每次geiMin()直接拿min就可以
         * <p>
         * 第二个方法就是自己实现一个栈,用链表
         */
        //我们可以在节点中保存数值的信息并同时保存最小值
        private Node head;
        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

       private class Node{

           int val;
           int min;
           Node next;

           public Node(int val, int min, Node next) {
               this.val = val;
               this.min = min;
               this.next = next;
           }

           public Node(int val, int min) {
               this(val, min, null);
           }

       }

    }


/**
 * 栈里可以用实体类将值和最小值放一起，可以少一个栈
 */
//class MinStack {
//
//          Deque<Integer> stack;
//          Deque<Integer> minStack;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new LinkedList<>();
//        minStack = new LinkedList<>();
//        minStack.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        //因为每次放的是当前值和栈顶比的最小值，那下一次拿出的一定是第二小的值
//        minStack.push(Math.min(x, minStack.peek()));
//    }
//
//
//    public void pop() {
//        if (stack.isEmpty()) {
//            return;
//        }
//        stack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }