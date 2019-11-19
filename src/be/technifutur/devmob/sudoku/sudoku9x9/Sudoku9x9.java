package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.*;

public class Sudoku9x9 {
    public static final char EMPTY = '.';
    private Cellule[] values = new Cellule[9*9];
    private boolean locked;

    public Sudoku9x9() {
        locked = false;
    }

    public Cellule[] getValues() {
        return values;
    }

    public Cellule getCellule(Position9x9 p) {
        return this.values[p.getPos()];
    }

    public boolean add(Position9x9 p, char value) throws SudokuException {
        boolean result = false;
        if(this.values[p.getPos()].getValue() != EMPTY) {
            throw new CellAlreadySetException(p.getRow(), p.getCol());
        }
        if(value > '0' && value <= '9') {
            result = values[p.getPos()].setValue(value);
        }
        else {
            throw new ValueOutOfBoundException(value, 9);
        }
        return result;
    }

    public boolean isComplete() {
        boolean result = true;
        for(Cellule c : this.values) {
            if(c.getValue() == EMPTY) result = false;
        }
        return result;
    }

    public char get(Position9x9 p) {
        return values[p.getPos()].getValue();
    }

    public boolean delete(Position9x9 p) throws SudokuException {
        return values[p.getPos()].deleteValue();
    }

    public void setCellule(Position9x9 p, Cellule cell) {
        this.values[p.getPos()] = cell;
    }

    public boolean update(Position9x9 p, char val) throws SudokuException {
        boolean result = false;
        if(this.values[p.getPos()].getValue() == EMPTY) {
            throw new CellNotSetException(p.getRow(), p.getCol());
        }
        if(val >= '1' && val <= '9') {
            result = values[p.getPos()].updateValue(val);
        }
        else {
            throw new ValueOutOfBoundException(val, 9);
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
