package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.*;

public abstract class AbstractSudoku implements UpdatableSudoku, VisualSudoku {
    private Cellule[] values;
    private boolean locked;

    public AbstractSudoku(int size) {
        this.locked = false;
        this.values = new Cellule[size];
    }

    public void setCellule(Position p, Cellule c) {
        values[p.getPos()] = c;
    }

    public Cellule getCellule(Position p) {
        return values[p.getPos()];
    }

    @Override
    public boolean add(Position p, char val) throws SudokuException {
        boolean result = false;
        if(values[p.getPos()].getValue() != VisualSudoku.EMPTY) {
            throw new CellAlreadySetException(p.getRow(), p.getCol());
        }
        if(isValid(val)) {
            result = values[p.getPos()].setValue(val);
        }
        else {
            throw new ValueOutOfBoundException(val, values.length);
        }
        return result;
    }

    @Override
    public char get(Position p) {
        return values[p.getPos()].getValue();
    }

    @Override
    public boolean isComplete() {
        boolean result = true;
        for(Cellule c : values) {
            if(c.getValue() == VisualSudoku.EMPTY) result = false;
        }
        return result;
    }

    public Cellule[] getValues() {
        return this.values;
    }

    @Override
    public boolean delete(Position p) throws SudokuException {
        boolean result = values[p.getPos()].deleteValue();
        if(!result) {
            throw new CellNotSetException(p.getRow(), p.getCol());
        }
        return result;
    }

    @Override
    public boolean update(Position p, char val) throws SudokuException {
        boolean result = false;
        if(this.values[p.getPos()].getValue() == VisualSudoku.EMPTY) {
            throw new CellNotSetException(p.getRow(), p.getCol());
        }
        if(isValid(val)) {
            result = values[p.getPos()].updateValue(val);
        }
        else {
            throw new ValueOutOfBoundException(val, 4);
        }
        return result;
    }

    public void lock() {
        locked = true;
        for(Cellule c : values) {
            if(c.getValue() != VisualSudoku.EMPTY) c.lock();
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public abstract boolean isValid(char val);
}
