package com.example.game_java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/game_java";
    private static  final  String USERNAME = "root";
    private static  final  String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
