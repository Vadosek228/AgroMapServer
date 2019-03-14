package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnector {
    public static void main(String srgs[]) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/business";
        String userName = "engneAdmin";
        String password = "1qaz2wsx3edc";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(url, userName, password)){
            System.out.println("Connection Succesful");
        }
    }
}
