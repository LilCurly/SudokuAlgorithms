package be.technifutur.devmob.sudoku.sudokuEtoile;

import be.technifutur.devmob.sudoku.PositionInvalidException;
import be.technifutur.devmob.sudoku.SudokuException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionEtoileTest {

    /*
        Test N°1 : Testing if getPos() returns the correct value that was given
     */
    @Test
    void testGetPosReturnsGivenValue() {
        PositionEtoile p = new PositionEtoile(10);
        assertEquals(10, p.getPos(), String.format("Pos 10 should give Pos 10 but got %d", p.getPos()));
    }

    /*
        Test N°2 : Testing if getPos() returns the correct value from a given row and column (0, 0)
     */
    @Test
    void testGetPosReturnsCorrectValueFromRowCol() {
        PositionEtoile p = new PositionEtoile(0, 0);
        assertEquals(0, p.getPos(), String.format("Row 0 Col 0 should give Pos 0 but got %d", p.getPos()));
    }

    /*
        Test N°3 : Testing if getPos() returns the expected value for a more complex given row and column
     */
    @Test
    void testGetPostReturnsExpectedValueForComplexRowCol() {
        // Testing case 1
        PositionEtoile p = new PositionEtoile(2, 4);
        assertEquals(40, p.getPos());
        PositionEtoile p2 = new PositionEtoile(5, 17);
        assertEquals(104, p2.getPos());
        // Testing case 2
        PositionEtoile p3 = new PositionEtoile(6, 0);
        assertEquals(108, p3.getPos());
        PositionEtoile p4 = new PositionEtoile(8, 10);
        assertEquals(160, p4.getPos());
        // Testing case 3
        PositionEtoile p5 = new PositionEtoile(9, 6);
        assertEquals(171, p5.getPos());
        PositionEtoile p6 = new PositionEtoile(11, 10);
        assertEquals(193, p6.getPos());
        // Testing case 4
        PositionEtoile p7 = new PositionEtoile(12, 0);
        assertEquals(198, p7.getPos());
        PositionEtoile p8 = new PositionEtoile(14, 10);
        assertEquals(250, p8.getPos());
        // Testing case 5
        PositionEtoile p9 = new PositionEtoile(15, 0);
        assertEquals(261, p9.getPos());
        PositionEtoile p10 = new PositionEtoile(18, 17);
        assertEquals(329, p10.getPos());
        PositionEtoile p11 = new PositionEtoile(20, 20);
        assertEquals(368, p11.getPos());
    }

    /*
        Test N°4 : Testing if isValid() returns true for valid row and column
     */
    @Test
    void testIsValidReturnsTrueForValidRowCol() throws SudokuException {
        // Testing case 1
        assertTrue(PositionEtoile.isValid(0, 0));
        assertTrue(PositionEtoile.isValid(3, 16));
        // Testing case 2
        assertTrue(PositionEtoile.isValid(6, 10));
        assertTrue(PositionEtoile.isValid(8, 18));
        // Testing case 3
        assertTrue(PositionEtoile.isValid(9, 6));
        assertTrue(PositionEtoile.isValid(11, 14));
        // Testing case 4
        assertTrue(PositionEtoile.isValid(12, 0));
        assertTrue(PositionEtoile.isValid(14, 10));
        // Testing case 5
        assertTrue(PositionEtoile.isValid(15, 0));
        assertTrue(PositionEtoile.isValid(18, 16));
        assertTrue(PositionEtoile.isValid(20, 20));
    }

    /*
        Test N°5 : Testing if isValid() throws a PositionInvalidException when position for given row and column is not valid
     */
    @Test
    void testIsValidThrowsPositionInvalidExceptionWhenPositionForGivenRowAndColumnIsInvalid() {
        // Out of bound
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(0, 21));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(21, 21));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(-1, 9));
        // Testing case 1
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(0, 9));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(4, 10));
        // Testing case 3
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(9, 0));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(11, 4));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(10, 18));
        // Testing case 5
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(15, 9));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(17, 10));
        assertThrows(PositionInvalidException.class, () -> PositionEtoile.isValid(20, 11));
    }
}