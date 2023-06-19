package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;

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

    }

    @Override
    public Parent render() {
        return null;
    }

    public void chooseDirectory(ActionEvent actionEvent) {
    }

    public void exitTool(ActionEvent actionEvent) {
        stop();

    }

    public void openCreateOrChooseCharacterPopup(ActionEvent actionEvent) {
    }
}
