package com.example.game_java.Model.charClass;

import com.example.game_java.Model.Database;
import com.example.game_java.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Character {
    private int id;
    private String name;
    private int charClass;
    private int level;
    private int maxHealthPoint;
    private int healthPoint;
    private int damage;

    public Character() {
        this.name = "default";
        this.level = 1;
        this.maxHealthPoint = 100;
        this.healthPoint = 100;
        this.damage = 10;
    }

    public Character(String name, int charClass, int level, int maxHealthPoint, int healthPoint, int damage) {
        this.name = name;
        this.charClass = charClass;
        this.level = level;
        this.maxHealthPoint = maxHealthPoint;
        this.healthPoint = healthPoint;
        this.damage = damage;
    }

    public Character(String name, int charClass) {
        this.name = name;
        this.charClass = charClass;
        this.level = 1;
        this.maxHealthPoint = 100;
        this.healthPoint = 100;
        this.damage = 10;
    }

    public Character(String name, int charClassId, int level) {
        this.name = name;
        this.charClass = charClassId;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharClass() {
        return charClass;
    }

    public void setCharClass(int charClass) {
        this.charClass = charClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void saveCharacter(Character character, User user){
        String request = "INSERT INTO characters (name, char_class_id, level, maxHealth, health, damage, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);
            pst.setString(1, character.getName());
            pst.setInt(2, character.getCharClass());
            pst.setInt(3, character.getLevel());
            pst.setInt(4, character.getMaxHealthPoint());
            pst.setInt(5, character.getHealthPoint());
            pst.setInt(6, character.getDamage());
            pst.setInt(7, user.getIdDB());

            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCharClassName(int classId) throws SQLException, ClassNotFoundException {
        String className = null;
        String request = "SELECT name FROM char_class WHERE id = ?";
        try (Connection connection = Database.getConnection()){
            PreparedStatement pst = connection.prepareStatement(request);
            pst.setInt(1, classId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                className = rs.getString("name");
            }
            return className;
        }
    }
}