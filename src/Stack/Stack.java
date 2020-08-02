package Stack;

public class Stack {

    private int MAX_SIZE = 1;
    private int[] stack = new int[MAX_SIZE];
    private int top = -1;

    public void push(int value) {
        if(this.top == this.stack.length - 1) {
            int newStackSize;
            newStackSize = this.stack.length * 2;

            int[] newStack = new int[newStackSize];
            for (int i = 0; i <= top; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack;
        }
        this.stack[++this.top] = value;
    }

    public void pop() {
        if (this.top <= -1) return;
        this.top--;
    }

    public int top() {
        return this.stack[this.top];
    }

    public Boolean isEmpty() {
        return this.top <= -1;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(this.stack[i]);
        }
    }

}
