package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudoku4x4.Position4x4;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku9x9.Position9x9;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudoku_interfaces.Position;
import be.technifutur.devmob.sudoku.sudoku_interfaces.UpdatableSudoku;

public class PositionFactory {
    public static Position get(UpdatableSudoku model, int col, int row) {
        if (model instanceof Sudoku4x4) {
            return new Position4x4(col, row);
        }
        else if(model instanceof Sudoku9x9) {
            return new Position9x9(col, row);
        }
        return null;
    }
}
