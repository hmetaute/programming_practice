package com.metaute.api.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    Map<Integer, String> units;
    Map<Integer, String> roundTens;
    Map<Integer, String> magnitudes;

    public IntFormatter() {
        initializeUnits();
        initializeRoundTens();
        initializeMagnitudes();
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
        units.put(10, "ten");
        units.put(11, "eleven");
        units.put(12, "twelve");
        units.put(13, "thirteen");
        units.put(14, "fourteen");
        units.put(15, "fifteen");
        units.put(16, "sixteen");
        units.put(17, "seventeen");
        units.put(18, "eighteen");
        units.put(19, "nineteen");
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

    private void initializeMagnitudes() {
        magnitudes = new HashMap<>();
        magnitudes.put(100, "hundred");
        magnitudes.put(1000, "thousand");
        magnitudes.put(1000000, "million");
        magnitudes.put(1000000000, "billion");
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
        if (toTransform < 1000000000) {
            formattedNumber = formatMillions(toTransform);
        } else {
            formattedNumber = "???";
        }
        return capitalizeNumber(signString + formattedNumber);
    }

    /**
     * Capitalizes the formatted String representations
     * @param formattedNumber
     * @return
     */
    private String capitalizeNumber(String formattedNumber) {
        if (formattedNumber == null || formattedNumber.length() == 0) {
            return formattedNumber;
        }
        return formattedNumber.substring(0, 1).toUpperCase() + formattedNumber.substring(1);
    }

    /**
     * Transforms numbers up to 99
     * @param tensToTransform
     * @return
     */
    private String formatTens(int tensToTransform) {
        String formattedNumber;
        if (tensToTransform < 20) {
            formattedNumber = units.get(tensToTransform);
        } else {
            int unit = tensToTransform % 10;
            int tens = tensToTransform - unit;
            String tensString = roundTens.get(tens);
            String unitString = unit != 0 ? " " + units.get(unit) : "";
            formattedNumber = tensString + unitString;
        }
        return formattedNumber;
    }

    /**
     * This method is capable of formatting numbers up to 999
     * @param hundredsToTransform
     * @param finalDigits Signals whether or not this method is called for the last three numbers of the int
     * @return formatted signed number
     */
    private String formatHundreds(int hundredsToTransform, boolean finalDigits) {
        String formattedNumber;
        if (hundredsToTransform < 100) {
            formattedNumber = finalDigits ? "and " + formatTens(hundredsToTransform) : formatTens(hundredsToTransform);
        } else {
            String concatPhrase = finalDigits ? " and " : " ";
            int decimals = hundredsToTransform % 100;
            int hundreds = (hundredsToTransform - decimals) / 100;
            //We need to account for the case of round numbers. We get "one hundred and zero".
            String formattedDecimals = decimals == 0 ? "" : concatPhrase + formatTens(decimals)  ;
            formattedNumber = formatTens(hundreds) + " " + magnitudes.get(100) + formattedDecimals;
        }
        return formattedNumber;
    }

    /**
     * Method capable of transforming numbers up to a 999.999
     * @param thousandsToTransform
     * @return
     */
    private String formatThousands(int thousandsToTransform, boolean shouldAppendAnd) {
        String formattedNumber;
        if (thousandsToTransform < 1000) {
            formattedNumber = formatHundreds(thousandsToTransform, thousandsToTransform > 99 || shouldAppendAnd);
        } else {
            int hundreds = thousandsToTransform % 1000;
            int thousands = (thousandsToTransform - hundreds) / 1000;
            String formattedHundreds;
            if (hundreds == 0) {
                formattedHundreds = ""; //stop processing if round thousand
            } else {
                //Adds " and " when you have thousands, zeros and tens. E.g. 13.001, 450.025, 950.090
                formattedHundreds = " " + formatHundreds(hundreds, true);
            }
            formattedNumber = formatHundreds(thousands, false)
                    + " " + magnitudes.get(1000) + formattedHundreds;
        }
        return formattedNumber;
    }

    /**
     * Formats numbers up to 999.999.999
     * @param numberToTransform
     * @return
     */
    private String formatMillions(int numberToTransform) {
        String formattedNumber;
        if (numberToTransform < 1000000) {
            formattedNumber = formatThousands(numberToTransform, false);
        } else {
            int thousands = numberToTransform % 1000000;
            int millions = (numberToTransform - thousands) / 1000000;
            String formattedThousands;
            if (thousands == 0) {
                formattedThousands = "";
            } else {
                formattedThousands = " " + formatThousands(thousands, true);
            }
            formattedNumber = formatHundreds(millions, false) + " " + magnitudes.get(1000000)
                     + formattedThousands;
        }
        return formattedNumber;
    }

    /**
     * Divides up the number into its components
     * @param number
     * @return
     */
    private static ArrayList<Integer> getNumberPlacements(int number) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while(number > 0) {
            int unit = number % 10;
            number = (number - unit)/10;
            numbers.add(unit);
        }
        return numbers;
    }
}
