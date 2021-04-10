package org.diploma.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/diploma";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123456";

    public Connection getConnection(){

        Connection connection = null;

        try{
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Connection failed");
        }

        return connection;

    }

    public void putConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
