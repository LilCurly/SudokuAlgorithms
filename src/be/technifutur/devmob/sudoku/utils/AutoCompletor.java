package be.technifutur.devmob.sudoku.utils;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;

public class AutoCompletor {
    public static void complete(Sudoku4x4 model) {

    }

    public static char[] generatePossibleValues(int length) {
        char[] vals = new char[length];
        for(int i = 0; i < vals.length; i++) {
            vals[i] = Character.forDigit(i+1, 10);
        }
        return vals;
    }
}
