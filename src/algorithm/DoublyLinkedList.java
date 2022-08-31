package algorithm;

import java.util.List;

public class DoublyLinkedList {
    class Node {
        Object data;
        Node left, right;

        public Node(Object data, Node leftNode) {
            this.data = data;
            this.left = leftNode;
            right = null;
        }
    }

    Node head;

    public void insert(Object data) {
        head = insertRec(null, head, data);
    }

    private Node insertRec(Node prevNode, Node head, Object data) {
        if (head == null) {
            return new Node(data, prevNode);
        } else {
            head.right = insertRec(head, head.right, data);
        }
        return head;
    }

    public void display() {
        System.out.println("::::: Traversing DLL : Left -> Right :::::");
        displayRec(head);
    }

    private void displayRec(Node head) {
        if (head != null) {
            System.out.println(head.data);
            displayRec(head.right);
        }
    }

    public void displayRev() {
        System.out.println("::::: Traversing DLL : Right -> Left :::::");
        Node temp = head;
        while (temp.right != null) {
            temp = temp.right;
        }
        displayRevRec(temp);
    }

    private void displayRevRec(Node tail) {
        if (tail != null) {
            System.out.println(tail.data);
            displayRevRec(tail.left);
        }
    }

    public static DoublyLinkedList valueOf(BinarySearchTree binarySearchTree) {
        List<Integer> values = binarySearchTree.inorder();
        DoublyLinkedList dll = new DoublyLinkedList();
        values.forEach(value -> dll.insert(value));
        return dll;
    }
}
