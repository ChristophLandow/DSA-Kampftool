package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.util.ArrayList;

public class SpecialAbilityController implements ScreenController {

    @FXML ChoiceBox<String> specialAbilityChoiceBox;

    private final ArrayList<Ability> specialAbilityList = new ArrayList<>();

    public  SpecialAbilityController(){

    }

    @Override
    public void init() {
        loadSpecialAbilityList();
        loadChoiceBox();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/SpecialAbilityBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
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
