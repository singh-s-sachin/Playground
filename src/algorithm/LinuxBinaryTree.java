package algorithm;

public class LinuxBinaryTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    class NodeMeta {
        int sumLeft;
        int sumRight;

        NodeMeta(int sumLeft, int sumRight) {
            this.sumLeft = sumLeft;
            this.sumRight = sumRight;
        }
    }

    public int getMaximumDuplicateFolder(Node root) {
        getMaximumDuplicateFolderRec(root, 0);

        //TODO : Yet to be implemented
        return 0;
    }

    private void getMaximumDuplicateFolderRec(Node root, int maxDuplicateFolder) {
        if (root.left != null) {
            getMaximumDuplicateFolderRec(root.left, maxDuplicateFolder);
        }
        int left, right;
        if (root.right == null) {
            right = 0;
        } else {
            right = root.data;
        }

    }


}
