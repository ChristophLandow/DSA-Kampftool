package de.cLandow.dsaKampftool.services;


import de.cLandow.dsaKampftool.model.Character;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class FileReadHandler extends DefaultHandler {

    private Character character;
    private String name;
    private int attacke;
    private int parade;
    private int fernkampf;
    private int initiative;

    StringBuilder nameBuilder = new StringBuilder();

    @Override
    public void startDocument(){
    }

    @Override
    public void endDocument(){
        character = new Character(name, attacke, parade, fernkampf, initiative);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("Attacke".equals(qName)) {
            attacke = Integer.parseInt(attributes.getValue("AT"));
        }
        if ("Parade".equals(qName)) {
            parade = Integer.parseInt(attributes.getValue("PA"));
        }
        if ("Fernkampf".equals(qName)) {
            fernkampf = Integer.parseInt(attributes.getValue("FK"));
        }
        if("Initiative".equals(qName)){
            initiative = Integer.parseInt(attributes.getValue("INI"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if("name".equals(qName)){
            name = nameBuilder.toString();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
        nameBuilder.append(ch, start, length);
    }

    public Character getCharacter(){
        return this.character;
    }


}
