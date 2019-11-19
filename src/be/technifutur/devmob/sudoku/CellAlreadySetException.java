package be.technifutur.devmob.sudoku;

public class CellAlreadySetException extends SudokuException {
    public CellAlreadySetException(int row, int col) {
        super(String.format("Cell at row %d and col %d is already set. Try updating it", row, col));
    }
}
