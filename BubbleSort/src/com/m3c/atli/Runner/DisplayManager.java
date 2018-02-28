package com.m3c.atli.Runner;

import java.util.Scanner;

public final class DisplayManager {

    private static void print(int[] array) {
        // print array
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] array, String description) {
        System.out.print(description + " array: ");
        print(array);
    }

    public static void printTimeDifference(long start, long end, String type) {
        long time = end-start;
        System.out.println("Time taken to sort with " + type + ": " + time);
    }

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter size of array");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = sc.nextInt();
        } while (number <= 0);
        return number;
    }
}
