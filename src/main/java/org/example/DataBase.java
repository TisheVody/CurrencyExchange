package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//connection with database
public class DataBase {
    private static final String URL = "jdbc:sqlite:src/main/resources/currency.db";
    Connection connection;
    public DataBase() {
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    public Connection getConnection() {
        return connection;
    }
}
