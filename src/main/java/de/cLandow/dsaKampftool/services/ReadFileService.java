package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static de.cLandow.dsaKampftool.Constants.*;

public class ReadFileService {

    public ReadFileService(){
    }

    public Character loadCharacter(String name){
        String path = FILEPATH + name + ".xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            // XXE attack, see https://rules.sonarsource.com/java/RSPEC-2755
            SAXParser saxParser = factory.newSAXParser();

            FileReadHandler handler = new FileReadHandler();

            saxParser.parse(path, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> loadCharakterNamesForChoiceBox(){
        ArrayList<String> characterArray = new ArrayList<>();
        File characterDirectory = new File(Paths.get(System.getProperty("user.home") + "//DSAKampftool").toUri());
        File[] characterList = characterDirectory.listFiles();
        if (characterList != null) {
            for (File character : characterList) {
                int index = character.getName().indexOf(".");
                String name = character.getName().substring(0,index);
                characterArray.add(name);
            }
        } else {
            return null;
        }
        return characterArray;
    }
}
