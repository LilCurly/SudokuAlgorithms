package be.technifutur.devmob.sudoku.utils;

import static java.lang.Thread.sleep;

public class UserFake implements User {
    private GridGenerator gg = new GridGenerator();
    private String[] values;
    private int valuesCpt = 0;

    public UserFake(int limit) {
        values = gg.generate(limit);
    }

    @Override
    public void show(String message) {
        System.out.println("---------------------");
        System.out.println(message);
    }

    @Override
    public String prompt(String message) {
        System.out.println(message);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(valuesCpt < values.length ? values[valuesCpt] : "0");
        return valuesCpt < values.length ? values[valuesCpt++] : "0";
    }
}
