package com.metaute.api.main;

import com.metaute.api.lib.IntFormatter;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Captures integers through standard input and prints the String representation of the number
 * Stops when the user stops the program or inputs something other than a valid int
 */
public class Main {



    public static void main(String[] args) {
        System.out.println("Welcome to the integer formatter! You can convert Integers to Strings in english");
        System.out.println("In order to stop the program, press CTRL + C.");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        IntFormatter formatter = new IntFormatter();
        while(true) {
            System.out.println("Enter the number you wish to convert.");
            System.out.println("");
            try {
                int min = 1000000000;
                int max = Integer.MAX_VALUE;
                for(int i = 0; i < 100; i++) {
                    Random random = new Random();
                    int number = random.nextInt(max + 1 -min) + min;
                    System.out.println(number);
                }
                Scanner input = new Scanner(System.in, StandardCharsets.UTF_8.name());
                int intToTransform = input.nextInt();
                String formattedInt = formatter.format(intToTransform);
                System.out.println(formattedInt);
            } catch (InputMismatchException e) {
                System.out.println("Your input couldn't be interpreted as a valid Int");
            }
        }
    }
}
