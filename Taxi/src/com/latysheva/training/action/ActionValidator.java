package com.latysheva.training.action;

import com.latysheva.training.item.AutoType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ActionValidator {
    static Logger logger = LogManager.getLogger("ActionValidator");

    private static final String REG_EXP_FOR_REG_NIMBER = "\\d\\d\\d\\d[a-zA-Z][a-zA-Z][1-7]";   //первые 4 символов - цифры, 5-6 символы - буквы, 7 символ цифра от 1 до 7

    // проверка на валидность БЕЛОРУССКОГО гос.номера
    private static boolean isRegNumberValid(String regNumber) {
        if ((regNumber.length() == 7) && (regNumber.matches(REG_EXP_FOR_REG_NIMBER))) {
            logger.debug("ActionValidator.isRegNumberValid: RegNumber format is valid.");
            return true;
        } else {
            logger.error("ActionValidator.isRegNumberValid: RegNumber format is not valid.");
            return false;
        }
    }

    //проверка, явяется ли строка элементом enum AutoType
    public static boolean isAcceptableType(String string) {
        AutoType[] autoTypes = AutoType.values();
        String s = string.toUpperCase();
        for (AutoType autoType : autoTypes) {
            if (s.equals(autoType.name())) {
                return true;
            }
        }
        logger.error("ActionValidator.isAcceptableType: Value is not Autotype.");
        return false;
    }

    //проверка, является строка целочисленым числом
    private static boolean isValidIntValue(String string) {
        try {
            int i = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            logger.error("ActionValidator.isValidIntValue: Value is not integer.");
            return false;
        }
    }

    private static boolean isValidDoubleValue(String string) {
        try {
            double value = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException nfe) {
            logger.error("ActionValidator.isValidDoubleValue: Value is not double.");
            return false;
        }
    }


    private static boolean isValidBoolValue(String string) {
        try {
            int i = Integer.parseInt(string);
            return (i == 1) || (i == 0);
        } catch (NumberFormatException nfe) {
            logger.error("ActionValidator.isValidBoolValue: Invalid value for boolean field.");
            return false;
        }
    }


    //првоерка валидности параметров для объекта Auto
    public static boolean isAutoParamsValid(String initString) {
        ArrayList<String> listOfParams = Action.parseString(initString);
        if (isRegNumberValid(listOfParams.get(2))) {
            if (isValidDoubleValue(listOfParams.get(3))) {
                if (isValidDoubleValue(listOfParams.get(4))) {
                    logger.debug("ActionValidator.isAutoParamsValid: Input parameters are valid for type Auto");
                    return true;
                }
            }
        }
        logger.error("ActionValidator.isAutoParamsValid: Input parameters are not valid for type Auto");
        return false;
    }

    //првоерка валидности параметров для объекта Car
    public static boolean isCarParamsValid(String initString) {
        ArrayList<String> listOfParams = Action.parseString(initString);
        if ((listOfParams.size() == 7) && (isAutoParamsValid(initString))
                && (isValidIntValue(listOfParams.get(5)))
                && (isValidBoolValue(listOfParams.get(6)))) {
            logger.debug("ActionValidator.isCarParamsValid: Input parameters are valid for type Car");
            return true;
        } else {
            logger.error("ActionValidator.isCarParamsValid: Input parameters are not valid for type Car");
            return false;
        }

    }

    //првоерка валидности параметров для объекта Minibus
    public static boolean isMinibusParamsValid(String initString) {
        ArrayList<String> listOfParams = Action.parseString(initString);
        if (((listOfParams.size() == 8) && (isAutoParamsValid(initString))
                && (isValidIntValue(listOfParams.get(5)))
                && (isValidBoolValue(listOfParams.get(6)))
                && (isValidIntValue(listOfParams.get(7))))) {
            logger.debug("ActionValidator.isMinibusParamsValid: Input parameters are valid for type Minibus");
            return true;
        } else {
            logger.error("ActionValidator.isMinibusParamsValid: Input parameters are not valid for type Minibus");
            return false;
        }
    }

    //првоерка валидности параметров для объекта Truck
    public static boolean isTruckParamsValid(String initString) {
        ArrayList<String> listOfParams = Action.parseString(initString);
        if ((listOfParams.size() == 6) && (isAutoParamsValid(initString))
                && (isValidIntValue(listOfParams.get(5)))) {
            logger.debug("ActionValidator.isTruckParamsValid: Input parameters are valid for type Truck");
            return true;
        } else {
            logger.error("ActionValidator.isTruckParamsValid: Input parameters are not valid for type Truck");
            return false;
        }
    }
}
