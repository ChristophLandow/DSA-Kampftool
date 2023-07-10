package de.cLandow.dsaKampftool.model;

public class Shield extends Gear{

    private String statModificator;
    private int initiativeBonus;

    public Shield(){

    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public String getStatModificator() {
        return statModificator;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    public void setStatModificator(String statModificator) {
        this.statModificator = statModificator;
    }
}
