package de.cLandow.dsaKampftool;

import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.CloseCombatScreenController;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterLoadPopupController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.FileService;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Tool extends Application {

    @FXML VBox screenBox;

    private static Stage primaryStage;


    private Character actualCharacter;

    private CharacterScreenController characterScreenController;
    private CharacterLoadPopupController characterLoadPopupController;
    private CloseCombatScreenController closeCombatScreenController;

    public Tool(){
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showSetupScreen();
        primaryStage.show();
        if(actualCharacter == null) {
            callCharacterLoadPopup();
        }
    }

    @Override
    public  void stop(){
        cleanup();
    }

    private static void cleanup() {
    }

    private void showSetupScreen() {
        cleanup();
        try {
            // load setup view
            Parent manScreenRoot = FXMLLoader.load(Objects.requireNonNull(Tool.class.getResource("views/mainSetup.fxml")));
            Scene newestScene = new Scene(manScreenRoot);
            //init controller
            // display scene on primary stage
            newestScene.getStylesheets().add("/de/cLandow/dsaKampftool/styles/globalStyles.css");
            primaryStage.setScene(newestScene);
            //Otherwise, the window was always minimized at TestFX later.
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCharacterScreen(ActionEvent actionEvent) {
        screenBox.getChildren().clear();
        if(characterScreenController == null){
            characterScreenController = new CharacterScreenController();
            screenBox.getChildren().add(characterScreenController.render());
            characterScreenController.init();
        }
        screenBox.getChildren().add(characterScreenController.render());
    }

    public void callCharacterLoadPopup(){
        Stage infoStage = new Stage();
        infoStage.initModality(Modality.WINDOW_MODAL);
        characterLoadPopupController = new CharacterLoadPopupController(this);
        infoStage.setScene(new Scene(characterLoadPopupController.render()));
        infoStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
        characterLoadPopupController.init();
        infoStage.show();
    }

    public void setActualCharacter(Character character){
        this.actualCharacter = character;
    }

    public void openCloseCombatScreen(ActionEvent actionEvent) {
        screenBox.getChildren().clear();
        if(closeCombatScreenController == null){
            closeCombatScreenController = new CloseCombatScreenController();
            screenBox.getChildren().add(closeCombatScreenController.render());
            closeCombatScreenController.init();
        }
        screenBox.getChildren().add(closeCombatScreenController.render());
    }
}
