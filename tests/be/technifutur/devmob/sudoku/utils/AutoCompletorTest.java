package be.technifutur.devmob.sudoku.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoCompletorTest {

    /*
        Test N°1 : Testing if generatePossibleValues() generates an array of 1 char that is '1'
     */
    @Test
    void testGeneratePossibleValuesReturnsArrayOfOneCharThatIs1() {
        char[] vals = AutoCompletor.generatePossibleValues(1);
        assertEquals(1, vals.length);
        assertEquals('1', vals[0]);
    }
}