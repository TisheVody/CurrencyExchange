package org.example.service;

import org.example.dao.CurrencyDao;
import org.example.model.CurrencyModel;

import java.sql.SQLException;
import java.util.List;

//work with dao
public class CurrencyService {
    private CurrencyDao currencyDao;

    public CurrencyService() {
        currencyDao = new CurrencyDao();
    }
    public void addCurrency(String code, String fullName, String sign) {
        currencyDao.addCurrency(code, fullName, sign);
    }

    public CurrencyModel getCurrencyModelByCode(String code) throws SQLException {
        return currencyDao.getCurrencyByCode(code);
    }

    public List<CurrencyModel> getAllCurrencies() throws SQLException {
        return currencyDao.getAllCurrencies();
    }
}
