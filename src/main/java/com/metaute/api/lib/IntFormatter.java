package com.metaute.api.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    Map<Integer, String> units;
    Map<Integer, String> tens;
    Map<Integer, String> roundTens;

    public IntFormatter() {
        initializeUnits();
        initializeTens();
        initializeRoundTens();
    }

    private void initializeUnits() {
        units = new HashMap<>();
        units.put(0, "zero");
        units.put(1, "one");
        units.put(2, "two");
        units.put(3, "three");
        units.put(4, "four");
        units.put(5, "five");
        units.put(6, "six");
        units.put(7, "seven");
        units.put(8, "eight");
        units.put(9, "nine");
    }

    private void initializeTens() {
        tens = new HashMap<>();
        tens.put(10, "ten");
        tens.put(11, "eleven");
        tens.put(12, "twelve");
        tens.put(13, "thirteen");
        tens.put(14, "fourteen");
        tens.put(15, "fifteen");
        tens.put(16, "sixteen");
        tens.put(17, "seventeen");
        tens.put(18, "eighteen");
        tens.put(19, "nineteen");
    }

    private void initializeRoundTens() {
        roundTens = new HashMap<>();
        roundTens.put(20, "twenty");
        roundTens.put(30, "thirty");
        roundTens.put(40, "forty");
        roundTens.put(50, "fifty");
        roundTens.put(60, "sixty");
        roundTens.put(70, "seventy");
        roundTens.put(80, "eighty");
        roundTens.put(90, "ninety");
    }

    /**
     * Takes in a number and returns its
     * @param toTransform the number you want to be transformed to an english string
     * @return
     */
    public String format(int toTransform) {
        String formattedNumber;
        String signString = "";
        if (toTransform < 0) {
            signString = "minus ";
            toTransform = toTransform * -1;
        }
        if (toTransform < 10) {
            formattedNumber = formatUnits(toTransform, signString);
        } else if (toTransform < 100) {
            formattedNumber = formatTens(toTransform, signString);
        } else {
            formattedNumber = "???";
        }
        return formattedNumber;
    }

    /**
     * Formats a single signed unit
     * @param unitToTransform
     * @param signString
     * @return
     */
    private String formatUnits(int unitToTransform, String signString) {
        return signString + units.get(unitToTransform);
    }

    /**
     * Transforms signed numbers from 10 to 99
     * @param tensToTransform
     * @param signString
     * @return
     */
    private String formatTens(int tensToTransform, String signString) {
        String formattedTen;
        if (tensToTransform < 20) {
            formattedTen = signString + tens.get(tensToTransform);
        } else {
            int unit = tensToTransform % 10;
            int tens = tensToTransform - unit;
            String tensString = roundTens.get(tens);
            String unitString = unit != 0 ? " " + units.get(unit) : "";
            formattedTen = signString + tensString + unitString;
        }
        return formattedTen;
    }
}
