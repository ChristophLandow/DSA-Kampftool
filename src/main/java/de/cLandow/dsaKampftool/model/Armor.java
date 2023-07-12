package de.cLandow.dsaKampftool.model;

public class Armor extends Gear{

    private String name;
    private Integer headArmor;
    private Integer chestArmor;
    private Integer backsideArmor;

    private Integer tummyArmor;
    private Integer leftArmArmor;
    private Integer rightArmArmor;
    private Integer lefLegArmor;
    private Integer rightLegArmor;
    private Double summArmorclass;
    private Double summHandicap;

    public Armor(String name, Integer headArmor, Integer chestArmor, Integer backsideArmor, Integer tummyArmor,
                 Integer leftArmArmor, Integer rightArmArmor, Integer lefLegArmor, Integer rightLegArmor,
                 Double summArmorclass, Double summHandicap){
        super(name);
        this.headArmor = headArmor;
        this.chestArmor = chestArmor;
        this.backsideArmor = backsideArmor;
        this.tummyArmor = tummyArmor;
        this.leftArmArmor = leftArmArmor;
        this.rightArmArmor = rightArmArmor;
        this.lefLegArmor = lefLegArmor;
        this.rightLegArmor = rightLegArmor;
        this.summArmorclass = summArmorclass;
        this.summHandicap = summHandicap;
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
