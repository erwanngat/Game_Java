package com.example.game_java.Model.charClass;

import java.util.Objects;

public class CharClass {
    protected int id;
    protected String name;
    protected int defaultHealthPoint;
    protected int defaultDamage;

    public CharClass(){
        this.name = "No class";
        this.defaultHealthPoint = 100;
        this.defaultDamage = 10;
    }

    public CharClass(int id, String name){
        this.name = name;
        this.id = id;
        switch (name) {
            case "warrior":
                this.defaultHealthPoint = 120;
                this.defaultDamage = 8;
                break;
            case "rogue":
                this.defaultHealthPoint = 80;
                this.defaultDamage = 14;
                break;
            case "wizard":
                this.defaultHealthPoint = 90;
                this.defaultDamage = 12;
                break;
            case "archer":
                this.defaultHealthPoint = 85;
                this.defaultDamage = 13;
                break;
            default:
                throw new IllegalArgumentException("Unknown class : " + name);
        }
    }

    public CharClass(String name, int defaultHealthPoint, int defaultDamage){
        this.name = name;
        this.defaultHealthPoint = defaultHealthPoint;
        this.defaultDamage = defaultDamage;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getDefaultHealthPoint(){
        return this.defaultHealthPoint;
    }

    public int getDefaultDamage(){
        return this.defaultDamage;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDefaultHealthPoint(int defaultHealthPoint){
        this.defaultHealthPoint = defaultHealthPoint;
    }

    public void setDefaultDamage(int defaultDamage){
        this.defaultDamage = defaultDamage;
    }
}
