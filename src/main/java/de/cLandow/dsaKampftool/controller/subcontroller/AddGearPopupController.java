package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import de.cLandow.dsaKampftool.model.Weapon_rangedCombat;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class AddGearPopupController implements RenderController {


    @FXML VBox gearListVBox;
    @FXML HBox showSelectedGearHBox;
    @FXML Button addGear_Button;
    @FXML Button closePopup_Button;
    private final CharacterScreenController characterScreenController;
    private final SelectedGearBoxController selectedGearBoxController;

    private final GearListBoxController gearListBoxController;

    public AddGearPopupController(CharacterScreenController characterScreenController) {
        this.characterScreenController = characterScreenController;
        this.selectedGearBoxController = new SelectedGearBoxController();
        this.gearListBoxController = new GearListBoxController();
    }
    @Override
    public void init() {
        //load selectedGear HBox
        showSelectedGearHBox.getChildren().add(selectedGearBoxController.render());
        selectedGearBoxController.init();
        //load gearList VBox
        gearListVBox.getChildren().add(gearListBoxController.render());
        gearListBoxController.init();
    }

    @Override
    public void stop() {
    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/addGearPopup.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void closeAddGearPopup(ActionEvent actionEvent) {
        characterScreenController.closePopup();
    }

    public void addGearToHero(ActionEvent actionEvent) {
    }

    public void addGearToList(MouseEvent mouseEvent) {
    }

    public void removeGearFromList(MouseEvent mouseEvent) {
    }



    private void loadArmorList() {

    }

    public void loadSelectedGear(){

    }
}
