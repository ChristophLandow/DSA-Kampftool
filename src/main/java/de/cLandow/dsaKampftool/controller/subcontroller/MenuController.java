package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController implements ScreenController {


    private final SetupScreenController setupScreenController;
    private Stage popupStage;
    private EditCharacterController editCharacterController;

    public MenuController(SetupScreenController setupScreenController, Stage popupStage){
        this.setupScreenController = setupScreenController;
        this.popupStage = popupStage;
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/menuBox.fxml"));
        loader.setControllerFactory(c->this);
        final Parent menuBarParent;
        try {
            menuBarParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return menuBarParent;
    }

    public void createNewChar(ActionEvent actionEvent) {
        setupScreenController.callCharacterLoadPopup();
    }

    public void editChar(ActionEvent actionEvent) {
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        editCharacterController = new EditCharacterController(this.getSetupScreenController());
        popupStage.setScene(new Scene(editCharacterController.render()));
        editCharacterController.init();
        popupStage.show();
    }

    public void deleteChar(ActionEvent actionEvent) {
    }

    public void editDirectory(ActionEvent actionEvent) {
    }

    public SetupScreenController getSetupScreenController() {
        return setupScreenController;
    }
}
