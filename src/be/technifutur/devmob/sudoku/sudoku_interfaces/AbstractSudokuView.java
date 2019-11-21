package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;

public abstract class AbstractSudokuView {
    private StringBuilder sb;
    private User user;

    public AbstractSudokuView() {
        this.user = new UserConsole();
    }

    public abstract void update();

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

    public void setStringBuilder(StringBuilder sb) {
        this.sb = sb;
    }

    public StringBuilder getStringBuilder() {
        return this.sb;
    }
}
