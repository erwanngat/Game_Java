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

    public static User getUserByEmail(String email){
        String request = "SELECT * FROM " + TABLE + " WHERE " + EMAIL + " = ?";
        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new User(rs.getString(EMAIL), rs.getString(PASSWORD));
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e){
            System.err.println("Error retrieving user by email: " + e.getMessage());
        }
        return null;
    }

    public static boolean verifyPassword(String entryPassword, String userPassword){
        if (entryPassword == null || entryPassword.isEmpty()) {
            return false;
        }
        if (userPassword == null || userPassword.isEmpty()) {
            return false;
        }

        return BCrypt.checkpw(entryPassword, userPassword);
    }

    public static boolean loginUser(String email, String password){
        User user = getUserByEmail(email);

        if (user == null){
            return false;
        }
        return verifyPassword(password, user.getPassword());
    }
}
