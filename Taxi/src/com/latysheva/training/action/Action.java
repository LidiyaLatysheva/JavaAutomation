package com.latysheva.training.action;

import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.item.*;

import java.util.ArrayList;

/**
 * Created by Lidziya_Latyshava on 2/24/2017.
 */
public class Action {
    final static String REG_EX_FOR_SPLIT = " ";

    //string parser
    public static ArrayList<String> parseString(String string) {
        String[] s = string.split(REG_EX_FOR_SPLIT);
        ArrayList<String> listOfStrings = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("")) {
                listOfStrings.add(s[i]);
            }
        }
        return listOfStrings;
    }

    /*public static String toString(Auto auto) throws IncorrectInputDataException {
        if (!auto.equals(null)) {
            String s = "";
            if (auto instanceof Minibus) {
                Minibus autoTMP = (Minibus) auto;
                s = AutoType.MINIBUS.toString() + " " +
                        autoTMP.getModel() + " " +
                        autoTMP.getRegNumber() + " " +
                        autoTMP.getPrice() + " " +
                        autoTMP.getRentPrice() + " " +
                        autoTMP.getPassCount() + " " +
                        autoTMP.getStringValueIsBabySeatAvailable() + " " +
                        autoTMP.getCarrying();
                return s;
            } else if (auto instanceof Car) {
                Car autoTMP = (Car) auto;
                s = AutoType.CAR.toString() + " " +
                        autoTMP.getModel() + " " +
                        autoTMP.getRegNumber() + " " +
                        autoTMP.getPrice() + " " +
                        autoTMP.getRentPrice() + " " +
                        autoTMP.getPassCount() + " " +
                        autoTMP.getStringValueIsBabySeatAvailable();
                return s;
            } else if (auto instanceof Truck) {
                Truck autoTMP = (Truck) auto;
                s = AutoType.TRUCK.toString() + " " +
                        autoTMP.getModel() + " " +
                        autoTMP.getRegNumber() + " " +
                        autoTMP.getPrice() + " " +
                        autoTMP.getRentPrice() + " " +
                        autoTMP.getCarrying();
                return s;
            } else throw new IncorrectInputDataException("Invalid object. Can't create a string for it");
        } else throw new IncorrectInputDataException("Object shouldn't be NULL. Can't create a string for it");

    }*/

    //TODO
    //sorting by parameters

    //calculate price
    public static double calculatePriceOfTaxiSation(TaxiStation taxiStation) throws IncorrectInputDataException {
        if (taxiStation == null) {
            throw new IncorrectInputDataException("TaxiStation can't be NULL. Correct your data.");
        } else {
            int size = taxiStation.getTaxiStationAuto().size();
            double price = 0;
            for (int i = 0; i < size; i++) {
                price += taxiStation.getTaxiStationAuto().get(i).getPrice();
            }
            return price;
        }
    }

    // calculate rent price
    public static double calculateRentPriceOfTaxiSation(TaxiStation taxiStation) throws IncorrectInputDataException {
        if (taxiStation == null) {
            throw new IncorrectInputDataException("TaxiStation can't be NULL. Correct your data.");
        } else {
            int size = taxiStation.getTaxiStationAuto().size();
            double rentPrice = 0;
            for (int i = 0; i < size; i++) {
                rentPrice += taxiStation.getTaxiStationAuto().get(i).getRentPrice();
            }
            return rentPrice;
        }
    }

}
