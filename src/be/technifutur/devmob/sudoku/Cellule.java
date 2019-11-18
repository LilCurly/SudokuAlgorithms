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

    public boolean setValue(char value) {
        boolean result = canBeSet(value);
        if(result) {
            this.value = value;
            for(ValueSet vsItem : this.vs) {
                vsItem.add(value);
            }
        }
        return result;
    }

    private boolean canBeSet(char value) {
        boolean result = isModifiable;
        int index = 0;
        while(result && index < vs.size()) {
            result = !this.vs.get(index).contains(value);
            index += 1;
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
