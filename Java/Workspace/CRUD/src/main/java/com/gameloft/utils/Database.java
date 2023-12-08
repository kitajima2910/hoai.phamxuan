/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.utils;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kitajima2910
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/pxh?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Database instance;
    private Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.getMessage();
            // Handle the exception accordingly
        }
    }

    // Method to get the singleton instance
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Close the connection when needed
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getMessage();
            // Handle the exception accordingly
        }
    }

    // Create a Faker instance
    private static Faker faker = new Faker(new Locale("vi"));

    public static class Table {

        public static void createUsers() {
            try {
                // Drop the users table if i does'nt exist 
                String sqlDrop = "DROP TABLE IF EXISTS users";
                Database.getInstance().getConnection().createStatement().executeUpdate(sqlDrop);

                // Create the users table if it doesn't exist
                String sqlInsert
                        = "CREATE TABLE IF NOT EXISTS users ("
                            + "id INT AUTO_INCREMENT PRIMARY KEY,"
                            + "name VARCHAR(255),"
                            + "email VARCHAR(255),"
                            + "country VARCHAR(255),"
                            + "password VARCHAR(255)"
                        + ")";
                Database.getInstance().getConnection().createStatement().executeUpdate(sqlInsert);

                // Generate and insert 50 random data into the users table
                String insertSQL = "INSERT INTO users (name, email, country, password) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = Database.getInstance().getConnection().prepareStatement(insertSQL)) {
                    for (int i = 0; i < 50; i++) {
                        preparedStatement.setString(1, faker.name().fullName());
                        preparedStatement.setString(2, faker.internet().emailAddress());
                        preparedStatement.setString(3, faker.address().country());
                        preparedStatement.setString(4, faker.internet().password());

                        preparedStatement.executeUpdate();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) {
        if (Database.getInstance().getConnection() != null) {
            System.out.println("Yes");
            Database.Table.createUsers();
        } else {
            System.out.println("No");
        }
    }

}
