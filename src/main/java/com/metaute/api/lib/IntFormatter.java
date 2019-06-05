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
        units.put(1, "one");
    }

    /**
     * Takes in a number and returns its
     * @param toTransform the number you want to be transformed to an english string
     * @return
     */
    public String format(int toTransform) {
        String formattedNumber;
        if (toTransform == 0) {
            formattedNumber = "zero";
        } else if (toTransform == 1) {
            formattedNumber = "one";
        } else if (toTransform == 2) {
            formattedNumber = "two";
        } else if (toTransform == 3) {
            formattedNumber = "three";
        } else if (toTransform == 4) {
            formattedNumber = "four";
        } else if (toTransform == 5) {
            formattedNumber = "five";
        } else if (toTransform == 6) {
            formattedNumber = "six";
        } else if (toTransform == 7) {
            formattedNumber = "seven";
        } else if (toTransform == 8) {
            formattedNumber = "eight";
        } else if (toTransform == 9) {
            formattedNumber = "nine";
        } else {
            formattedNumber = "???";
        }
        return formattedNumber;
    }
}
