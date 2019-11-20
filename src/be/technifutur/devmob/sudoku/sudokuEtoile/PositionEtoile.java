package be.technifutur.devmob.sudoku.sudokuEtoile;

import be.technifutur.devmob.sudoku.PositionInvalidException;

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

    public static boolean isValid(int row, int col) throws PositionInvalidException {
        boolean result = col >= 0 && col <= 20 && row >= 0 && row <= 20;
        // CASE 1
        if(result && row >= 0 && row <= 5) {
            result = col < 9 || col > 11;
        }
        // CASE 2
        else if(result && row >= 6 && row <= 8) {
            result = true;
        }
        // CASE 3
        else if(result && row >= 9 && row <= 11) {
            result = col > 5 && col < 15;
        }
        // CASE 4
        else if(result && row >= 12 && row <= 14) {
            result = true;
        }
        // CASE 5
        else if(result && row >= 15 && row <= 20) {
            result = col < 9 || col > 11;
        }
        if(!result) {
            throw new PositionInvalidException(row+1, col+1);
        }
        return result;
    }

    private void setPos(int row, int col) {
        // CASE 1
        if(row >= 0 && row <= 5) {
            this.pos = ((row * 18) + col) - ((int) Math.floor(col / 12) * 3);
        }
        // CASE 2
        else if(row >= 6 && row <= 8) {
            this.pos = (((row * 20) - 12) + (row % 6)) + col;
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
