package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Vue;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9Vue;
import be.technifutur.devmob.sudoku.sudokuEtoile.SudokuEtoileVue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sudoku4x4Vue s4 = new Sudoku4x4Vue();
        Sudoku9x9Vue s9 = new Sudoku9x9Vue();
        SudokuEtoileVue sEtoile = new SudokuEtoileVue();
        boolean keepGoing = true;
        System.out.println("Bienvenu sur SudokuAlgorithm");
        System.out.println("# By Roman Muzikantov");
        while(keepGoing) {
            System.out.println("----------------------------\n");
            System.out.println("Choisissez le sudoku à compléter:");
            System.out.println("(1) Sudoku 4x4");
            System.out.println("(2) Sudoku 9x9");
            System.out.println("(3) Sudoku Etoile");
            System.out.println("(0) Quitter\n");
            System.out.print("Votre choix : ");
            Scanner in = new Scanner(System.in);
            String opt = in.nextLine();
            while (!opt.equals("1") && !opt.equals("2") && !opt.equals("3") && !opt.equals("0")) {
                System.out.println("Mauvaise entrée!");
                System.out.print("Votre choix : ");
                opt = in.nextLine();
            }
            if (opt.equals("1")) {
                s4.show();
            } else if (opt.equals("2")) {
                s9.show();
            } else if (opt.equals("3")) {
                sEtoile.show();
            } else {
              keepGoing = false;
            }
        }
    }
}
