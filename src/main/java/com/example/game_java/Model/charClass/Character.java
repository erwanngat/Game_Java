package com.example.game_java.Model.charClass;

public class Character {
    private int id;
    private String name;
    private CharClass charClass;
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

    public Character(String name, CharClass charClass) {
        this.name = name;
        this.charClass = charClass;
        this.level = 1;
        this.maxHealthPoint = 100;
        this.healthPoint = 100;
        this.damage = 10;
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

    public CharClass getCharClass() {
        return charClass;
    }

    public void setCharClass(CharClass charClass) {
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
}
