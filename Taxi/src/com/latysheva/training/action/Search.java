package com.latysheva.training.action;

import com.latysheva.training.item.Auto;
import com.latysheva.training.item.Car;
import com.latysheva.training.item.Minibus;
import com.latysheva.training.item.Truck;

import java.util.ArrayList;

public class Search {

    public static ArrayList<Auto> searchByModel(ArrayList<Auto> autoList, String model) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto anAutoList : autoList) {
            if (anAutoList.getModel().contains(model)) {
                autoResult.add(anAutoList);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByPrice(ArrayList<Auto> autoList, double price) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            Double tmp = auto.getPrice();
            if (tmp.compareTo(price) == 0) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByPrice(ArrayList<Auto> autoList, double priceFrom, double priceTo) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            Double tmp = auto.getPrice();
            if ((tmp.compareTo(priceFrom) >= 0) && (tmp.compareTo(priceTo) <= 0)) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByRentPrice(ArrayList<Auto> autoList, double price) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto anAutoList : autoList) {
            Double tmp = anAutoList.getRentPrice();
            if (tmp.compareTo(price) == 0) {
                autoResult.add(anAutoList);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByRentPrice(ArrayList<Auto> autoList, double priceFrom, double priceTo) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            Double tmp = auto.getRentPrice();
            if ((tmp.compareTo(priceFrom) >= 0) && (tmp.compareTo(priceTo) <= 0)) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByPassCount(ArrayList<Auto> autoList, int passCount) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            if ((auto instanceof Car) && (((Car) auto).getPassCount() == passCount)) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByCarrying(ArrayList<Auto> autoList, int carrying) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            if ((auto instanceof Truck) && (((Truck) auto).getCarrying() >= carrying)) {
                autoResult.add(auto);
            } else if ((auto instanceof Minibus) && (((Minibus) auto).getCarrying() >= carrying)) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

    public static ArrayList searchByBabySeat(ArrayList<Auto> autoList, boolean babySeat) {
        ArrayList<Auto> autoResult = new ArrayList<>();
        for (Auto auto : autoList) {
            if ((auto instanceof Car) && (((Car) auto).isBabySeatAvailable() == babySeat)) {
                autoResult.add(auto);
            }
        }
        return autoResult;
    }

}
