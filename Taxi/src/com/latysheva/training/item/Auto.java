package com.latysheva.training.item;

/**
 * Created by Lidziya_Latyshava on 2/23/2017.
 */
public class Auto {
    private String model;       //модель авто
    private String regNumber;   //гос.номер
    private double price;       //цена авто
    private double rentPrice;   //цена поездки/км пути

    public Auto(String model, String regNumber, double price, double rentPrice) {
        this.model = model;
        this.regNumber = regNumber;
        this.price = price;
        this.rentPrice = rentPrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }


    //@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auto auto = (Auto) obj;
        if (regNumber == null) {
            if (auto.regNumber != null)
                return false;
        } else if (!regNumber.equals(auto.regNumber))
            return false;
/*
        if (model == null) {
            if (auto.model != null)
                return false;
        } else if (!model.equals(auto.model))
            return false;
        if (((Double) auto.price).compareTo(price) != 0)
            return false;
        if (((Double) auto.rentPrice).compareTo(rentPrice) != 0)
            return false;
*/
        return true;
    }
}
