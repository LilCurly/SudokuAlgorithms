package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.*;

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

    public boolean add(Position4x4 p, char val) throws SudokuException {
        boolean result = false;
        if(values[p.getPos()].getValue() != EMPTY) {
            throw new CellAlreadySetException(p.getRow(), p.getCol());
        }
        if(val >= '1' && val <= '4') {
            result = values[p.getPos()].setValue(val);
        }
        else {
            throw new ValueOutOfBoundException(val, 4);
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

    public boolean delete(Position4x4 p) {
        return values[p.getPos()].deleteValue();
    }

    public boolean update(Position4x4 p, char val) throws SudokuException {
        boolean result = false;
        if(this.values[p.getPos()].getValue() == EMPTY) {
            throw new CellNotSetException(p.getRow(), p.getCol());
        }
        if(val >= '1' && val <= '4') {
            result = values[p.getPos()].updateValue(val);
        }
        else {
            throw new ValueOutOfBoundException(4, val);
        }
        return result;
    }

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
