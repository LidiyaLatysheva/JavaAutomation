package com.latysheva.training.factory;


import com.latysheva.training.action.InputOutput;
import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.factory.AutoCreator;
import com.latysheva.training.item.Auto;
import com.latysheva.training.item.TaxiStation;
import com.latysheva.training.parser.DOMParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TaxiStationCreatorXML_DOM {
    static Logger logger = LogManager.getLogger("TaxiStationCreator");

    public static TaxiStation createTaxiStation(String filePath) {
        DOMParser parser = new DOMParser();
        parser.buildSetAutos("data/taxiStation.xml");
        System.out.println(parser.getAutos());
        ArrayList<Auto> autoList = new ArrayList<>(parser.getAutos());
        TaxiStation taxiStation = new TaxiStation(autoList);
        return taxiStation;
    }
}
