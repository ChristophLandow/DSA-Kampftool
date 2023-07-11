package de.cLandow.dsaKampftool.model;

public class Weapon_closeCombat extends Gear{

    private String name;
    private int ini;
    private String damage;
    private String damageModificator;
    private String statModificator;
    private String distanceClass;

    public Weapon_closeCombat(String name, int initiative, String damage, String damageMod, String statMod, String distance){
        this.name = name;
        this.ini = initiative;
        this.damage = damage;
        this.damageModificator = damageMod;
        this.statModificator = statMod;
        this.distanceClass = distance;
    }

    public String getName() {
        return name;
    }

    public int getIni() {
        return ini;
    }

    public String getDamage() {
        return damage;
    }

    public String getDamageModificator() {
        return damageModificator;
    }

    public String getStatModificator() {
        return statModificator;
    }

    public String getDistanceClass() {
        return distanceClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setDamageModificator(String damageModificator) {
        this.damageModificator = damageModificator;
    }

    public void setStatModificator(String statModificator) {
        this.statModificator = statModificator;
    }

    public void setDistanceClass(String distanceClass) {
        this.distanceClass = distanceClass;
    }
}
