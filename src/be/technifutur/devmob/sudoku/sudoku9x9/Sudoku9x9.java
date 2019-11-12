package be.technifutur.devmob.sudoku.sudoku9x9;

public class Sudoku9x9 {
    public static final char EMPTY = '.';
    private char[] values = new char[9*9];

    public Sudoku9x9() {

    }

    public void initiate() {
        for(int i = 0; i < values.length; i++) {
            values[i] = EMPTY;
        }
    }
}
