package be.technifutur.devmob.sudoku;

public class PositionInvalidException extends SudokuException {
    public PositionInvalidException(int row, int col, int max) {
        super(String.format("Position is invalid : row should be between 1 and %d (but was %d), col should be between 1 and 4 (but was %d)", max, row+1, col+1));
    }

    public PositionInvalidException(int pos, int max) {
        super(String.format("Position is invalid : pos should be between 1 and %d (but was %d)", max, pos+1));
    }
}
