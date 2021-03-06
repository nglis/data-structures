package BinarySearchTree;

import Queue.QueueLinkedList;

class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return this.value;
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

    private BSTNode find(BSTNode root, int value) {
        if (root == null)
            return null;
        else if (root.value == value)
            return root;
        else if (value <= root.value)
            return find(root.left, value);
        else
            return find(root.right, value);
    }

    public int minimumValue(BSTNode root) {
        if (root == null)
            return -1;
        else if (root.left == null)
            return root.value;
        else
            return minimumValue(root.left);
    }

    private BSTNode minimumValueNode(BSTNode root) {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        else
            return minimumValueNode(root.left);
    }

    private BSTNode minimumValueNodeIterative(BSTNode root) {
        if (root == null) {
            return root;
        }
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public int maximumValue(BSTNode root) {
        if (root == null)
            return -1;
        else if (root.right == null)
            return root.value;
        else
            return maximumValue(root.right);
    }

    private BSTNode maximumValueNode(BSTNode root) {
        if (root == null)
            return null;
        else if (root.right == null)
            return root;
        else
            return maximumValueNode(root.right);
    }

    public int height(BSTNode root) {
        // Counts number of edges - O(n)
        if (root == null)
            return -1;

        return Integer.max(height(root.left), height(root.right)) + 1;
    }

    private void preOrderTraversal(BSTNode root) {
        if (root == null) return;

        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(BSTNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    private void postOrderTraversal(BSTNode root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public void levelOrderTraversal(BSTNode root) {
        if (root == null) return;

        QueueLinkedList<BSTNode> queue = new QueueLinkedList<BSTNode>();
        queue.enqueue(root);

        while(!queue.isEmpty()) {
            BSTNode tempNode = (BSTNode) queue.dequeue();
            System.out.println(tempNode.value);

            if (tempNode.left != null)
                queue.enqueue(tempNode.left);
            if (tempNode.right != null)
                queue.enqueue(tempNode.right);
        }
    }

    private Boolean isBstUtil(BSTNode root, int minBoundary, int maxBoundary) {
        if(root == null) return true;

        return root.value > minBoundary && root.value < maxBoundary &&
            isBstUtil(root.left, minBoundary, root.value) &&
            isBstUtil(root.right, root.value, maxBoundary);
    }

    public Boolean isBinarySearchTree(BSTNode root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public BSTNode deleteNode(BSTNode root, int value) {
        if (root == null) return null;
        else if (value < root.value)
            root.left = deleteNode(root.left, value);
        else if (value > root.value)
            root.right = deleteNode(root.right, value);
        else {
            // Case 1: Node has no children
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: Node has one child
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            // Case 3: Node has two children
            else {
                BSTNode temp = minimumValueNode(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }
        return root;
    }

    public BSTNode getSuccessor(BSTNode root, int value) {
        // Search for given node with value - O(h)
        BSTNode current = find(root, value);
        if (current == null) return null;

        // Case 1: Node has right subtree
        if (current.right != null) {
            return minimumValueNode(current.right);
        }

        // Case 2: Node does not have a right subtree
        else {
            BSTNode successor = null;
            BSTNode ancestor = root;

            while (ancestor != current) {
                if (current.value < ancestor.value) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }
}
