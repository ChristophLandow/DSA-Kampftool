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

    @Override
    public String getName() {
        return name;
    }
    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public String getStatModificator() {
        return statModificator;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    public void setStatModificator(String statModificator) {
        this.statModificator = statModificator;
    }
}
