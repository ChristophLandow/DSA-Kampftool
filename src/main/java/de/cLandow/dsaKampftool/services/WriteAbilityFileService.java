package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteAbilityFileService {

    public WriteAbilityFileService(){

    }

    public void createFile(){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(SETUP_FILEPATH + "Armor.xml")){
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
            writer.writeStartElement("Sonderfertigkeiten");

            writer.writeStartElement(CLOTHES);

            writer.writeStartElement(ARMOR);
            writer.writeAttribute(NAME, "Anaurak");
            writer.writeAttribute(ZONE,FULLARMOR_WITH_HELMET);
            writer.writeAttribute(HEAD_ARMOR, "1");
            writer.writeAttribute(CHEST_ARMOR, "1");
            writer.writeAttribute(BACKSIDE_ARMOR, "1");
            writer.writeAttribute(TUMMY_ARMOR, "1");
            writer.writeAttribute(LEFTARM_ARMOR, "1");
            writer.writeAttribute(RIGHTARM_ARMOR, "1");
            writer.writeAttribute(LEFTLEG_ARMOR, "1");
            writer.writeAttribute(RIGHTLEG_ARMOR, "1");
            writer.writeAttribute(SUMM_ARMOR, "1");
            writer.writeAttribute(SUMM_ENCUMBRANCE, "1");
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
