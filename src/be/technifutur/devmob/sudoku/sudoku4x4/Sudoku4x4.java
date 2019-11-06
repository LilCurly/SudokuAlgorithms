package be.technifutur.devmob.sudoku.sudoku4x4;

public class Sudoku4x4 {
    private char[][] values = new char[4][4];

    public Sudoku4x4() {
        initiate();
    }

    public void initiate() {
        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values.length; j++) {
                values[i][j] = '0';
            }
        }
    }

    public void add(Position4x4 p, char val) {

    }
}
