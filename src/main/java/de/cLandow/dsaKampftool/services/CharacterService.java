package de.cLandow.dsaKampftool.services;

import de.cLandow.dsaKampftool.model.Character;

public class CharacterService {


    public CharacterService(){
    }

    public Character createCharacter(String name, Integer at, Integer pa, Integer fk, Integer ini, Integer lp, Integer aup){
        return new Character(name, at, pa, fk, ini, lp, aup);
    }

    public Character modifyNameOfCharacter(Character character, String newName){
        character.setName(newName);
        return character;
    }

    public Character modifyAttackOfCharacter(Character character, Integer newAttack){
        character.setAt(newAttack);
        return character;
    }

    public Character modifyParadeOfCharacter(Character character, Integer newParade){
        character.setPa(newParade);
        return character;
    }

    public Character modifyDistancefightingOfCharacter(Character character, Integer newDf){
        character.setPa(newDf);
        return character;
    }


}
