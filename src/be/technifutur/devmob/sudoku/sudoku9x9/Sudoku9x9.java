package be.technifutur.devmob.sudoku.sudoku9x9;

public class Sudoku9x9 {
    public static final char EMPTY = '.';
    private char[] values = new char[9*9];

    public Sudoku9x9() {
        initiate();
    }

    public void initiate() {
        for(int i = 0; i < values.length; i++) {
            values[i] = EMPTY;
        }
    }

    public char[] getValues() {
        return values;
    }

    public boolean add(Position9x9 p, char value) {
        boolean result = true;
        if(value > '0' && value <= '9') {
            values[p.getPos()] = value;
        }
        else result = false;
        return result;
    }

    public boolean isComplete() {
        boolean result = true;
        int index = 0;
        while(result && index <= 80) {
            if(values[index] == EMPTY) {
                result = false;
            }
            index++;
        }
        return result;
    }

    public char get(Position9x9 p) {
        return values[p.getPos()];
    }

    public void delete(Position9x9 p) {
        values[p.getPos()] = EMPTY;
    }
}
