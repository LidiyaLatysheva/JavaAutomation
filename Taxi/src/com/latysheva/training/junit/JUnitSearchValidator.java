package com.latysheva.training.junit;

import com.latysheva.training.action.Search;
import com.latysheva.training.factory.TaxiStationCreator;
import com.latysheva.training.item.Auto;
import com.latysheva.training.item.TaxiStation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


public class JUnitSearchValidator {
    @Test
    public void searchByModelTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_Model.txt";
        String model = "Audi";
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByModel(autoToSearch, model);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }

    @Test
    public void searchByPriceTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_Price.txt";
        double price = 54;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByPrice(autoToSearch, price);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }

    @Test
    public void searchByPriceFromToTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_PriceFromTo.txt";
        double priceFrom = 54;
        double priceTo = 545;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByPrice(autoToSearch, priceFrom, priceTo);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }

    @Test
    public void searchByRentPriceTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_RentPrice.txt";
        double price = 54;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByRentPrice(autoToSearch, price);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }

    @Test
    public void searchByRentPriceFromToTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_RentPriceFromTo.txt";
        double priceFrom = 30;
        double priceTo = 55;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByRentPrice(autoToSearch, priceFrom, priceTo);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }

    @Test
    public void searchByPassCountTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_PassCount.txt";
        int passCount = 3;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByPassCount(autoToSearch, passCount);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }


    @Test
    public void searchByCarryingTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_Crrying.txt";
        int carrying = 11;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByCarrying(autoToSearch, carrying);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }
    @Test
    public void searchByBabySeatTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correctResult_BabySeat.txt";
        boolean babySeat = true;
        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        TaxiStation taxiStationResult = TaxiStationCreator.createTaxiStation(filePathResult);
        ArrayList<Auto> autoToSearch = taxiStationToSearch.getTaxiStationAuto();
        ArrayList<Auto> autoToSearchResult = Search.searchByBabySeat(autoToSearch, babySeat);
        ArrayList<Auto> autoResult = taxiStationResult.getTaxiStationAuto();
        ArrayList<String> autoToSearchResultSTR = new ArrayList<>();
        for (int i = 0; i < autoToSearchResult.size(); i++) {
            autoToSearchResultSTR.add(autoToSearchResult.get(i).toString());
        }
        ArrayList<String> autoResultSTR = new ArrayList<>();
        for (Auto auto : autoResult) {
            autoResultSTR.add(auto.toString());
        }
        Collections.sort(autoResultSTR);
        Collections.sort(autoToSearchResultSTR);
        Assert.assertEquals(autoResultSTR, autoToSearchResultSTR);
    }
}
