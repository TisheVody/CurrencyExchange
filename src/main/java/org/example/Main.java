package org.example;

import org.example.service.CurrencyService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CurrencyService currencyService = new CurrencyService();
        currencyService.addCurrency("RUB", "Russian ruble", "₽");
        System.out.println(currencyService.getAllCurrencies());
    }
}