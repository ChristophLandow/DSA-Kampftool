package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.model.Gear;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CharacterService {
    private String name;
    private Integer closeCombatAttack;
    private Integer parade;
    private Integer distanceCombatAttack;
    private Integer initiative;
    private Integer lifePoints;
    private Integer endurancePoints;
    private Integer strength;

    private Integer agility;
    private ObservableList<Gear> gearArrayList = FXCollections.observableArrayList();
    private Character currentCharacter;

    public CharacterService(){
    }

    public Character createCharacter(String name, Integer at, Integer pa, Integer fk, Integer ini, Integer lp, Integer aup, Integer kk, Integer ge){
        return new Character(name, at, pa, fk, ini, lp, aup, kk, ge);
    }

    public String getName() {
        return name;
    }

    public Character getCurrentCharacter() {
        return currentCharacter;
    }

    public Integer getParade() {
        return parade;
    }

    public Integer getCloseCombatAttack() {
        return closeCombatAttack;
    }

    public Integer getDistanceCombatAttack() {
        return distanceCombatAttack;
    }

    public Integer getEndurancePoints() {
        return endurancePoints;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getAgility() {
        return agility;
    }

    public ObservableList<Gear> getGearArrayList() {
        return gearArrayList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentCharacter(Character currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    public void setCloseCombatAttack(Integer closeCombatAttack) {
        this.closeCombatAttack = closeCombatAttack;
    }

    public void setDistanceCombatAttack(Integer distanceCombatAttack) {
        this.distanceCombatAttack = distanceCombatAttack;
    }

    public void setEndurancePoints(Integer endurancePoints) {
        this.endurancePoints = endurancePoints;
    }

    public void setGearArrayList(ObservableList<Gear> gearArrayList) {
        this.gearArrayList = gearArrayList;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setParade(Integer parade) {
        this.parade = parade;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }
}
