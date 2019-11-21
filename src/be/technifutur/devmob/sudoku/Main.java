package be.technifutur.devmob.sudoku;

import be.technifutur.devmob.sudoku.sudokuEtoile.SudokuEtoileVue;
import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudokuController;
import be.technifutur.devmob.sudoku.sudoku_interfaces.AbstractSudokuFactory;
import be.technifutur.devmob.sudoku.sudoku_interfaces.SudokuType;

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
                    AbstractSudokuController controller = AbstractSudokuFactory.getSudoku(SudokuType.SUDOKU_4_4);
                    controller.start();
                    break;
                }
                case "2": {
                    AbstractSudokuController controller = AbstractSudokuFactory.getSudoku(SudokuType.SUDOKU_9_9);
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
