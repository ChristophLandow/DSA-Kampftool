package de.cLandow.dsaKampftool.services;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class GearFileReadHandler extends DefaultHandler {

    private String name = "";
    private String mod = "";
    private String distance = "";

    private ArrayList<String> weaponList = new ArrayList<>();
    StringBuilder nameBuilder = new StringBuilder();

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
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if("Waffe".equals(qName)){
            name = nameBuilder.toString();

        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
        nameBuilder.append(ch, start, length);
    }

    public ArrayList getGearList() {
        return weaponList;
    }
}
