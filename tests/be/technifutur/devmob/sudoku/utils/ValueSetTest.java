package be.technifutur.devmob.sudoku.utils;

import com.sun.jdi.Value;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ValueSetTest {
    /*
        Testing if creating a new instance of ValueSet gives an empty data
     */
    @Test
    void testIsDataEmptyWhenObjectCreated() {
        ValueSet set = new ValueSet(9);
        assertTrue(set.isEmpty());
    }

    /*
        Testing if data is not empty after adding a new value
     */
    @Test
    void testNotEmptyAfterAddingNewValue() {
        ValueSet set = new ValueSet(9);
        assertTrue(set.add('1'));
        assertFalse(set.isEmpty());
    }

    /*
        Testing if adding the two same values returns true the first time but false the second time
     */
    @Test
    void testAddingTwoValuesReturnsFalseSecondTime() {
        ValueSet set = new ValueSet(9);
        assertTrue(set.add('1'));
        assertFalse(set.add('1'));
    }

    /*
        Testing if contains() returns false when the ValueSet does not contain the value
     */
    @Test
    void testContainsReturnsFalseWhenValueSetDoesNotContainValue() {
        ValueSet set = new ValueSet(9);
        assertFalse(set.contains('2'));
    }

    /*
        Testing if contains() returns true when the ValueSet contains the value
     */
    @Test
    void testContainsReturnsTrueWhenValueSetContainsValue() {
        ValueSet set = new ValueSet(9);
        set.add('2');
        assertTrue(set.contains('2'));
    }

    /*
        Testing if deleting a value that does not exist returns false
     */
    @Test
    void testDeletingReturnsFalseWhenValueDoesNotExist() {
        ValueSet set = new ValueSet(9);
        assertFalse(set.delete('3'));
    }

    /*
        Testing if deleting a value that exists returns true
     */
    @Test
    void testDeletingValueThatExistsReturnsTrue() {
        ValueSet set = new ValueSet(9);
        set.add('3');
        assertTrue(set.delete('3'));
    }

    /*
        Testing if deleting a value that exists deletes the correct value
     */
    @Test
    void testDeletingValueThatExistsDeletesCorrectValue() {
        ValueSet set = new ValueSet(9);
        set.add('5');
        set.add('4');
        assertTrue(set.contains('5'));
        assertTrue(set.contains('4'));
        set.delete('4');
        assertTrue(set.contains('5'));
        assertFalse(set.contains('4'));
        set.delete('5');
        assertFalse(set.contains('5'));
    }

    /*
        Testing if ValueSetIterator hasNext() returns false when there is no value
     */
    @Test
    void testIteratorHasNextReturnsFalseWhenNoValue() {
        ValueSet set = new ValueSet(9);
        Iterator iterator = set.iterator();
        assertFalse(iterator.hasNext());
    }

    /*
        Testing if ValueSetIterator hasNext() returns true when there is one value
     */
    @Test
    void testIteratorHasNextReturnsTrueWhenOneValue() {
        ValueSet set = new ValueSet(9);
        set.add('5');
        Iterator iterator = set.iterator();
        assertTrue(iterator.hasNext());
    }

    /*
        Testing if ValueSetIterator next() returns null when there is no values
     */
    @Test
    void testIteratorNextReturnsFalseWhenNoValue() {
        ValueSet set = new ValueSet(9);
        Iterator iterator = set.iterator();
        assertNull(iterator.next());
    }

    /*
        Testing if ValueSetIterator next() returns the correct value when there is one value
     */
    @Test
    void testIteratorNextReturnsCorrectValueWhenThereIsOne() {
        ValueSet set = new ValueSet(9);
        Iterator iterator = set.iterator();
        assertNull(iterator.next());
        set.add('5');
        assertEquals(5, iterator.next());
    }

    /*
        Testing if ValueSetIterator hasNext() returns true when there is two or more values
     */
    @Test
    void testIteratorHasNextReturnsTrueWhenMoreThanOneValue() {
        ValueSet set = new ValueSet(9);
        set.add('1');
        set.add('6');
        Iterator iterator = set.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1 ,iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6 ,iterator.next());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    /*
        Testing if size() returns 0 when there is no values
     */
    @Test
    void testSizeReturns0WhenThereIsNoValues() {
        ValueSet set = new ValueSet(9);
        assertEquals(0, set.size());
    }

    /*
        Testing if size() returns a value > 0 when there is more than one value
     */
    @Test
    void testSizeReturnsValueGreaterThan0IfThereIsMoreThanOneValue() {
        ValueSet set = new ValueSet(9);
        set.add('1');
        assertEquals(1, set.size());
        set.add('4');
        assertEquals(2, set.size());
        set.add('9');
        assertEquals(3, set.size());
    }
}