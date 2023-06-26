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

import static de.cLandow.dsaKampftool.Constants.FILEPATH;
import static de.cLandow.dsaKampftool.Constants.GEAR_FILEPATH;

public class WriteGearFileService {

    public WriteGearFileService(){
    }

    public void createFile(){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(GEAR_FILEPATH + "Ausrüstung.xml")){
            writeXml(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createGearFolder(){
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool" + "//Ausrüstung");
        File folder = new File(path.toUri());
        if(!folder.exists()){
            return folder.mkdirs();
        }
        return false;
    }

    private static void writeXml(OutputStream out)  {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = null;
        try {
            writer = output.createXMLStreamWriter(out, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            // <Ausrüstungsklasse>
            writer.writeStartElement("Waffen");
            // als Kommentar
            writer.writeComment("Dies ist ein Charakter für das DSA4.1 Kampftool https://github.com/ChristophLandow/DSA-Kampftool");
            // <Waffen>
            writer.writeStartElement("Barbarenstreitaxt");

            writer.writeStartElement("Gattung");
            writer.writeAttribute("Typ", "Zweihand-Hiebwaffe");
            writer.writeEndElement();

            writer.writeStartElement("Schaden");
            writer.writeAttribute("TP", "3w6+2");
            writer.writeEndElement();

            writer.writeStartElement("Bonus");
            writer.writeAttribute("TP/KK", "15/1");
            writer.writeEndElement();

            writer.writeStartElement("Initiative");
            writer.writeAttribute("INI_mod", "-2");
            writer.writeEndElement();

            writer.writeStartElement("Modi");
            writer.writeAttribute("WM", "-1/-4");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("Langdolch");

            writer.writeStartElement("Gattung");
            writer.writeAttribute("Typ", "Dolche");
            writer.writeEndElement();

            writer.writeStartElement("Schaden");
            writer.writeAttribute("TP", "1w6+1");
            writer.writeEndElement();

            writer.writeStartElement("Bonus");
            writer.writeAttribute("TP/KK", "12/5");
            writer.writeEndElement();

            writer.writeStartElement("Initiative");
            writer.writeAttribute("INI_mod", "0");
            writer.writeEndElement();

            writer.writeStartElement("Modi");
            writer.writeAttribute("WM", "0/-1");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeEndDocument();
            // <Charakter>

            writer.flush();

            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
