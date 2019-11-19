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
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[0].getValue(), vals[1].getValue(), vals[2].getValue(), vals[3].getValue(), vals[4].getValue(), vals[5].getValue(), vals[6].getValue(), vals[7].getValue(), vals[8].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[9].getValue(), vals[10].getValue(), vals[11].getValue(), vals[12].getValue(), vals[13].getValue(), vals[14].getValue(), vals[15].getValue(), vals[16].getValue(), vals[17].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[18].getValue(), vals[19].getValue(), vals[20].getValue(), vals[21].getValue(), vals[22].getValue(), vals[23].getValue(), vals[24].getValue(), vals[25].getValue(), vals[26].getValue()));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[27].getValue(), vals[28].getValue(), vals[29].getValue(), vals[30].getValue(), vals[31].getValue(), vals[32].getValue(), vals[33].getValue(), vals[34].getValue(), vals[35].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[36].getValue(), vals[37].getValue(), vals[38].getValue(), vals[39].getValue(), vals[40].getValue(), vals[41].getValue(), vals[42].getValue(), vals[43].getValue(), vals[44].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[45].getValue(), vals[46].getValue(), vals[47].getValue(), vals[48].getValue(), vals[49].getValue(), vals[50].getValue(), vals[51].getValue(), vals[52].getValue(), vals[53].getValue()));
        sb.append(              "+---------+---------+---------+\n");
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[54].getValue(), vals[55].getValue(), vals[56].getValue(), vals[57].getValue(), vals[58].getValue(), vals[59].getValue(), vals[60].getValue(), vals[61].getValue(), vals[62].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[63].getValue(), vals[64].getValue(), vals[65].getValue(), vals[66].getValue(), vals[67].getValue(), vals[68].getValue(), vals[69].getValue(), vals[70].getValue(), vals[71].getValue()));
        sb.append(String.format("| %s  %s  %s | %s  %s  %s | %s  %s  %s |\n", vals[72].getValue(), vals[73].getValue(), vals[74].getValue(), vals[75].getValue(), vals[76].getValue(), vals[77].getValue(), vals[78].getValue(), vals[79].getValue(), vals[80].getValue()));
        sb.append(              "+---------+---------+---------+\n");
    }

    public void showSudoku() {
        System.out.println(sb.toString());
    }

    public void separator() {
        System.out.println("---------------------");
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
