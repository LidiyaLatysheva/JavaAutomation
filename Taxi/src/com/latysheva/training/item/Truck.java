package com.latysheva.training.item;

/**
 * Created by Lidziya_Latyshava on 2/23/2017.
 */
public class Truck extends Auto {
    private int carrying;   //грузоподъемность

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }


    public Truck(String model, String regNumber, double price, double rentPrice, int carrying) {
        super( model, regNumber, price, rentPrice );
        this.carrying = carrying;
    }

    //@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Truck auto = (Truck) obj;
        if (getRegNumber() == null) {
            if (auto.getRegNumber() != null)
                return false;
        } else if (!getRegNumber().equals(auto.getRegNumber()))
            return false;
/*
        if (getModel() == null) {
            if (auto.getModel() != null)
                return false;
        } else if (!getModel().equals(auto.getModel()))
            return false;
        if (((Double) auto.getPrice()).compareTo(getPrice()) != 0)
            return false;
        if (((Double) auto.getRentPrice()).compareTo(getRentPrice()) != 0)
            return false;
        if (carrying != auto.carrying)
            return false;
*/
        return true;
    }

    @Override
    public String toString(){
        String s = AutoType.TRUCK.toString() + " " +
                getModel() + " " +
                getRegNumber() + " " +
                getPrice() + " " +
                getRentPrice() + " " +
                getCarrying();
        return s;
    }
}
