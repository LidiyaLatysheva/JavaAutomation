package com.latysheva.training.item;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class TaxiStation {
    static Logger logger = LogManager.getLogger("AutoCreator");
    private ArrayList<Auto> taxiStationAuto;

    public TaxiStation() {
        super();
    }

    public TaxiStation(ArrayList<Auto> taxiStationAuto) {
        super();
        this.taxiStationAuto = taxiStationAuto;
    }

    public ArrayList<Auto> getTaxiStationAuto() {
        return taxiStationAuto;
    }

    public void setTaxiStationAuto(ArrayList<Auto> taxiStationAuto) {
        this.taxiStationAuto = taxiStationAuto;
    }

    public ArrayList<String> taxiStationToAL() {
        ArrayList<Auto> taxiStationTMP = this.getTaxiStationAuto();
        ArrayList<String> strAL = new ArrayList<>();
        int size = taxiStationTMP.size();
        for (int i = 0; i < size; i++) {
            strAL.add(taxiStationTMP.get(i).toString());
        }
        return strAL;
    }
}
