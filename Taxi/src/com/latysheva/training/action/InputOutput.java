package com.latysheva.training.action;

import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.item.Auto;
import com.latysheva.training.item.TaxiStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class InputOutput {
    static Logger logger = LogManager.getLogger("InputOutput");


    public static ArrayList<String> readFromFile(String filePath) {
        Set<String> fileStringsSet = new HashSet<String>();
        logger.info("InputOutput.readFromFile: Reading initial data from file...");
        try {
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(fileStringsSet::add);
        } catch (FileNotFoundException fnfe) {
            logger.fatal("InputOutput.readFromFile: File not found by the path specified: " + filePath);
            fnfe.printStackTrace();

        } catch (IOException ioe) {
            logger.error("InputOutput.readFromFile: IOException has been caught.");
            ioe.printStackTrace();
        }
        ArrayList<String> fileStringsArrayList = new ArrayList<String>(fileStringsSet);
        return fileStringsArrayList;
    }

    public static void printResultTaxiStationToFile(TaxiStation taxiStation, String fileToWrite) {
        logger.info("InputOutput.printResultTaxiStationToFile: Writing result Taxi station to file...");
        int size = taxiStation.getTaxiStationAuto().size();
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);
            for (int i = 0; i < size; i++) {
                String line = taxiStation.getTaxiStationAuto().get(i).toString() + ". \n ";
                fileWriter.write(line);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error("InputOutput.printResultTaxiStationToFile: File not found by the path specified: " + fileToWrite);
            e.printStackTrace();
        }
    }

    public static void printResultToFile(String message, String value, String fileToWrite) {
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);
            String line = message + " " + value + ". \n ";
            fileWriter.write(line);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error("InputOutput.printResultToFile: Problems with writing to file");
            e.printStackTrace();
        }
    }

    public static void printResultAutoListToFile(ArrayList<Auto> autoList, String fileToWrite) {

        int size = autoList.size();
        try {
            FileWriter fileWriter = new FileWriter(fileToWrite);
            for (int i = 0; i < size; i++) {
                String line = autoList.get(i).toString() + ". \n ";
                fileWriter.write(line);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error("InputOutput.printResultAutoListToFile: Problems with writing to file");
            e.printStackTrace();
        }
    }
}
