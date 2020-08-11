package TestModule;

import BinarySearchTree.BinarySearchTree;
import DynamicIntegerList.DynamicIntegerList;
import Queue.QueueArray;
import Queue.QueueLinkedList;
import SinglyLinkedList.SinglyLinkedList;
import DoublyLinkedList.DoublyLinkedList;
import Stack.Stack;
import Stack.ReverseString;
import Stack.LinkedListStack;
import Stack.EvaluateExpressions;
import Stack.BalancedParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestModule {

    @Test
    void EvaluateBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 10);
        assertTrue(bst.search(bst.root, 10));
        bst.root = bst.insert(bst.root, 5);
        assertEquals(1, bst.height(bst.root));
        bst.root = bst.insert(bst.root, 15);
        bst.root = bst.insert(bst.root, 12);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 25);
        assertTrue(bst.search(bst.root, 15));
        assertTrue(bst.search(bst.root, 10));
        assertTrue(bst.search(bst.root, 20));
        assertFalse(bst.search(bst.root, 19));
        assertFalse(bst.search(bst.root, 1));
        assertFalse(bst.search(bst.root, 30));
        assertEquals(5, bst.min(bst.root));
        assertEquals(25, bst.max(bst.root));
        assertEquals(3, bst.height(bst.root));
//        bst.preOrderTraversal(bst.root); // 10, 5, 15, 12, 20, 25
//        bst.inOrderTraversal(bst.root); // 5, 10, 12, 15, 20, 25
//        bst.postOrderTraversal(bst.root); //5, 12, 25, 20, 15, 10
    }

    @org.junit.jupiter.api.Test
    void EvaluateQueueLinkedList() {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        assertTrue(queueLinkedList.isEmpty());
        queueLinkedList.enqueue(1);
        queueLinkedList.enqueue(2);
        queueLinkedList.enqueue(3);
//        queueLinkedList.printAll();
        assertEquals(1, queueLinkedList.top());
        assertEquals(1, queueLinkedList.dequeue());
        assertEquals(2, queueLinkedList.dequeue());
        assertEquals(3, queueLinkedList.dequeue());
        assertEquals(-1, queueLinkedList.dequeue());
        assertTrue(queueLinkedList.isEmpty());
//        queueLinkedList.printAll();
    }

    @org.junit.jupiter.api.Test
    void EvaluateQueueArray() {
        QueueArray queueArray = new QueueArray();
        assertTrue(queueArray.isEmpty());
        queueArray.enqueue(5);
        assertEquals(5, queueArray.front());
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(20);
        assertEquals(5, queueArray.front());
        assertEquals(5, queueArray.dequeue());
        assertEquals(10, queueArray.dequeue());
        assertEquals(20, queueArray.dequeue());
        queueArray.enqueue(10);
        assertEquals(30, queueArray.dequeue());
        assertEquals(20, queueArray.front());
        assertFalse(queueArray.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void EvaluateExpressionStack() {
        EvaluateExpressions evaluateExpressions = new EvaluateExpressions();
        assertEquals(2, evaluateExpressions.evaluatePostfix("11+"));
        assertEquals(17, evaluateExpressions.evaluatePostfix("23*54*+9-"));
        assertEquals(2, evaluateExpressions.evaluatePrefix("+11"));
        assertEquals(17, evaluateExpressions.evaluatePrefix("-+*23*549"));
        assertEquals("12+", evaluateExpressions.infixToPostfix("1+2"));
        assertEquals("ABC*+DE*-", evaluateExpressions.infixToPostfix("A+B*C-D*E"));
        assertEquals("AB+C*D-E*", evaluateExpressions.infixToPostfix("((A+B)*C-D)*E"));
        assertEquals("ABC+*", evaluateExpressions.infixToPostfix("A*(B+C)"));

    }

    @org.junit.jupiter.api.Test
    void BalancedParenthesesStack() {
        BalancedParentheses balancedParentheses = new BalancedParentheses();
        assertTrue(balancedParentheses.balancedParenthesesStack("{}"));
        assertTrue(balancedParentheses.balancedParenthesesStack(""));
        assertFalse(balancedParentheses.balancedParenthesesStack("}"));
        assertTrue(balancedParentheses.balancedParenthesesStack("(())"));
        assertFalse(balancedParentheses.balancedParenthesesStack("())"));
        assertTrue(balancedParentheses.balancedParenthesesStack("{([])}"));
        assertFalse(balancedParentheses.balancedParenthesesStack("[{]}"));
        assertFalse(balancedParentheses.balancedParenthesesStack("{(])}]"));
        assertTrue(balancedParentheses.balancedParenthesesStack("{Test}(Test[Test])[]{(Test)}"));
    }

    @org.junit.jupiter.api.Test
    void reverseStringStack() {
        ReverseString reverseString = new ReverseString();
        assertEquals("olleh", reverseString.reverseStringStack("hello"));
        assertEquals("race car", reverseString.reverseStringStack("rac ecar"));
        assertEquals("", reverseString.reverseStringStack(""));
    }

    @org.junit.jupiter.api.Test
    void testLinkedListStack() {
        LinkedListStack stack = new LinkedListStack();
        assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.top());
        stack.pop();
        assertEquals(1, stack.top());
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testStack() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.top());
        stack.pop();
        stack.push(6);
        assertEquals(6, stack.top());
        assertFalse(stack.isEmpty());
//        stack.print();
//        System.out.println(stack.stack[0]);
//        System.out.println(stack.stack[4]);
//        System.out.println(stack.stack.length);
    }

    @org.junit.jupiter.api.Test
    void testDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtHead(3);
        doublyLinkedList.insertAtHead(2);
        doublyLinkedList.insertAtHead(1);
        doublyLinkedList.insertAtTail(4);
        doublyLinkedList.insertAtTail(5);
        doublyLinkedList.delete(1);
        doublyLinkedList.delete(0);
//        doublyLinkedList.printListIteratively();
//        doublyLinkedList.printReversedListIteratively();
//        doublyLinkedList.printReversedListRecursively(doublyLinkedList.getHeadNode());
    }

    @org.junit.jupiter.api.Test
    void testSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        assertNull(singlyLinkedList.valueAtIndex(0));
        assertNull(singlyLinkedList.valueAtIndex(1));
        singlyLinkedList.add(10);
        singlyLinkedList.delete(0);
        assertNull(singlyLinkedList.valueAtIndex(0));
        assertNull(singlyLinkedList.valueAtIndex(1));

        singlyLinkedList.insert(2, 10);
        assertNull(singlyLinkedList.valueAtIndex(0));
        assertNull(singlyLinkedList.valueAtIndex(1));
        assertNull(singlyLinkedList.valueAtIndex(2));
        assertNull(singlyLinkedList.valueAtIndex(3));

        //singlyLinkedList.insert(0, 10);
        singlyLinkedList.add(10);
        assertEquals(10, singlyLinkedList.valueAtIndex(0));
        assertNull(singlyLinkedList.valueAtIndex(1));
        singlyLinkedList.delete(0);

        singlyLinkedList.add(10);
        assertEquals(10, singlyLinkedList.valueAtIndex(0));
        assertNull(singlyLinkedList.valueAtIndex(1));

        singlyLinkedList.add(20);
        assertEquals(10, singlyLinkedList.valueAtIndex(0));
        assertEquals(20, singlyLinkedList.valueAtIndex(1));
        assertNull(singlyLinkedList.valueAtIndex(2));
        assertNull(singlyLinkedList.valueAtIndex(3));

        singlyLinkedList.add(30);
        singlyLinkedList.add(40);
        assertEquals(30, singlyLinkedList.valueAtIndex(2));

        singlyLinkedList.delete(2);
        assertEquals(40, singlyLinkedList.valueAtIndex(2));

        singlyLinkedList.insert(2, 30);
        assertEquals(10, singlyLinkedList.valueAtIndex(0));
        assertEquals(20, singlyLinkedList.valueAtIndex(1));
        assertEquals(30, singlyLinkedList.valueAtIndex(2));
        assertEquals(40, singlyLinkedList.valueAtIndex(3));

        singlyLinkedList.reverseListIteratively();
        assertEquals(40, singlyLinkedList.valueAtIndex(0));
        assertEquals(30, singlyLinkedList.valueAtIndex(1));
        assertEquals(20, singlyLinkedList.valueAtIndex(2));
        assertEquals(10, singlyLinkedList.valueAtIndex(3));


        singlyLinkedList.reverseListIteratively();
        //singlyLinkedList.printListRecursively(singlyLinkedList.getHeadNode());

        singlyLinkedList.reverseListRecursively(singlyLinkedList.getHeadNode());
        //singlyLinkedList.printListRecursively(singlyLinkedList.getHeadNode());
        //singlyLinkedList.printReversedListRecursively(singlyLinkedList.getHeadNode());
    }

    @org.junit.jupiter.api.Test
    void testDynamicIntegerList() {
        DynamicIntegerList dynamicIntegerList = new DynamicIntegerList();
        assertEquals(0, dynamicIntegerList.length());

        dynamicIntegerList.add(10);
        assertEquals(1, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertNull(dynamicIntegerList.getNumAtIndex(1));
        assertEquals(1, dynamicIntegerList.length());

        dynamicIntegerList.add(20);
        assertEquals(2, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(20, dynamicIntegerList.getNumAtIndex(1));
        assertEquals(2, dynamicIntegerList.length());

        dynamicIntegerList.add(30);
        assertEquals(3, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(20, dynamicIntegerList.getNumAtIndex(1));
        assertEquals(30, dynamicIntegerList.getNumAtIndex(2));
        assertEquals(3, dynamicIntegerList.length());

        dynamicIntegerList.add(40);
        dynamicIntegerList.add(50);
        dynamicIntegerList.add(60);
        dynamicIntegerList.add(70);
        assertEquals(7, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(40, dynamicIntegerList.getNumAtIndex(3));
        assertEquals(70, dynamicIntegerList.getNumAtIndex(6));

        dynamicIntegerList.delete(6);
        assertEquals(6, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(40, dynamicIntegerList.getNumAtIndex(3));
        assertEquals(60, dynamicIntegerList.getNumAtIndex(5));
        assertNull(dynamicIntegerList.getNumAtIndex(6));
        assertNull(dynamicIntegerList.getNumAtIndex(7));

        dynamicIntegerList.delete(0);
        dynamicIntegerList.delete(2);

        dynamicIntegerList.insert(4, 80);

        //dynamicIntegerList.printAll();
    }
}