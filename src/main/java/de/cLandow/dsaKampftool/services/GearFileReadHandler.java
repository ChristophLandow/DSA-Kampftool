package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
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
    private ArrayList<Weapon_closeCombat> temporaryWeaponLIst = new ArrayList<>();

    private final GearListBoxController gearListBoxController;

    public GearFileReadHandler(GearListBoxController gearListBoxController) {
        this.gearListBoxController = gearListBoxController;
    }

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
                    gearListBoxController.setTwoHandedImpactWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
                }
                case DAGGERS -> {
                    gearListBoxController.setDaggers(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
                }
                case FENCING_WEAPONS -> {
                    gearListBoxController.setFencingWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
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
}
