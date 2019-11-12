package be.technifutur.devmob.sudoku.utils;

import java.util.Scanner;

public class UserConsole implements User {

    @Override
    public void show(String message) {
        System.out.println("---------------------");
        System.out.println(message);
    }

    @Override
    public String prompt(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
