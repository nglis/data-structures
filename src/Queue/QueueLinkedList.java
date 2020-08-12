package Queue;

class Node<T> {

    T value;
    Node ref;

    Node(T value, Node ref) {
        this.value = value;
        this.ref = ref;
    }

    int getInt() {
        try {
            return Integer.parseInt(this.value.toString());
        } catch (Exception e) {
            System.out.println("Error");
        }
        return -1;
    }
}

public class QueueLinkedList<T> {

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
        int returnValue = this.front.getInt();
        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.ref;
        }
        return returnValue;
    }

    public int top() {
        return this.front.getInt();
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
