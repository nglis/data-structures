package TestModule;

import DynamicIntegerList.DynamicIntegerList;
import SinglyLinkedList.SinglyLinkedList;
import DoublyLinkedList.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TestModule {

    @org.junit.jupiter.api.Test
    void testDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtHead(3);
        doublyLinkedList.insertAtHead(2);
        doublyLinkedList.insertAtHead(1);
        doublyLinkedList.insertAtTail(4);
        doublyLinkedList.insertAtTail(5);
        doublyLinkedList.delete(1);
//        doublyLinkedList.printListIteratively();
//        doublyLinkedList.printReversedListIteratively();
        doublyLinkedList.printReversedListRecursively(doublyLinkedList.getHeadNode());
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