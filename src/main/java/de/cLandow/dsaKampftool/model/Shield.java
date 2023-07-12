package de.cLandow.dsaKampftool.model;

public class Shield extends Gear{

    private  String name;
    private String statModificator;
    private Integer initiativeBonus;

    public Shield(String name, String statModificator, Integer initiativeBonus){
        super(name);
        this.statModificator = statModificator;
        this.initiativeBonus = initiativeBonus;
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
