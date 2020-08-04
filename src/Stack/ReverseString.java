package Stack;

public class ReverseString {

    // Reverse a string using a linked list
    public String ReverseStringStack(String str) {
        LinkedListStack linkedListStack =  new LinkedListStack();
        char[] stringCharacters = str.toCharArray();
        int characterCount = stringCharacters.length;

        for (char c : stringCharacters) {
            linkedListStack.push(c);
        }

        char[] charsReversed = new char[characterCount];

        for (int i = 0; i < charsReversed.length; i++) {
            charsReversed[i] = (char) linkedListStack.pop();
        }

        return new String(charsReversed);
    }
}
