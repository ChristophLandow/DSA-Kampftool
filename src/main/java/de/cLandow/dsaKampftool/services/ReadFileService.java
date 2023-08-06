package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.AbilityListBoxController;
import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
import de.cLandow.dsaKampftool.model.*;
import de.cLandow.dsaKampftool.model.Character;
import javafx.collections.ObservableList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static de.cLandow.dsaKampftool.Constants.*;

public class ReadFileService {

    private AbilityListBoxController abilityListBoxController;
    private GearListBoxController gearListBoxController;

    public ReadFileService(GearListBoxController gearListBoxController) {
        this.gearListBoxController = gearListBoxController;
    }
    public ReadFileService(AbilityListBoxController abilityListBoxController) {
        this.abilityListBoxController = abilityListBoxController;
    }

    public ReadFileService(){

    }

    public Character loadCharacter(String name){
        String path = CHARACTER_FILEPATH +  name + "//" + name + ".xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            CharacterFileReadHandler handler = new CharacterFileReadHandler();
            saxParser.parse(path, handler);
            return handler.getCharacter();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> loadCharakterNamesForChoiceBox() {
        ArrayList<String> characterArray = new ArrayList<>();
        try {
            ArrayList<String> pathList = iterateCharacterDirectory();
            for (String path : pathList) {
                if(path.endsWith(".xml")){
                    File newFile =  new File(path);
                    String name = newFile.getName();
                    int index = name.lastIndexOf(".");
                    String nameWithoutXML = name.substring(0, index);
                    String safeName = nameWithoutXML.replace("_", " ");
                    characterArray.add(safeName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return characterArray;
    }

    private ArrayList<String> iterateCharacterDirectory() throws Exception {
        ArrayList<String> pathList = new ArrayList<>();
        Files.walk(Paths.get(CHARACTER_FILEPATH), FileVisitOption.FOLLOW_LINKS).forEach((path) -> {
            String stringPath = path.toString();
            pathList.add(stringPath);
        });
        return pathList;
    }

    public ObservableList<Weapon_closeCombat> loadWeapons(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            WeaponFileReadHandler weaponFileHandler = new WeaponFileReadHandler(gearListBoxController);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(WEAPON_FILEPATH, weaponFileHandler);
            return weaponFileHandler.getObservableWeaponList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Armor> loadArmor(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            ArmorFileReadHandler armorFileHandler = new ArmorFileReadHandler(gearListBoxController);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(ARMOR_FILEPATH, armorFileHandler);
            return armorFileHandler.getObservableArmorList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Ability> loadAbilities(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            AbilityFileReadHandler abilityFileReadHandler = new AbilityFileReadHandler();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(ABILITY_FILEPATH, abilityFileReadHandler);
            return abilityFileReadHandler.getObservableAbilityList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Characteristic> loadCharacteristics(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            CharacteristicsFileReadHandler characteristicsFileReadHandler = new CharacteristicsFileReadHandler();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(CHARACTERISTICS_FILEPATH, characteristicsFileReadHandler);
            return characteristicsFileReadHandler.getObservableList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
