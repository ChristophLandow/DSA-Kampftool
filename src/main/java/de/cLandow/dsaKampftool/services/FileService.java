package de.cLandow.dsaKampftool.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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

    public void saveFile(){
        createFolder();
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool//test.txt");
        String test = "test";
        byte[] bs = test.getBytes();
        try {
            Files.write(path, bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
