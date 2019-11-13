package be.technifutur.devmob.sudoku.utils;

public class ValueSet {
    private int data;

    public ValueSet() {
        this.data = 0;
    }

    public boolean isEmpty() {
        return this.data == 0;
    }

    public boolean add(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if (!contains(val)) {
            data |= 1 << intVal;
            result = true;
        }
        return result;
    }

    public boolean contains(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if ((data >> intVal & 1) == 1) {
            result = true;
        }
        return result;
    }

    public boolean delete(char val) {
        int intVal = Character.getNumericValue(val) - 1;
        boolean result = false;
        if (contains(val)) {
            data ^= 1 << intVal;
            result = true;
        }
        return result;
    }
}
