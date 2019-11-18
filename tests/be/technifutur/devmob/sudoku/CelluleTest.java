package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.utils.ValueSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelluleTest {

    /*
        Test N°1 : Testing if adding a new ValueSet to the Cell correctly adds it to the ArrayList
     */
    @Test
    void testAddNewValueSetAddsItToArrayList() {
        Cellule cell = new Cellule();
        assertEquals(0, cell.getValueSet().size());
        cell.addValueSet(new ValueSet(4));
        assertEquals(1, cell.getValueSet().size());
    }

    /*
        Test N°2 : Testing if a value can be retrieved after being added
     */
    @Test
    void testValueCanBeRetrievedAfterBeingAdded() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        cell.setValue('1');
        assertEquals('1', cell.getValue());
    }

    /*
        Test n°3 : Testing if a value can be added once with one ValueSet
     */
    @Test
    void testValueCanBeAddedOnceWithOneValueSet() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        assertTrue(cell.setValue('1'));
    }

    /*
        Test N°4 : Testing if a value cannot be added more than once with one ValueSet
     */
    @Test
    void testValueCannotBeAddedMoreThanOnceWithOneValueSet() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        cell.setValue('2');
        assertFalse(cell.setValue('2'));
    }

    /*
        Test N°5 : Testing if a value can be added once with more than one ValueSet
     */
    @Test
    void testValueCanBeAddedOnceWithMoreThanOneValueSet() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        cell.addValueSet(new ValueSet(4));
        assertTrue(cell.setValue('3'));
    }

    /*
        Test N°6 : Testing if a value cannot be added more than once with more than one ValueSet
     */
    @Test
    void testValueCannotBeSetMoreThanOnceWithMoreThanOneValueSet() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        cell.addValueSet(new ValueSet(4));
        cell.setValue('3');
        assertFalse(cell.setValue('3'));
    }

    /*
        Test N°7 : Testing if two different values can be add
     */
    @Test
    void testTwoDifferentValuesCanBeAdded() {
        Cellule cell = new Cellule();
        cell.addValueSet(new ValueSet(4));
        cell.addValueSet(new ValueSet(4));
        assertTrue(cell.setValue('1'));
        assertTrue(cell.setValue('2'));
    }

    /*
        Test N°8 : Testing if two distinct Cells with one similar ValueSet cannot add more than once the same value
     */
    @Test
    void testTwoCellsWithSameValueSetCannotAddSameValue() {
        Cellule cell1 = new Cellule();
        Cellule cell2 = new Cellule();
        ValueSet vs = new ValueSet(4);
        cell1.addValueSet(vs);
        cell2.addValueSet(vs);
        assertTrue(cell1.setValue('2'));
        assertFalse(cell2.setValue('2'));
    }
}