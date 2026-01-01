package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String currencyRate = Converter.getCurrencyByDate(formatter.format(today));
        Path path = Path.of("src/main/resources/valutes.xml");
        Files.writeString(path, currencyRate);

        ValCurs valCurs = new ValCurs();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse("src/main/resources/valutes.xml");
        Node root = document.getFirstChild();
        NamedNodeMap attributes = root.getAttributes();

        System.out.println(root);
        System.out.println(attributes);

        for (int i = 0; i < attributes.getLength(); i++) {
            valCurs.getAttributes().put(attributes.item(i).getNodeName(), attributes.item(i).getNodeValue());
        }

        NodeList childNode = root.getChildNodes();

        System.out.println(childNode);

//        System.out.println(currencyRate);
    }
}