package com.latysheva.training.junit;


import com.latysheva.training.action.InputOutput;
import com.latysheva.training.comparator.PriceComparator;
import com.latysheva.training.comparator.RegNumberComparator;
import com.latysheva.training.factory.TaxiStationCreator;
import com.latysheva.training.item.Auto;
import com.latysheva.training.item.TaxiStation;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class JUnitSortValidator {
    @Test
    public void sortByRegNumberTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correct_resultSort_RegNumber.txt";
        String filePathSortResult = "resource\\correct_resultSorting_ RegNumber.txt";

        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        ArrayList<Auto> autoToSort = taxiStationToSearch.getTaxiStationAuto();
        Collections.sort(autoToSort, new RegNumberComparator());

        InputOutput.printResultAutoListToFile(autoToSort, filePathSortResult);
        File expectedFile = new File(filePathResult);
        File actualFile = new File(filePathSortResult);
        boolean fileCompare = false;
        try {
            fileCompare = FileUtils.contentEquals(expectedFile, actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(fileCompare);
    }

    @Test
    public void sortByPriceThenRegNumberTest() {
        String filePath = "resource\\correct.txt";
        String filePathResult = "resource\\correct_resultSort_PriceRegNumber.txt";
        String filePathSortResult = "resource\\correct_resultSorting_ PriceRegNumber.txt";

        TaxiStation taxiStationToSearch = TaxiStationCreator.createTaxiStation(filePath);
        ArrayList<Auto> autoToSort = taxiStationToSearch.getTaxiStationAuto();
        Collections.sort(autoToSort, new PriceComparator().thenComparing(new RegNumberComparator()));
        InputOutput.printResultAutoListToFile(autoToSort, filePathSortResult);
        File expectedFile = new File(filePathResult);
        File actualFile = new File(filePathSortResult);
        boolean fileCompare = false;
        try {
            fileCompare = FileUtils.contentEquals(expectedFile, actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(fileCompare);
    }
}
