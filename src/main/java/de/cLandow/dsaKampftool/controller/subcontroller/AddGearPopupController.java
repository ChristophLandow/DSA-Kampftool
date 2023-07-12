package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Gear;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static de.cLandow.dsaKampftool.Constants.CLOSECOMBATCLASS;

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
        this.selectedGearBoxController = new SelectedGearBoxController(this);
        this.gearListBoxController = new GearListBoxController(this);
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

    public void addGearFromListToEquipment(Gear gear){
        String gearClass = String.valueOf(gear.getClass());
        switch (gearClass) {
            case CLOSECOMBATCLASS -> {
                selectedGearBoxController.setMainWeapon((Weapon_closeCombat) gear);
            }
            default -> {
                System.out.println("Unidentified Gear Class");
            }
        }

    }

    public void addGearToHero(ActionEvent actionEvent) {
    }
}
