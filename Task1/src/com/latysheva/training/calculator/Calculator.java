package com.latysheva.training.calculator;

import java.util.Scanner;

public class Calculator {
    private static final String[] operationType = {"*", ":", "/", "-", "+"};

    public static void main(String[] args) {
        boolean exitFlag = false;
        do {
            double digit1 = 0;
            double digit2 = 0;
            double result = 0;
            String operation = "";
            boolean flag = false;
            Scanner scanner = new Scanner(System.in);
            do {
                if (scanner.hasNextDouble()) {
                    digit1 = scanner.nextDouble();
                    if (scanner.hasNext()) {
                        operation = scanner.next();
                        for (int i = 0; i < operationType.length; i++) {
                            if (!operation.equals(operationType[i])) {
                                flag = false;
                            } else {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("operation: Incorrect input. Try again.");
                            break;
                        }
                        if (scanner.hasNextDouble()) {
                            digit2 = scanner.nextDouble();
                        } else {
                            System.out.println("digit2 : Incorrect input. Try again.");
                            flag = false;
                            break;
                        }
                    }
                } else {
                    System.out.println(" digit1: Incorrect input. Try again.");
                    flag = false;
                    break;
                }
            } while (!flag);
            if (flag) {
                switch (operation) {
                    case "+":
                        result = digit1 + digit2;
                        break;
                    case "-":
                        result = digit1 - digit2;
                        break;
                    case "/":
                        result = digit1 / digit2;
                        break;
                    case ":":
                        result = digit1 / digit2;
                        break;
                    case "*":
                        result = digit1 * digit2;
                        break;
                    default:
                        result = 0;
                }
                System.out.println("Result is: " + digit1 + " " + operation + " " + digit2 + " = " + result);
                System.out.println("Enter any key to continue or enter q to exit");

                if (scanner.hasNext()) {
                    String str = scanner.next();
                    if (str.equals("q")) {
                        exitFlag = true;
                    }
                }
            }
        } while (!exitFlag);
    }
}
