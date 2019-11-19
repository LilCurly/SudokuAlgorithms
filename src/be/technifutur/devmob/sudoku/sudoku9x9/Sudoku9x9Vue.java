package be.technifutur.devmob.sudoku.sudoku9x9;

import be.technifutur.devmob.sudoku.Cellule;
import be.technifutur.devmob.sudoku.utils.User;
import be.technifutur.devmob.sudoku.utils.UserConsole;


public class Sudoku9x9Vue {
    private StringBuilder sb;
    private Sudoku9x9 model;
    private User user;

    public Sudoku9x9Vue(Sudoku9x9 model) {
        this.model = model;
        this.user = new UserConsole();
        update();
    }

    public void update() {
        Cellule[] vals = model.getValues();
        sb = new StringBuilder();
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[0], vals[1], vals[2], vals[3], vals[4], vals[5], vals[6], vals[7], vals[8]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[9], vals[10], vals[11], vals[12], vals[13], vals[14], vals[15], vals[16], vals[17]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[18], vals[19], vals[20], vals[21], vals[22], vals[23], vals[24], vals[25], vals[26]));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[27], vals[28], vals[29], vals[30], vals[31], vals[32], vals[33], vals[34], vals[35]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[36], vals[37], vals[38], vals[39], vals[40], vals[41], vals[42], vals[43], vals[44]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[45], vals[46], vals[47], vals[48], vals[49], vals[50], vals[51], vals[52], vals[53]));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[54], vals[55], vals[56], vals[57], vals[58], vals[59], vals[60], vals[61], vals[62]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[63], vals[64], vals[65], vals[66], vals[67], vals[68], vals[69], vals[70], vals[71]));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[72], vals[73], vals[74], vals[75], vals[76], vals[77], vals[78], vals[79], vals[80]));
        sb.append(              "+---------+---------+---------+\n");
    }

    public void showSudoku() {
        System.out.println(sb.toString());
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
}
