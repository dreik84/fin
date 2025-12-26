package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    public static String getCurrencyByDate(String date) throws IOException, InterruptedException {
        URI uri = URI.create("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body().toString();
    }
}
