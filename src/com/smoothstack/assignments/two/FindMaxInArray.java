package com.smoothstack.assignments.two;

import java.util.Arrays;
import java.util.Random;

public class FindMaxInArray {
    private Double[][] masterArr = new Double[8][8];

    public static void main(String[] args) {
        FindMaxInArray q2 = new FindMaxInArray();
        q2.run();
    }

    public FindMaxInArray() {
        initializeArray();
        
    }

    public void run() {
        printArray();
        findTheMaxValue();
        
    }

    private void initializeArray() {
        Random randGen = new Random();

        for(Double[] arr : masterArr) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = (randGen.nextDouble() * 100);
            }
        }
    }

    private void printArray() {
        for(Double[] arr : masterArr) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    private void findTheMaxValue() {
        Double max = masterArr[0][0];
        int iIndex = 0;
        int jIndex = 0;

        for (int i = 0; i < masterArr.length; i++) {
            for (int j = 0; j < masterArr[i].length; j++) {
                if (masterArr[i][j] > max) {
                    max = masterArr[i][j];
                    iIndex = i;
                    jIndex = j;
                }
            }
        }

        System.out.println("The max value is: " + max + ". Located at [" + iIndex + "][" + jIndex + "] in the above array.");
    }
}