package de.cLandow.dsaKampftool.services;


import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.model.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class CharacterFileReadHandler extends DefaultHandler {

    private Character character;
    private String name;
    private Integer attacke;
    private Integer parade;
    private Integer fernkampf;
    private Integer initiative;
    private Integer lifePoints;
    private Integer endurancePoints;
    private Integer strength;
    private Integer agility;

    StringBuilder nameBuilder = new StringBuilder();
    private final ObservableList<Ability> observableList = FXCollections.observableArrayList();;

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){
        character = new Character(name, attacke, parade, fernkampf, initiative, lifePoints, endurancePoints, strength, agility);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("Attacke".equals(qName)) {
            attacke = Integer.parseInt(attributes.getValue("AT"));
        }
        if ("Parade".equals(qName)) {
            parade = Integer.parseInt(attributes.getValue("PA"));
        }
        if ("Fernkampf".equals(qName)) {
            fernkampf = Integer.parseInt(attributes.getValue("FK"));
        }
        if("Initiative".equals(qName)){
            initiative = Integer.parseInt(attributes.getValue("INI"));
        }
        if("Lebenspunkte".equals(qName)){
            lifePoints = Integer.parseInt(attributes.getValue("LP"));
        }
        if("Ausdauerpunkte".equals(qName)){
            endurancePoints = Integer.parseInt(attributes.getValue("AUP"));
        }
        if("Koerperkrafte".equals(qName)){
            strength = Integer.parseInt(attributes.getValue("KK"));
        }
    }

    //Heißt endElement, wird aber noch vor startElement aufgerufen
    @Override
    public void endElement(String uri, String localName, String qName){
        if("Name".equals(qName)){
            name = parseToNameWithSpaces(nameBuilder.toString());
        }
    }

    private String parseToNameWithSpaces(String string) {
        return string.replace("ↂ", " ");
    }

    @Override
    public void characters(char[] ch, int start, int length){
        nameBuilder.append(ch, start, length);
    }



    public Character getCharacter(){
        return this.character;
    }


    public ObservableList<Ability> getObservableAbilityList() {
        return observableList;
    }
}
