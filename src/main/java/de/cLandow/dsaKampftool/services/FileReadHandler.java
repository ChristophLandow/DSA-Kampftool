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
            System.out.println("at");
        }
        if ("Parade".equals(qName)) {
            parade = Integer.parseInt(attributes.getValue("PA"));
            System.out.println("pa");
        }
        if ("Fernkampf".equals(qName)) {
            fernkampf = Integer.parseInt(attributes.getValue("FK"));
            System.out.println("fk");
        }
        if("Initiative".equals(qName)){
            initiative = Integer.parseInt(attributes.getValue("INI"));
            System.out.println("ini");
        }
    }

    //Heißt endElement, wird aber noch vor startElement aufgerufen
    @Override
    public void endElement(String uri, String localName, String qName){
        if("Name".equals(qName)){
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
