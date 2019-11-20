package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudoku;

public class Sudoku9x9 extends AbstractSudoku {

    public Sudoku9x9() {
        super(81);
    }

    @Override
    public boolean isValid(char val) {
        return val >= '1' && val <= '9';
    }
}
