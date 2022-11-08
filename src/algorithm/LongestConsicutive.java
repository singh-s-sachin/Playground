package algorithm;

import java.util.*;

class BST {
    public int maxConsicutive() {
        int maxCount = Integer.MIN_VALUE, currCount = 0;
        List<Integer> sortedArray = new ArrayList<>();
        maxConsicutiveRec(this.root, sortedArray);
        for (int i = 1; i < sortedArray.size(); i++) {
            int diff = sortedArray.get(i) - sortedArray.get(i - 1);
            if (diff == 0 || diff == 1) {
                currCount += 1;
            }else {
                currCount = 0;
            }
            if (maxCount < currCount) {
                maxCount = currCount;
            }
        }
        return maxCount+1;
    }

    private void maxConsicutiveRec(Node root, List<Integer> sortedArray) {
        if (root != null) {
            maxConsicutiveRec(root.left, sortedArray);
            sortedArray.add(root.data);
            maxConsicutiveRec(root.right, sortedArray);
        }
    }

    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     * <p>
     * <p>
     * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * <p>
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     * <p>
     * Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     */

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insertRec(root.left, data);
        }
        if (root.data <= data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void insert(List<Integer> inputs) {
        inputs.forEach(data -> insert(data));
    }

}

public class LongestConsicutive {
    public static void main(String args[]) {
        BST bst = new BST();
        bst.insert(Arrays.asList(100,4,4,200,1,3,2));
        System.out.println(bst.maxConsicutive());
    }
}