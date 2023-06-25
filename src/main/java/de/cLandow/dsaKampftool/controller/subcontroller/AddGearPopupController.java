package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Armor;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import de.cLandow.dsaKampftool.model.Weapon_rangedCombat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class AddGearPopupController implements RenderController {


    @FXML HBox showSelectedGearHBox;
    @FXML ChoiceBox<String> gearGroupChoiceBox;
    @FXML ListView<String> gearListView;
    @FXML Button addGear_Button;
    @FXML Button closePopup_Button;
    private final CharacterScreenController characterScreenController;
    private final SelectedGearBoxController selectedGearBoxController;
    private ArrayList<Armor> armorList = new ArrayList<>();
    private ArrayList<Weapon_closeCombat> closeCombatWeaponList = new ArrayList<>();
    private ArrayList<Weapon_rangedCombat> rangedCombatWeaponList = new ArrayList<>();

    public AddGearPopupController(CharacterScreenController characterScreenController) {
        this.characterScreenController = characterScreenController;
        this.selectedGearBoxController = new SelectedGearBoxController();
    }
    @Override
    public void init() {
        loadGearLists();
        //load selectedGear HBox
        showSelectedGearHBox.getChildren().add(selectedGearBoxController.render());
        selectedGearBoxController.init();
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

    public void loadGearLists(){
        loadArmorList();
    }

    private void loadArmorList() {
        gearListView.getItems().add(new Armor("Amazonenüstung",3,5,3,5,2,2,3,3,3.7,2.7,8).toString());
    }

    public void loadSelectedGear(){

    }
}
