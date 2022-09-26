package algorithm;

import java.util.Map;

public class LRUCache {

    /**
     * Map.Entry<></>
     * <p>
     * Search O(n)
     * <p>
     * Queue<Map.Entry>
     */

    class CacheNode {
        String key;
        String value;

        public CacheNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    class Node {
        CacheNode dataNode;
        Node next;

        public Node(CacheNode dataNode) {
            this.dataNode = dataNode;
            this.next = null;
        }
    }


    private int size;
    private int top;

    private Node head;

    public LRUCache(int size) {
        this.head = null;
        this.size = size;
        this.top = 0;
    }

    public void insert(String key, String value) { //O(n)
        CacheNode dataNode = new CacheNode(key, value);
        while (this.top >= size) {
            deleteTop();
        }
        this.head = insertRec(this.head, dataNode);
        this.top++;

    }

    private Node insertRec(Node head, CacheNode dataNode) {
        if (head == null) {
            return new Node(dataNode);
        }
        head.next = insertRec(head.next, dataNode);
        return head;
    }

    private void deleteTop() {//O(1)
        this.head = this.head.next;
        this.top--;
    }

    public String get(String key) {//O(n)
        if (head.dataNode.key.equals(key)) {
            CacheNode dataNode = head.dataNode;
            deleteTop();
            insert(dataNode.key, dataNode.value);
            return dataNode.value;
        }
        return getRec(this.head, key);
    }

    private String getRec(Node head, String key) {
        if (head.next == null) {
            return String.valueOf(-1);
        }
        if (head.next.dataNode.key.equals(key)) {
            String value = head.next.dataNode.value;
            head.next = head.next.next;
            return value;
        } else {
            return getRec(head.next, key);
        }
    }


}
