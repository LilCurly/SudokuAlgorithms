package be.technifutur.devmob.sudoku.sudokuEtoile;

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
        PositionEtoile p = new PositionEtoile(2, 4);
        assertEquals(40, p.getPos());
        PositionEtoile p2 = new PositionEtoile(5, 17);
        assertEquals(104, p2.getPos());
        PositionEtoile p3 = new PositionEtoile(6, 0);
        assertEquals(108, p3.getPos());
    }
}