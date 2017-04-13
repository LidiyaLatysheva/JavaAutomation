package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;
import com.latysheva.training.item.Minibus;

import java.util.Comparator;

public class MinibusCarryingComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return ((Minibus) o1).getCarrying() - ((Minibus) o2).getCarrying();
    }
}
