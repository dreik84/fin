package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String currencyRate = Converter.getCurrencyByDate("02/03/2002");
        System.out.println(currencyRate);
    }
}