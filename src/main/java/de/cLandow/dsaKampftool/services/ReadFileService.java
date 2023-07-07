package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.controller.subcontroller.GearListBoxController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import javafx.collections.ObservableList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import static de.cLandow.dsaKampftool.Constants.*;

public class ReadFileService {

    private GearListBoxController gearListBoxController;

    public ReadFileService(GearListBoxController gearListBoxController) {
        this.gearListBoxController = gearListBoxController;
    }

    public ReadFileService(){

    }

    public Character loadCharacter(String name){
        String path = CHARACTER_FILEPATH + name + ".xml";
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
        File characterDirectory = new File(Paths.get(System.getProperty("user.home") + "//DSAKampftool//Charakter").toUri());
        File[] characterList = characterDirectory.listFiles();
        if (characterList != null) {
            for (File character : characterList) {
                int index = character.getName().indexOf(".");
                String name = character.getName().substring(0, index);
                characterArray.add(name);
            }
        } else {
            return null;
        }
        return characterArray;
    }


    public ObservableList<Weapon_closeCombat> loadGear(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            GearFileReadHandler gearHandler = new GearFileReadHandler(gearListBoxController);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(GEAR_FILEPATH, gearHandler);
            return gearHandler.getObservableGearList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
