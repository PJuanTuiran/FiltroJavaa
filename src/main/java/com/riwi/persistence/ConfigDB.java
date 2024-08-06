package com.riwi.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection connection = null;
    public static Connection openConnection (){
        String url ="jdbc:mysql://localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "tupassword";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection Succesful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("connection closed");

        }

    }
}
