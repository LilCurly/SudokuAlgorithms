package be.technifutur.devmob.sudoku.sudoku9x9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sudoku9x9Controller {
    private Sudoku9x9 model;
    private Sudoku9x9Vue view;

    public Sudoku9x9Controller(Sudoku9x9 model, Sudoku9x9Vue view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean isOver = false;
        view.show("Sudoku 9x9");
        view.showSudoku();
        while(!isOver) {
            String entry;
            Pattern p = Pattern.compile("^\\d\\.\\d\\.\\d");
            Matcher m;
            do {
                entry = view.prompt("Entrez une valeur dans le format : {ligne}.{colonne}.{valeur} pour entrer une nouvelle valeur ou 0 pour quitter :");
                m = p.matcher(entry);
            } while(!entry.equals("0") && !m.matches());
            if(entry.equals("0")) {
                isOver = true;
            }
            else {
                Pattern p2 = Pattern.compile("\\.");
                String[] values = p2.split(entry);
                int row = Integer.parseInt(values[0]);
                int col = Integer.parseInt(values[1]);
                char val = values[2].charAt(0);
                boolean result = false;
                if(Position9x9.isValid(col - 1, row - 1)) {
                    result = model.add(new Position9x9(col - 1, row - 1), val);
                }
                if(result) {
                    view.update();
                    if(model.isComplete()) {
                        view.show(String.format("%s ajouté à la ligne %d et la colonne %d\nSudoku terminé!", val, row, col));
                        view.showSudoku();
                        view.prompt("Entrez n'importe quelle valeur pour quitter le Sudoku: ");
                        isOver = true;
                    }
                    else {
                        view.show(String.format("%s ajouté à la ligne %d et la colonne %d", val, row, col));
                        view.showSudoku();
                    }
                }
                else {
                    view.show(String.format("Impossible d'ajouter %s à la ligne %d et la colonne %d", val, row, col));
                    view.showSudoku();
                }
            }
        }
    }
}
