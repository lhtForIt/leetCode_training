//题号：641
//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 71 👎 0

  
package leetcode.editor.cn;

import java.util.LinkedList;

public class DesignCircularDeque{
      public static void main(String[] args) {
          MyCircularDeque circularDeque = new DesignCircularDeque().new MyCircularDeque(3);
          circularDeque.insertLast(1);                    // 返回 true
          circularDeque.insertLast(2);                    // 返回 true
          circularDeque.insertFront(3);                    // 返回 true
          circularDeque.insertFront(4);                    // 已经满了，返回 false
          circularDeque.getRear();                // 返回 2
          circularDeque.isFull();                        // 返回 true
          circularDeque.deleteLast();                    // 返回 true
          circularDeque.insertFront(4);                    // 返回 true
          circularDeque.getFront();                // 返回 4


      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class MyCircularDeque {

          private DBLinkedListNode head;
          private DBLinkedListNode tail;
          private int count;
          private int size;


          public MyCircularDeque(int k) {
              this.head = new DBLinkedListNode(-1);
              this.tail = new DBLinkedListNode(-1);
              head.next = tail;
              tail.prev = head;
              this.count = k;
          }

          public boolean insertFront(int value) {
              if (isFull()) {
                  return false;
              }
              DBLinkedListNode node = new DBLinkedListNode(value);
              head.next.prev = node;
              node.next = head.next;
              head.next = node;
              node.prev = head;
              size++;
              return true;
          }

          public boolean insertLast(int value) {
              if (isFull()) {
                  return false;
              }
              DBLinkedListNode node = new DBLinkedListNode(value);
              tail.prev.next = node;
              node.next = tail;
              node.prev = tail.prev;
              tail.prev = node;
              size++;
              return true;
          }

          public boolean deleteFront() {
              if (isEmpty()) {
                  return false;
              }

              head.next.next.prev = head;
              head.next = head.next.next;
              size--;
              return true;
          }

          public boolean deleteLast() {
              if (isEmpty()) {
                  return false;
              }

              tail.prev.prev.next = tail;
              tail.prev = tail.prev.prev;
              size--;
              return true;
          }

          public int getFront() {
              if (isEmpty()) {
                  return -1;
              }

              return head.next.val;
          }

          public int getRear() {
              if (isEmpty()) {
                  return -1;
              }
              return tail.prev.val;
          }

          public boolean isEmpty() {
              return size == 0;
          }

          public boolean isFull() {
              return size == count;
          }

          public int getCount() {
              return count;
          }
      }

      class DBLinkedListNode{
          DBLinkedListNode prev;
          DBLinkedListNode next;
          int val;

          public DBLinkedListNode(int val) {
              this.val = val;
          }
      }

    /**
     * 数组实现
     * 用两个指针head和tail标识头和尾，为了方便判断队列是否为空，我们特意浪费一个尾指针空间，
     * tail这个指针其实是站位用的，存放last元素的其实是(tail-1+count)%count。
     * 这里因为有很多越界容错操作，因此会有很多+count%count的操作，作用都是为了找到正确下标
     * 这样就能很简单的用head==tail判断队列为空，相应的队列满就是(tail+1)%count==head,
     * 注意这哭数组是可以循环转动的，随着操作的变多，可能head会变到tail后面去，因此需要取余。
     *
     *
     *
      */
//class MyCircularDeque {
//
//    private int[] items;
//    private int count;
//    private int head;
//    private int tail;
//
//
//    /** Initialize your data structure here. Set the size of the deque to be k. */
//    public MyCircularDeque(int k) {
//        this.count = k+1;
//        this.items = new int[count];
//        this.head = 0;
//        this.tail = 0;
//    }
//
//    /** Adds an item at the front of Deque. Return true if the operation is successful. */
//    public boolean insertFront(int value) {
//
//        if (isFull()) {
//            return false;
//        }
//        //这里+count是为了将-1这种数变成正数，方便计算
//        head = (head - 1 + count) % count;
//        items[head] = value;
//
//
//        return true;
//    }
//
//    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//    public boolean insertLast(int value) {
//
//        if (isFull()) {
//            return false;
//        }
//        //tail是用于站位的，是在最后一个元素后面，因此不需要+1就可以赋值，然后将下边后移
//        items[tail] = value;
//        tail = (tail + 1) % count;
//
//        return true;
//    }
//
//    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//    public boolean deleteFront() {
//
//        if (isEmpty()) {
//            return false;
//        }
//
//        head = (head + 1) % count;
//
//        return true;
//    }
//
//    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//    public boolean deleteLast() {
//
//        if (isEmpty()) {
//            return false;
//        }
//        //tail这里是在最后一个元素后面，因此要-1,要防止越界要+count
//        tail = (tail - 1 + count) % count;
//
//        return true;
//    }
//
//    /** Get the front item from the deque. */
//    public int getFront() {
//        if (isEmpty()) {
//            return -1;
//        }
//
//        return items[head];
//    }
//
//    /** Get the last item from the deque. */
//    public int getRear() {
//
//        if (isEmpty()) {
//            return -1;
//        }
//
//        return items[(tail - 1 + count) % count];
//    }
//
//    /** Checks whether the circular deque is empty or not. */
//    public boolean isEmpty() {
//        return head==tail;
//    }
//
//    /** Checks whether the circular deque is full or not. */
//    public boolean isFull() {
//        return (tail + 1) % count == head;
//    }
//}

    /**
     * 链表实现
     */

//    class MyCircularDeque {
//        int size;
//        int k;
//        DoubleListNode head;
//        DoubleListNode tail;
//        /** Initialize your data structure here. Set the size of the deque to be k. */
//        public MyCircularDeque(int k) {
//            head = new DoubleListNode(-1);
//            tail = new DoubleListNode(-1);
//            head.pre = tail;
//            tail.next = head;
//            this.k = k;
//            this.size = 0;
//        }
//
//        /** Adds an item at the front of Deque. Return true if the operation is successful. */
//        public boolean insertFront(int value) {
//            if (size == k)
//                return false;
//            DoubleListNode node = new DoubleListNode(value);
//            node.next = head;
//            node.pre = head.pre;
//            head.pre.next = node;
//            head.pre = node;
//            size++;
//            return true;
//        }
//
//        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
//        public boolean insertLast(int value) {
//            if (size == k)
//                return false;
//            DoubleListNode node = new DoubleListNode(value);
//            node.next = tail.next;
//            tail.next.pre = node;
//            tail.next = node;
//            node.pre = tail;
//            size++;
//            return true;
//        }
//
//        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
//        public boolean deleteFront() {
//            if (size == 0)
//                return false;
//            head.pre.pre.next = head;
//            head.pre = head.pre.pre;
//            size--;
//            return true;
//        }
//
//        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
//        public boolean deleteLast() {
//            if (size == 0)
//                return false;
//            tail.next.next.pre = tail;
//            tail.next = tail.next.next;
//            size--;
//            return true;
//        }
//
//        /** Get the front item from the deque. */
//        public int getFront() {
//            return head.pre.val;
//        }
//
//        /** Get the last item from the deque. */
//        public int getRear() {
//            return tail.next.val;
//        }
//
//        /** Checks whether the circular deque is empty or not. */
//        public boolean isEmpty() {
//            return size == 0;
//        }
//
//        /** Checks whether the circular deque is full or not. */
//        public boolean isFull() {
//            return size == k;
//        }
//    }
//
//    class DoubleListNode {
//        DoubleListNode pre;
//        DoubleListNode next;
//        int val;
//        public DoubleListNode(int val) {
//            this.val = val;
//        }
//    }





/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }