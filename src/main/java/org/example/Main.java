package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JAXBException {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String currencyRate = Converter.getCurrencyByDate(formatter.format(today));

        StringReader reader = new StringReader(currencyRate);
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ValCurs valCurs = (ValCurs) unmarshaller.unmarshal(reader);

        System.out.println(currencyRate);
    }
}