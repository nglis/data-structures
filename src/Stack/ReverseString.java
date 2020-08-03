package Stack;

public class ReverseString {

    // Reverse a string using a linked list
    public String ReverseStringStack(String str) {
        LinkedListStack linkedListStack =  new LinkedListStack();
        char[] stringCharacters = str.toCharArray();

        for (char c : stringCharacters) {
            linkedListStack.push(c);
        }

        String reversedString = "";

        while(!linkedListStack.isEmpty()) {
            reversedString += (char) linkedListStack.pop();
        }

        return reversedString;
    }
}
