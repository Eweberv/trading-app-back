package com.example.demo.Services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
@Service
public class CurrencyConversionService {
    Dotenv dotenv = Dotenv.load();

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        final String URL = dotenv.get("CURRENCY_API_URL") + fromCurrency.toLowerCase() + ".json";

        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(URL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        double convertedAmount = 0.0;

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode toCurrencyRateNode = rootNode.path(fromCurrency.toLowerCase()).path(toCurrency.toLowerCase());

            if (!toCurrencyRateNode.isMissingNode()) {
                double toCurrencyRate = toCurrencyRateNode.asDouble();
                convertedAmount = amount * toCurrencyRate;
            } else {
                throw new IllegalArgumentException("Convert rate not found for " + toCurrency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertedAmount;
    }
}