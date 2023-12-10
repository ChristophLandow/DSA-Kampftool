package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Armor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collections;

import static de.cLandow.dsaKampftool.Constants.*;

public class ArmorFileReadHandler extends DefaultHandler {

    private Boolean subListLoaded = false;
    private String name;

    private String zone;
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


    private ObservableList<Armor> temporaryArmorLIst = FXCollections.observableArrayList();;
    private final ObservableList<Armor> observableList = FXCollections.observableArrayList();;
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
            name = attributes.getValue(NAME);
            zone = attributes.getValue(ZONE);
            headArmor = Integer.parseInt(attributes.getValue(HEAD_ARMOR));
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
        if(ARMOR.equals(qName)){
            subListLoaded = false;
            ArrayList<String> armorZones = createZoneList(zone);
            Armor armor = new Armor(name, armorZones, headArmor, chestArmor, backsideArmor, tummyArmor, leftArmArmor, rightArmArmor, lefLegArmor, rightLegArmor, summArmorclass, summEncumbrance);
            observableList.add(armor);
            temporaryArmorLIst.add(armor);
        }
        if(!ARMOR.equals(qName)){
            switch (qName) {
                case CLOTHES -> {
                    subListLoaded = true;
                    gearListBoxController.setClothes(temporaryArmorLIst);
                    temporaryArmorLIst = FXCollections.observableArrayList();
                }
                case CLOTARMOR -> {
                    subListLoaded = true;
                    gearListBoxController.setClothArmor(temporaryArmorLIst);
                    temporaryArmorLIst = FXCollections.observableArrayList();
                }
                default -> {
                    if(subListLoaded.equals(false)){
                        System.out.println("Ruestung fremder Klasse");
                    }
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    private ArrayList<String> createZoneList(String zone) {
        String[] zonesToCast = zone.split("_");
        ArrayList<String> result = new ArrayList<>();
        Collections.addAll(result, zonesToCast);
        return result;
    }

    public ObservableList<Armor> getObservableArmorList() {
        return observableList;
    }
}
