package com.metaute.api.lib;

/**
 * Transforms an integer to its string representation in english
 */
public class IntFormatter {

    /**
     * Takes in a number and returns its
     * @param toTransform the number you want to be transformed to an english string
     * @return
     */
    public String format(int toTransform) {
        String result;
        if (toTransform == 1) {
            result = "one";
        } else if (toTransform == 2) {
            result = "two";
        } else {
            result = "??";
        }
        return result;
    }
}
