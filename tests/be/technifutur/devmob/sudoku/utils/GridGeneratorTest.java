package be.technifutur.devmob.sudoku.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridGeneratorTest {

    /*
        Testing if the generate(9) function returns a valid 81 of length String array
     */
    @Test
    void testGenerate9ReturnsValidStringArray() {
        GridGenerator gg = new GridGenerator();
        String[] values = gg.generate(9);
        assertEquals(81, values.length);
        assertEquals("1.1.1", values[0]);
        assertEquals("9.9.9", values[80]);
    }

    /*
        Testing if the generate(4) function returns a valid 16 of length String array
     */
    @Test
    void testGenerate4ReturnsValidStringArray() {
        GridGenerator gg = new GridGenerator();
        String[] values = gg.generate(4);
        assertEquals(16, values.length);
        assertEquals("1.1.1", values[0]);
        assertEquals("4.4.4", values[15]);
    }
}