//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 433 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {
    public static void main(String[] args) {
//        Solution solution = new LfuCache().new Solution();
//        LFUCache lfuCache = new LFUCache(2);
//        lfuCache.put(1, 1);
//        lfuCache.put(2, 2);
//        lfuCache.get(1);
//        lfuCache.put(3, 3);
//        lfuCache.get(2);
//        lfuCache.get(3);
//        lfuCache.put(4, 4);
//        lfuCache.get(1);
//        lfuCache.get(3);
//        lfuCache.get(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class LFUCache {

        Map<Integer, Node> cache; // 存储缓存的内容

        Map<Integer, DLinkedList> freqMap; // 存储每个频次对应的双向链表
        int size;
        int capacity;
        int min; // 存储当前最小频次

        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node == null) {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                if (size == capacity) {
                    DLinkedList minFreqLinkedList = freqMap.get(min);
                    cache.remove(minFreqLinkedList.removeTail().key);// 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                    size--;
                }
                size++;
                min = 1;
                DLinkedList newList = freqMap.getOrDefault(newNode.freq,new DLinkedList());
                newList.addToHead(newNode);
                freqMap.put(newNode.freq, newList);
            } else {
                node.value = value;
                freqInc(node);
            }
        }

        void freqInc(Node node) {
            // 从原freq对应的链表里移除, 并更新min
            DLinkedList oldList = freqMap.get(node.freq);
            oldList.removeNode(node);
            //该节点就是最小访问节点且该频率对应链表只有这一个元素，则min+1
            if (node.freq == min && oldList.head.next == oldList.tail) min++;
            // 加入新freq对应的链表
            node.freq++;
            DLinkedList newList = freqMap.getOrDefault(node.freq,new DLinkedList());
            newList.addToHead(node);
            freqMap.put(node.freq, newList);
        }
    }

    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLinkedList {
        Node head;
        Node tail;

        public DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        Node removeTail() {
            Node node = tail.prev;
            removeNode(node);

            return node;
        }

    }












    /**
     * 思路：一个map缓存节点内容，一个map存储每个频次对应的节点，这个可能是多个，
     * 按照访问顺序存放，这样做是为了当缓存满了之后，找到最少访问频次对应的双向链表时，
     * 双向链表的头/尾节点就是最久没访问的节点，可以直接删除。
     * 因为map无序，我们不能找到最小访问频次，所以用一个变量存储
     *
     * 这里面的DLinkedList也可以直接用java的LinkedHashSet，只是会慢点
     *
     */
//    class LFUCache {
//
//        Map<Integer, Node> cache; // 存储缓存的内容
//
//        Map<Integer, DLinkedList> freqMap; // 存储每个频次对应的双向链表
//        int size;
//        int capacity;
//        int min; // 存储当前最小频次
//
//        public LFUCache(int capacity) {
//            cache = new HashMap<>(capacity);
//            freqMap = new HashMap<>();
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            Node node = cache.get(key);
//            if (node == null) {
//                return -1;
//            }
//            freqInc(node);
//            return node.value;
//        }
//
//        public void put(int key, int value) {
//            if (capacity == 0) {
//                return;
//            }
//            Node node = cache.get(key);
//            if (node == null) {
//                Node newNode = new Node(key, value);
//                cache.put(key, newNode);
//                if (size == capacity) {
//                    DLinkedList minFreqLinkedList = freqMap.get(min);
//                    cache.remove(minFreqLinkedList.removeTail().key);// 这里不需要维护min, 因为下面add了newNode后min肯定是1.
//                    size--;
//                }
//                size++;
//                min = 1;
//                DLinkedList newList = freqMap.getOrDefault(newNode.freq,new DLinkedList());
//                newList.addToHead(newNode);
//                freqMap.put(newNode.freq, newList);
//            } else {
//                node.value = value;
//                freqInc(node);
//            }
//        }
//
//        void freqInc(Node node) {
//            // 从原freq对应的链表里移除, 并更新min
//            DLinkedList oldList = freqMap.get(node.freq);
//            oldList.removeNode(node);
//            if (node.freq == min && oldList.head.next == oldList.tail) min++;
//            // 加入新freq对应的链表
//            node.freq++;
//            DLinkedList newList = freqMap.getOrDefault(node.freq,new DLinkedList());
//            newList.addToHead(node);
//            freqMap.put(node.freq, newList);
//        }
//    }
//
//  class Node {
//        int key;
//        int value;
//        int freq;
//        Node prev;
//        Node next;
//
//        public Node() {}
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//            this.freq = 1;
//        }
//    }
//
//   class DLinkedList {
//        Node head;
//        Node tail;
//
//        public DLinkedList() {
//            head = new Node();
//            tail = new Node();
//            head.next = tail;
//            tail.prev = head;
//        }
//
//        void removeNode(Node node) {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//        }
//
//        void addToHead(Node node) {
//            node.next = head.next;
//            node.prev = head;
//            head.next.prev = node;
//            head.next = node;
//        }
//
//        Node removeTail() {
//            Node node = tail.prev;
//            removeNode(node);
//
//            return node;
//        }
//
//}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}