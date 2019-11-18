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
}