package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class SpecialAbilityPopupController implements ScreenController {

    @FXML ListView<String> abilityListView;

    private final CharacterScreenController characterScreenController;

    private final ArrayList<Ability> specialAbilityList = new ArrayList<>();

    public  SpecialAbilityPopupController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
        abilityListView.setEditable(false);
    }

    @Override
    public void init() {
        loadSpecialAbilityList();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/addAbilityPopup.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void closeAddSpecialAbilityPopup(ActionEvent actionEvent) {
        characterScreenController.closeAddSpecialAbilityPopup();
    }

    public void addSpecialAbilityToHero(ActionEvent actionEvent) {
        ObservableList<String> auswahl = abilityListView.getSelectionModel().getSelectedItems();
    }

    private void loadSpecialAbilityList() {
        specialAbilityList.add(new Ability("Kampfreflexe",0,0,4,
                ""));
        abilityListView.getItems().add("Kampfreflexe");
    }


}
