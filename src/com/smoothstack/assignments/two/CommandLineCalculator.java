package com.smoothstack.assignments.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLineCalculator {

    public void run() {
        double total = addValues(readUserInput());
        System.out.println("Sum of values: " + total);
    }

    public static void main(String[] args) {
    }

    private List<Double> readUserInput() {
        List<Double> userNumbers = new ArrayList<Double>(); 
        boolean completedInput = false;

        while(completedInput == false) {
            try {
                Scanner scan = new Scanner(System.in);

                readInstructions();

                String userInput = scan.nextLine();
                String[] userInputArray = userInput.split(" ");

                for(String item : userInputArray) {
                    userNumbers.add(Double.parseDouble(item));
                }

                completedInput = true;
            } catch (Exception e) {
                System.out.printf("%nSorry you did not input numbers. Please try again.%n%n");
            }
        }

        return userNumbers;
    }

    private double addValues(List<Double> userValues) {
        double total = 0;
        for(double item : userValues) {
            total += item;
        }

            return total;
    }

    private void readInstructions() {
        System.out.println("Please input the values you would like to be added with a space seperating them. You may input integers or decimals.");
        System.out.println("Ex. Input: '2.5 1.5 3' ");
        System.out.println("Ex. 'Sum of Values: 7'");
        System.out.println("Hit Enter when you have inputed all the values you wish to be added.");
    }

}