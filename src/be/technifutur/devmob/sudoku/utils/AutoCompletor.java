package be.technifutur.devmob.sudoku.utils;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.SudokuException;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudoku;

public class AutoCompletor {
    public static void complete(AbstractSudoku model) {
        Cellule[] cells = model.getValues();
        char[] vals = generatePossibleValues((int) Math.sqrt(cells.length));
        for(int i = 0; i < cells.length; i++) {
            int index = 0;
            boolean repeat = true;
            while(repeat) {
                try {
                    repeat = !cells[i].setValue(vals[index]);
                } catch (SudokuException e) {
                    System.out.println(e.getMessage());
                    repeat = true;
                }
                index++;
            }
        }
    }

    public static void complete(Sudoku9x9 model) {
        Cellule[] cells = model.getValues();
        char[] vals = generatePossibleValues((int) Math.sqrt(cells.length));
        for(int i = 0; i < cells.length; i++) {
            int index = 0;
            boolean repeat = true;
            while(repeat) {
                try {
                    repeat = !cells[i].setValue(vals[index]);
                } catch (SudokuException e) {
                    System.out.println(e.getMessage());
                    repeat = true;
                }
                index++;
            }
        }
    }

    public static char[] generatePossibleValues(int length) {
        char[] vals = new char[length];
        for(int i = 0; i < vals.length; i++) {
            vals[i] = Character.forDigit(i+1, 10);
        }
        return vals;
    }
}
