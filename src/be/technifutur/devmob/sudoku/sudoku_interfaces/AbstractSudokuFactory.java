package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.sudoku4x4.Position4x4;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Vue;
import be.technifutur.devmob.sudoku.sudoku9x9.Position9x9;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9Vue;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;
import be.technifutur.devmob.sudoku.utils.ValueSet;

public class AbstractSudokuFactory {
    public static AbstractSudoku getSudokuModel(SudokuType type) {
        AbstractSudoku model = null;
        ValueSet[] sets;
        switch (type) {
            case SUDOKU_4_4:
                model = new Sudoku4x4();
                sets = new ValueSet[12];
                for (int i = 0; i < 12; i++) {
                    sets[i] = new ValueSet(4);
                }
                for (int i = 0; i < 16; i++) {
                    Cellule cell = new Cellule();
                    // ROW
                    cell.addValueSet(sets[(int) Math.floor((double) i / 4)]);
                    // COLUMN
                    cell.addValueSet(sets[(i % 4) + 4]);
                    // SECTOR
                    cell.addValueSet(sets[(((int) Math.floor((double) i / 8) * 2) + (int) Math.floor((double) (i % 4) / 2)) + 8]);
                    model.setCellule(new Position4x4(i), cell);
                }
                break;
            case SUDOKU_9_9:
                model = new Sudoku9x9();
                sets = new ValueSet[27];
                for(int i = 0; i < 27; i++) {
                    sets[i] = new ValueSet(9);
                }
                for(int i = 0; i < 81; i++) {
                    Cellule cell = new Cellule();
                    // ROW
                    cell.addValueSet(sets[(int) Math.floor((double) i / 9)]);
                    // COLUMN
                    cell.addValueSet(sets[(i % 9) + 9]);
                    // SECTOR
                    cell.addValueSet(sets[(((int) Math.floor((double) i / 27) * 3) + (int) Math.floor((double) (i % 9) / 3)) + 18]);
                    model.setCellule(new Position9x9(i), cell);
                }
                break;
        }

        return model;
    }

    public static AbstractSudokuView getSudokuView(AbstractSudoku model, User user) {
        AbstractSudokuView view = null;
        if (model instanceof Sudoku4x4) {
            view = new Sudoku4x4Vue(model);
        }
        else if (model instanceof Sudoku9x9) {
            view = new Sudoku9x9Vue(model);
        }
        if (view != null) {
            view.setUser(user);
        }
        return view;
    }

    public static AbstractSudokuController getSudoku(SudokuType type, User user) {
        AbstractSudoku model = getSudokuModel(type);
        return new AbstractSudokuController(model, getSudokuView(model, user));
    }

    public static AbstractSudokuController getSudoku(SudokuType type) {
        AbstractSudoku model = getSudokuModel(type);
        return new AbstractSudokuController(model, getSudokuView(model, new UserConsole()));
    }
}
