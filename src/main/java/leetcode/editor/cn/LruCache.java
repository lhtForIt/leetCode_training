//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1298 👎 0

package leetcode.editor.cn;

import javafx.scene.text.TextAlignment;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LruCache LruCache = new LruCache();
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class LRUCache {

        class DLinkedNode{
            private int key;
            private int value;
            private DLinkedNode prev, next;

            public DLinkedNode(){}

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        class DLinkedList{

            private DLinkedNode head, tail;
            public DLinkedList(){
                this.head = new DLinkedNode();
                this.tail = new DLinkedNode();
                head.next = tail;
                tail.prev = head;
            }

            public void removeNode(DLinkedNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            public void addToHead(DLinkedNode node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            public void moveToHead(DLinkedNode node) {
                removeNode(node);
                addToHead(node);
            }

            public DLinkedNode removeTail(){
                DLinkedNode tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }


        }


        private int capacity;
        private Map<Integer, DLinkedNode> cache;
        private DLinkedList dLinkedList;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.dLinkedList = new DLinkedList();
        }

        public int get(int key) {

            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            dLinkedList.moveToHead(node);
            return node.value;
        }



        public void put(int key, int value) {

            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newHead = new DLinkedNode(key, value);
                cache.put(key, newHead);
                if (cache.size() > capacity) {
                    DLinkedNode tailNode = dLinkedList.removeTail();
                    cache.remove(tailNode.key);
                }
                dLinkedList.addToHead(newHead);
            } else {
                dLinkedList.moveToHead(node);
                node.value = value;
            }


        }


        /**
         * 将双链表抽成一个类，这种方法复用性更强一点
         */
//        class DLinkedNode{
//            private int key;
//            private int value;
//            private DLinkedNode prev, next;
//
//            public DLinkedNode(){}
//
//            public DLinkedNode(int key, int value) {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//        class DLinkedList{
//
//            private DLinkedNode head, tail;
//            public DLinkedList(){
//                this.head = new DLinkedNode();
//                this.tail = new DLinkedNode();
//                head.next = tail;
//                tail.prev = head;
//            }
//
//            public void removeNode(DLinkedNode node) {
//                node.prev.next = node.next;
//                node.next.prev = node.prev;
//            }
//
//            public void addToHead(DLinkedNode node) {
//                node.prev = head;
//                node.next = head.next;
//                head.next.prev = node;
//                head.next = node;
//            }
//
//            public void moveToHead(DLinkedNode node) {
//                removeNode(node);
//                addToHead(node);
//            }
//
//            public DLinkedNode removeTail(){
//                DLinkedNode tailNode = tail.prev;
//                removeNode(tailNode);
//                return tailNode;
//            }
//
//
//        }
//
//
//        private int capacity;
//        private Map<Integer, DLinkedNode> cache;
//        private DLinkedList dLinkedList;
//
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            this.cache = new HashMap<>();
//            this.dLinkedList = new DLinkedList();
//        }
//
//        public int get(int key) {
//
//            DLinkedNode node = cache.get(key);
//            if (node == null) {
//                return -1;
//            }
//
//            dLinkedList.moveToHead(node);
//            return node.value;
//        }
//
//
//
//        public void put(int key, int value) {
//
//            DLinkedNode node = cache.get(key);
//            if (node == null) {
//                DLinkedNode newHead = new DLinkedNode(key, value);
//                cache.put(key, newHead);
//                if (cache.size() > capacity) {
//                    DLinkedNode tailNode = dLinkedList.removeTail();
//                    cache.remove(tailNode.key);
//                }
//                dLinkedList.addToHead(newHead);
//            } else {
//                dLinkedList.moveToHead(node);
//                node.value = value;
//            }
//
//
//        }



        /**
         * 思路：因为时间复杂度要是O（1），那数组一定不行，因为数组插入删除是O(n)，
         * 树堆这些高级数据结构也不行，因为只能到O(logn)，因此只能是链表，严格来说双向链表，因为单向链表删除是O(n)的，因为要查前驱节点需要遍历整个链表，
         * 但是链表有个致命问题就是查询是O(n)的，那就需要一个数据结构去专门记录链表每个节点的位置，然后又需要是O(1)操作能实现，很自然想到哈希表HashMap，
         * 然后就组成了java里面的LinkedHashMap,这里利用了head和tail节点站位，省去了很多空判断
         */

//        class DLinkedNode{
//            private int key;
//            private int value;
//            private DLinkedNode prev;
//            private DLinkedNode next;
//            public DLinkedNode(){}
//
//            public DLinkedNode(int key, int value) {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//        private int capacity;
//        private Map<Integer, DLinkedNode> cache = new HashMap<>();
//        private DLinkedNode head, tail;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            head = new DLinkedNode();
//            tail = new DLinkedNode();
//            head.next = tail;
//            tail.prev = head;
//        }
//
//        public int get(int key) {
//
//            if (cache.containsKey(key)) {
//                DLinkedNode node = cache.get(key);
//                moveToHead(node);
//                return node.value;
//            }
//
//            return -1;
//
//
//        }
//
//        private void moveToHead(DLinkedNode node) {
//            removeNode(node);
//            addToHead(node);
//        }
//
//        private void addToHead(DLinkedNode node) {
//            node.prev = head;
//            node.next = head.next;
//            head.next.prev = node;
//            head.next = node;
//        }
//
//        private void removeNode(DLinkedNode node) {
//            node.next.prev = node.prev;
//            node.prev.next = node.next;
//        }
//
//
//        public void put(int key, int value) {
//
//            DLinkedNode node = cache.get(key);
//            if (node == null) {
//                DLinkedNode newHead = new DLinkedNode(key, value);
//                cache.put(key, newHead);
//                addToHead(newHead);
//                if (cache.size() > capacity) {
//                    DLinkedNode tail = removeTail();
//                    cache.remove(tail.key);
//                }
//            } else {
//                moveToHead(node);
//                node.value = value;
//            }
//
//        }
//
//        private DLinkedNode removeTail() {
//            DLinkedNode node = tail.prev;
//            removeNode(node);
//
//            return node;
//        }


        /**
         * 运用双向链表原因是在删除节点的时候需要知道前驱节点，
         * 如果是单链表需要重新遍历一次链表，
         * 而双链表可以直接查到
          */

//    class DLinkedNode{
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//        public DLinkedNode(){}
//
//        public DLinkedNode(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private Map<Integer, DLinkedNode> cache = new HashMap<>();
//    private int capacity;
//    private DLinkedNode head, tail;
//
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        //使用伪头部和伪尾部节点
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            return -1;
//        }
//
//        //如果key存在，先通过哈希表找到位置O(1)，然后将其移到头部
//        moveToHead(node);
//        return node.value;
//    }
//
//        private void moveToHead(DLinkedNode node) {
//            removeNode(node);
//            addToHead(node);
//        }
//
//        private void removeNode(DLinkedNode node) {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//        }
//
//        /**
//         * 自己的写法
//         * 事实上我们不需要size这个变量，直接用cache.size()就可以判断
//         * DLinkedNode node = cache.get(key);
//         *             if (node == null) {
//         *                 //没有就新建
//         *                 DLinkedNode newHead = new DLinkedNode(key, value);
//         *                 //放入map
//         *                 cache.put(key, newHead);
//         *                 //不论怎样都要添加该元素到头部，所以先添加
//         *                 addToHead(newHead);
//         *                 //判断是否超过缓存最大值
//         *                 if (++size > capacity) {
//         *                     //因为不知道当前尾部节点的key，所以需要返回尾部节点得到key
//         *                     DLinkedNode tail = removeTail();
//         *                     //删除缓存
//         *                     cache.remove(tail.key);
//         *                     size--;
//         *                 }
//         *             } else {
//         *                 //有元素就删除原有元素在将其添加到头部
//         *                 moveToHead(node);
//         *                 //这里值可能变，所以要重新赋值
//         *                 node.value = value;
//         *                 cache.put(key, node);
//         * }
//         *
//         *
//         */
//        public void put(int key, int value) {
//            DLinkedNode node = cache.get(key);
//            if (node == null) {
//                //如果不存在则新建并加入缓存
//                DLinkedNode newNode = new DLinkedNode(key, value);
//                cache.put(key, newNode);
//                //添加到双向链表头部
//                addToHead(newNode);
//                if (cache.size() > capacity) {
//                    //如果链表满了，则删除尾部节点(最久没用的)
//                    DLinkedNode tail = removeTail();
//                    //删除哈希表对应项
//                    cache.remove(tail.key);
//                }
//            } else {
//                //如果存在，修改值并移到头部
//                node.value = value;
//                moveToHead(node);
//            }
//    }
//
//        private DLinkedNode removeTail() {
//            DLinkedNode res = tail.prev;
//            removeNode(res);
//            return res;
//        }
//        //这里是addToHead，因此要以head为准，不能用
//        //tail.prev.next = node;
//        //tail.prev = node;这个写法
//        private void addToHead(DLinkedNode node) {
//            node.prev = head;
//            node.next = head.next;
//            head.next.prev = node;
//            head.next = node;
//        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}