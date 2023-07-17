package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.SpecialAbilityPopupController;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static de.cLandow.dsaKampftool.Constants.*;

public class AbilityFileReadHandler extends DefaultHandler{

    private String name;
    private Integer attack_mod;
    private Integer parade_mod;
    private Integer initiative_mod;
    private Double encumbrance_mod;

    private Boolean subListLoaded = false;
    private ObservableList<Ability> temporaryAbilityLIst = FXCollections.observableArrayList();;
    private final ObservableList<Ability> observableList = FXCollections.observableArrayList();;

    public AbilityFileReadHandler(){

    }

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (ABILITY.equals(qName)) {
            name = attributes.getValue(NAME);
            attack_mod = Integer.parseInt(attributes.getValue(ATTACK_MOD));
            parade_mod = Integer.parseInt(attributes.getValue(PARADE_MOD));
            initiative_mod = Integer.parseInt(attributes.getValue(INITIATIVEMOD));
            encumbrance_mod = Double.parseDouble(attributes.getValue(ENCUMBRANCE_MOD));

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if(ABILITY.equals(qName)) {
            Ability ability = new Ability(name, attack_mod, parade_mod, initiative_mod, encumbrance_mod);
            observableList.add(ability);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    public ObservableList<Ability> getObservableAbilityList(){
        return observableList;
    }
}
