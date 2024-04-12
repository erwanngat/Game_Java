package com.example.game_java.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/game_java";
    private static  final  String USERNAME = "laravel";
    private static  final  String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void openDatabaseConnection(){
        try{
            Connection connection = Database.getConnection();
            System.out.println("connection open");
        } catch (SQLException e){
            System.err.println("error : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDatabaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("connection close");
        }
    }
}