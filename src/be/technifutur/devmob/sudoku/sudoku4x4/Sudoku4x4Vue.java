package be.technifutur.devmob.sudoku.sudoku4x4;

import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;

import java.util.Scanner;

public class Sudoku4x4Vue {
    private StringBuilder sb;
    private Sudoku4x4 model;
    private User user;

    public Sudoku4x4Vue(Sudoku4x4 model) {
        this.model = model;
        this.user = new UserConsole();
        update();
    }

    public void update() {
        sb = new StringBuilder();
        sb.append(              "+------+------+\n");
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(0)), model.get(new Position4x4(1)), model.get(new Position4x4(2)), model.get(new Position4x4(3))));
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(4)), model.get(new Position4x4(5)), model.get(new Position4x4(6)), model.get(new Position4x4(7))));
        sb.append(              "+------+------+\n");
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(8)), model.get(new Position4x4(9)), model.get(new Position4x4(10)), model.get(new Position4x4(11))));
        sb.append(String.format("| %s  %s | %s  %s |\n", model.get(new Position4x4(12)), model.get(new Position4x4(13)), model.get(new Position4x4(14)), model.get(new Position4x4(15))));
        sb.append(              "+------+------+\n");
    }

    public void showSudoku(){
        System.out.println(sb.toString());
    }

    public void show(String message) {
        user.show(message);
    }

    public void separator() {
        System.out.println("---------------------");
    }

    public String prompt(String message) {
        return user.prompt(message);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
