package be.technifutur.devmob.sudoku.sudoku9x9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sudoku9x9Test {

    /*
        Testing if the sudoku 9x9 is instantiated with empty values
     */
    @Test
    void testSudokuEmptyAfterInitiation() {
        Sudoku9x9 s = new Sudoku9x9();
        char[] vals = s.getValues();
        for(char v : vals) {
            assertEquals(Sudoku9x9.EMPTY, v, String.format("Should be empty but got %s", v));
        }
    }

    /*
        Testing if the sudoku 9x9 got values that was added
     */
    @Test
    void testSudokuGotValuesAfterAddingValidValues() {
        Sudoku9x9 s = new Sudoku9x9();
        assertTrue(s.add(new Position9x9(0,0), '5'));
        assertTrue(s.add(new Position9x9(2,3), '1'));
        assertTrue(s.add(new Position9x9(8,8), '9'));
        assertEquals('5' ,s.getValues()[0], String.format("Should be 5 but got %s", s.getValues()[0]));
        assertEquals('1' ,s.getValues()[29], String.format("Should be 1 but got %s", s.getValues()[29]));
        assertEquals('9' ,s.getValues()[80], String.format("Should be 9 but got %s", s.getValues()[80]));
    }

    /*
        Testing if the sudoku 9x9 does not get values that was added but was not valid
     */
    @Test
    void testSudokuDoesNotGetValuesAfterAddingNonValidValues() {
        Sudoku9x9 s = new Sudoku9x9();
        assertFalse(s.add(new Position9x9(0, 0), '0'));
        assertEquals(Sudoku9x9.EMPTY, s.getValues()[0], String.format("Should be empty but got %s", s.getValues()[0]));
    }

    /*
        Testing if isComplete() returns false while all the squares of the sudoku are not complete
     */
    @Test
    void testIsCompleteReturnsFalseWhenSudokuIsNotComplete() {
        Sudoku9x9 s = new Sudoku9x9();
        s.add(new Position9x9(0), '1');
        assertFalse(s.isComplete());
    }

    /*
        Testing if isComplete() returns true when all the squares of the sudoku are complete
     */
    @Test
    void testIsCompleteReturnsTrueWhenSudokuIsComplete() {
        Sudoku9x9 s = new Sudoku9x9();
        for(int i = 0; i <= 80; i++) {
            s.add(new Position9x9(i), '1');
        }
        assertTrue(s.isComplete());
    }

    /*
        Testing if get() returns the value at the given position
     */
    @Test
    void testGetReturnsValueAtGivenPosition() {
        Sudoku9x9 s = new Sudoku9x9();
        Position9x9 pos = new Position9x9(50);
        s.add(pos, '5');
        assertEquals('5', s.get(pos), String.format("Should be 5 but got %s", s.get(pos)));
        assertEquals(Sudoku9x9.EMPTY, s.get(new Position9x9(0)), String.format("Should be empty but got %s", s.get(new Position9x9(0))));
    }

    /*
        Testing if delete() deletes the value at a given position and sets it back to empty
     */
    @Test
    void testDeleteSetsBackTheGivenPositionToEmpty() {
        Sudoku9x9 s = new Sudoku9x9();
        Position9x9 pos = new Position9x9(35);
        s.add(pos, '9');
        assertEquals('9', s.get(pos), String.format("Should be 9 but got %s", s.get(pos)));
        s.delete(pos);
        assertEquals(Sudoku9x9.EMPTY, s.get(pos), String.format("Should be empty but got %s", s.get(pos)));
    }

    /*
        Testing if delete() does not change anything if the value at the given position was already empty
     */
    @Test
    void testDeleteDoesNotChangeIfAlreadyEmpty() {
        Sudoku9x9 s = new Sudoku9x9();
        Position9x9 pos = new Position9x9(35);
        assertEquals(Sudoku9x9.EMPTY, s.get(pos), String.format("Should be empty but got %s", s.get(pos)));
        s.delete(pos);
        assertEquals(Sudoku9x9.EMPTY, s.get(pos), String.format("Should be empty but got %s", s.get(pos)));
    }
}