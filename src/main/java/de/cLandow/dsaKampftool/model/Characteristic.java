package de.cLandow.dsaKampftool.model;

import javafx.collections.ObservableList;

public class Characteristic {

    private final String name;
    private final String group;
    private final Integer atkMod;
    private final Integer defMod;
    private final Integer initMod;
    private final ObservableList<Ability> abilityList;

    public Characteristic(String name, String group, Integer atkMod, Integer defMod, Integer initMod, ObservableList<Ability> abilityList){
        this.name = name;
        this.group = group;
        this.atkMod = atkMod;
        this.defMod = defMod;
        this.initMod = initMod;
        this.abilityList = abilityList;
    }

    public String getName() {
        return name;
    }

    public Integer getAtkMod() {
        return atkMod;
    }

    public Integer getDefMod() {
        return defMod;
    }

    public Integer getInitMod() {
        return initMod;
    }

    public ObservableList<Ability> getAbilityList() {
        return abilityList;
    }
}
