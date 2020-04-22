package com.smoothstack.assignments.three.partone;

import java.util.Comparator;

public class SortStrByLength implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}