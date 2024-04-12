package com.example.game_java.Model;

import java.sql.*;

public class UserDAO {
    private static final String TABLE = "users";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    public static void createUser(User user){
        String request = "INSERT INTO " + TABLE + " (" + EMAIL + ", " + PASSWORD + ") VALUES (?, ?)";

        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());

            pst.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error opening database connection: " + e.getMessage());
        }
    }

    public boolean loginUser(User user) throws SQLException{
        if (user != null && verifyPassword(password, user.getPassword())) {
            // Login successful
            return true;
        } else {
            // Login failed
            return false;
        }
    }
}
