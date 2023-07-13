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

            writer.writeStartElement(BASTARDSWORDS);

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Anderthalbhaender");
            writer.writeAttribute(DAMAGE, "1W6+5");
            writer.writeAttribute(DAMAGEMOD, "11/4");
            writer.writeAttribute(DISTANCE, "NS");
            writer.writeAttribute(INITIATIVEMOD, "1");
            writer.writeAttribute(STATMOD, "0/0");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Bastardschwert");
            writer.writeAttribute(DAMAGE, "1W6+5");
            writer.writeAttribute(DAMAGEMOD, "11/3");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(STATMOD, "0/-1");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Nachtwind");
            writer.writeAttribute(DAMAGE, "1W6+4");
            writer.writeAttribute(DAMAGEMOD, "11/5");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "2");
            writer.writeAttribute(STATMOD, "0/0");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Rondrakamm");
            writer.writeAttribute(DAMAGE, "1W6+6");
            writer.writeAttribute(DAMAGEMOD, "12/3");
            writer.writeAttribute(DISTANCE, "NS");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(STATMOD, "0/0");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Tuzakmesser");
            writer.writeAttribute(DAMAGE, "1W6+6");
            writer.writeAttribute(DAMAGEMOD, "12/4");
            writer.writeAttribute(DISTANCE, "NS");
            writer.writeAttribute(INITIATIVEMOD, "1");
            writer.writeAttribute(STATMOD, "0/0");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement(TWO_HANDED_IMPACT_WEAPON);

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Barbarenstreitaxt");
            writer.writeAttribute(DAMAGE, "3W6+2");
            writer.writeAttribute(DAMAGEMOD, "15/1");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "-2");
            writer.writeAttribute(STATMOD, "-1/-4");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Echsische Axt");
            writer.writeAttribute(DAMAGE, "1W6+5");
            writer.writeAttribute(DAMAGEMOD, "12/4");
            writer.writeAttribute(DISTANCE, "NS");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(STATMOD, "0/-1");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Felsspalter");
            writer.writeAttribute(DAMAGE, "2W6+2");
            writer.writeAttribute(DAMAGEMOD, "14/2");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "-1");
            writer.writeAttribute(STATMOD, "0/-2");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Gruufhai");
            writer.writeAttribute(DAMAGE, "1W6+6");
            writer.writeAttribute(DAMAGEMOD, "14/2");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "-2");
            writer.writeAttribute(STATMOD, "-1/-3");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement(DAGGERS);

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Langdolch");
            writer.writeAttribute(DAMAGE, "1W6+2");
            writer.writeAttribute(DAMAGEMOD, "12/4");
            writer.writeAttribute(DISTANCE, "H");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(STATMOD, "0/0");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement(FENCING_WEAPONS);

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Degen");
            writer.writeAttribute(DAMAGE, "1W6+3");
            writer.writeAttribute(DAMAGEMOD, "12/5");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "2");
            writer.writeAttribute(STATMOD, "0/-1");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Florett");
            writer.writeAttribute(DAMAGE, "1W6+3");
            writer.writeAttribute(DAMAGEMOD, "13/5");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "3");
            writer.writeAttribute(STATMOD, "+1/-1");
            writer.writeEndElement();

            writer.writeEndElement();

            writer.writeStartElement(IMPACT_WEAPONS);

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Baccanaq/Bacca");
            writer.writeAttribute(DAMAGE, "1W6+4");
            writer.writeAttribute(DAMAGEMOD, "12/4");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "-1");
            writer.writeAttribute(STATMOD, "0/-2");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Beil");
            writer.writeAttribute(DAMAGE, "1W6+3");
            writer.writeAttribute(DAMAGEMOD, "11/4");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "-1");
            writer.writeAttribute(STATMOD, "-1/-2");
            writer.writeEndElement();

            writer.writeStartElement(WEAPON);
            writer.writeAttribute(NAME, "Brabakbengel");
            writer.writeAttribute(DAMAGE, "1W6+5");
            writer.writeAttribute(DAMAGEMOD, "13/3");
            writer.writeAttribute(DISTANCE, "N");
            writer.writeAttribute(INITIATIVEMOD, "0");
            writer.writeAttribute(STATMOD, "0/-1");
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
