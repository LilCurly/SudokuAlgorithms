package be.technifutur.devmob.sudoku.sudoku9x9;

public class Position9x9 {
    private int pos;

    public Position9x9(int pos) {
        this.pos = pos;
    }

    public Position9x9(int col, int row) {
        setPos(col, row);
    }

    private void setPos(int col, int row) {
        this.pos = col + (row * 9);
    }

    public int getPos() {
        return this.pos;
    }

    public int getRow() {
        return (int) Math.floor(this.pos / 9);
    }

    public int getCol() {
        return this.pos % 9;
    }

    public int getRowSector() {
        return (int) Math.floor(this.pos / 27);
    }

    public int getColSector() {
        return (int) Math.floor(getCol() / 3);
    }

    public int getSector() {
        return getColSector() + (getRowSector() * 3);
    }

    public static boolean isValid(int pos) {
        boolean result = true;
        if(pos < 0 || pos >= 81) {
            result = false;
        }
        return result;
    }

    public static boolean isValid(int col, int row) {
        boolean result = true;
        if((col < 0 || col >= 9) || (row < 0 || row >= 9)) {
            result = false;
        }
        return result;
    }
}
