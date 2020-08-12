package Queue;

class Node<T> {
    T data;
    Node ref;

    Node(T data, Node ref) {
        this.data = data;
        this.ref = ref;
    }
}

public class QueueLinkedList<T> {

    private Node front;
    private Node rear;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data) {
        Node tempNode = new Node(data, null);
        if(isEmpty()) {
            this.front = tempNode;
            this.rear = this.front;
        } else {
            this.rear.ref = tempNode;
            this.rear = this.rear.ref;
        }
    }

    public Object dequeue() {
        if (isEmpty()) return null;
        Object returnValue = this.front.data;
        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.ref;
        }
        return returnValue;
    }

    public Object top() {
        return this.front.data;
    }

    public Boolean isEmpty() {
        return this.front == null && this.rear == null;
    }

    public void printAll() {
        Node tempNode = this.front;
        while(tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.ref;
        }
    }

}
