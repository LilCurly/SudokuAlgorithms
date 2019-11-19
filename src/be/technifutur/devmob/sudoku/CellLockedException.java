package be.technifutur.devmob.sudoku;

public class CellLockedException extends SudokuException {

    public CellLockedException() {
        super("This cell is locked, it cannot be modified");
    }
}
