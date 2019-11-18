package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;
import be.technifutur.devmob.sudoku.utils.ValueSet;

public class Sudoku4x4Factory {
    public static Sudoku4x4 getSudokuModel() {
        Sudoku4x4 model = new Sudoku4x4();
        ValueSet[] sets = new ValueSet[12];
        for(int i = 0; i < 12; i++) {
            sets[i] = new ValueSet(4);
        }
        for(int i = 0; i < 16; i++) {
            Cellule cell = new Cellule();
            // ROW
            cell.addValueSet(sets[(int) Math.floor((double) i / 4)]);
            // COLUMN
            cell.addValueSet(sets[(i % 4) + 4]);
            // SECTOR
            cell.addValueSet(sets[(((int) Math.floor((double) i / 8) * 2) + (int) Math.floor((double) (i % 4) / 2)) + 8]);
            model.setCellule(new Position4x4(i), cell);
        }
        return model;
    }

    public static Sudoku4x4Vue getSudokuView(Sudoku4x4 model, User user) {
        Sudoku4x4Vue view = new Sudoku4x4Vue(model);
        view.setUser(user);
        return view;
    }

    public static Sudoku4x4Controller getSudoku4x4(User user) {
        Sudoku4x4 model = getSudokuModel();
        return new Sudoku4x4Controller(model, getSudokuView(model, user));
    }

    public static Sudoku4x4Controller getSudoku4x4() {
        Sudoku4x4 model = getSudokuModel();
        return new Sudoku4x4Controller(model, getSudokuView(model, new UserConsole()));
    }
}
