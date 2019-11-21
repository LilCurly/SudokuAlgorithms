package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.SudokuStructuresConsole;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudokuEtoile.SudokuEtoile;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;

public class AbstractSudokuView {
    private StringBuilder sb;
    private User user;
    private SudokuStructures struct;
    private VisualSudoku model;

    public AbstractSudokuView(VisualSudoku model) {
        this.user = new UserConsole();
        this.model = model;
        this.struct = new SudokuStructuresConsole(model);
        update();
    }

    public void update() {
        this.sb = struct.getStructure();
    }

    public void showTitle() {
        if(this.model instanceof Sudoku4x4) {
            System.out.println("Sudoku 4x4");
        }
        else if(this.model instanceof Sudoku9x9) {
            System.out.println("Sudoku 9x9");
        }
        else if(this.model instanceof SudokuEtoile) {
            System.out.println("Sudoku Etoile");
        }
        else {
            System.out.println("Sudoku");
        }
    }

    public void showSudoku() {
        System.out.println(sb.toString());
    }

    public void separator() {
        System.out.println("---------------------");
    }

    public void show(String message) {
        user.show(message);
    }

    public String prompt(String message) {
        return user.prompt(message);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
