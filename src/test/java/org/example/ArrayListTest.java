package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {
    @Test
    @DisplayName("Add 100 elements")
    void testAdd() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

    @Test
    @DisplayName("Add 2 elements and insert the 3rd element between them")
    void testAddAtIndex() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");
        assertEquals(3, list.size());
        assertEquals("B", list.get(1));
    }

    @Test
    @DisplayName("Add 3 elements and get the 2nd")
    void testGet() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.get(1));
    }

    @Test
    @DisplayName("Add 5 elements and remove the 3rd")
    void testRemove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.remove(2);
        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    @DisplayName("Add 100 elements and clear")
    void testClear() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Add 100 numbers as String in reverse and sort")
    void testSortIntegers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            list.add(i);
        }
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i + 1), list.get(i));
        }
    }


    @Test
    @DisplayName("Add letters as String in reverse and sort")
    void testSortStrings() {
        List<String> list = new ArrayList<>();
        for (char chr = 'z'; chr >= 'a'; chr--) {
            list.add(String.valueOf(chr));
        }
        list.sort(Comparator.naturalOrder());
        int i = 0;
        for (char chr = 'a'; chr <= 'z'; chr++) {
            assertEquals(String.valueOf(chr), list.get(i++));
        }
    }

    @Test
    @DisplayName("Replace 2nd element")
    void testReplace() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.replace(1, "B");
        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Add element til 100 and check size")
    void testSize() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
            assertEquals(i + 1, list.size());
        }
    }
}