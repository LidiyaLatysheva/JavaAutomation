package com.latysheva.training.factory;

import com.latysheva.training.action.Action;
import com.latysheva.training.action.ActionValidator;
import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.item.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class AutoCreator {

    static Logger logger = LogManager.getLogger("AutoCreator");

    public static Auto createAuto(String initString) throws IncorrectInputDataException {
        ArrayList<String> listOfParams = Action.parseString( initString );
        Auto auto = null;
        try {
            AutoType type = AutoType.valueOf( listOfParams.get( 0 ) );
            if (ActionValidator.isAcceptableType( listOfParams.get( 0 ) )) {
                if (ActionValidator.isAutoParamsValid( initString )) {
                    String model = listOfParams.get( 1 );
                    String regNumber = listOfParams.get( 2 );
                    int price = Integer.parseInt( listOfParams.get( 3 ) );
                    int rentPrice = Integer.parseInt( listOfParams.get( 4 ) );
                    switch (type) {
                        case CAR: {
                            if (ActionValidator.isCarParamsValid( initString )) {
                                int passCount = Integer.parseInt( listOfParams.get( 5 ) );
                                int i = Integer.parseInt( listOfParams.get( 6 ) );
                                boolean isBabySeatAvailable = true;
                                if (i == 0) {
                                    isBabySeatAvailable = false;
                                }
                                auto = new Car( model, regNumber, price, rentPrice, passCount, isBabySeatAvailable );
                                logger.info("AutoCreator.createAuto: CAR is created.");
                                return auto;
                            } else {
                                logger.error("AutoCreator.createAuto: I'm unable to create an Object CAR. Exception is thrown.");
                                throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data is not valid for CAR type. Please, correct the data." );
                            }
                        }
                        case MINIBUS: {
                            if (ActionValidator.isMinibusParamsValid( initString )) {
                                int passCount = Integer.parseInt( listOfParams.get( 5 ) );
                                int i = Integer.parseInt( listOfParams.get( 6 ) );
                                boolean isBabySeatAvailable = true;
                                if (i == 0) {
                                    isBabySeatAvailable = false;
                                }
                                int carrying = Integer.parseInt( listOfParams.get( 7 ) );
                                auto = new Minibus( model, regNumber, price, rentPrice, passCount, isBabySeatAvailable, carrying );
                                logger.info("AutoCreator.createAuto: MINIBUS is created.");
                                return auto;
                            } else {
                                logger.error("AutoCreator.createAuto: I'm unable to create an Object MINIBUS. Exception is thrown.");
                                throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data is not valid for MINIBUS type. Please, correct the data." );
                            }
                        }
                        case TRUCK: {
                            if (ActionValidator.isTruckParamsValid( initString )) {
                                int carrying = Integer.parseInt( listOfParams.get( 5 ) );
                                auto = new Truck( model, regNumber, price, rentPrice, carrying );
                                logger.info("AutoCreator.createAuto: TRUCK is created.");
                                return auto;
                            } else {
                                logger.error("AutoCreator.createAuto: I'm unable to create an Object TRUCK. Exception is thrown.");
                                throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data is not valid for TRUCK type. Please, correct the data." );
                            }
                        }
                        default:
                            logger.error("AutoCreator.createAuto: I'm unable to create an Object. Exception is thrown.");
                            throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data contains incorrect auto type. Please, correct the data." );
                    }
                } else {
                    logger.error("AutoCreator.createAuto: I'm unable to create an Object because of invalid parameters.");
                    throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data is not valid for AUTO type. Please, correct the data." );
                }
            } else {
                logger.error("AutoCreator.createAuto: I'm unable to create an Object because auto type is missed.");
                throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data doesn't contain auto type. Please, correct the data." );
            }

        } catch (IllegalArgumentException e) {
            logger.error("AutoCreator.createAuto: Incorrect value for enum field is provided.");
        }
        return auto;
    }

}

