package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

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

            writer.writeStartElement("Zweihand-Hiebwaffen");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Barbarenstreitaxt");
            writer.writeAttribute("Mod", "15/1");
            writer.writeAttribute("Distanz", "N");
            writer.writeAttribute("Ini", "-2");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement("Dolche");

            writer.writeStartElement("Waffe");
            writer.writeAttribute("Name", "Langdolch");
            writer.writeAttribute("Mod", "12/3");
            writer.writeAttribute("Distanz", "HN");
            writer.writeAttribute("Ini", "1");
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
