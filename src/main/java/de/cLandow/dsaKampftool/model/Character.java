package de.cLandow.dsaKampftool.model;

public class Character {
    private String name;
    private Integer at;
    private Integer pa;
    private Integer fk;
    private Integer ini;
    private Integer lp;
    private Integer aup;
    private Integer kk;
    private Integer ge;


    public Character(String name, Integer at, Integer pa, Integer fk, Integer ini, Integer lp, Integer aup, Integer kk, Integer ge){
        this.name = name;
        this.at = at;
        this.pa = pa;
        this.fk = fk;
        this.ini = ini;
        this.lp = lp;
        this.aup = aup;
        this.kk = kk;
        this.ge = ge;
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
    public int getAup() {
        return aup;
    }

    public int getLp() {
        return lp;
    }

    public int getKk() {
        return kk;
    }

    public Integer getGe() {
        return ge;
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

    public void setAup(int aup) {
        this.aup = aup;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public void setKk(int kk){
        this.kk = kk;
    }

    public void setGe(Integer ge) {
        this.ge = ge;
    }
}
