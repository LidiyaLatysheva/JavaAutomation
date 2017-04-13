package com.latysheva.training.parser;

import com.latysheva.training.action.ActionValidator;
import com.latysheva.training.exception.IncorrectInputDataException;
import com.latysheva.training.item.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lidziya_Latyshava on 3/27/2017.
 */
public class DOMParser {
    private DocumentBuilder docBuilder;
    static Logger logger = LogManager.getLogger("DOMParser");

    private Set<Auto> autos;

    public DOMParser() {
        this.autos = new HashSet<Auto>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Auto> getAutos() {
        return autos;
    }

    public void buildSetAutos(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>


            NodeList carList = root.getElementsByTagName("CAR");
            for (int i = 0; i < carList.getLength(); i++) {
                Element autoElement = (Element) carList.item(i);
                Auto auto = null;
                try {
                    auto = buildAuto("CAR", autoElement);
                } catch (IncorrectInputDataException e) {
                    e.printStackTrace();
                }
                autos.add(auto);
            }

            NodeList truckList = root.getElementsByTagName("TRUCK");
            for (int i = 0; i < truckList.getLength(); i++) {
                Element autoElement = (Element) truckList.item(i);
                Auto auto = null;
                try {
                    auto = buildAuto("TRUCK", autoElement);
                } catch (IncorrectInputDataException e) {
                    e.printStackTrace();
                }
                autos.add(auto);
            }

            NodeList minibusList = root.getElementsByTagName("MINIBUS");
            for (int i = 0; i < minibusList.getLength(); i++) {
                Element autoElement = (Element) minibusList.item(i);
                Auto auto = null;
                try {
                    auto = buildAuto("MINIBUS", autoElement);
                } catch (IncorrectInputDataException e) {
                    e.printStackTrace();
                }
                autos.add(auto);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }


    private Auto buildAuto(String type, Element autoElement) throws IncorrectInputDataException {
        Auto auto = null;
        AutoType autoType;
        if (ActionValidator.isAcceptableType(type)) {
            autoType = AutoType.valueOf(type);

            switch (autoType) {
                case CAR: {
                    String model = getElementTextContent(autoElement, "model");
                    String regNumber = getElementTextContent(autoElement, "regNumber");
                    int price = Integer.parseInt(getElementTextContent(autoElement, "price"));
                    int rentPrice = Integer.parseInt(getElementTextContent(autoElement, "rentPrice"));
                    int passCount = Integer.parseInt(getElementTextContent(autoElement, "passCount"));
                    boolean isBabySeatAvailable = Boolean.parseBoolean(getElementTextContent(autoElement, "isBabySeatAvailable"));
                    auto = new Car(model, regNumber, price, rentPrice, passCount, isBabySeatAvailable);
                    logger.info("AutoCreator.createAuto: CAR is created.");
                    return auto;
                }

                case MINIBUS: {
                    String model = getElementTextContent(autoElement, "model");
                    String regNumber = getElementTextContent(autoElement, "regNumber");
                    int price = Integer.parseInt(getElementTextContent(autoElement, "price"));
                    int rentPrice = Integer.parseInt(getElementTextContent(autoElement, "rentPrice"));
                    int passCount = Integer.parseInt(getElementTextContent(autoElement, "passCount"));
                    boolean isBabySeatAvailable = Boolean.parseBoolean(getElementTextContent(autoElement, "isBabySeatAvailable"));
                    int carrying = Integer.parseInt(getElementTextContent(autoElement, "carrying"));
                    auto = new Minibus(model, regNumber, price, rentPrice, passCount, isBabySeatAvailable, carrying);
                    logger.info("AutoCreator.createAuto: MINIBUS is created.");
                    return auto;
                }

                case TRUCK: {
                    String model = getElementTextContent(autoElement, "model");
                    String regNumber = getElementTextContent(autoElement, "regNumber");
                    int price = Integer.parseInt(getElementTextContent(autoElement, "price"));
                    int rentPrice = Integer.parseInt(getElementTextContent(autoElement, "rentPrice"));
                    int carrying = Integer.parseInt(getElementTextContent(autoElement, "carrying"));
                    auto = new Truck(model, regNumber, price, rentPrice, carrying);
                    logger.info("AutoCreator.createAuto: TRUCK is created.");
                    return auto;
                }
            }
        } else {
            logger.error("AutoCreator.createAuto: I'm unable to create an Object because of invalid parameters.");
            throw new IncorrectInputDataException( "AutoCreator.createAuto: Input data is not valid for AUTO type. Please, correct the data." );
        }
        return auto;
    }
    // получение текстового содержимого тега

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

