package de.cLandow.dsaKampftool.model;

import java.util.ArrayList;

public class Weapon_rangedCombat extends Gear{

    private String name;
    private String damage;
    private ArrayList<Integer> distances;
    private Integer neededStrength;
    public Weapon_rangedCombat(String name, String damage, ArrayList<Integer> distances, Integer neededStrength){
        this.name = name;
        this.damage = damage;
        this.distances = distances;
        this.neededStrength = neededStrength;
    }

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public ArrayList<Integer> getDistances() {
        return distances;
    }

    public Integer getNeededStrength() {
        return neededStrength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setDistances(ArrayList<Integer> distances) {
        this.distances = distances;
    }

    public void setNeededStrength(Integer neededStrength) {
        this.neededStrength = neededStrength;
    }
}
