package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.model.Ability;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class SpecialAbilityController {

    private final ChoiceBox<String> specialAbilityChoiceBox;
    private ArrayList<Ability> specialAbilityList;

    public  SpecialAbilityController(ChoiceBox<String> specialAbilityChoiceBox){
        this.specialAbilityChoiceBox = specialAbilityChoiceBox;
        loadSpecialAbilityList();
        loadChoiceBox();
    }

    private void loadChoiceBox() {
        for (Ability ability : specialAbilityList){
            specialAbilityChoiceBox.getItems().add(ability.abilityName());
        }
    }

    private void loadSpecialAbilityList() {
        specialAbilityList.add(new Ability("Kampfreflexe",0,0,4,
                ""));
    }


}
