package de.cLandow.dsaKampftool.model;

import javafx.collections.ObservableList;

public class Drawback extends Characteristic{
    public Drawback(String name, Integer atkMod, Integer defMod, Integer initMod, ObservableList<Ability> abilityList) {
        super(name, atkMod, defMod, initMod, abilityList);
    }
}
