package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.sudoku4x4.Position4x4;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;
import be.technifutur.devmob.sudoku.utils.ValueSet;

public class Sudoku9x9Factory {
    public static Sudoku9x9 getSudokuModel() {
        Sudoku9x9 model = new Sudoku9x9();
        ValueSet[] sets = new ValueSet[27];
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
        return model;
    }

    public static Sudoku9x9Vue getSudokuView(Sudoku9x9 model, User user) {
        Sudoku9x9Vue view = new Sudoku9x9Vue(model);
        view.setUser(user);
        return view;
    }

    public static Sudoku9x9Controller getSudoku9x9(User user) {
        Sudoku9x9 model = getSudokuModel();
        return new Sudoku9x9Controller(model, getSudokuView(model, user));
    }

    public static Sudoku9x9Controller getSudoku9x9() {
        Sudoku9x9 model = getSudokuModel();
        return new Sudoku9x9Controller(model, getSudokuView(model, new UserConsole()));
    }
}
