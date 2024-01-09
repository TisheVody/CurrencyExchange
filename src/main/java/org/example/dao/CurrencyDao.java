package org.example.dao;

import org.example.DataBase;
import org.example.model.CurrencyModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//ps
public class CurrencyDao {
    private static final String INSERT_CURRENCY_STATEMENT = "INSERT INTO Currencies (code, fullName, sign) VALUES (?, ?, ?)";
    private static final String SELECT_CURRENCY_STATEMENT = "SELECT id, code, fullName, sign FROM Currencies WHERE code = ?";
    private static final String SELECT_ALL_CURRENCIES_STATEMENT = "SELECT id, code, fullName, sign FROM Currencies";
    private Connection connection;
    public CurrencyDao() {
        DataBase dataBase = new DataBase();
        connection = dataBase.getConnection();
    }

    public void addCurrency(String code, String fullName, String sign) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CURRENCY_STATEMENT);
            ps.setString(1, code);
            ps.setString(2, fullName);
            ps.setString(3, sign);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CurrencyModel getCurrencyByCode(String code) throws SQLException {
        CurrencyModel currencyModel;
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_CURRENCY_STATEMENT);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currencyModel = new CurrencyModel(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            } else {
                throw new RuntimeException("Your currency doesn't exist");
            }
        } catch (SQLException | RuntimeException e) {
            throw e;
        }
        return currencyModel;
    }
    public List<CurrencyModel> getAllCurrencies() throws SQLException {
        List<CurrencyModel> currencies = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CURRENCIES_STATEMENT);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            currencies.add(new CurrencyModel(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));
        }
        return currencies;
    }
}
