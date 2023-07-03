package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import static de.cLandow.dsaKampftool.Constants.*;

import java.util.ArrayList;

public class GearFileReadHandler extends DefaultHandler {

    private String name = "";
    private String statMod = "";
    private String distance = "";
    private String initiative = "";

    private String damage = "";
    private String damageMod = "";
    private Boolean subListLoaded = false;

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
            statMod = attributes.getValue(STATMOD);
        }
        if (WEAPON.equals(qName)) {
            distance = attributes.getValue(DISTANCE);
        }
        if (WEAPON.equals(qName)) {
            name = attributes.getValue(NAME);
        }
        if (WEAPON.equals(qName)) {
            initiative = attributes.getValue(INITIATIVEMOD);
        }
        if (WEAPON.equals(qName)) {
            damage = attributes.getValue(DAMAGE);
        }
        if (WEAPON.equals(qName)) {
            damageMod = attributes.getValue(DAMAGEMOD);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(WEAPON.equals(qName)){
            subListLoaded = false;
            Weapon_closeCombat weapon = new Weapon_closeCombat(name,Integer.parseInt(initiative),damage,damageMod,statMod,distance);
            weaponList.add(weapon);
            temporaryWeaponLIst.add(weapon);
        }
        if(!WEAPON.equals(qName)){
            switch (qName) {
                case TWO_HANDED_IMPACT_WEAPON -> {
                    subListLoaded = true;
                    gearListBoxController.setTwoHandedImpactWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
                }
                case DAGGERS -> {
                    subListLoaded = true;
                    gearListBoxController.setDaggers(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
                }
                case FENCING_WEAPONS -> {
                    subListLoaded = true;
                    gearListBoxController.setFencingWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = new ArrayList<>();
                }
                default -> {
                    if(subListLoaded.equals(false)){
                        System.out.println("Waffe fremder Klasse");
                    }
                }
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
