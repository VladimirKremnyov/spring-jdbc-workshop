package org.shop;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/practice_one_jdbc?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "653241";
    public static void main(String[] args) throws SQLException {
        DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
