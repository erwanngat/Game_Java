package com.example.game_java.Model;

import java.sql.*;
import java.util.Objects;

import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
    private static final String TABLE = "users";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    public static void createUser(User user){
        String request = "INSERT INTO " + TABLE + " (" + EMAIL + ", " + PASSWORD + ") VALUES (?, ?)";
        String hashPassword = hashPassword(user.getPassword());

        if (Objects.equals(user.getPassword(), user.getPasswordConfirmation())){
            try (Connection connection = Database.getConnection()){
                PreparedStatement pst = connection.prepareStatement(request);

                pst.setString(1, user.getEmail());
                pst.setString(2, hashPassword);

                pst.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error opening database connection: " + e.getMessage());
            }
        }
    }

    public boolean loginUser(User user) throws SQLException{
        return true;
    }
}
