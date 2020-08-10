package BinarySearchTree;

public class BinarySearchTree {
    public BSTNode insert(BSTNode root, int value) {
        if (root == null)
            root = new BSTNode(value, null, null);
        else if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public Boolean search(BSTNode root, int value) {
        if (root == null)
            return false;
        else if (root.value == value)
            return true;
        else if (value <= root.value)
            return search(root.left, value);
        else
            return search(root.right, value);
    }
}
