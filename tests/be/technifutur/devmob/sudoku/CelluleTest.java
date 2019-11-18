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
}