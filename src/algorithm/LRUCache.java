package algorithm;

public class LRUCache {

    class CacheNode {
        String key;
        Object value;
        CacheNode next;

        CacheNode(String key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    CacheNode head;
    int size;

    public LRUCache(int size) throws Exception {
        if (size < 2) {
            throw new Exception("Minimum of 2 nodes expected in cache");
        }
        this.head = null;
        this.size = size;
    }

    public void insert(String key, Object value) {
        CacheNode headk = insertRec(head, key, value, 1, size);
        if (head == null) {
            head = headk;
        }
    }

    private CacheNode insertRec(CacheNode head, String key, Object value, int pointer, int size) {
        pointer++;
        if (head == null) {
            return new CacheNode(key, value);
        }
        if (pointer > size) {
            CacheNode newNode = new CacheNode(key, value);
            newNode.next = this.head;
            this.head = newNode;
            return null;
        }
        head.next = insertRec(head.next, key, value, pointer, size);
        return head;
    }

    public Object get(String key) {
        return getRec(head, key);
    }

    private Object getRec(CacheNode head, String key) {
        while (head != null) {
            if (key.equals(head.key)) {
                return head.value;
            }
            head = head.next;
        }
        return -1;
    }

    public void display() {
        displayRec(head);
    }

    private void displayRec(CacheNode head) {
        if (head != null) {
            System.out.println("Key : " + head.key + "\t\tValue : " + head.value);
            displayRec(head.next);
        }
    }
}
