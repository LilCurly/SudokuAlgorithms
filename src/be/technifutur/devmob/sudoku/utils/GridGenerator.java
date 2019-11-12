package be.technifutur.devmob.sudoku.utils;

public class GridGenerator {
    public String[] generate(int limit) {
        String[] result = new String[limit * limit];
        for(int i = 0; i < limit * limit; i++) {
            result[i] = String.format("%d.%d.%d", (int) Math.ceil((double) (i+1)/limit), (i%limit)+1, (i%limit)+1);
        }
        return result;
    }
}
