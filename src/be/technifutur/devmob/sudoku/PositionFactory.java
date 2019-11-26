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

    public static Position get(UpdatableSudoku model, int num) {
        if (model instanceof Sudoku4x4) {
            return new Position4x4(num);
        }
        else if(model instanceof Sudoku9x9) {
            return new Position9x9(num);
        }
        return null;
    }

    public static boolean isValid(UpdatableSudoku model, int col, int row) throws PositionInvalidException {
        boolean result = false;
        if (model instanceof Sudoku4x4) {
            result = true;
            if ((col < 0 || col >= 4) || (row < 0 || row >= 4)) {
                throw new PositionInvalidException(row, col, 4);
            }
        }
        else if (model instanceof Sudoku9x9) {
            result = true;
            if((col < 0 || col >= 9) || (row < 0 || row >= 9)) {
                throw new PositionInvalidException(col, row, 9);
            }
        }
        return result;
    }
}
