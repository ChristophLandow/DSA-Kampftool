package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteGearFileService {

    public WriteGearFileService(){
    }

    public void createFile(){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(SETUP_FILEPATH + "Gear.xml")){
            writeXml(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(OutputStream out)  {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            // <Charakter>
            writer.writeStartElement("Waffen");

            writer.writeStartElement("Anderthalbhaender");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Anderthalbhaender");
            writer.writeAttribute("Schaden", "1W6+5");
            writer.writeAttribute("SchadensMod", "11/4");
            writer.writeAttribute("Distanzklasse", "NS");
            writer.writeAttribute("IniBonus", "+1");
            writer.writeAttribute("StatBonus", "0/0");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("Zweihand-Hiebwaffen");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Barbarenstreitaxt");
            writer.writeAttribute("Schaden", "3W6+2");
            writer.writeAttribute("SchadensMod", "15/1");
            writer.writeAttribute("Distanzklasse", "N");
            writer.writeAttribute("IniBonus", "-2");
            writer.writeAttribute("StatBonus", "-1/-4");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("Dolche");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Langdolch");
            writer.writeAttribute("Schaden", "1W6+2");
            writer.writeAttribute("SchadensMod", "12/4");
            writer.writeAttribute("Distanzklasse", "H");
            writer.writeAttribute("IniBonus", "0");
            writer.writeAttribute("StatBonus", "0/0");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("Fechtwaffen");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Degen");
            writer.writeAttribute("Schaden", "1W6+3");
            writer.writeAttribute("SchadensMod", "12/5");
            writer.writeAttribute("Distanzklasse", "N");
            writer.writeAttribute("IniBonus", "2");
            writer.writeAttribute("StatBonus", "0/-1");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeEndDocument();

            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
