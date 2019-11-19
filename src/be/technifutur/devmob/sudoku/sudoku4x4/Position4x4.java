package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.PositionInvalidException;

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

    public static boolean isValid(int pos) throws PositionInvalidException {
        boolean result = true;
        if(pos < 0 || pos >= 16) {
            throw new PositionInvalidException(pos);
        }
        return result;
    }

    public static boolean isValid(int col, int row) throws PositionInvalidException {
        boolean result = true;
        if((col < 0 || col >= 4) || (row < 0 || row >= 4)) {
            throw new PositionInvalidException(row, col);
        }
        return result;
    }
}
