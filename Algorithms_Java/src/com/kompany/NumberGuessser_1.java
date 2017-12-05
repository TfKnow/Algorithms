package com.kompany;


import java.util.Random;

public class NumberGuessser_1 {


    private static int iteration_1 = 1;
    private static int iteration = 1;

    public static void main(String[] args) {

        tester();

    }

    private static void tester() {
        for (int i = 1; i <= 100; i++) {
            numberGuesser(i);
        }
        System.out.println("Total number of iterations combined : " + iteration_1);
        System.out.println("Approximate average : " + iteration_1 / 100);
    }

    private static void numberGuesser(int number) {
        determine(number);
    }

    private static void determine(int number) {

        int x = 0;
        int guess = 50;
        int fundamental = 50;

        int array[];

        if (guess == number) {
            System.out.println("Found it (Number : " + number + ")");
            System.out.println("Number of iterations: " + iteration + "\n");
        }

        if (guess > number) {
            int newGuess = guess;
            boolean flag = false;
            while (!flag) {
                newGuess /= 2;

                if (newGuess == number) {
                    System.out.println("Found it (Number : " + number + ")");
                    System.out.println("Number of iterations : " + iteration + "\n");
                    break;
                }
                if (newGuess < number) {
                    array = getArray(newGuess, fundamental);
                    finalSlash(array, number);
                    flag = true;
                } else {
                    iteration++;
                    iteration_1++;
                }
            }
        }

        if (guess < number) {
            array = getArray_1(guess, 100);
            finalSlash(array, number);
        }
    }


    private static int[] getArray(int start, int finish) {
        int[] array = new int[finish - start];
        for (int i = 0, j = start; j < finish; j++, i++) {
            array[i] = j;
        }
        return array;
    }

    private static int[] getArray_1(int start, int finish) {
        int[] array = new int[finish - start + 1];
        for (int i = 0, j = start; j < finish + 1; j++, i++) {
            array[i] = j;
        }
        return array;
    }

    private static void finalSlash(int[] array, int number) {
        int iterationsTotal;
        int oldGuess = 0;
        int finish = 100;
        int guess = array[array.length / 2];
        iteration++;
        iteration_1++;
        if (guess == number) {
            System.out.println("Found it (Number : " + number + ")");

            System.out.println("Number of iterations: " + iteration + "\n");
        }
        while (guess != number) {
            if (guess < number) {

                oldGuess = guess;
                while (guess < number) {
                    oldGuess = guess;
                    array = getArray_1(guess, finish);
                    guess = array[array.length / 2];

                    iteration++;
                    iteration_1++;

                }
            }
            if (guess > number) {
                finish = guess;
                while (guess > number) {
                    array = getArray(oldGuess, guess);
                    guess = array[array.length / 2];

                    iteration++;
                    iteration_1++;

                }
            }
            if (guess == number) {
                iterationsTotal = iteration;
                iteration = 0;
                System.out.println("Found it (Number : " + number + ")");
                System.out.println("Number of iterations: " + iterationsTotal + "\n");
            }
        }
    }
}





