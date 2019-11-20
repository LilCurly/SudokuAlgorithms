package be.technifutur.devmob.sudoku.sudokuEtoile;

public class PositionEtoile {
    private int pos;
    private int row;
    private int col;

    public PositionEtoile(int pos) {
        this.pos = pos;
    }

    public PositionEtoile(int row, int col) {
        setPos(row, col);
    }

    private void setPos(int row, int col) {
        // CASE 1
        if(row >= 0 && row <= 5) {
            this.pos = ((row * 18) + col) - ((int) Math.floor(col / 12) * 3);
        }
        // CASE 2
        else if(row >= 6 && row <= 8) {
            this.pos = ((row * 18) + (2 * (int) Math.ceil(row / 7))) + col;
        }
        // CASE 3
        else if(row >= 9 && row <= 11) {
            this.pos = ((row * 9) + 90) + (col - 6);
        }
        // CASE 4
        else if(row >= 12 && row <= 14) {
            this.pos = (((row * 20) - 42) + (row % 12)) + col;
        }
        // CASE 5
        else if(row >= 15 && row <= 20) {
            this.pos = (((row * 18) - 9) + col) - ((col / 12) * 3);
        }
    }

    public int getPos() {
        return pos;
    }
}
