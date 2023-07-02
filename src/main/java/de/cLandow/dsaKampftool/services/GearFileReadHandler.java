package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import static de.cLandow.dsaKampftool.Constants.*;

import java.util.ArrayList;

public class GearFileReadHandler extends DefaultHandler {

    private String name = "";
    private String mod = "";
    private String distance = "";
    private String initiative = "";

    private final ArrayList<Weapon_closeCombat> weaponList = new ArrayList<>();
    private final ArrayList<Weapon_closeCombat> temporaryWeaponLIst = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> twoHandedStrikingWeapons = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> fencingWeapons = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> daggers = new ArrayList<>();

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (WEAPON.equals(qName)) {
            mod = attributes.getValue("Mod");
        }
        if (WEAPON.equals(qName)) {
            distance = attributes.getValue("Distanz");
        }
        if (WEAPON.equals(qName)) {
            name = attributes.getValue("Name");
        }
        if (WEAPON.equals(qName)) {
            initiative = attributes.getValue("Ini");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(WEAPON.equals(qName)){
            Weapon_closeCombat weapon = new Weapon_closeCombat(name,Integer.parseInt(initiative),mod,distance);
            weaponList.add(weapon);
            temporaryWeaponLIst.add(weapon);
        }
        if(!WEAPON.equals(qName)){
            switch (qName) {
                case TWO_HANDED_IMPACT_WEAPON -> {
                    twoHandedStrikingWeapons = temporaryWeaponLIst;
                    temporaryWeaponLIst.clear();
                }
                case DAGGERS -> {
                    daggers = temporaryWeaponLIst;
                    temporaryWeaponLIst.clear();
                }
                case FENCING_WEAPONS -> {
                    fencingWeapons = temporaryWeaponLIst;
                    temporaryWeaponLIst.clear();
                }
                default -> System.out.println("Waffe fremder Klasse");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    public ArrayList<Weapon_closeCombat> getGearList() {
        return weaponList;
    }

    public ArrayList<Weapon_closeCombat> getFencingWeapons(){
        return fencingWeapons;
    }

    public ArrayList<Weapon_closeCombat> getDaggers() {
        return daggers;
    }

    public ArrayList<Weapon_closeCombat> getTwoHandedStrikingWeapons() {
        return twoHandedStrikingWeapons;
    }
}
