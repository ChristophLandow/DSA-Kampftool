package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileService {


    public FileService(){

    }

    public boolean createFolder(){
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool");
        File folder = new File(path.toUri());
        if(!folder.exists()){
            return folder.mkdirs();
        }
        return false;
    }

    public void saveNewCharacter(String name){
        createFolder();
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool//" + name + ".txt");
        String characterData = name + " 0000";
        byte[] bs = characterData.getBytes();
        try {
            Files.write(path, bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Character loadCharacter(String name){
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool//" + name + ".txt");
        File file = new File(path.toUri());
        try {
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            int index = data.indexOf(" ");
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
}
