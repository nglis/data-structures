package Stack;

public class EvaluateExpressions {

    // Only works with single digit numbers
    public int evaluatePostfix(String expression) {
        LinkedListStack linkedListStack = new LinkedListStack();

        char[] chars = expression.toCharArray();

        for (char c : chars) {
            if (c == '-' || c == '+' || c == '/' || c == '*') {
                int op2 = linkedListStack.pop();
                int op1 = linkedListStack.pop();

                if (c == '-') {
                    linkedListStack.push(op1 - op2);
                } else if (c == '+') {
                    linkedListStack.push(op1 + op2);
                } else if (c == '/') {
                    linkedListStack.push(op1 / op2);
                } else {
                    linkedListStack.push(op1 * op2);
                }
            } else {
                linkedListStack.push(Character.getNumericValue(c));
            }
        }
        return linkedListStack.top();
    }

    public int evaluatePrefix(String expression) {
        LinkedListStack linkedListStack = new LinkedListStack();

        char[] chars = expression.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == '-' || c == '+' || c == '/' || c == '*') {
                int op1 = linkedListStack.pop();
                int op2 = linkedListStack.pop();

                if (c == '-') {
                    linkedListStack.push(op1 - op2);
                } else if (c == '+') {
                    linkedListStack.push(op1 + op2);
                } else if (c == '/') {
                    linkedListStack.push(op1 / op2);
                } else {
                    linkedListStack.push(op1 * op2);
                }
            } else {
                linkedListStack.push(Character.getNumericValue(c));
            }
        }
        return linkedListStack.top();
    }

}
