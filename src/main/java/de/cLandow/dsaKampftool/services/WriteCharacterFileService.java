package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteCharacterFileService {

    // Write wirth StAX Cursor API
    public WriteCharacterFileService(){
    }

    public Character saveNewCharacterAsFXM(String name, Integer attack, Integer parade, Integer shooting, Integer initiative, Integer lifePoints, Integer endurancePoints, Integer strengh, Integer agility) {
        Character newCharacter = new Character(name,attack,parade,shooting,initiative, lifePoints, endurancePoints, strengh, agility);
        if(createCharacterFolder()){
            if(createSpecificCharacterFolder(newCharacter)){
                return createFile(newCharacter);
            }
        }
        return null;
    }

    public Character createFile(Character character){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(CHARACTER_FILEPATH +  character.getName() + "//" + character.getName() + ".xml")){
            writeXml(out, character);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return character;
    }

    public boolean createCharacterFolder(){
        Path path = Paths.get(CHARACTER_FILEPATH);
        File folder = new File(path.toUri());
        if(!folder.exists()){
            return folder.mkdirs();
        }
        return false;
    }

    public boolean createSpecificCharacterFolder(Character character){
        Path path = Paths.get(CHARACTER_FILEPATH +  character.getName() + "//");
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
            writer.writeStartElement(character.getName());
            // als Kommentar
            writer.writeComment("Dies ist ein Charakter für das DSA4.1 Kampftool https://github.com/ChristophLandow/DSA-Kampftool");
            // </Attribute>
            writer.writeStartElement("Held");
            writer.writeAttribute("erstellt", String.valueOf(LocalDate.now()));

            writer.writeStartElement("Name");
            writer.writeCharacters(character.getName());
            writer.writeEndElement();

            writer.writeStartElement("Attacke");
            writer.writeAttribute("AT", String.valueOf(character.getAt()));
            writer.writeEndElement();

            writer.writeStartElement("Parade");
            writer.writeAttribute("PA", String.valueOf(character.getPa()));
            writer.writeEndElement();

            writer.writeStartElement("Fernkampf");
            writer.writeAttribute("FK", String.valueOf(character.getFk()));
            writer.writeEndElement();

            writer.writeStartElement("Initiative");
            writer.writeAttribute("INI", String.valueOf(character.getIni()));
            writer.writeEndElement();

            writer.writeStartElement("Lebenspunkte");
            writer.writeAttribute("LP", String.valueOf(character.getLp()));
            writer.writeEndElement();

            writer.writeStartElement("Ausdauerpunkte");
            writer.writeAttribute("AUP", String.valueOf(character.getAup()));
            writer.writeEndElement();

            writer.writeStartElement("Koerperkraft");
            writer.writeAttribute("KK", String.valueOf(character.getKk()));
            writer.writeEndElement();

            writer.writeStartElement("Gewandheit");
            writer.writeAttribute("GE", String.valueOf(character.getGe()));
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
