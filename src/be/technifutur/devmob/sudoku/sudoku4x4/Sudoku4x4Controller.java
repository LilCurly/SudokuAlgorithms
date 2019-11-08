package be.technifutur.devmob.sudoku.sudoku4x4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sudoku4x4Controller {
    private Sudoku4x4 model;
    private Sudoku4x4Vue view;

    public Sudoku4x4Controller(Sudoku4x4 model, Sudoku4x4Vue view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean isOver = false;
        view.show();
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
                String[] regexValues = p2.split(entry);
                int row = Integer.parseInt(regexValues[0]);
                int col = Integer.parseInt(regexValues[1]);
                char value = regexValues[2].charAt(0);
                model.add(new Position4x4(col - 1, row - 1), value);
                view.update();
                view.show(String.format("%s ajouté à la ligne %d et la colonne %d", value, row, col));
            }
        }
    }
}
