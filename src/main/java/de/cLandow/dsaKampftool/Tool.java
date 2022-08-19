package de.cLandow.dsaKampftool;

import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterLoadPopupController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Tool extends Application {

    private Character actualCharacter;
    @FXML VBox screenBox;
    private static Stage primaryStage;

    private CharacterScreenController characterScreenController;
    private CharacterLoadPopupController characterLoadPopupController;


    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showSetupScreen();
        primaryStage.show();
        loadCharacter();
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

    private void loadCharacter() {
        //TODO: Wenn das charakter erstellen und bearbeiten implementiert wurde muss hier beim öffnen des Tools einer
        // ausgewählt oder neu erstellt werden
        if(actualCharacter == null){
            callAlert();
        } else {
            System.out.println("test");
        }
    }

    public void openCharacterScreen(ActionEvent actionEvent) {
        screenBox.getChildren().clear();
        characterScreenController = new CharacterScreenController();
        screenBox.getChildren().add(characterScreenController.render());
        characterScreenController.init();
    }

    public void callAlert(){
        Stage infoStage = new Stage();
        infoStage.initModality(Modality.WINDOW_MODAL);
        characterLoadPopupController = new CharacterLoadPopupController();
        infoStage.setScene(new Scene(characterLoadPopupController.render()));
        infoStage.show();

    }
}
