package com.example.jan.jbapp;

/**
 * Created by jan on 27.03.2018.
 */


public class Weapon {
    String name;
    int power;
    int durability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public Weapon(String name, int power, int durability) {
        this.name = name;
        this.power = power;
        this.durability = durability;
    }
}
