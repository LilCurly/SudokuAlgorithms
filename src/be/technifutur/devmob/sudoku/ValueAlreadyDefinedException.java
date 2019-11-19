package be.technifutur.devmob.sudoku;

public class ValueAlreadyDefinedException extends SudokuException {

    private int val;

    public ValueAlreadyDefinedException(int val) {
        super(String.format("Value %d is already defined", val));
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
