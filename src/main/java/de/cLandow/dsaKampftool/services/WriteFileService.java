package de.cLandow.dsaKampftool.services;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static de.cLandow.dsaKampftool.Constants.FILEPATH;

public class WriteFileService {

    // Write wirth StAX Cursor API
    public WriteFileService(){

    }

    public void saveNewCharacterAsFXM(String name){
        // writes the users
        createFolder();
        createFile(name);
    }

    public void createFile(String name){
        // send the output to a xml file
        try(FileOutputStream out = new FileOutputStream(FILEPATH + name + ".xml")){
            writeXml(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // send the output to System.out
        // writeXml(System.out);
    }

    public boolean createFolder(){
        Path path = Paths.get(System.getProperty("user.home") + "//DSAKampftool");
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
            writer = output.createXMLStreamWriter(out);
            writer.writeStartDocument("utf-8", "1.0");
            // <company>
            writer.writeStartElement("company");

            // <staff>

            // add XML comment
            writer.writeComment("This is Staff 1001");

            writer.writeStartElement("staff");
            writer.writeAttribute("id", "1001");

            writer.writeStartElement("name");
            writer.writeCharacters("mkyong");
            writer.writeEndElement();

            writer.writeStartElement("salary");
            writer.writeAttribute("currency", "USD");
            writer.writeCharacters("5000");
            writer.writeEndElement();

            writer.writeStartElement("bio");
            writer.writeCData("HTML tag <code>testing</code>");
            writer.writeEndElement();

            writer.writeEndElement();
            // </staff>

            // <staff>
            writer.writeStartElement("staff");
            writer.writeAttribute("id", "1002");

            writer.writeStartElement("name");
            writer.writeCharacters("yflow");
            writer.writeEndElement();

            writer.writeStartElement("salary");
            writer.writeAttribute("currency", "EUR");
            writer.writeCharacters("8000");
            writer.writeEndElement();

            writer.writeStartElement("bio");
            writer.writeCData("a & b");
            writer.writeEndElement();

            writer.writeEndElement();
            // </staff>

            writer.writeEndDocument();
            // </company>

            writer.flush();

            writer.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
