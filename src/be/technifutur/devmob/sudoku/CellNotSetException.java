package be.technifutur.devmob.sudoku;

public class CellNotSetException extends SudokuException {
    public CellNotSetException(int row, int col) {
        super(String.format("Cell at row %d and col %d has no value. Try setting it to a value.", row+1, col+1));
    }
}
