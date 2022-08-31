package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root = null;

    public void insert(List<Integer> values) {
        values.forEach(data -> insert(data));
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data > root.data) {
                root.right = insertRec(root.right, data);
            } else {
                root.left = insertRec(root.left, data);
            }
        }
        return root;
    }

    public List<Integer> inorder() {
        System.out.println("::::: Traversing inorder :::::");
        List<Integer> values = new ArrayList<>();
        inorderRec(root, values);
        return values;
    }

    private void inorderRec(Node root, List<Integer> values) {
        if (root != null) {
            inorderRec(root.left, values);
            values.add(root.data);
            System.out.println(root.data);
            inorderRec(root.right, values);
        }
    }

    public void preorder() {
        System.out.println("::::: Traversing preorder :::::");
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        System.out.println("::::: Traversing postorder :::::");
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root != null) {
            if (data == root.data) {
                return true;
            }
            if (data > root.data) {
                return searchRec(root.right, data);
            }
            if (data < root.data) {
                return searchRec(root.left, data);
            }
        }
        return false;
    }

    public void circumferenceView() {
        System.out.println("::::: Traversing circumference clockwise :::::");
        circumferenceViewLeftRec(root);
        circumferenceViewRightRec(root.right);
        circumferenceViewBottomRec(root);
    }

    private void circumferenceViewLeftRec(Node root) {
        if (root != null) {
            circumferenceViewLeftRec(root.left);
            if (!(root.left == null && root.right == null)) {
                System.out.println(root.data);
            }
        }
    }

    private void circumferenceViewRightRec(Node root) {
        if (root != null) {
            if (!(root.left == null && root.right == null)) {
                System.out.println(root.data);
            }
            circumferenceViewLeftRec(root.right);
        }
    }

    private void circumferenceViewBottomRec(Node root) {
        if (root != null) {
            circumferenceViewBottomRec(root.right);
            if (root.left == null && root.right == null) {
                System.out.println(root.data);
            }
            circumferenceViewBottomRec(root.left);
        }
    }

    class Max {
        int maxTop;

        Max(int val) {
            maxTop = val;
        }
    }

    public void rightView() {
        System.out.println("::::: Right view :::::");
        rightViewRec(root, 0, new Max(0));
    }

    private void rightViewRec(Node root, int counter, Max max) {
        if (root != null) {
            if (counter > max.maxTop || counter == 0) {
                System.out.println(root.data);
                max.maxTop = counter;
            }
            rightViewRec(root.right, counter + 1, max);
            rightViewRec(root.left, counter + 1, max);
        }
    }

    public void leftView() {
        System.out.println("::::: Left view :::::");
        leftViewRec(root, 0, new Max(0));
    }

    private void leftViewRec(Node root, int counter, Max max) {
        if (root != null) {
            if (counter > max.maxTop || counter == 0) {
                System.out.println(root.data);
                max.maxTop = counter;
            }
            leftViewRec(root.left, counter + 1, max);
            leftViewRec(root.right, counter + 1, max);
        }
    }

    public int nearestVal(int k)
    {
        Max min=new Max(Integer.MAX_VALUE);
        nearestValRec(k,root,min);
        return min.maxTop;

    }

    private void nearestValRec(int k, Node root, Max min) {
        if(root!=null) {
            int currDiff=k - root.data;
            min.maxTop=currDiff>=0?currDiff< min.maxTop?currDiff:min.maxTop:min.maxTop;
            nearestValRec(k, root.left, min );
            nearestValRec(k, root.right, min);
        }
    }

    public int height() {
        Max height = new Max(0);
        heightRec(root, 0, height);
        return height.maxTop + 1;
    }

    private void heightRec(Node root, int counter, Max height) {
        if (root != null) {
            if (counter == 0 || counter > height.maxTop) {
                height.maxTop = counter;
            }
            heightRec(root.left, counter + 1, height);
            heightRec(root.right, counter + 1, height);
        }
    }

    public int getCommonAncestor(int a, int b) {
        List<Integer> pathForA = new ArrayList<>();
        findPathRec(a, root, pathForA);
        List<Integer> pathForB = new ArrayList<>();
        findPathRec(b, root, pathForB);
        if (!pathForA.contains(a) || !pathForB.contains(b)) {
            return -1;
        } else {
            int lenA = pathForA.size();
            for (int i = lenA - 1; i >= 0; i--) {
                if (pathForB.contains(pathForA.get(i))) {
                    return pathForA.get(i);
                }
            }
        }
        return -1;
    }

    private void findPathRec(int a, Node root, List<Integer> path) {
        if (root != null) {
            path.add(root.data);
            if (a == root.data) {
                return;
            }
            if (a > root.data) {
                findPathRec(a, root.right, path);
            }
            if (a < root.data) {
                findPathRec(a, root.left, path);
            }
        }
    }
}
