package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.*;
import de.cLandow.dsaKampftool.model.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterScreenController implements RenderController {

    @FXML HBox tabPaneHBox;
    @FXML HBox charModelHBox;
    @FXML Button addSpecialAbilityButton;
    @FXML HBox healthAndEnduranceBox;

    private Parent characterScreenParent;
    private Character actualCharacter;
    private final HealthAndEnduranceBoxController healthAndEnduranceBoxController;
    private final CharModelController charModelController;

    private final TabPaneController tabPaneController;
    private Stage popupStage;
    private ToggleGroup rightArm_toggleGroup = new ToggleGroup();

    public CharacterScreenController(Character actualCharacter) {
        this.actualCharacter = actualCharacter;
        this.healthAndEnduranceBoxController = new HealthAndEnduranceBoxController(this);
        this.charModelController = new CharModelController(this);
        this.tabPaneController = new TabPaneController(this);
    }

    @Override
    public void init() {
        //load healthAndEndurance HBox
        healthAndEnduranceBox.getChildren().add(healthAndEnduranceBoxController.render());
        healthAndEnduranceBoxController.init();
        //load charModel HBox
        charModelHBox.getChildren().add(charModelController.render());
        charModelController.init();
        //load TabPane HBox
        tabPaneHBox.getChildren().add(tabPaneController.render());
        tabPaneController.init();
    }



    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/characterScreen.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        characterScreenParent = parent;
        return parent;
    }

    public Parent getCharacterScreenParent() {
        return this.characterScreenParent;
    }

    public void openAddSpecialAbilityPopup(ActionEvent actionEvent) {
        closePopup();
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        SpecialAbilityPopupController specialAbilityPopupController = new SpecialAbilityPopupController(this);
        popupStage.setScene(new Scene(specialAbilityPopupController.render()));
        specialAbilityPopupController.init();
        popupStage.show();
    }

    public void closePopup(){
        if(popupStage != null){
            popupStage.close();
        }
    }

    public Stage getPopupStage(){
        return this.popupStage;
    }

    public Character getActualCharacter() {
        return actualCharacter;
    }

    public void openAddGearPopup(ActionEvent actionEvent) {
        closePopup();
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        AddGearPopupController addGearPopupController = new AddGearPopupController(this);
        popupStage.setScene(new Scene(addGearPopupController.render()));
        addGearPopupController.init();
        popupStage.show();
    }

}
