package template.leetcode.editor.cn;

//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 104 
// 0 <= value <= 105 
// At most 2 * 105 calls will be made to get and put. 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1480 👎 0

import java.util.HashMap;
import java.util.Map;

public class LruCache{

    public static void main(String[] args) {
        LRUCache solution = new LRUCache(2);

        solution.put(1, 1); // 缓存是 {1=1}
        solution.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(solution.get(1));    // 返回 1
        solution.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(solution.get(2));    // 返回 -1 (未找到)
        solution.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(solution.get(1));    // 返回 -1 (未找到)
        System.out.println(solution.get(3));    // 返回 3
        System.out.println(solution.get(4));    // 返回 4

        System.out.println("===");

        solution.put(2, 1);
        solution.put(2, 2);
        System.out.println(solution.get(2)); // 2
        solution.put(1, 1);
        solution.put(4, 1);
        System.out.println(solution.get(2)); // -1
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class LRUCache {

    private int size;
    private int capacity;
    private Map<Integer, DNode> cache;
    private DLinkList dLinkList;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        dLinkList = new DLinkList();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            DNode node = cache.get(key);
            dLinkList.moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            DNode newNode = new DNode(key, value);
            if (size == capacity) {
                DNode lastNode = dLinkList.removeLast();
                cache.remove(lastNode.key);
                size--;
            }
            cache.put(key, newNode);
            dLinkList.addNode(newNode);
            size++;
        } else {
            node.val = value;
            // 更新缓存
            cache.put(key, node);
            // 更新位置
            dLinkList.moveToHead(node);
        }
    }

    class DLinkList {

        DNode head;
        DNode tail;

        DLinkList() {
            head = new DNode();
            tail = new DNode();

            head.next = tail;
            tail.pre = head;
        }

        public void addNode(DNode node) {
            DNode oldFirst = head.next;
            head.next = node;
            node.pre = head;
            oldFirst.pre = node;
            node.next = oldFirst;
        }

        public void removeNode(DNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public DNode removeLast() {
            DNode last = tail.pre;
            removeNode(last);
            return last;
        }

        public void moveToHead(DNode node) {
            removeNode(node);
            addNode(node);
        }
    }

    class DNode {
        int key;
        int val;
        DNode pre;
        DNode next;
        DNode () {  }
        DNode (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}