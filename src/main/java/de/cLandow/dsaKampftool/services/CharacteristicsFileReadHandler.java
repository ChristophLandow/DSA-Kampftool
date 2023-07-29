package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class CharacteristicsFileReadHandler extends DefaultHandler {

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {


    }

    //Heißt endElement, wird aber noch vor startElement aufgerufen
    @Override
    public void endElement(String uri, String localName, String qName){

    }

    @Override
    public void characters(char[] ch, int start, int length){

    }

    public ObservableList<Characteristic> getObservableList() {
        return null;
    }
}
