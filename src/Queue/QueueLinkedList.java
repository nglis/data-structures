package Queue;

class Node<T> {

    T data;
    Node ref;

    Node(T data, Node ref) {
        this.data = data;
        this.ref = ref;
    }

    public String toString() {
        return this.data.toString();
    }

    public T getData() {
        return data;
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

    public String dequeue() {
        if (isEmpty()) return "-1";
        String returnValue = this.front.toString();
        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.ref;
        }
        return returnValue;
    }

    public String top() {
        return this.front.toString();
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
