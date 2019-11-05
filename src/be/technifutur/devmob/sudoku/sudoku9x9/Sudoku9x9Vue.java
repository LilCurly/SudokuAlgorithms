package be.technifutur.devmob.sudoku.sudoku9x9;

public class Sudoku9x9Vue {
    StringBuilder sb;

    public Sudoku9x9Vue() {
        sb = new StringBuilder();
        sb.append("+---------+---------+---------+\n");
        sb.append("| 1  2  3 | 4  5  6 | 7  8  9 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("+---------+---------+---------+\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("+---------+---------+---------+\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("| 9  8  7 | 1  2  3 | 4  5  6 |\n");
        sb.append("+---------+---------+---------+\n");
    }

    public void show() {
        System.out.println(sb.toString());
    }
}
