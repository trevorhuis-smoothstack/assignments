package com.smoothstack.assignments.three.partone;

import java.util.Comparator;

public class SortByFirstLetterE implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.charAt(0) == 'e') {
            return -1;
        }
        return 0;
    }

}