package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterLoadPopupController;
import de.cLandow.dsaKampftool.controller.subcontroller.MenuController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.PrefService;
import static de.cLandow.dsaKampftool.Constants.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupScreenController implements RenderController {
    @FXML VBox screenBox;
    @FXML Label nameLabel;
    @FXML Label baseAtLabel;
    @FXML Label basePaLabel;
    @FXML Label baseFkLabel;
    @FXML Label baseIniLabel;
    @FXML Label baseAupLabel;
    @FXML Label baseLepLabel;
    @FXML HBox menuBox;

    private final Tool tool;
    private final PrefService prefService;
    private Stage popupStage;
    private CharacterLoadPopupController characterLoadPopupController;
    private Character actualCharacter;
    private CharacterScreenController characterScreenController;
    private MenuController menuController;


    public SetupScreenController(Tool tool){
        this.tool = tool;
        this.prefService = new PrefService();
    }
    @Override
    public void init() {
        if(actualCharacter == null) {
            callCharacterLoadPopup();
        }
        menuController = new MenuController(this, popupStage);
        menuBox.getChildren().add(menuController.render());
        menuController.init();
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
        PrefService prefService = new PrefService();
        if(prefService.getDirectory().equals(NOSAVEFILE)){
            popupStage = new Stage();
            popupStage.initModality(Modality.WINDOW_MODAL);
            characterLoadPopupController = new CharacterLoadPopupController(this);
            popupStage.setScene(new Scene(characterLoadPopupController.render()));
            popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
            characterLoadPopupController.init();
            popupStage.show();
        } else {
            popupStage = new Stage();
            popupStage.initModality(Modality.WINDOW_MODAL);
            characterLoadPopupController = new CharacterLoadPopupController(this);
            popupStage.setScene(new Scene(characterLoadPopupController.render()));
            popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
            characterLoadPopupController.init();
            popupStage.show();
        }
    }

    public void closeCharacterLoadPopup(){
        this.getPopupStage().close();
        loadStats();
        openCharacterScreen();
    }

    public void setActualCharacter(Character character){
        this.actualCharacter = character;
    }

    public void loadCharacterName(){
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
            characterScreenController = new CharacterScreenController(actualCharacter);
            screenBox.getChildren().add(characterScreenController.render());
            characterScreenController.init();
        } else {
            screenBox.getChildren().add(characterScreenController.getCharacterScreenParent());
        }
    }

    public void loadStats() {
        baseAtLabel.setText(Integer.toString(actualCharacter.getAt()));
        basePaLabel.setText(Integer.toString(actualCharacter.getPa()));
        baseFkLabel.setText(Integer.toString(actualCharacter.getFk()));
        baseIniLabel.setText(Integer.toString(actualCharacter.getIni()));
        baseAupLabel.setText(Integer.toString(actualCharacter.getAup()));
        baseLepLabel.setText(Integer.toString(actualCharacter.getLp()));
    }

    public Tool getTool(){
        return this.tool;
    }


}
