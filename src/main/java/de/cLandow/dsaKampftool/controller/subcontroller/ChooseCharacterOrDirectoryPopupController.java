package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ChooseCharacterOrDirectoryPopupController implements RenderController {

    private SetupScreenController setupScreenController;

    public ChooseCharacterOrDirectoryPopupController(SetupScreenController setupScreenController){
        this.setupScreenController = setupScreenController;
    }
    @Override
    public void init() {

    }

    @Override
    public void stop() {
        setupScreenController.closePopupStage();
    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/ChooseCharacterOrSetDirectoryPopup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent chooseCharacterOrSetDirectory;
        try {
            chooseCharacterOrSetDirectory =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return chooseCharacterOrSetDirectory;
    }

    public void chooseDirectory(ActionEvent actionEvent) {
    }

    public void exitTool(ActionEvent actionEvent) {
        stop();

    }

    public void openCreateOrChooseCharacterPopup(ActionEvent actionEvent) {
        stop();
        setupScreenController.openCharacterLoadPopup();
    }
}
