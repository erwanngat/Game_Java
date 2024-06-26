package com.example.game_java.Model;

import com.example.game_java.Model.charClass.Character;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String email;
    private String password;
    private String passwordConfirmation;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String passwordConfirmation){
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getIdDB(){
        String request = "SELECT id FROM users WHERE email = ?";
        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);
            pst.setString(1, this.email);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId(){
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public List<Character> getCharacter() throws SQLException, ClassNotFoundException {
        List<Character> characters = new ArrayList<>();
        String request = "SELECT name, char_class_id, level FROM characters WHERE user_id = ?";
        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);
            pst.setInt(1, getIdDB());

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int charClassId = rs.getInt("char_class_id");
                int level = rs.getInt("level");
                Character character = new Character(name, charClassId, level); // Assuming a Character class exists
                characters.add(character);
            }
            return characters;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
