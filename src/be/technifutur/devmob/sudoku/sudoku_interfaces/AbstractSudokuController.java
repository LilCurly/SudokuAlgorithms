package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.PositionFactory;
import be.technifutur.devmob.sudoku.PositionInvalidException;
import be.technifutur.devmob.sudoku.SudokuException;
import be.technifutur.devmob.sudoku.sudoku4x4.Sudoku4x4Vue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractSudokuController {
    private UpdatableSudoku model;
    private Sudoku4x4Vue view;

    public AbstractSudokuController(UpdatableSudoku model, Sudoku4x4Vue view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean isOver = false;
        view.separator();
        view.show("Sudoku 4x4");
        view.showSudoku();
        while(!isOver) {
            String entry;
            Pattern add = Pattern.compile("(\\d\\.\\d\\.\\d)");
            Pattern delete = Pattern.compile("d(\\d\\.\\d)");
            Pattern update = Pattern.compile("u(\\d\\.\\d\\.\\d)");
            Matcher addMatcher;
            Matcher deleteMatcher;
            Matcher updateMatcher;
            do {
                entry = view.prompt("Entrez une valeur dans le format : {ligne}.{colonne}.{valeur} pour entrer une nouvelle valeur ou 0 pour quitter : ");
                view.separator();
                addMatcher = add.matcher(entry);
                deleteMatcher = delete.matcher(entry);
                updateMatcher = update.matcher(entry);
            } while(!entry.equals("0") && !addMatcher.matches() && !deleteMatcher.matches() && !updateMatcher.matches());
            if(entry.equals("0")) {
                isOver = true;
            }
            else if (addMatcher.matches() || updateMatcher.matches()) {
                Matcher match = Pattern.compile("u?(?<val>\\d\\.\\d\\.\\d)").matcher(entry);
                if(match.lookingAt()) {
                    entry = match.group("val");
                }
                String[] regexValues = stringSplitter(entry);
                int row = Integer.parseInt(regexValues[0]);
                int col = Integer.parseInt(regexValues[1]);
                char value = regexValues[2].charAt(0);
                boolean result = false;
                boolean validPosition = handlePositionValidation(col, row);
                if(validPosition && addMatcher.matches()) {
                    try {
                        result = model.add(PositionFactory.get(model, col-1, row-1), value);
                    } catch (SudokuException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(validPosition && updateMatcher.matches()) {
                    try {
                        result = model.update(PositionFactory.get(model, col-1, row-1), value);
                    } catch (SudokuException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if(result) {
                    view.update();
                    if(model.isComplete()) {
                        handleComplete(value, row, col);
                        isOver = true;
                    }
                    else {
                        handleAdded(value, row, col);
                        view.showSudoku();
                    }
                }
                else {
                    view.showSudoku();
                }
            }
            else {
                Matcher match = Pattern.compile("d?(?<val>\\d\\.\\d)").matcher(entry);
                if(match.lookingAt()) {
                    entry = match.group("val");
                }
                String[] regexValues = stringSplitter(entry);
                int row = Integer.parseInt(regexValues[0]);
                int col = Integer.parseInt(regexValues[1]);
                boolean result = false;
                boolean validPosition = handlePositionValidation(col, row);
                if(validPosition) {
                    try {
                        result = model.delete(PositionFactory.get(model, col-1, row-1));
                    } catch (SudokuException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if(result) {
                    view.update();
                    handleDelete(row, col);
                    view.showSudoku();
                }
                else {
                    view.showSudoku();
                }
            }
        }
    }

    private void handleDelete(int row, int col) {
        view.show(String.format("La valeur à la ligne %d et la colonne %d a été retirée", row, col));
    }

    private boolean handlePositionValidation(int col, int row) {
        boolean result = false;
        try {
            result = PositionFactory.isValid(model, col - 1, row - 1);
        } catch (PositionInvalidException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private String[] stringSplitter(String entry) {
        Pattern splitter = Pattern.compile("\\.");
        return splitter.split(entry);
    }

    private void handleComplete(char value, int row, int col) {
        handleAdded(value, row, col);
        view.show("Sudoku terminé!");
        view.showSudoku();
        view.prompt("Entrez n'importe quelle valeur pour quitter le Sudoku: ");
    }

    private void handleAdded(char value, int row, int col) {
        view.show(String.format("%s ajouté à la ligne %d et la colonne %d", value, row, col));
    }
}
