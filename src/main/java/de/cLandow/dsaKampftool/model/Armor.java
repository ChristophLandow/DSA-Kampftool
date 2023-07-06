package de.cLandow.dsaKampftool.model;

public record Armor(
        String name,
        int kopf,
        int brust,
        int ruecken,

        int bauch,
        int arm_l,
        int arm_r,
        int bein_l,
        int bein_r,
        double gRS,
        double gBE

){
    public String toString(){
        return name;
    }
}
