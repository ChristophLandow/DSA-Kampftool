package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteArmorFileService {

    public WriteArmorFileService(){
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
            writer.writeStartElement("Ruestungen");

            writer.writeStartElement(CLOTHES);

            writer.writeStartElement(ARMOR);
            writer.writeAttribute(NAME, "Anaurak");
            writer.writeAttribute(ZONE, HEAD);
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

            writer.writeStartElement(ARMOR);
            writer.writeAttribute(NAME, "Dicke Kleidung");
            writer.writeAttribute(ZONE, FULLARMOR);
            writer.writeAttribute(HEAD_ARMOR, "0");
            writer.writeAttribute(CHEST_ARMOR, "1");
            writer.writeAttribute(BACKSIDE_ARMOR, "1");
            writer.writeAttribute(TUMMY_ARMOR, "1");
            writer.writeAttribute(LEFTARM_ARMOR, "1");
            writer.writeAttribute(RIGHTARM_ARMOR, "1");
            writer.writeAttribute(LEFTLEG_ARMOR, "1");
            writer.writeAttribute(RIGHTLEG_ARMOR, "1");
            writer.writeAttribute(SUMM_ARMOR, "0.9");
            writer.writeAttribute(SUMM_ENCUMBRANCE, "0.9");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement(CLOTARMOR);

            writer.writeStartElement(ARMOR);
            writer.writeAttribute(NAME, "Gambeson");
            writer.writeAttribute(ZONE, FULLARMOR);
            writer.writeAttribute(HEAD_ARMOR, "0");
            writer.writeAttribute(CHEST_ARMOR, "2");
            writer.writeAttribute(BACKSIDE_ARMOR, "2");
            writer.writeAttribute(TUMMY_ARMOR, "2");
            writer.writeAttribute(LEFTARM_ARMOR, "1");
            writer.writeAttribute(RIGHTARM_ARMOR, "1");
            writer.writeAttribute(LEFTLEG_ARMOR, "1");
            writer.writeAttribute(RIGHTLEG_ARMOR, "1");
            writer.writeAttribute(SUMM_ARMOR, "1.5");
            writer.writeAttribute(SUMM_ENCUMBRANCE, "1.5");
            writer.writeEndElement();

            writer.writeStartElement(ARMOR);
            writer.writeAttribute(NAME, "Mattenruecken");
            writer.writeAttribute(ZONE, TORSOARMOR_WITH_HELMET);
            writer.writeAttribute(HEAD_ARMOR, "1");
            writer.writeAttribute(CHEST_ARMOR, "1");
            writer.writeAttribute(BACKSIDE_ARMOR, "3");
            writer.writeAttribute(TUMMY_ARMOR, "0");
            writer.writeAttribute(LEFTARM_ARMOR, "0");
            writer.writeAttribute(RIGHTARM_ARMOR, "0");
            writer.writeAttribute(LEFTLEG_ARMOR, "0");
            writer.writeAttribute(RIGHTLEG_ARMOR, "0");
            writer.writeAttribute(SUMM_ARMOR, "0.9");
            writer.writeAttribute(SUMM_ENCUMBRANCE, "0.9");
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
