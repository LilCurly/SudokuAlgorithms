package be.technifutur.devmob.sudoku.utils;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Factory;
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

    /*
        Test N°2 : Testing if generatePossibleValues() generates an array of char values that goes from '1' to the given length
     */
    @Test
    void testGeneratePossibleValuesReturnsArrayOfCharFrom1ToLength() {
        char[] vals = AutoCompletor.generatePossibleValues(4);
        assertEquals(4, vals.length);
        assertEquals('1', vals[0]);
        assertEquals('2', vals[1]);
        assertEquals('3', vals[2]);
        assertEquals('4', vals[3]);
    }

    /*
        Test N°3 : Testing if complete() is able to complete a 4x4 Sudoku
     */
    @Test
    void testCompleteIsAbleToComplete4x4Sudoku() {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        AutoCompletor.complete(s);
        assertTrue(s.isComplete());
    }
}