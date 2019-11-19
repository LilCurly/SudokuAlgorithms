package be.technifutur.devmob.sudoku;

public class ValueOutOfBoundException extends SudokuException {

    private int val;

    public ValueOutOfBoundException(char val, int max) {
        super(String.format("Value should be between 1 and %d, but you gave %s", max, val));
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
