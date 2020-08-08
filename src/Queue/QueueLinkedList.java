package Queue;

class Node {

    int value;
    Node ref;

    Node(int value, Node ref) {
        this.value = value;
        this.ref = ref;
    }
}

public class QueueLinkedList {

    private Node front;
    private Node rear;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value) {
        Node tempNode = new Node(value, null);
        if(isEmpty()) {
            this.front = tempNode;
            this.rear = this.front;
        } else {
            this.rear.ref = tempNode;
            this.rear = this.rear.ref;
        }
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int returnValue = this.front.value;
        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.ref;
        }
        return returnValue;
    }

    public int top() {
        return this.front.value;
    }

    public Boolean isEmpty() {
        return this.front == null && this.rear == null;
    }

    public void printAll() {
        Node tempNode = this.front;
        while(tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.ref;
        }
    }

}
