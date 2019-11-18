package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.Cellule;
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
}
