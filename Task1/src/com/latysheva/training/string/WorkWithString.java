package com.latysheva.training.string;

import java.util.Scanner;

/**
 * Created by Lidziya_Latyshava on 4/4/2017.
 */
public class WorkWithString {


    public static void main(String[] args) {

        //revert string
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String input = sc.next();
            String result = new StringBuilder(input).reverse().toString();
            System.out.println(result);
        }
    }
}
