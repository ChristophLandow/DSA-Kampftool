package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteSetupFileService {

    public WriteSetupFileService(){

    }

    public void saveSetupFile(String path){
        createFolder();
        createFile(path);
    }

    public void createFile(String path){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(SETUP_FILEPATH + "SetupFile.xml")){
            writeXml(out, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createFolder(){
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool");
        File folder = new File(path.toUri());
        if(!folder.exists()){
            return folder.mkdirs();
        }
        return false;
    }

    private static void writeXml(OutputStream out, String path)  {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = null;
        try {
            writer = output.createXMLStreamWriter(out, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            // <Charakter>
            writer.writeStartElement("SETUP");
            // als Kommentar
            writer.writeComment("Dies ist ein Setup-File für das DSA4.1 Kampftool https://github.com/ChristophLandow/DSA-Kampftool");
            // </Attribute>
            writer.writeStartElement("Date");
            writer.writeAttribute("erstellt", String.valueOf(LocalDate.now()));

            writer.writeStartElement("Path");
            writer.writeCharacters(path);
            writer.writeEndElement();

            writer.writeEndElement();
            // </Attribute>

            writer.writeEndDocument();
            // <Charakter>

            writer.flush();

            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
