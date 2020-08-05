package Stack;

public class BalancedParentheses {

    public Boolean balancedParenthesesStack(String input) {
        LinkedListStack linkedListStack = new LinkedListStack();

        char[] inputChars = input.toCharArray();

        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] == '(' || inputChars[i] == '{' || inputChars[i] == '[') {
                linkedListStack.push(inputChars[i]);
            }
            else if (inputChars[i] == ')' || inputChars[i] == '}' || inputChars[i] == ']') {
                if (linkedListStack.isEmpty()) return false;

                if(inputChars[i] == ')' && linkedListStack.top() != '(') {
                    return false;
                }
                if(inputChars[i] == '}' && linkedListStack.top() != '{') {
                    return false;
                }
                if(inputChars[i] == ']' && linkedListStack.top() != '[') {
                    return false;
                }
                linkedListStack.pop();
            }
        }

        return linkedListStack.isEmpty();
    }

}
