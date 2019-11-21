package be.technifutur.devmob.sudoku.sudokuEtoile;

import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudoku;

public class SudokuEtoile extends AbstractSudoku {

    public SudokuEtoile() {
        super(369);
    }

    @Override
    public boolean isValid(char val) {
        return val >= '1' && val <= '9';
    }
}
