package be.technifutur.devmob.sudoku.sudoku4x4;

public class Position4x4 {
    private int pos;

    public Position4x4(int num) {
        this.pos = num;
    }

    public Position4x4(int col, int row) {
        setPos(col, row);
    }

    private void setPos(int col, int row) {
        this.pos = col + (row * 4);
    }

    public int getCol() {
        return pos % 4;
    }

    public int getRow() {
        return (int) Math.ceil(pos / 4);
    }

    public int getSector() {
        return getColSector() + (getRowSector() * 2);
    }

    public int getRowSector() {
        return (int) Math.floor(pos / 8);
    }

    public int getColSector() {
        return (int) Math.floor(getCol() / 2);
    }

    public int getPos() {
        return pos;
    }
}