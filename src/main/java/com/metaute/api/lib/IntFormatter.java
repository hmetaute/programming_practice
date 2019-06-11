package com.metaute.api.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    private Map<Integer, String> units;
    private Map<Integer, String> roundTens;
    private Map<Integer, String> magnitudes;
    private List<Integer> magnitudeOrder;

    private static final String MIN_INT_REPRESENTATION =
            "Negative two billion one hundred forty seven million " +
                    "four hundred eighty three thousand six hundred and forty eight";

    public IntFormatter() {
        initializeUnits();
        initializeRoundTens();
        initializeMagnitudes();
        magnitudeOrder = new ArrayList<>();
        magnitudeOrder.add(1000000000);
        magnitudeOrder.add(1000000);
        magnitudeOrder.add(1000);
        magnitudeOrder.add(100);
        magnitudeOrder.add(10);
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
     * Relies on recursion in order to divide and format any valid int
     * @param toFormat a number between MIN_INT+1 and MAX_INT
     * @param magnitude one of the elements in magnitudeOrder. It's the numeric representation of what qualifier the number has
     * @return the formatted number in english
     */
    public String recursiveFormat(int toFormat, int magnitude) {
        if (toFormat < 100) {
            String formattedBaseCase = formatTens(toFormat);
            return formattedBaseCase;
        }
        int nextMagnitudeIndex = magnitudeOrder.indexOf(magnitude) + 1;
        Integer nextMagnitude = magnitudeOrder.get(nextMagnitudeIndex);
        if (toFormat < magnitude) {
            return recursiveFormat(toFormat, nextMagnitude);
        } else {
            //We split the number to the left and right of the magnitude.
            //e.g. magnitude is 1000 and toFormat is 1003 then left = 1000 and right = 3
            int right = toFormat % magnitude;
            int left = (toFormat - right) / magnitude;
            String formattedLeftWithMagnitude =
                    String.format("%s %s", recursiveFormat(left, nextMagnitude), magnitudes.get(magnitude));
            if (right == 0) {
                return formattedLeftWithMagnitude;
            } else {
                String formattedRight = recursiveFormat(right, magnitudeOrder.get(0));
                return String.format("%s %s", formattedLeftWithMagnitude, formattedRight);
            }
        }
    }

    public String format(int toFormat) {
        String signString = "";
        if (toFormat == Integer.MIN_VALUE) {
            return MIN_INT_REPRESENTATION;
        }
        if (toFormat < 0) {
            signString = "negative ";
            toFormat = toFormat * -1;
        }
        /**
         * Handles the special case of adding " and " between hundreds and tens only in the last position.
         * e.g. 234,501,723: Two hundred thirty four million five hundred one thousand seven hundred and twenty three.
         */
        if (toFormat > 100) {
            int right = toFormat % 100;
            int left = (toFormat - right);
            String formattedLeft = recursiveFormat(left, magnitudeOrder.get(0));
            if (right == 0) {
                return capitalizeNumber(signString + formattedLeft);
            } else {
                String formattedNumber = String.format("%s and %s", formattedLeft, formatTens(right));
                return capitalizeNumber(signString + formattedNumber);
            }
        }
        String plainFormattedNumber = signString +
                recursiveFormat(toFormat, magnitudeOrder.get(0));
        return capitalizeNumber(plainFormattedNumber);
    }


}