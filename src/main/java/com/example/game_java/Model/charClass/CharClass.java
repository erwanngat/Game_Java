package com.example.game_java.Model.charClass;

public class CharClass {
    protected int id;
    protected String name;
    protected int defaultHealthPoint;
    protected int defaultDamage;

    public CharClass(){
        this.name = "No lass";
        this.defaultHealthPoint = 100;
        this.defaultDamage = 10;
    }

    public CharClass(String name){
        this.name = name;
        this.defaultHealthPoint = 100;
        this.defaultDamage = 10;
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
