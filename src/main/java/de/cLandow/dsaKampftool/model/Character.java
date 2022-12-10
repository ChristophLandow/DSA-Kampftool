package de.cLandow.dsaKampftool.model;

public class Character {

    private String name;
    private int at;
    private int pa;
    private int fk;
    private int ini;

    private boolean kampfreflexe;
    private boolean kampfgespuehr;
    private boolean beengt;

    public Character(String name, int at, int pa, int fk, int ini, boolean kampfreflexe, boolean kampfgespuehr, boolean beengt){
        this.name = name;
        this.at = at;
        this.pa = pa;
        this.fk = fk;
        this.ini = ini;
        this.kampfreflexe = kampfreflexe;
        this.kampfgespuehr = kampfgespuehr;
        this.beengt = beengt;
    }

    public String getName() {
        return name;
    }

    public int getAt() {
        return at;
    }

    public int getPa() {
        return pa;
    }

    public int getFk() {
        return fk;
    }

    public int getIni() {
        return ini;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setFk(int fk) {
        this.fk = fk;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

}
