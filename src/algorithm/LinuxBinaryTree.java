package algorithm;

public class LinuxBinaryTree {

    public int data;
    public LinuxBinaryTree left, right;

    public LinuxBinaryTree(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    class NodeVal
    {
        int data;
        int max=0;

        public NodeVal(int i) {
            data=i;

        }
    }
    public Object getMaxWeightDuplicateDirectory() {
        NodeVal nodeVal = new NodeVal(-1);
        getMaxWeightDuplicateDirectoryRec(this, 0, 0,nodeVal);
        return nodeVal.data;
    }

    //Incorrect
    private void getMaxWeightDuplicateDirectoryRec(LinuxBinaryTree linuxBinaryTree, int totalLeft, int totalRight, NodeVal nodeVal) {
        int root = linuxBinaryTree.data;
        if (linuxBinaryTree.left != null) {
            int left = linuxBinaryTree.left.data;
            getMaxWeightDuplicateDirectoryRec(linuxBinaryTree.left, totalLeft + left, totalRight, nodeVal);
        }
        if (linuxBinaryTree.right != null) {
            int right = linuxBinaryTree.right.data;
            getMaxWeightDuplicateDirectoryRec(linuxBinaryTree.right, totalLeft, totalRight + right, nodeVal);
        }
        if(right==left && (totalLeft+totalRight)>nodeVal.max)
        {
            nodeVal.max=totalLeft+totalRight;
            nodeVal.data=root;
        }
    }


}
