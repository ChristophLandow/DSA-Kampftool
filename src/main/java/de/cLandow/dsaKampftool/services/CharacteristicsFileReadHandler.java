package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collections;

import static de.cLandow.dsaKampftool.Constants.*;

public class CharacteristicsFileReadHandler extends DefaultHandler {

    private String name;
    private String group;
    private Integer atkMod;
    private Integer defMod;
    private Integer initMod;
    private ObservableList<Ability> abilityList = FXCollections.observableArrayList();
    private final ObservableList<Characteristic> observableList = FXCollections.observableArrayList();

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (CHARACTERISTIC.equals(qName)) {
            name = attributes.getValue(NAME);
            group = attributes.getValue(CHARACTERISTIC_GROUP);
            atkMod = Integer.parseInt(attributes.getValue(ATTACK_MOD));
            defMod = Integer.parseInt(attributes.getValue(PARADE_MOD));
            initMod = Integer.parseInt(attributes.getValue(INITIATIVEMOD));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName){
        if(CHARACTERISTIC.equals(qName)) {
            Characteristic characteristic = new Characteristic(name,atkMod, defMod, initMod, abilityList);
            observableList.add(characteristic);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
    }

    private ArrayList<String> createAbilityList(String list) {
        String[] listToCast = list.split("_");
        ArrayList<String> result = new ArrayList<>();
        Collections.addAll(result, listToCast);
        return result;
    }

    public ObservableList<Characteristic> getObservableList() {
        return null;
    }
}
