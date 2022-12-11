package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterLoadPopupController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.PrefService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupScreenController implements ScreenController{
    @FXML VBox screenBox;
    @FXML Label nameLabel;

    private final Tool tool;
    private final PrefService prefService;
    private Stage popupStage;
    private CharacterLoadPopupController characterLoadPopupController;
    private Character actualCharacter;
    private CharacterScreenController characterScreenController;

    public SetupScreenController(Tool tool){
        this.tool = tool;
        this.prefService = new PrefService();
    }
    @Override
    public void init() {
        if(actualCharacter == null) {
            callCharacterLoadPopup();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/mainSetup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent setupScreenParent;
        try {
            setupScreenParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return setupScreenParent;
    }

    public void callCharacterLoadPopup() {
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        characterLoadPopupController = new CharacterLoadPopupController(this);
        popupStage.setScene(new Scene(characterLoadPopupController.render()));
        popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
        characterLoadPopupController.init();
        popupStage.show();
    }

    public void closeCharacterLoadPopup(){
        this.getPopupStage().close();
        openCharacterScreen();
    }

    public void setActualCharacter(Character character){
        this.actualCharacter = character;
        nameLabel.setText(actualCharacter.getName());
    }

    public Character getActualCharacter(){
        return this.actualCharacter;
    }

    public Stage getPopupStage(){
        return this.popupStage;
    }

    public void openCharacterScreen() {
        screenBox.getChildren().clear();
        if (characterScreenController == null) {
            characterScreenController = new CharacterScreenController();
            screenBox.getChildren().add(characterScreenController.render());
            characterScreenController.init();
        } else {
            screenBox.getChildren().add(characterScreenController.getCharacterScreenParent());
        }
    }
}
