package de.cLandow.dsaKampftool.model;

public class Armor {

    private String name;
    private int headArmor;
    private int chestArmor;
    private int backsideArmor;

    private int tummyArmor;
    private int leftArmArmor;
    private int rightArmArmor;
    private int lefLegArmor;
    private int rightLegArmor;
    private double summArmorclass;
    private double summHandicap;

    public Armor(){
    }

    public String getName() {
        return name;
    }

    public int getHeadArmor() {
        return headArmor;
    }

    public int getChestArmor() {
        return chestArmor;
    }

    public int getBacksideArmor() {
        return backsideArmor;
    }

    public int getTummyArmor() {
        return tummyArmor;
    }

    public int getLeftArmArmor() {
        return leftArmArmor;
    }

    public int getRightArmArmor() {
        return rightArmArmor;
    }

    public int getLefLegArmor() {
        return lefLegArmor;
    }

    public int getRightLegArmor() {
        return rightLegArmor;
    }

    public double getSummArmorclass() {
        return summArmorclass;
    }

    public double getSummHandicap() {
        return summHandicap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadArmor(int headArmor) {
        this.headArmor = headArmor;
    }

    public void setChestArmor(int chestArmor) {
        this.chestArmor = chestArmor;
    }

    public void setBacksideArmor(int backsideArmor) {
        this.backsideArmor = backsideArmor;
    }

    public void setTummyArmor(int tummyArmor) {
        this.tummyArmor = tummyArmor;
    }

    public void setLeftArmArmor(int leftArmArmor) {
        this.leftArmArmor = leftArmArmor;
    }

    public void setRightArmArmor(int rightArmArmor) {
        this.rightArmArmor = rightArmArmor;
    }

    public void setLefLegArmor(int lefLegArmor) {
        this.lefLegArmor = lefLegArmor;
    }

    public void setRightLegArmor(int rightLegArmor) {
        this.rightLegArmor = rightLegArmor;
    }

    public void setSummArmorclass(double summArmorclass) {
        this.summArmorclass = summArmorclass;
    }

    public void setSummHandicap(double summHandicap) {
        this.summHandicap = summHandicap;
    }

    public String toString(){
        return name;
    }
}
