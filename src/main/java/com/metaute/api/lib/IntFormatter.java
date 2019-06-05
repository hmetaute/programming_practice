package com.metaute.api.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    Map<Integer, String> units;

    public IntFormatter() {
        this.units = new HashMap<>();
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

    /**
     * Takes in a number and returns its
     * @param toTransform the number you want to be transformed to an english string
     * @return
     */
    public String format(int toTransform) {
        String formattedNumber = "";
        if (toTransform < 0) {
            formattedNumber = "minus ";
            toTransform = toTransform * -1;
        }
        if (toTransform < 10) {
            formattedNumber = formattedNumber + this.units.get(toTransform);
        } else {
            formattedNumber = "???";
        }
        return formattedNumber;
    }
}
