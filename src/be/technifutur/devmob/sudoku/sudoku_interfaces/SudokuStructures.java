package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudokuEtoile.SudokuEtoile;

public abstract class SudokuStructures {
    private VisualSudoku model;

    public SudokuStructures (VisualSudoku model) {
        this.model = model;
    }

    public StringBuilder getStructure() {
        StringBuilder sb = null;
        if(model instanceof Sudoku4x4) {
            sb = build4x4();
        }
        else if(model instanceof Sudoku9x9) {
            sb = build9x9();
        }
        else if(model instanceof SudokuEtoile) {
            sb = buildEtoile();
        }
        return sb;
    }

    public VisualSudoku getModel() {
        return model;
    }

    protected abstract StringBuilder buildEtoile();
    protected abstract StringBuilder build9x9();
    protected abstract StringBuilder build4x4();
}
