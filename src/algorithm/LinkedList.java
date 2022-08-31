package algorithm;

public class LinkedList {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private class Flag {
        boolean flagVal;
        Object data = null;

        Flag() {
            flagVal = true;
        }

        void disable() {
            flagVal = false;
        }

        boolean isEnabled() {
            return flagVal;
        }
    }

    Node head;

    public void insert(Object data) {
        head = insertRec(head, data);
    }

    private Node insertRec(Node head, Object data) {
        if (head == null) {
            return new Node(data);
        } else {
            head.next = insertRec(head.next, data);
        }
        return head;
    }

    public void reverse(int group) {
        Node temp = head;
        this.head = null;
        revRecGrp(temp, null, group, 0, new Flag());
    }

    private void revRecGrp(Node temp, Object data, int group, int index, Flag flag) {
        if (index != group && temp != null) {
            revRecGrp(temp.next, temp.data, group, index + 1, flag);
        }
        if (data != null) {
            if (flag.isEnabled()) {
                flag.data = temp;
                flag.disable();
            }
            insert(data);
        } else {
            if (flag.data == null) {
                return;
            }
            revRecGrp((Node) flag.data, null, group, 0, new Flag());
        }

    }

    public void reverse() {
        revRec(head, new Flag());
    }

    private void revRec(Node head, Flag flag) {
        if (head != null) {
            revRec(head.next, flag);
            if (flag.isEnabled()) {
                this.head = null;
                flag.disable();
            }
            insert(head.data);
        }
    }

    public static LinkedList sum(LinkedList a, LinkedList b) {
        a.reverse();
        b.reverse();
        LinkedList ll = new LinkedList();
        sumRec(a.head, b.head, ll, 0);
        ll.reverse();
        return ll;
    }

    private static void sumRec(Node a, Node b, LinkedList ll, int remainder) {
        if (a == null && b == null) {
            if (remainder > 0)
                ll.insert(remainder);
            return;
        }
        int sum = (a == null ? 0 : (int) a.data)
                + (b == null ? 0 : (int) b.data)
                + remainder;
        remainder = 0;
        if (sum > 9) {
            remainder = sum / 10;
            sum = sum % 10;
        }
        ll.insert(sum);
        sumRec(a == null ? null : a.next, b == null ? null : b.next, ll, remainder);
    }

    public void display() {
        System.out.println("::::: Traversing LinkedList");
        displayRec(head);
    }

    private void displayRec(Node head) {
        if (head != null) {
            System.out.println(head.data);
            displayRec(head.next);
        }
    }
}
