package be.technifutur.devmob.sudoku.sudoku4x4;

public class Sudoku4x4 {
    public static final char EMPTY = 0;
    private Position4x4[][] values = new Position4x4[4][4];

    public Sudoku4x4() {
        initiate();
    }

    public void initiate() {
        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values.length; j++) {
                values[i][j] = add(new Position4x4(i, j), EMPTY);
            }
        }
    }

    public Position4x4 add(Position4x4 p, char val) {

        return p;
    }
}
