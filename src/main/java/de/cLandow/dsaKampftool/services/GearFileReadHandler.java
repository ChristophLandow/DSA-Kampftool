package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class GearFileReadHandler extends DefaultHandler {

    private String name = "";
    private String mod = "";
    private String distance = "";
    private String initiative = "";

    private final ArrayList<Weapon_closeCombat> weaponList = new ArrayList<>();

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("Waffe".equals(qName)) {
            mod = attributes.getValue("Mod");
        }
        if ("Waffe".equals(qName)) {
            distance = attributes.getValue("Distanz");
        }
        if ("Waffe".equals(qName)) {
            name = attributes.getValue("Name");
        }
        if ("Waffe".equals(qName)) {
            initiative = attributes.getValue("Ini");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if("Waffe".equals(qName)){
            weaponList.add(new Weapon_closeCombat(name,Integer.parseInt(initiative),mod,distance));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    public ArrayList<Weapon_closeCombat> getGearList() {
        return weaponList;
    }
}
