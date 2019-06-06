package com.metaute.api.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    Map<Integer, String> units;
    Map<Integer, String> tens;

    public IntFormatter() {
        initializeUnits();
        initializeTens();
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

    /**
     * Takes in a number and returns its
     * @param toTransform the number you want to be transformed to an english string
     * @return
     */
    public String format(int toTransform) {
        String formattedNumber = "";
        String signString = "";
        if (toTransform < 0) {
            signString = "minus ";
            toTransform = toTransform * -1;
        }
        if (toTransform < 10) {
            formattedNumber = signString + units.get(toTransform);
        } else if (toTransform < 20){
            formattedNumber = signString + tens.get(toTransform);
        }
        return formattedNumber;
    }
}
