package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;

import java.util.Comparator;


public class RegNumberComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getRegNumber().compareToIgnoreCase(o2.getRegNumber());
    }
}
