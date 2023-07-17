package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class SpecialAbilityPopupController implements RenderController {

    @FXML ListView<String> selectionListView;
    @FXML Button closeButton;
    @FXML Button addButton;
    @FXML TextArea informationTextPane;
    @FXML ListView<String> abilityListView = new ListView<>();

    private final CharacterScreenController characterScreenController;

    private ObservableList<Ability> observableAbilityList;

    public  SpecialAbilityPopupController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
        abilityListView.setEditable(false);
        informationTextPane.setEditable(false);
    }

    @Override
    public void init() {
        loadSpecialAbilityList();
        fillAbilityList();
    }

    private void fillAbilityList() {
        observableAbilityList.forEach((abiliy) -> abilityListView.getItems().add(abiliy.name()));
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
        characterScreenController.closePopup();
    }

    public void addSpecialAbilityToHero(ActionEvent actionEvent) {
        ObservableList<String> auswahl = abilityListView.getSelectionModel().getSelectedItems();
    }

    private void loadSpecialAbilityList() {
        ReadFileService readFileService = new ReadFileService(this);
        observableAbilityList = readFileService.loadAbilities();
    }
}
