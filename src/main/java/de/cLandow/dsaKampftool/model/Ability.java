package de.cLandow.dsaKampftool.model;

public class Ability {
    private String name;

    private Integer attackModificator;
    private Integer paradeModificator;

    private Integer initiativeModificator;

    private Double encumbranceModificator;

    public Ability(String name, Integer attackModificator, Integer paradeModificator, Integer initiativeModificator,
                   Double encumbranceModificator){
        this.name = name;
        this.attackModificator = attackModificator;
        this.paradeModificator = paradeModificator;
        this.initiativeModificator = initiativeModificator;
        this.encumbranceModificator = encumbranceModificator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackModificator(Integer attackModificator) {
        this.attackModificator = attackModificator;
    }

    public void setParadeModificator(Integer paradeModificator) {
        this.paradeModificator = paradeModificator;
    }

    public void setInitiativeModificator(Integer initiativeModificator) {
        this.initiativeModificator = initiativeModificator;
    }

    public void setEncumbranceModificator(Double encumbranceModificator) {
        this.encumbranceModificator = encumbranceModificator;
    }

    public String getName() {
        return name;
    }

    public Integer getAttackModificator() {
        return attackModificator;
    }

    public Integer getParadeModificator() {
        return paradeModificator;
    }

    public Integer getInitiativeModificator() {
        return initiativeModificator;
    }

    public Double getEncumbranceModificator() {
        return encumbranceModificator;
    }

    public String toString(){
        return this.name;
    }
}
