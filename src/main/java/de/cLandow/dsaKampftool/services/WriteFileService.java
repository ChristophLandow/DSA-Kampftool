package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static de.cLandow.dsaKampftool.Constants.FILEPATH;

public class WriteFileService {

    // Write wirth StAX Cursor API
    public WriteFileService(){

    }

    public void saveCharacterAsFXM(Character character){
        // writes the users
        createFolder();
        createFile(character);
    }

    public void saveNewCharacterAsFXM(String name) {
        createFolder();
        createFile(new Character(name,0,0,0,0));
    }

    public void createFile(Character character){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(FILEPATH + character.name() + ".xml")){
            writeXml(out, character);
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

    private static void writeXml(OutputStream out, Character character)  {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = null;
        try {
            writer = output.createXMLStreamWriter(out, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            // <Charakter>
            writer.writeStartElement(character.name());
            // als Kommentar
            writer.writeComment("Dies ist ein Charakter für das DSA4.1 Kampftool https://github.com/ChristophLandow/DSA-Kampftool");
            // </Attribute>
            writer.writeStartElement("Held");
            writer.writeAttribute("erstellt", String.valueOf(LocalDate.now()));

            writer.writeStartElement("name");
            writer.writeCharacters(character.name());
            writer.writeEndElement();

            writer.writeStartElement("Attacke");
            writer.writeAttribute("AT", String.valueOf(character.at()));
            writer.writeEndElement();

            writer.writeStartElement("Parade");
            writer.writeAttribute("PA", String.valueOf(character.pa()));
            writer.writeEndElement();

            writer.writeStartElement("Fernkampf");
            writer.writeAttribute("FK", String.valueOf(character.fk()));
            writer.writeEndElement();

            writer.writeStartElement("Initiative");
            writer.writeAttribute("INI", String.valueOf(character.ini()));
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
