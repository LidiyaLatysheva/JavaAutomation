package com.latysheva.training.matrix;

import java.util.Scanner;

/**
 * Created by Lidziya_Latyshava on 4/4/2017.
 */
public class TurnTheMatrix {

    public static void main(String[] args) {

        int m = 0;
        int n = 0;
        boolean exitFlag = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter correct matrix sizes. Both values should be positive integer: ");
            if (sc.hasNextInt()) {
                m = sc.nextInt();
                if (m > 0) {
                    if (sc.hasNextInt()) {
                        n = sc.nextInt();
                        if (n > 0) {
                            exitFlag = true;
                            String[][] inputMatrix = new String[m][n];
                            System.out.print("Enter matrix " + m + " x " + n + ": ");

                            for (int i = 0; i < m; i++)
                                for (int j = 0; j < n; j++) {
                                inputMatrix[i][j] = sc.next();
                                }
                            String[][] resultMatrix = new String[n][m];
                            for (int i = 0; i < n; i++)
                                for (int j = 0; j < m; j++) {
                                    resultMatrix[i][j] = inputMatrix[m - j - 1][i];
                                }

                            System.out.println("Input matrix:");
                            for (int i = 0; i < inputMatrix.length; i++) {
                                for (int j = 0; j < inputMatrix[0].length; j++) {
                                    System.out.printf("%5s", inputMatrix[i][j]);
                                }
                                System.out.println();
                            }
                            System.out.println();
                            System.out.println("Result matrix:");
                            for (int i = 0; i < resultMatrix.length; i++) {
                                for (int j = 0; j < resultMatrix[0].length; j++) {
                                    System.out.format("%5s ", resultMatrix[i][j]);
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.print("Negative 2 number invalid input. Try again.");
                            exitFlag = false;
                        }
                    } else {
                        System.out.print("Not  a nubmer 2: invalid input. Try again.");
                        exitFlag = false;
                    }
                } else {
                    System.out.print("Negative 1 number invalid input. Try again.");
                    exitFlag = false;
                }
            } else {
                System.out.print("Not a number 1: invalid input. Try again.");
                exitFlag = false;
            }
        } while (!exitFlag);
    }
}
