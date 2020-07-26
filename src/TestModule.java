import static org.junit.jupiter.api.Assertions.*;

class TestModule {

    @org.junit.jupiter.api.Test
    void testDynamicIntegerList() {
        DynamicIntegerList dynamicIntegerList = new DynamicIntegerList();
        assertEquals(0, dynamicIntegerList.length());

        dynamicIntegerList.add(10);
        assertEquals(1, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertNull(dynamicIntegerList.getNumAtIndex(1));
        assertEquals(2, dynamicIntegerList.dynamicList.length);

        dynamicIntegerList.add(20);
        assertEquals(2, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(20, dynamicIntegerList.getNumAtIndex(1));
        assertEquals(2, dynamicIntegerList.dynamicList.length);

        dynamicIntegerList.add(30);
        assertEquals(3, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(20, dynamicIntegerList.getNumAtIndex(1));
        assertEquals(30, dynamicIntegerList.getNumAtIndex(2));
        assertEquals(4, dynamicIntegerList.dynamicList.length);

        dynamicIntegerList.add(40);
        dynamicIntegerList.add(50);
        dynamicIntegerList.add(60);
        dynamicIntegerList.add(70);
        assertEquals(7, dynamicIntegerList.length());
        assertEquals(10, dynamicIntegerList.getNumAtIndex(0));
        assertEquals(40, dynamicIntegerList.getNumAtIndex(3));
        assertEquals(70, dynamicIntegerList.getNumAtIndex(6));
        assertEquals(8, dynamicIntegerList.dynamicList.length);

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

        dynamicIntegerList.printAll();
    }
}