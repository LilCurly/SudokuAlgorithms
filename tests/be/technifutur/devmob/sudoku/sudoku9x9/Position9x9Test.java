package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.PositionInvalidException;
import be.technifutur.devmob.sudoku.SudokuException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Position9x9Test {

    /*
        Testing if getPos() returns the correct position that was given to the constructor
     */
    @Test
    void testGetPosReturnsCorrectValueFromPosGivenToConstructor() {
        Position9x9 p = new Position9x9(35);
        assertEquals(35, p.getPos(), String.format("Pos 35 should give Pos 35 but got %d", p.getPos()));
    }

    /*
        Testing if getPos() returns the correct position when Position9x9 is instantiated with a row and a column
     */
    @Test
    void testGetPosReturnsCorrectValueFromRowColGivenToConstructor() {
        Position9x9 p = new Position9x9(4, 5);
        assertEquals(49, p.getPos(), String.format("Col 4 Row 5 should give pos 49 but go %d", p.getPos()));
    }

    /*
        Testing if getRow() returns the correct row when Position9x9 is instantiated with a position
     */
    @Test
    void testGetRowReturnsCorrectRowFromPosGivenToConstructor() {
        Position9x9 p1 = new Position9x9(56);
        Position9x9 p2 = new Position9x9(19);
        Position9x9 p3 = new Position9x9(74);
        assertEquals(6, p1.getRow(), String.format("Pos 56 should give Row 6 but got %d", p1.getRow()));
        assertEquals(2, p2.getRow(), String.format("Pos 19 should give Row 2 but got %d", p2.getRow()));
        assertEquals(8, p3.getRow(), String.format("Pos 74 should give Row 8 but got %d", p3.getRow()));
    }

    /*
        Testing if getCol() returns the correct col when Position9x9 is instantiated with a position
     */
    @Test
    void testGetColReturnsCorrectColFromPosGivenToConstructor() {
        Position9x9 p1 = new Position9x9(43);
        Position9x9 p2 = new Position9x9(0);
        Position9x9 p3 = new Position9x9(80);
        assertEquals(7, p1.getCol(), String.format("Pos 43 should give Col 7 but got %d", p1.getCol()));
        assertEquals(0, p2.getCol(), String.format("Pos 0 should give Col 0 but got %d", p2.getCol()));
        assertEquals(8, p3.getCol(), String.format("Pos 80 should give Col 8 but got %d", p3.getCol()));
    }

    /*
        Testing if getRow() returns the correct row when Position9x9 is instantiated with a row and a column
     */
    @Test
    void testGetRowReturnsCorrectRowFromRowColGivenToConstructor() {
        Position9x9 p = new Position9x9(4, 5);
        assertEquals(5, p.getRow(), String.format("Col 4 Row 5 should give Row 5 but got %d", p.getRow()));
    }

    /*
        Testing if getCol() returns the correct col when Position9x9 is instantiated with a row and a column
     */
    @Test
    void testGetColReturnsCorrectColFromRowColGivenToConstructor() {
        Position9x9 p = new Position9x9(7, 4);
        assertEquals(7, p.getCol(), String.format("Col 7 Row 4 should give Col 7 but got %d", p.getCol()));
    }

    /*
        Testing if getRowSector() returns the correct Row in the form of 3x3 sectors
     */
    @Test
    void testGetRowSectorReturnsCorrectRowSector() {
        Position9x9 p1 = new Position9x9(25);
        Position9x9 p2 = new Position9x9(37);
        Position9x9 p3 = new Position9x9(59);
        assertEquals(0, p1.getRowSector(), String.format("Pos 25 should give Row Sector 0 but got %d", p1.getRowSector()));
        assertEquals(1, p2.getRowSector(), String.format("Pos 37 should give Row Sector 1 but got %d", p2.getRowSector()));
        assertEquals(2, p3.getRowSector(), String.format("Pos 59 should give Row Sector 2 but got %d", p3.getRowSector()));
    }

    /*
        Testing if getColSector() returns the correct Col in the form of 3x3 sectors
     */
    @Test
    void testGetColSectorReturnsCorrectColSector() {
        Position9x9 p1 = new Position9x9(10);
        Position9x9 p2 = new Position9x9(49);
        Position9x9 p3 = new Position9x9(70);
        assertEquals(0, p1.getColSector(), String.format("Pos 10 should give Col Sector 0 but got %d", p1.getColSector()));
        assertEquals(1, p2.getColSector(), String.format("Pos 49 should give Col Sector 1 but got %d", p2.getColSector()));
        assertEquals(2, p3.getColSector(), String.format("Pos 70 should give Col Sector 2 but got %d", p3.getColSector()));
    }

    /*
        Testing if getSector() returns the correct Sector in the form of 3x3 sectors
     */
    @Test
    void testGetSectorReturnsCorrectSector() {
        Position9x9 p1 = new Position9x9(19);
        Position9x9 p2 = new Position9x9(40);
        Position9x9 p3 = new Position9x9(80);
        assertEquals(0, p1.getSector(), String.format("Pos 19 should give Sector 0 but got %d", p1.getSector()));
        assertEquals(4, p2.getSector(), String.format("Pos 40 should give Sector 4 but got %d", p2.getSector()));
        assertEquals(8, p3.getSector(), String.format("Pos 80 should give Sector 8 but got %d", p3.getSector()));
    }

    /*
        Testing if isValid() returns false when the values are out of limits
     */
    @Test
    void testIsValidReturnsFalseWhenOutOfLimits() throws SudokuException {
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(-1));
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(81));
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(100));
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(-1, 5));
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(5, 9));
        assertThrows(PositionInvalidException.class, () -> Position9x9.isValid(-1, 9));
    }

    /*
        Testing if isValid() returns true when the values are valid
     */
    @Test
    void testIsValidReturnsTrueWhenValuesAreValid() throws SudokuException {
        assertTrue(Position9x9.isValid(0));
        assertTrue(Position9x9.isValid(80));
        assertTrue(Position9x9.isValid(30));
        assertTrue(Position9x9.isValid(0, 8));
        assertTrue(Position9x9.isValid(8, 0));
        assertTrue(Position9x9.isValid(2, 3));
    }
}