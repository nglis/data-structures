package Queue;

public class QueueArray {
    // Uses a circular array

    private int[] arr;
    private int front;
    private int end;
    private int SIZE = 10;

    public QueueArray() {
        this.arr = new int[SIZE];
        this.front = -1;
        this.end = -1;
    }

    public void enqueue(int value) {
        if ((this.end + 1) % SIZE == this.front) {
            return;
        } else if (isEmpty()) {
            this.front = 0;
            this.end = 0;
        } else {
            this.end = (this.end + 1) % SIZE;
        }
        this.arr[this.end] = value;
    }

    public int dequeue() {
        int returnValue = this.arr[this.front];
        if (isEmpty()) {
            return -1;
        } else if (this.front == this.end) {
            this.front = -1;
            this.end = -1;
        } else {
            this.front = (this.front + 1) % SIZE;
        }
        return returnValue;
    }

    public int front() {
        if (isEmpty()) return -1;
        return this.arr[this.front];
    }

    public boolean isEmpty() {
        return this.front == -1 && this.end == -1;
    }

}
