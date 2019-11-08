package be.technifutur.devmob.sudoku.sudoku4x4;

public class Sudoku4x4 {
    public static final char EMPTY = '.';
    private char[] values = new char[16];

    public Sudoku4x4() {
        initiate();
    }

    public void initiate() {
        for(int i = 0; i < values.length; i++) {
            values[i] = EMPTY;
        }
    }

    public boolean add(Position4x4 p, char val) {
        boolean result = true;
        return result;
    }

    public char get(Position4x4 p) {
        return values[p.getPos()];
    }

    public boolean isComplete() {
        boolean result = true;
        for(char c : values) {
            if(c == EMPTY) result = false;
        }
        return result;
    }
}
