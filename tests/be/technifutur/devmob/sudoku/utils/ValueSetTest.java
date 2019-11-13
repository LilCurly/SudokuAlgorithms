package be.technifutur.devmob.sudoku.utils;

import com.sun.jdi.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueSetTest {
    /*
        Testing if creating a new instance of ValueSet gives an empty data
     */
    @Test
    void testIsDataEmptyWhenObjectCreated() {
        ValueSet set = new ValueSet();
        assertTrue(set.isEmpty());
    }

    /*
        Testing if data is not empty after adding a new value
     */
    @Test
    void testNotEmptyAfterAddingNewValue() {
        ValueSet set = new ValueSet();
        assertTrue(set.add('1'));
        assertFalse(set.isEmpty());
    }

    /*
        Testing if adding the two same values returns true the first time but false the second time
     */
    @Test
    void testAddingTwoValuesReturnsFalseSecondTime() {
        ValueSet set = new ValueSet();
        assertTrue(set.add('1'));
        assertFalse(set.add('1'));
    }

    /*
        Testing if contains() returns false when the ValueSet does not contain the value
     */
    @Test
    void testContainsReturnsFalseWhenValueSetDoesNotContainValue() {
        ValueSet set = new ValueSet();
        assertFalse(set.contains('2'));
    }

    /*
        Testing if contains() returns true when the ValueSet contains the value
     */
    @Test
    void testContainsReturnsTrueWhenValueSetContainsValue() {
        ValueSet set = new ValueSet();
        set.add('2');
        assertTrue(set.contains('2'));
    }

    /*
        Testing if deleting a value that does not exist returns false
     */
    @Test
    void testDeletingReturnsFalseWhenValueDoesNotExist() {
        ValueSet set = new ValueSet();
        assertFalse(set.delete('3'));
    }

    /*
        Testing if deleting a value that exists returns true
     */
    @Test
    void testDeletingValueThatExistsReturnsTrue() {
        ValueSet set = new ValueSet();
        set.add('3');
        assertTrue(set.delete('3'));
    }

    /*
        Testing if deleting a value that exists deletes the correct value
     */
    @Test
    void testDeletingValueThatExistsDeletesCorrectValue() {
        ValueSet set = new ValueSet();
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
}