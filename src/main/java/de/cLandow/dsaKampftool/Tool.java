package de.cLandow.dsaKampftool;

import de.cLandow.dsaKampftool.controller.MainScreenController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Tool extends Application {

    private static Stage primaryStage;
    private MainScreenController mainScreenController;
    public Tool() {
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        showSetupScreen();
        primaryStage.show();
        mainScreenController.init();
        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    @Override
    public void stop() {
    }

    private void showSetupScreen() {
        mainScreenController = new MainScreenController(this);
        Scene newestScene = new Scene(mainScreenController.render());
        primaryStage.setScene(newestScene);
        primaryStage.centerOnScreen();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

