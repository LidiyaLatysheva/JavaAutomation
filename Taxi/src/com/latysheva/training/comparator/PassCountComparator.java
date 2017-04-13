package com.latysheva.training.comparator;

import com.latysheva.training.item.Auto;
import com.latysheva.training.item.Car;

import java.util.Comparator;

/**
 * Created by Lidziya_Latyshava on 3/1/2017.
 */
public class PassCountComparator  implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return ((Car) o1).getPassCount() - ((Car) o2).getPassCount();
    }
}
