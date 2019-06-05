package com.metaute.api.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntFormatterTest {

    /**
     * Handles the duplication of creating a formatter, transforming and asserting the number
     * it also provides an additional error message detailing the fail
     * @param toTransform
     * @param expectedWhenFormatted
     */
    private void testNumber(int toTransform, String expectedWhenFormatted) {
        IntFormatter converter = new IntFormatter();
        String transformed = converter.format(toTransform);
        assertEquals(String.format("Error formatting %d. Expected: \"%s\" Got: \"%s\"",
                toTransform, expectedWhenFormatted, transformed), expectedWhenFormatted, transformed);
    }

    @Test
    public void convertsZero() {
        testNumber(0, "zero");
    }

    @Test
    public void convertsOne() {
        testNumber(1, "one");
    }

    @Test
    public void convertsTwo() {
        testNumber(2, "two");
    }

    @Test
    public void convertsThree() {
        testNumber(3, "three");
    }

    @Test
    public void convertsFour() {
        testNumber(4, "four");
    }

    @Test
    public void convertsFive() {
        testNumber(5, "five");
    }

    @Test
    public void convertsSix() {
        testNumber(6, "six");
    }

    @Test
    public void convertsSeven() {
        testNumber(7, "seven");
    }

    @Test
    public void convertEight() {
        testNumber(8, "eight");
    }

    @Test
    public void convertNine() {
        testNumber(9, "nine");
    }
}
