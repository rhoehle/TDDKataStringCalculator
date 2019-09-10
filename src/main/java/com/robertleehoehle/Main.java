package com.robertleehoehle;

import java.util.Scanner;

/**
 * @author Robert Hoehle
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Enter two numbers separated by a comma(,) with no spaces (e.g. 2,7):");
        Scanner sc = new Scanner(System.in);

        String inputs = sc.next();
        System.out.println("Answer: " + TDDKataStringCalculator.add(inputs));

    }

}
