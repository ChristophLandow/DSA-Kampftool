package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static de.cLandow.dsaKampftool.Constants.*;

public class WriteCharacteristicsFileService {

    public WriteCharacteristicsFileService(){

    }

    public void createFile(){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(SETUP_FILEPATH + "Characteristics.xml")){
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
            writer.writeStartElement("Liste_aller_Sonderfertigkeiten");

            writer.writeStartElement(CHARACTERISTICS);

            writer.writeStartElement(CHARACTERISTIC);
            writer.writeAttribute(NAME, "Balance");
            writer.writeAttribute(CHARACTERISTIC_GROUP, ADVANTAGE);
            writer.writeAttribute(ATTACK_MOD, "0");
            writer.writeAttribute(PARADE_MOD, "0");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(ENCUMBRANCE_MOD, "0");
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
