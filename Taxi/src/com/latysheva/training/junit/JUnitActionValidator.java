package com.latysheva.training.junit;

import com.latysheva.training.action.Action;
import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.factory.TaxiStationCreator;
import com.latysheva.training.item.TaxiStation;
import org.junit.Assert;
import org.junit.Test;


public class JUnitActionValidator {
    @Test
    public void calculatePriceOfTaxiSationTest() {
        String filePath = "resource\\correct.txt";
        double sum = 42037;
        double calculatedSum = 0;
        TaxiStation taxiStation = TaxiStationCreator.createTaxiStation(filePath);
        try {
            calculatedSum = Action.calculatePriceOfTaxiSation(taxiStation);
        } catch (IncorrectInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(((Double) sum).compareTo(calculatedSum) == 0);
    }

    @Test
    public void calculateRentPriceOfTaxiSationTest() {
        String filePath = "resource\\correct.txt";
        double sum = 247;
        double calculatedSum = 0;
        TaxiStation taxiStation = TaxiStationCreator.createTaxiStation(filePath);
        try {
            calculatedSum = Action.calculateRentPriceOfTaxiSation(taxiStation);
        } catch (IncorrectInputDataException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(((Double) sum).compareTo(calculatedSum) == 0);
    }
}
