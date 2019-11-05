package be.technifutur.devmob.sudoku.sudoku4x4;

public class Sudoku4x4Vue {
    private StringBuilder sb;
    public Sudoku4x4Vue() {
        sb = new StringBuilder();
        sb.append("+------+------+\n");
        sb.append("| 1  2 | 3  4 |\n");
        sb.append("| 4  3 | 1  2 |\n");
        sb.append("+------+------+\n");
        sb.append("| 3  4 | 2  3 |\n");
        sb.append("| 2  1 | 4  1 |\n");
        sb.append("+------+------+\n");

    }

    public void show(){
        int sq = (int) Math.sqrt(4);
        System.out.println(sb.toString());
    }
}
