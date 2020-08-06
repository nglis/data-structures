package Stack;

public class EvaluateExpressions {

    public String infixToPostfix(String expression) {
        LinkedListStack linkedListStack = new LinkedListStack();

        char[] chars = expression.toCharArray();
        String postFix = "";

        for (char c : chars) {
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                while (!linkedListStack.isEmpty() && equalOrHigherPrecedence((char) linkedListStack.top(), c)) {
                    postFix += (char) linkedListStack.pop();
                }
                linkedListStack.push(c);
            } else if (c == '(') {
                linkedListStack.push(c);
            } else if (c == ')') {
                while(!linkedListStack.isEmpty() && linkedListStack.top() != '(') {
                    postFix += (char) linkedListStack.pop();
                }
                linkedListStack.pop();
            } else {
                postFix += c;
            }
        }

        while (!linkedListStack.isEmpty()) {
            postFix += (char) linkedListStack.pop();
        }

        return postFix;
    }

    private Boolean equalOrHigherPrecedence(char a, char b) {
        return ((a == '/' || a == '*') && (b == '+' || b == '-')) ||
                ((a == '+' || a == '-') && (b == '+' || b == '-')) ||
                ((a == '/' || a == '*') && (b == '/' || b == '*'));
    }

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
