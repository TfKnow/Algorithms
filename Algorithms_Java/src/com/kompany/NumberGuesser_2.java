package com.kompany;

import java.util.Random;

public class NumberGuesser_2{

    public static void main(String[] args) {

        tester();

    }

    private static void tester() {
        for (int i = 1; i <= 101; i++) {
            numberGuesser(i);
        }
    }

    private static int numberGuesser(int number) {

        int iteration = 0;
        Random rn = new Random();
        int min = 1;
        int max = 100;
        int guess = rn.nextInt(min + max) / 2;

        while (true) {
            iteration++;

            if (guess == number) {
                break;
            }

            if (guess < number) {
                min = guess;
            }

            if (guess > number) {
                max = guess;
            }

            guess = (min + max) / 2;
        }
        System.out.println("Number to guess : " + number + " number of iterations " + iteration);
        return iteration;
    }
}
