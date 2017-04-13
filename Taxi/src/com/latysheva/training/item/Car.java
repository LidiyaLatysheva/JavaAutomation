package com.latysheva.training.item;

/**
 * Created by Lidziya_Latyshava on 2/23/2017.
 */
public class Car extends Auto {

    private int passCount;                  //максимальное допустимое кол-во пассажиров
    private boolean isBabySeatAvailable;    // наличие детского кресла в авто

    public Car(String model, String regNumber, double price, double rentPrice, int passCount, boolean isBabySeatAvailable) {
        super(model, regNumber, price, rentPrice);
        this.passCount = passCount;
        this.isBabySeatAvailable = isBabySeatAvailable;
    }


    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public String getStringValueIsBabySeatAvailable() {
        if (isBabySeatAvailable) {
            return "Baby_Seat_Is_Available";
        } else {
            return "Baby_Seat_Is_Not_Available";
        }
    }


    public boolean isBabySeatAvailable() {
        return isBabySeatAvailable;
    }

    public void setBabySeatAvailable(boolean babySeatAvailable) {
        isBabySeatAvailable = babySeatAvailable;
    }

    //@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car auto = (Car) obj;
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
        if (passCount != auto.passCount)
            return false;
        if (isBabySeatAvailable != auto.isBabySeatAvailable)
            return false;
*/
        return true;
    }

    @Override
    public String toString() {
        String s = AutoType.CAR.toString() + " " +
                getModel() + " " +
                getRegNumber() + " " +
                getPrice() + " " +
                getRentPrice() + " " +
                getPassCount() + " " +
                getStringValueIsBabySeatAvailable();
        return s;
    }
}



