package interview.birdeye;


/**
 *           1
 *        2      3
 *      4  5   6
 *    7  8  10   9
 * 11   12
 *
 * //11,7,128
 */
public class BinaryTree {
    class Node{
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            this.left=this.right=null;
        }
    }
    Node root;
    public void displayBottom()
    {
        //displayBottomRec(root);
    }
}
