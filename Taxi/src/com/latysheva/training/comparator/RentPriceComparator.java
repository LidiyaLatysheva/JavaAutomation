package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;

import java.util.Comparator;


public class RentPriceComparator  implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {

        return Double.compare(o1.getRentPrice(), o2.getRentPrice());
    }
}
