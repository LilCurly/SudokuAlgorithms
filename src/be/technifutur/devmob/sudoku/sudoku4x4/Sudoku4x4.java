package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.Cellule;

public class Sudoku4x4 {
    public static final char EMPTY = '.';
    private Cellule[] values = new Cellule[16];
    private boolean locked;

    public Sudoku4x4() {
        locked = false;
    }

    public void setCellule(Position4x4 p, Cellule c) {
        values[p.getPos()] = c;
    }

    public Cellule getCellule(Position4x4 p) {
        return values[p.getPos()];
    }

    public boolean add(Position4x4 p, char val) {
        boolean result = false;
        if(val >= '1' && val <= '4') {
            result = values[p.getPos()].setValue(val);
        }
        return result;
    }

    public char get(Position4x4 p) {
        return values[p.getPos()].getValue();
    }

    public boolean isComplete() {
        boolean result = true;
        for(Cellule c : values) {
            if(c.getValue() == EMPTY) result = false;
        }
        return result;
    }

    public Cellule[] getValues() {
        return this.values;
    }

//    public void delete(Position4x4 p) {
//        values[p.getPos()] = EMPTY;
//    }
    public void lock() {
        locked = true;
        for(Cellule c : values) {
            if(c.getValue() != EMPTY) c.lock();
        }
    }

    public boolean isLocked() {
        return locked;
    }
}
