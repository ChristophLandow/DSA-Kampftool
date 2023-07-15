package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static de.cLandow.dsaKampftool.Constants.*;

public class ArmorFileReadHandler extends DefaultHandler {

    private Boolean subListLoaded = false;
    private Integer headArmor;
    private Integer chestArmor;
    private Integer backsideArmor;
    private Integer tummyArmor;
    private Integer leftArmArmor;
    private Integer rightArmArmor;
    private Integer lefLegArmor;
    private Integer rightLegArmor;
    private Double summArmorclass;
    private Double summEncumbrance;


    private ObservableList<Weapon_closeCombat> temporaryArmorLIst = FXCollections.observableArrayList();;
    private final ObservableList<Weapon_closeCombat> observableList = FXCollections.observableArrayList();;
    private final GearListBoxController gearListBoxController;


    public ArmorFileReadHandler(GearListBoxController gearListBoxController) {
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
        if (ARMOR.equals(qName)) {
            headArmor = Integer.parseInt(attributes.getValue(NAME));
            chestArmor = Integer.parseInt(attributes.getValue(CHEST_ARMOR));
            backsideArmor = Integer.parseInt(attributes.getValue(BACKSIDE_ARMOR));
            tummyArmor = Integer.parseInt(attributes.getValue(TUMMY_ARMOR));
            leftArmArmor = Integer.parseInt(attributes.getValue(LEFTARM_ARMOR));
            rightArmArmor = Integer.parseInt(attributes.getValue(RIGHTARM_ARMOR));
            lefLegArmor= Integer.parseInt(attributes.getValue(LEFTLEG_ARMOR));
            rightLegArmor = Integer.parseInt(attributes.getValue(RIGHTLEG_ARMOR));
            summArmorclass = Double.parseDouble(attributes.getValue(SUMM_ARMOR));
            summEncumbrance = Double.parseDouble(attributes.getValue(SUMM_ENCUMBRANCE));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(WEAPON.equals(qName)){
            subListLoaded = false;
            Weapon_closeCombat weapon = new Weapon_closeCombat(name,Integer.parseInt(initiative),damage,damageMod,statMod,distance);
            observableList.add(weapon);
            temporaryWeaponLIst.add(weapon);
        }
        if(!WEAPON.equals(qName)){
            switch (qName) {
                case BASTARDSWORDS -> {
                    subListLoaded = true;
                    gearListBoxController.setBastardswords(temporaryWeaponLIst);
                    temporaryWeaponLIst = FXCollections.observableArrayList();
                }
                case TWO_HANDED_IMPACT_WEAPON -> {
                    subListLoaded = true;
                    gearListBoxController.setTwoHandedImpactWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = FXCollections.observableArrayList();
                }
                case DAGGERS -> {
                    subListLoaded = true;
                    gearListBoxController.setDaggers(temporaryWeaponLIst);
                    temporaryWeaponLIst = FXCollections.observableArrayList();
                }
                case FENCING_WEAPONS -> {
                    subListLoaded = true;
                    gearListBoxController.setFencingWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = FXCollections.observableArrayList();
                }
                case IMPACT_WEAPONS -> {
                    subListLoaded = true;
                    gearListBoxController.setImpactWeapons(temporaryWeaponLIst);
                    temporaryWeaponLIst = FXCollections.observableArrayList();
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



    public ObservableList<Armor> getObservableArmorList() {
        return null;
    }
}
