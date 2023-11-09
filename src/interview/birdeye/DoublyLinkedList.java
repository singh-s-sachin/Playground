package interview.birdeye;

import java.util.Arrays;
import java.util.List;

public class DoublyLinkedList {
    class Node {
        private int data;
        Node left, right;

        public Node(int data, Node left) {
            this.data = data;
            this.left = left;
            this.right = null;
        }
    }

    Node root;

    public void insertAll(List<Integer> values) {
        values.forEach(data -> insert(data));
    }

    public void insert(int data) {
        root = insertRec(data, root, null);
    }

    private Node insertRec(int data, Node root, Node prevNode) {
        if (root == null) {
            return new Node(data, prevNode);
        } else {
            root.right = insertRec(data, root.right, root);
        }
        return root;
    }

    public void display() {
        displayRec(root);
    }

    private void displayRec(Node root) {
        if (root != null) {
            displayRec(root.right);
            System.out.print(root.data + " => ");
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAll(Arrays.asList(1, 2, 3, 4, 928, 5, 5, 6, 6));
        dll.display();
    }
}
