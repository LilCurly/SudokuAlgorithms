package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.utils.ValueSet;

import java.util.ArrayList;
import java.util.List;

public class Cellule {
    private char value;
    private boolean isModifiable;
    private List<ValueSet> vs;

    public Cellule() {
        value = Sudoku4x4.EMPTY;
        isModifiable = true;
        vs = new ArrayList<>();
    }

    public char getValue() {
        return value;
    }

    public boolean setValue(char value) throws SudokuException {
        boolean result = canBeSet(value);
        if(result) {
            this.value = value;
            for(ValueSet vsItem : this.vs) {
                vsItem.add(value);
            }
        }
        return result;
    }

    public boolean updateValue(char value) throws SudokuException {
        boolean result = canBeSet(value);
        if(result && this.value != Sudoku4x4.EMPTY) {
            for(ValueSet vsItem : this.vs) {
                vsItem.delete(this.value);
                vsItem.add(value);
            }
            this.value = value;
        }
        else result = false;
        return result;
    }

    public boolean deleteValue() throws SudokuException {
        if(!isModifiable) {
            throw new CellLockedException();
        }
        boolean result = true;
        int index = 0;
        while(result && index < vs.size()) {
            result = vs.get(index).delete(this.value);
            index++;
        }
        if(result) {
            this.value = Sudoku4x4.EMPTY;
        }
        return result;
    }

    private boolean canBeSet(char value) throws SudokuException {
        boolean result = isModifiable;
        if(!isModifiable) {
            throw new CellLockedException();
        }
        int index = 0;
        while(result && index < vs.size()) {
            result = !this.vs.get(index).contains(value);
            index += 1;
        }
        if(!result) {
            throw new ValueAlreadyDefinedException(Character.getNumericValue(value));
        }
        return result;
    }

    public void addValueSet(ValueSet vs) {
        this.vs.add(vs);
    }

    public List<ValueSet> getValueSet() {
        return this.vs;
    }

    public void lock() {
        this.isModifiable = false;
    }

    public boolean isLocked() {
        return !isModifiable;
    }
}
