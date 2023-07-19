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
import javafx.scene.control.*;

import java.io.IOException;

public class SpecialAbilityPopupController implements RenderController {

    @FXML ChoiceBox<String> abilityChoiceBox;
    @FXML TextField searchAbilityTextField;
    @FXML ListView<Ability> selectionListView;
    @FXML Button closeButton;
    @FXML Button addButton;
    @FXML ListView<Ability> abilityListView;

    private final CharacterScreenController characterScreenController;

    private ObservableList<Ability> observableAbilityList;

    public  SpecialAbilityPopupController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
    }

    @Override
    public void init() {
        loadSpecialAbilityList();
        abilityListView.setCellFactory(gearListView -> new AbilityListItemController(this));
        selectionListView.setCellFactory(gearListView -> new AbilityListItemController(this));
        loadAbilityListView();
    }

    private void loadAbilityListView() {
        abilityListView.setItems(observableAbilityList);
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
    }

    private void loadSpecialAbilityList() {
        ReadFileService readFileService = new ReadFileService(this);
        observableAbilityList = readFileService.loadAbilities();
    }

    public void addAbilityToList(Ability ability) {
        selectionListView.getItems().add(ability);
    }
}
