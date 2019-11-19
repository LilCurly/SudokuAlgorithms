package be.technifutur.devmob.sudoku;

public class PositionInvalidException extends SudokuException {
    public PositionInvalidException(int row, int col) {
        super(String.format("Position is invalid : row should be between 1 and 4 (but was %d), col should be between 1 and 4 (but was %d)", row, col));
    }

    public PositionInvalidException(int pos) {
        super(String.format("Position is invalid : pos should be between 1 and 16 (but was %d)", pos));
    }
}
