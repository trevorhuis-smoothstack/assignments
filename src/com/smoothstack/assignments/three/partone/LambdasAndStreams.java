package com.smoothstack.assignments.three.partone;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdasAndStreams {

    private List<String> arrString = Arrays.asList("hello", "create", "develop", "moment", "eleven", "it", "taught", "ate",
            "be", "supercalifragilisticexpialidocious", "slack", "smoothstack", "ape");

    public static void main(String[] args) {
        LambdasAndStreams q1 = new LambdasAndStreams();
        q1.sortByLength();
        q1.sortByLengthRev();
        q1.sortByFirstChar();
        q1.putStrWithEFirst();
        q1.assignOddOrEven();
        q1.startsAandThreeLetters();
    }

    public void sortByLength() {
        Collections.sort(arrString, new SortStrByLength()); 
  
        System.out.println("\nSort by Length:"); 
        arrString.forEach(e  -> {
            System.out.println(e);
        });
    }

    public void sortByLengthRev() {
        Comparator<String> compByLengthRev = (a, b) -> b.length() - a.length();

        System.out.println("\nSort by Length Reverse:"); 
        arrString.stream().sorted(compByLengthRev).forEach(System.out::println);
    }

    public void sortByFirstChar() {
        Comparator<String> compByFirstChar = (a, b) -> a.charAt(0) - b.charAt(0);

        System.out.println("\nSort by First Char:"); 
        arrString.stream().sorted(compByFirstChar).forEach(System.out::println);
    }

    public void putStrWithEFirst() {
        System.out.println("\nSort by First Letter being E:"); 
        Comparator<String> compByLetterE = (a, b) -> {
            if(a.charAt(0) == 'e') {
                return -1;
            }
            return 0;
        };
        
        arrString.stream().sorted(compByLetterE).forEach(System.out::println);
    }

    public void putStrWithEFirstTwo() {
        System.out.println("\nSort by First Letter being E Two:"); 
        Collections.sort(arrString, new SortByFirstLetterE()); 
  
        System.out.println("\nSort by Length:"); 
        arrString.forEach(e  -> {
            System.out.println(e);
        });
    }

    public void assignOddOrEven() {
        System.out.println("\nAssign Int odd or Even"); 
        List<Integer> arrInt = Arrays.asList(12, 432, 1, 7, 454, 9, 11, 20);

        String oddOrEvenStr = arrInt.stream()
            .map(e -> {
                if(e % 2 == 0) {
                    return "e" + e.toString();
                } else {
                    return "o" + e.toString();
                }
            })
            .collect(Collectors.joining(","));

        System.out.println("\n" + oddOrEvenStr);
    }   

    public void startsAandThreeLetters() {
        System.out.println("\nWords that start with 'a' and have only 3 letters."); 
        List<String> listOutput = arrString.stream()
            .filter(e -> e.charAt(0) == 'a' && e.length() == 3)
            .collect(Collectors.toList());

        listOutput.stream().forEach(System.out::println);
    }
    

}