package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudokuView;
import be.technifutur.devmob.sudoku.sudoku_interfaces.VisualSudoku;

public class Sudoku4x4Vue extends AbstractSudokuView {
    private VisualSudoku model;

    public Sudoku4x4Vue(VisualSudoku model) {
        this.model = model;
        update();
    }

    public void update() {
        setStringBuilder(new StringBuilder());
        StringBuilder sb = getStringBuilder();
        sb.append(              "+------+------+\n");
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(0)), model.get(new Position4x4(1)), model.get(new Position4x4(2)), model.get(new Position4x4(3))));
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(4)), model.get(new Position4x4(5)), model.get(new Position4x4(6)), model.get(new Position4x4(7))));
        sb.append(              "+------+------+\n");
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(8)), model.get(new Position4x4(9)), model.get(new Position4x4(10)), model.get(new Position4x4(11))));
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(12)), model.get(new Position4x4(13)), model.get(new Position4x4(14)), model.get(new Position4x4(15))));
        sb.append(              "+------+------+\n");
    }
}
