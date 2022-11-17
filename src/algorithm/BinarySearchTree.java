package algorithm;

import java.util.LinkedList;
import java.util.*;

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

    public void bfsTraversal() {
        System.out.println("::::: Traversing Breadth First :::::");
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node topNode = nodeQueue.poll();
            System.out.println(topNode.data);
            if (topNode.left != null) {
                nodeQueue.add(topNode.left);
            }
            if (topNode.right != null) {
                nodeQueue.add(topNode.right);
            }
        }
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
        Map.Entry<String, Integer> levelMap = new AbstractMap.SimpleEntry<>("Top", 0);
        if (root == null) {
            System.out.println("-1");
            return;
        }
        rightViewRec(root, 0, levelMap);
    }

    private void rightViewRec(Node root, int counter, Map.Entry<String, Integer> maxMap) {
        if (root != null) {
            if (counter >= maxMap.getValue()) {
                System.out.println(root.data);
                maxMap.setValue(counter + 1);
            }
            rightViewRec(root.right, counter + 1, maxMap);
            rightViewRec(root.left, counter + 1, maxMap);
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

    public int nearestVal(int k) {
        Max min = new Max(Integer.MAX_VALUE);
        nearestValRec(k, root, min);
        return min.maxTop;

    }

    private void nearestValRec(int k, Node root, Max min) {
        if (root != null) {
            int currDiff = Math.abs(k - root.data);
            int minDiff = Math.abs(k - min.maxTop);
            min.maxTop = currDiff < minDiff ? root.data : min.maxTop;
            nearestValRec(k, root.left, min);
            nearestValRec(k, root.right, min);
        }
    }

    public int kthNearest(int value, int k) {
        Stack<Integer> minStack = new Stack<>();
        Map.Entry<String, Integer> minMap = new AbstractMap.SimpleEntry<>("min", Integer.MAX_VALUE);
        kthNearestRec(root, value, minStack, minMap);
        int kthNearest = -1;
        while (k > 0) {
            kthNearest = minStack.pop();
            k--;
        }
        return kthNearest;
    }

    private void kthNearestRec(Node root, int value, Stack<Integer> minStack, Map.Entry<String, Integer> minMap) {
        if (root != null) {
            kthNearestRec(root.left, value, minStack, minMap);
            int currDiff = Math.abs(root.data - value);
            int minDiff = Math.abs(minMap.getValue() - value);
            if (minDiff > currDiff) {
                minStack.add(minMap.getValue());
                minMap.setValue(root.data);
            }
            kthNearestRec(root.right, value, minStack, minMap);
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

    public void averageOfEachLevel() {
        Map<Integer, List<Integer>> levelValuesMap = getValuesForLevel(root);

        System.out.println("Average of each levels : ");
        for (Map.Entry<Integer, List<Integer>> entry : levelValuesMap.entrySet()) {
            int s = 0, count = 0;
            for (int values : entry.getValue()) {
                s += values;
                count += 1;
            }
            System.out.println("Level " + (entry.getKey()+1) + ":" + (double) s / count);
        }
    }

    private Map<Integer, List<Integer>> getValuesForLevel(Node root) {
        Queue<Map.Entry<Node, Integer>> nodeStack = new LinkedList<>();
        Map<Integer, List<Integer>> levelValuesMap = new HashMap<>();
        nodeStack.add(new AbstractMap.SimpleEntry<>(root, 0));
        while (nodeStack.size() > 0) {
            Map.Entry<Node, Integer> currEntry = nodeStack.poll();
            Node currNode = currEntry.getKey();
            int currLevel = currEntry.getValue();

            List<Integer> levelValues = levelValuesMap.getOrDefault(currLevel, new ArrayList<>());
            levelValues.add(currNode.data);
            levelValuesMap.put(currLevel, levelValues);

            if (currNode.right != null) {
                nodeStack.add(new AbstractMap.SimpleEntry<>(currNode.right, currLevel + 1));
            }
            if (currNode.left != null) {
                nodeStack.add(new AbstractMap.SimpleEntry<>(currNode.left, currLevel + 1));
            }
        }
        return levelValuesMap;
    }

    /**
    public int getKSumPathCount(int k)
    {
        Map.Entry<String,Integer> countEntry = new AbstractMap.SimpleEntry<>("count",0);
        getKSumPathCount(root,k, root.data, countEntry);
        return countEntry.getValue();
    }

    private void getKSumPathCount(Node root, int k,int sum, Map.Entry<String, Integer> countEntry) {
        if(root!=null)
        {
            if(sum+ root.data>k)
            {
                countEntry.setValue(countEntry.getValue()+1);
                sum-=
            }
            getKSumPathCount(root.left,sum+ root.data,k,countEntry);

        }
    }
     **/
}
