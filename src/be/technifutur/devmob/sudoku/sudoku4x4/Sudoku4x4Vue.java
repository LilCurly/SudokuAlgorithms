package be.technifutur.devmob.sudoku.sudoku4x4;

import java.util.Scanner;

public class Sudoku4x4Vue {
    private StringBuilder sb;
    private Sudoku4x4 model;

    public Sudoku4x4Vue(Sudoku4x4 model) {
        this.model = model;
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

    public void show(){
        System.out.println("---------------------");
        System.out.println("Sudoku 4x4");
        System.out.println(sb.toString());
    }

    public void show(String str) {
        System.out.println("---------------------");
        System.out.println(str);
        System.out.println(sb.toString());
    }

    public String prompt(String str) {
        System.out.println(str);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
