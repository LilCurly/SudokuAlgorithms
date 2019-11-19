package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Controller;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Factory;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Vue;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9Controller;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9Factory;
import be.technifutur.devmob.sudoku.sudoku9x9.Sudoku9x9Vue;
import be.technifutur.devmob.sudoku.sudokuEtoile.SudokuEtoileVue;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;
import be.technifutur.devmob.sudoku.utils.UserFake;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuEtoileVue sEtoile = new SudokuEtoileVue();
        boolean keepGoing = true;
        System.out.println("Bienvenu sur SudokuAlgorithm");
        System.out.println("# By Roman Muzikantov");
        System.out.println("----------------------------\n");
        while(keepGoing) {
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
            switch (opt) {
                case "1": {
                    Sudoku4x4Controller controller = Sudoku4x4Factory.getSudoku4x4();
                    controller.start();
                    break;
                }
                case "2": {
                    Sudoku9x9Controller controller = Sudoku9x9Factory.getSudoku9x9();
                    controller.start();
                    break;
                }
                case "3":
                    sEtoile.show();
                    break;
                default:
                    keepGoing = false;
                    break;
            }
        }
    }
}
