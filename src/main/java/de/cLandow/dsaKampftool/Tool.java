package de.cLandow.dsaKampftool;

import de.cLandow.dsaKampftool.controller.SetupScreenController;
import de.cLandow.dsaKampftool.services.WriteFileService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Tool extends Application {

    private static Stage primaryStage;
    private SetupScreenController setupScreenController;
    public Tool() {
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showSetupScreen();
        primaryStage.show();
        setupScreenController.init();
    }

    @Override
    public void stop() {
    }

    private void showSetupScreen() {
        setupScreenController = new SetupScreenController(this);
        Scene newestScene = new Scene(setupScreenController.render());
        newestScene.getStylesheets().add("/de/cLandow/dsaKampftool/styles/globalStyles.css");
        primaryStage.setScene(newestScene);
        primaryStage.centerOnScreen();
    }


    
}

