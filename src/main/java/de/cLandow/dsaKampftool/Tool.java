package de.cLandow.dsaKampftool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Tool extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showSetupScreen();
        primaryStage.show();
    }

    @Override
    public  void stop(){
        cleanup();
    }

    private void showSetupScreen() {
        cleanup();
        try {
            // load setup view
            Parent ingameScreenRoot = FXMLLoader.load(Tool.class.getResource("views/mainSetup.fxml"));
            Scene newestScene = new Scene(ingameScreenRoot);
            // display scene on primary stage
            newestScene.getStylesheets().add("/de/cLandow/dsaKampftool/styles/globalStyles.css");
            primaryStage.setScene(newestScene);
            //Otherwise, the window was always minimized at TestFX.
            primaryStage.centerOnScreen();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void cleanup() {
    }
}
