package BinarySearchTree;

public class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BSTNode() {
        super();
    }
}