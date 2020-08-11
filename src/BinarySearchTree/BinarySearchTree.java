package BinarySearchTree;

class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {

    public BSTNode root;

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

    public int min(BSTNode root) {
        if (root == null)
            return -1;
        else if (root.left == null)
            return root.value;
        else
            return min(root.left);
    }

    public int max(BSTNode root) {
        if (root == null)
            return -1;
        else if (root.right == null)
            return root.value;
        else
            return max(root.right);
    }

    public int height(BSTNode root) {
        // Counts number of edges - O(n)
        if (root == null)
            return -1;

        return Integer.max(height(root.left), height(root.right)) + 1;
    }

    public void preOrderTraversal(BSTNode root) {
        if (root == null) return;

        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(BSTNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BSTNode root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
}
