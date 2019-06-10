package com.metaute.api.main;

import com.metaute.api.lib.IntFormatter;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Captures integers through standard input and prints the String representation of the number
 * Stops when the user stops the program or inputs something other than a valid int
 */
public class Main {

    private static final CharSequence[] specialCharactersToIgnore = { ".", ",", "`", "-", " " };

    /**
     * Tries to remove special separator characters from an input String
     * @param input
     * @return
     */
    private static String sanitizeInputString(String input) {
        String result = input;
        for (int i = 0; i < specialCharactersToIgnore.length; i++) {
            result = result.replace(specialCharactersToIgnore[i], "");
        }
        return result;
    }

    /**
     * Makes the best effort to convert the user's input to an integer
     * @param userInput
     * @return
     */
    private static int getIntFromUserInput(String userInput) throws NumberFormatException {
        String sanitizedInput = sanitizeInputString(userInput);
        int result = Integer.parseInt(sanitizedInput);
        return result;
    }



    public static void main(String[] args) {
        System.out.println("Welcome to the integer formatter! You can convert Integers to Strings in english");
        System.out.println("In order to stop the program, press CTRL + C.");
        System.out.println("You can format numbers between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE);
        IntFormatter formatter = new IntFormatter();
        while(true) {
            System.out.println("Enter the number you wish to convert.");
            try {
                Scanner input = new Scanner(System.in, StandardCharsets.UTF_8.name());
                int intToTransform = getIntFromUserInput(input.next());
                String formattedInt = formatter.format(intToTransform);
                System.out.println(formattedInt);
            } catch (NumberFormatException e) {
                System.out.println("Your input couldn't be interpreted as a valid Int");
            }
        }
    }
}
