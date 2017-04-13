package com.latysheva.training.factory;


import com.latysheva.training.action.InputOutput;
import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.item.Auto;
import com.latysheva.training.item.TaxiStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TaxiStationCreator {
    static Logger logger = LogManager.getLogger("TaxiStationCreator");

    public static TaxiStation createTaxiStation(String filePath) {
        //TODO
        //add itmes to hashset to avoid duplicates.
        ArrayList<Auto> autoList = new ArrayList<>();
        ArrayList<String> fileStrings = InputOutput.readFromFile(filePath);
        int size = fileStrings.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                try {
                    Auto tmpAuto = AutoCreator.createAuto(fileStrings.get(i));
                    if (tmpAuto != null) {
                        autoList.add(tmpAuto);
                    }
                } catch (IncorrectInputDataException e) {
                    logger.error("TaxiStationCreator.createTaxiStation: Incorrect input data for method AutoCreator.createAuto.");
                    e.printStackTrace();
                }
            }
        } else {
            logger.error("TaxiStationCreator.createTaxiStation: File is empty. Nothing to create.");
        }
        TaxiStation taxiStation = new TaxiStation(autoList);
        return taxiStation;
    }
}
