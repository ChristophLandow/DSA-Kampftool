package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.model.Ability;

import java.util.ArrayList;

public class SpecialAbilityController {

    private ArrayList<Ability> specialAbilityList;

    public  SpecialAbilityController(){
        loadSpecialAbilityList();
    }

    private void loadSpecialAbilityList() {
        specialAbilityList.add(new Ability("Kampfreflexe",0,0,4,
                ""));
    }


}
