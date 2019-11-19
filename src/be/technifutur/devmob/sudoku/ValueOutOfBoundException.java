package be.technifutur.devmob.sudoku;

public class ValueOutOfBoundException extends SudokuException {

    private int val;

    public ValueOutOfBoundException(int val, int max) {
        super(String.format("Value should be between 1 and %d, but you gave %d", max, val));
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
