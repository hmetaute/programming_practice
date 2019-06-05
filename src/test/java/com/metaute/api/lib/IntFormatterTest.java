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

    @Test
    public void convertsMinusOne() {
        testNumber(-1, "minus one");
    }

    @Test
    public void convertsMinusTwo() {
        testNumber(-2, "minus two");
    }

    @Test
    public void convertsMinusThree() {
        testNumber(-3, "minus three");
    }

    @Test
    public void convertsMinusFour() {
        testNumber(-4, "minus four");
    }

    @Test
    public void convertsMinusFive() {
        testNumber(-5, "minus five");
    }

    @Test
    public void convertsMinusSix() {
        testNumber(-6, "minus six");
    }

    @Test
    public void convertsMinusSeven() {
        testNumber(-7, "minus seven");
    }

    @Test
    public void convertMinusEight() {
        testNumber(-8, "minus eight");
    }

    @Test
    public void convertMinusNine() {
        testNumber(-9, "minus nine");
    }

    @Test
    public void convertTen() {
        testNumber(10, "ten");
    }

    @Test
    public void convertEleven() {
        testNumber(11, "eleven");
    }

    @Test
    public void convertTwelve() {
        testNumber(12, "twelve");
    }

    @Test
    public void convertThirteen() {
        testNumber(13, "thirteen");
    }

    @Test
    public void convertFourteen() {
        testNumber(14, "fourteen");
    }

    @Test
    public void convertFifteen() {
        testNumber(15, "fifteen");
    }

    @Test
    public void convertSixteen() {
        testNumber(16, "sixteen");
    }

    @Test
    public void convertSeventeen() {
        testNumber(17, "seventeen");
    }

    @Test
    public void convertEighteen() {
        testNumber(18, "eighteen");
    }

    @Test
    public void convertNineteen() {
        testNumber(19, "nineteen");
    }
}
