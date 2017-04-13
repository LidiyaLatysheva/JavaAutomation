package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;

import java.util.Comparator;

/**
 * Created by Lidziya_Latyshava on 3/1/2017.
 */
public class PriceComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {

        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
