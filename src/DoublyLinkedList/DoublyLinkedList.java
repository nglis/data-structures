package DoublyLinkedList;

class Node {
    Integer value;
    Node prev;
    Node next;

    Node(Integer value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

public class DoublyLinkedList {

    private Node headNode = null;

    public Node getHeadNode() {
        return this.headNode;
    }

    public void insertAtHead(Integer value) {
        Node newHeadNode = new Node(value, null, this.headNode);
        this.headNode = new Node(value, null, this.headNode);

        // Alternatively

        // Node newHeadNode = new Node(value, null, null);
        // if (this.headNode == null) {
        // this.headNode = newHeadNode;
        // return;
        // }

        // this.headNode.prev = newHeadNode;
        // newHeadNode.next = this.headNode;
        // this.headNode = newHeadNode;
    }

    public void insertAtTail(Integer value) {
        if (this.headNode == null) {
            this.headNode = new Node(value, null, null);
        }

        Node tempNode = this.headNode;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = new Node(value, tempNode, null);
    }

    public void printListIteratively() {
        Node tempNode = this.headNode;

        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void printReversedListRecursively(Node tempNode) {
        if (tempNode == null) return;

        printReversedListRecursively(tempNode.next);
        System.out.println(tempNode.value);
    }

    /* public void delete(int index) {
        Node tempNode = headNode;
        int count = 0;

        while (count < index) {
            tempNode = tempNode.next;
            count++;
        }

        Node prevNode = tempNode.prev;
        prevNode.next = tempNode.next;
    } */

}
