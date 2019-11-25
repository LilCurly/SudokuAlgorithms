package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudoku;

public class Sudoku4x4 extends AbstractSudoku {

    public Sudoku4x4() {
        super(16);
    }

    @Override
    public boolean isValid(char val) {
        return val >= '1' && val <= '4';
    }

    @Override
    public int size() {
        return 16;
    }
}
