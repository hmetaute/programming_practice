package com.metaute.api.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the input sanitizaion/handling functions in the main app
 */
public class InputValidationTest {

    @Test
    public void applicationParsesNumberWithDots() {
        String input = "1.000";
        assertEquals(1000, Main.getIntFromUserInput(input));
    }

    @Test
    public void applicationParsesNumberWithCommaSeparators() {
        String input = "1,001";
        assertEquals(1001, Main.getIntFromUserInput(input));
    }


    @Test
    public void applicationParsesBigNumberWithCommaSeparators() {
        String input = "234,501,723";
        assertEquals(234501723, Main.getIntFromUserInput(input));
    }


    @Test
    public void applicationParsesNumberWithLeftZeros() {
        String input = "0000234,501,723";
        assertEquals(234501723, Main.getIntFromUserInput(input));
    }
}
