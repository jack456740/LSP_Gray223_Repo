package org.howard.edu.lsp.assignment6;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty(), "Set should be empty after calling clear");
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        assertEquals(0, set1.length(), "Newly created set should have length 0");
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length(), "Set should have length 2 after adding two elements");
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2), "Sets with the same elements should be equal");
        set2.add(3);
        assertFalse(set1.equals(set2), "Sets with different elements should not be equal");
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        set1.add(5);
        assertTrue(set1.contains(5), "Set should contain element 5");
        assertFalse(set1.contains(3), "Set should not contain element 3");
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() {
        set1.add(10);
        set1.add(3);
        set1.add(7);
        try {
            assertEquals(10, set1.largest(), "Largest element should be 10");
        } catch (Exception e) {
            fail("Exception should not be thrown when finding largest in a non-empty set");
        }

        set1.clear();
        assertThrows(Exception.class, () -> set1.largest(), "Exception should be thrown for largest() on empty set");
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() {
        set1.add(10);
        set1.add(3);
        set1.add(7);
        try {
            assertEquals(3, set1.smallest(), "Smallest element should be 3");
        } catch (Exception e) {
            fail("Exception should not be thrown when finding smallest in a non-empty set");
        }

        set1.clear();
        assertThrows(Exception.class, () -> set1.smallest(), "Exception should be thrown for smallest() on empty set");
    }

    @Test
    @DisplayName("Test case for add()")
    public void testAdd() {
        set1.add(1);
        set1.add(2);
        set1.add(1);  // duplicate add, should not increase size
        assertEquals(2, set1.length(), "Set should have length 2 after adding 1 and 2, and ignoring duplicate 1");
        assertTrue(set1.contains(1) && set1.contains(2), "Set should contain elements 1 and 2");
    }

    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1), "Set should not contain element 1 after removal");
        assertTrue(set1.contains(2), "Set should still contain element 2");
        set1.remove(3);  // removing non-existent element, no effect
        assertEquals(1, set1.length(), "Removing a non-existent element should not change set length");
    }

    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2) && set1.contains(3), "Union should contain elements 1, 2, and 3");
        assertEquals(3, set1.length(), "Union should result in set length of 3");
    }

    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2), "Intersection should only contain common element 2");
        assertEquals(1, set1.length(), "Intersection should result in set length of 1");
    }

    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.diff(set2);
        assertTrue(set1.contains(1), "Difference should contain element 1 only");
        assertFalse(set1.contains(2), "Difference should not contain element 2");
        assertEquals(1, set1.length(), "Difference should result in set length of 1");
    }

    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        List<Integer> universalSet = List.of(1, 2, 3, 4);
        set1.add(2);
        set1.add(3);
        IntegerSet complementSet = set1.complement(universalSet);
        assertTrue(complementSet.contains(1) && complementSet.contains(4), "Complement should contain elements 1 and 4");
        assertFalse(complementSet.contains(2) || complementSet.contains(3), "Complement should not contain elements 2 and 3");
        assertEquals(2, complementSet.length(), "Complement should result in set length of 2");
    }

    @Test
    @DisplayName("Test case for isEmpty()")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty(), "Newly created set should be empty");
        set1.add(1);
        assertFalse(set1.isEmpty(), "Set should not be empty after adding an element");
    }

    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        set1.add(1);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString(), "toString should return '[1, 2]' for set containing 1 and 2");
    }
}
