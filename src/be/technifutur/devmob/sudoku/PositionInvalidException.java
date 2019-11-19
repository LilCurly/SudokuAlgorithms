package be.technifutur.devmob.sudoku;

public class PositionInvalidException extends SudokuException {
    public PositionInvalidException(int row, int col) {
        super(String.format("Position is invalid : row should be between 1 and 4 (but was %d), col should be between 1 and 4 (but was %d)", row, col));
    }
}
