package Stack;

class Node {
    int value;
    Node ref;

    Node(int value, Node ref) {
        this.value = value;
        this.ref = ref;
    }
}

public class LinkedListStack {

    private Node top;

    public void push(int value) {
        Node newHeadNode = new Node(value, null);
        if (this.top == null) {
            this.top = newHeadNode;
            return;
        }

        newHeadNode.ref = this.top;
        this.top = newHeadNode;
    }

    public int pop() {
        if (this.top == null) return -1;

        int returnValue = this.top.value;
        this.top = top.ref;

        return returnValue;
    }

    public int top() {
        return this.top.value;
    }

    public Boolean isEmpty() {
        return this.top == null;
    }
}
