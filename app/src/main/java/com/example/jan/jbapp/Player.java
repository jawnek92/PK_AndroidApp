package com.example.jan.jbapp;

/**
 * Created by jan on 27.03.2018.
 */

public class Player {

    String name;
    int lvl;
    int healthPoints;

    public Player(){
        this("UnknowPlayer");

    }

    public Player(String name)
    {
        this(name, 1,1);
    }

    public Player(String name, int lvl, int healthPoints) {
        this.name = name;
        this.lvl = lvl;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
