package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import static de.cLandow.dsaKampftool.Constants.*;

public class ReadFileService {



    public ReadFileService(){
    }





    public Character loadCharacter(String name){
        Path path = Paths.get(FILEPATH + name + ".txt");
        File file = new File(path.toUri());
        try {
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            int index = data.indexOf("_");
            int at = Integer.parseInt(data.substring(index+1,index+1));
            int pa = Integer.parseInt(data.substring(index+2,index+2));
            int fk = Integer.parseInt(data.substring(index+3,index+3));
            int ini = Integer.parseInt(data.substring(index+4,index+4));
            return new Character(name, at, pa, fk, ini);
        } catch (FileNotFoundException e) {
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