package de.cLandow.dsaKampftool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Tool extends Application {

    private Character actualCharacter;
    private static Stage primaryStage;

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
            Parent ingameScreenRoot = FXMLLoader.load(Objects.requireNonNull(Tool.class.getResource("views/mainSetup.fxml")));
            Scene newestScene = new Scene(ingameScreenRoot);
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
    }
}
