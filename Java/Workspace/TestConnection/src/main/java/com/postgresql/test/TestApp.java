package com.postgresql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApp {

    private static String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private static String user = "postgres";
    private static String password = "123456";

    public static void main(String[] args) {
        getConnection();
    }

    private static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Postgres!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

}
