package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudoku4x4.Position4x4;
import be.technifutur.devmob.sudoku.sudoku_interfaces.SudokuStructures;
import be.technifutur.devmob.sudoku.sudoku_interfaces.VisualSudoku;

public class SudokuStructuresConsole extends SudokuStructures {

    public SudokuStructuresConsole(VisualSudoku model) {
        super(model);
    }

    @Override
    protected StringBuilder buildEtoile() {
        StringBuilder sb = new StringBuilder();
        sb.append("+---------+---------+---------+         +---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+         +---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+---------+---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+---------+---------+---------+---------+\n");
        sb.append("                    | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("                    | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("                    | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+---------+---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+---------+---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+         +---------+---------+---------+\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("| %s  %s  %s | %s  %s  %s | %s  %s  %s |         | %s  %s  %s | %s  %s  %s | %s  %s  %s |\n");
        sb.append("+---------+---------+---------+         +---------+---------+---------+\n");
        return sb;
    }

    @Override
    protected StringBuilder build9x9() {
        VisualSudoku model = getModel();
        int offset = 0;
        Character[] values = new Character[9];
        StringBuilder sb = new StringBuilder();
        sb.append("+---------+---------+---------+\n");
        for(int i = 0; i < 12; i++) {
            if(i % 4 != 3) {
                for(int j = 0; j < 9; j++) {
                    values[j] = model.get(new Position4x4(j + offset));
                }
                sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", values));
                offset += 9;
            }
            else {
                sb.append("+---------+---------+---------+\n");
            }
        }
        return sb;
    }

    @Override
    protected StringBuilder build4x4() {
        VisualSudoku model = getModel();
        int offset = 0;
        Character[] values = new Character[4];
        StringBuilder sb = new StringBuilder();
        sb.append("+------+------+\n");
        for(int i = 0; i < 6; i++) {
            if(i % 3 != 2) {
                for(int j = 0; j < 4; j++) {
                    values[j] = model.get(new Position4x4(j + offset));
                }
                sb.append(String.format("| %s  %s | %s  %s |\n", values));
                offset += 4;
            }
            else {
                sb.append("+------+------+\n");
            }
        }
        return sb;
    }
}
