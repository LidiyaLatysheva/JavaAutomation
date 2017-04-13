package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;
import com.latysheva.training.item.Truck;

import java.util.Comparator;

/**
 * Created by Lidziya_Latyshava on 3/1/2017.
 */
public class TruckCarryingComparator implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return ((Truck) o1).getCarrying() - ((Truck) o2).getCarrying();
    }
}