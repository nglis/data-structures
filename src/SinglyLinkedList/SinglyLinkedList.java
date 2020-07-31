package SinglyLinkedList;// First index position is at 0

class Node {
    Integer value;
    Node ref;

    Node(Integer value, Node node) {
        this.value = value;
        this.ref = node;
    }
}

public class SinglyLinkedList {

    private Node headNode;

    public void add(Integer value) {
        if (this.headNode == null){
            headNode = new Node(value, null);
            return;
        }

        Node tempNode = this.headNode;

        while (tempNode.ref != null) {
            tempNode = tempNode.ref;
        }

        tempNode.ref = new Node(value, null);
    }

    public void insert(int index, Integer value) {
        int count = 0;

        if (index == 0) {
            this.headNode = new Node(value, this.headNode);
            return;
        }

        Node tempNode = this.headNode;

        while (count < index - 1) {
            if (tempNode == null) return;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null) return;

        tempNode.ref = new Node(value, tempNode.ref);
    }

    public void delete(int index) {
        if (this.headNode == null) return;
        if (index == 0) {
            this.headNode = headNode.ref;
            return;
        }

        int count = 0;
        Node tempNode = this.headNode;

        while (count < index - 1) {
            if (tempNode == null) return;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null || tempNode.ref == null) return;

        Node nextNode = tempNode.ref;
        tempNode.ref = nextNode.ref;

    }

    public Integer valueAtIndex(int index) {
        if(this.headNode == null) return null;

        int count = 0;
        Node tempNode = this.headNode;

        while(count < index) {
            if(tempNode == null) return null;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null) return null;

        return tempNode.value;
    }

    public void reverseListIteratively() {
        Node prevNode = null;
        Node currentNode = this.headNode;
        Node nextNode;

        while(currentNode != null) {
            nextNode = currentNode.ref;
            currentNode.ref = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        this.headNode = prevNode;
    }

    public void reverseListRecursively(Node currentNode) {
        if (currentNode.ref == null) {
            this.headNode = currentNode;
            return;
        }

        reverseListRecursively(currentNode.ref);
        Node tempNode = currentNode.ref;
        tempNode.ref = currentNode;
        currentNode.ref = null;
    }

    public Node getHeadNode() {
        return this.headNode;
    }

    public void printListRecursively(Node printNode) {
        if (printNode == null) return;

        System.out.println(printNode.value);
        printListRecursively(printNode.ref);
    }

    public void printReversedListRecursively(Node printNode) {
        if (printNode == null) return;

        printReversedListRecursively(printNode.ref);
        System.out.println(printNode.value);
    }

}
