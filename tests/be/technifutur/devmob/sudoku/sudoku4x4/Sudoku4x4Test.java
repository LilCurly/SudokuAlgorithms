package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.CellLockedException;
import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.SudokuException;
import be.technifutur.devmob.sudoku.ValueAlreadyDefinedException;
import be.technifutur.devmob.sudoku.utils.AutoCompletor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sudoku4x4Test {

    /*
        Test N°1 : Testing if creating a new instance of Sudoku4x4 creates an array with empty cells
     */
    @Test
    void testCellsEmptyAfterCreatingNewSudoku4x4Instance() {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Cellule[] values = s.getValues();
        for(Cellule c : values) {
            assertEquals(Sudoku4x4.EMPTY, c.getValue());
        }
    }

    /*
        Test N°2 : Testing if every Cells in the Sudoku4x4 Model got 3 ValueSet
     */
    @Test
    void testEveryCellsGot3ValueSet() {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Cellule[] values = s.getValues();
        for(Cellule c : values) {
            assertEquals(3, c.getValueSet().size());
        }
    }

    /*
        Test N°3 : Testing if adding a new value that is correct at a given Position4x4 correctly adds it to the values array
     */
    @Test
    void testAddingCorrectValueAtPositionAddsValueToArray() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 p = new Position4x4(5);
        assertTrue(s.add(p, '1'));
        assertEquals('1', s.get(p));
    }

    /*
        Test N°4 : Testing if adding a new value that is not correct at a given Position4x4 doesn't add it to the values array
     */
    @Test
    void testAddingNotCorrectValueAtPositionDoesNotAddValueToArray() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 p = new Position4x4(5);
        boolean isAdded = false;
        isAdded = s.add(p, 'z');
        assertFalse(isAdded);
        assertEquals(Sudoku4x4.EMPTY, s.get(p));
    }

    /*
        Test N°5 : Testing if getting the value at a given Position returns the correct value
     */
    @Test
    void testGetValueReturnsTheCorrectValue() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 pos = new Position4x4(10);
        s.add(pos, '3');
        assertEquals('3', s.get(pos));
    }

    /*
        Test N°6 : Testing if isComplete() returns false when the sudoku is not full yet
     */
    @Test
    void testIsCompleteReturnsFalseWhenTheSudokuIsNotFull() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        s.add(new Position4x4(10), '2');
        assertFalse(s.isComplete());
    }

    /*
        Test N°7 : Testing if isComplete() returns true when the sudoky is full
     */
    @Test
    void testIsCompleteReturnsTrueWhenTheSudokuIsFull() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        AutoCompletor.complete(s);
        assertTrue(s.isComplete());
    }

    /*
        Test N°8 : Testing if delete() deletes the value at the given position and sets it back to an empty value
     */
    @Test
    void testDeleteSetsBackValueToEmpty() throws CellLockedException, ValueAlreadyDefinedException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 p = new Position4x4(9);
        s.add(p, '2');
        assertEquals('2', s.get(p), String.format("Should get 2 but got %s", s.get(p)));
        s.delete(p);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should get empty but got %s", s.get(p)));
    }

    /*
        Test N°9 : Testing if delete() on an empty value does not change the value
     */
    @Test
    void testDeleteDoesNotChangeEmptyValue() {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 p = new Position4x4(2);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should be empty but got %s", s.get(p)));
        s.delete(p);
        assertEquals(Sudoku4x4.EMPTY, s.get(p), String.format("Should be empty but got %s", s.get(p)));
    }

    /*
        Test N°10 : Testing if update() updates the value at of the cell at a given Position
     */
    @Test
    void testUpdateUpdatesTheValueOfCellAtGivenPosition() throws SudokuException {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        Position4x4 p = new Position4x4(2);
        s.add(p, '2');
        assertEquals('2', s.get(p));
        s.update(p, '3');
        assertEquals('3', s.get(p));
    }

    /*
        Test N°11 : Testing if isLocked is false when the model is created
     */
    @Test
    void testIsLockedFalseWhenModelCreated() {
        Sudoku4x4 s = Sudoku4x4Factory.getSudokuModel();
        assertFalse(s.isLocked());
    }
}