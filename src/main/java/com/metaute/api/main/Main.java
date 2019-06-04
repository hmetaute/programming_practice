package com.metaute.api.main;

import com.metaute.api.lib.IntFormatter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Captures integers through standard input and prints the String representation of the number
 * Stops when the user stops the program or inputs something other than a valid int
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the integer formatter! You can convert Integers to Strings in english");
        System.out.println("In order to stop the program, press CTRL + C.");
        IntFormatter formatter = new IntFormatter();
        while(true) {
            System.out.println("Enter the number you whish to convert.");
            try {
                Scanner input = new Scanner(System.in);
                int intToTransform = input.nextInt();
                String formattedInt = formatter.format(intToTransform);
                System.out.println(formattedInt);
            } catch (InputMismatchException e) {
                System.out.println("Your input couldn't be interpreted as a valid Int");
            }

        }
    }
}
