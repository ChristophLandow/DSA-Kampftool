package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class EditCharacterController implements RenderController {

    private final SetupScreenController setupScreenController;

    public EditCharacterController(SetupScreenController setupScreenController){
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
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/editCharacterPopup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent characterEditParent;
        try {
            characterEditParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return characterEditParent;
    }

    public void editCharacter(ActionEvent actionEvent) {

    }

    public void close(ActionEvent actionEvent) {
    }

    public void uploadOwnPicture(ActionEvent actionEvent) {
    }
}
