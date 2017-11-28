
//You have an equation x^2 - ny^2 = k;
//This is how you write a simple algorithm that finds suitable values of x and y that satisfy an equation with specific n and k value.

package com.kompany;

import java.util.StringJoiner;

public class Diophantine_Equation {

    public static void main(String[] args) {

        System.out.println("x^2 - ny^2 = k");

        diophantus(81860, 1);
        diophantus(9009, 4);
        diophantus(9009, 3);
        diophantus(9009, 1);
        diophantus(9009, 4);
        diophantus(9009, 9);
        diophantus(9009, 16);
        diophantus(9009, 25);
        diophantus(9009, 36);
        diophantus(9009, 49);
        diophantus(9009, 64);
        diophantus(9009, 81);
        diophantus(9009, 100);
        diophantus(9009, 121);
        diophantus(9009, 144);
        diophantus(9009, 169);
        diophantus(9009, 196);
        diophantus(9009, 225);
        diophantus(9009, 256);
        diophantus(9009, 289);
        diophantus(9009, 324);
        diophantus(9009, 361);
        diophantus(9009, 400);

        diophantus(1000000, 3);
        diophantus(1000000, 1);
        diophantus(1000000, 4);
        diophantus(1000000, 9);
        diophantus(1000000, 16);
        diophantus(1000000, 25);
        diophantus(1000000, 36);
        diophantus(1000000, 49);
        diophantus(1000000, 64);
        diophantus(1000000, 81);
        diophantus(1000000, 100);
        diophantus(1000000, 121);
        diophantus(1000000, 144);
        diophantus(1000000, 169);
        diophantus(1000000, 196);
        diophantus(1000000, 225);
        diophantus(1000000, 256);
        diophantus(1000000, 289);
        diophantus(1000000, 324);
        diophantus(1000000, 361);
        diophantus(1000000, 400);
    }

    private static String diophantus(long k, int n) {

        if (Math.sqrt(n) % 1 != 0) {
            System.out.println("\nVariable 'n' inside equation 'x^2 - ny^2 = k' is supposed to be a square number\n");
            return null;
        }

        StringJoiner sj = new StringJoiner(",", "[", "]");

        for (long i = 1; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {

                long j = k / i;
                if ((j - i) % n != 0) continue;

                long x = (j + i) / 2;
                long y = (long) ((j - x) / Math.sqrt(n));

                //comment out this 'if' statement and use this method while 'k' = 81860 and 'n' = 1, you'll get  x's and y's that don't satisfy the equation
                if (x == y || (x * x) - n * (y * y) != k) continue;

                sj.add(String.format("[x = %d, y = %d]", x, y));
            }
        }

        System.out.println("n = " + n + ", k = " + k + "" +
                "\n" +
                sj.toString() + "\n");
        return sj.toString();
    }
}
