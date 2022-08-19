package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.services.FileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class CharacterLoadPopupController implements ScreenController {

    @FXML ChoiceBox<String> characterChoiceBox;
    @FXML TextField newCharacterNameField;
    @FXML Text noNameWarning;

    private final FileService fileService;

    public CharacterLoadPopupController(){
        this.fileService = new FileService();
    }

    @Override
    public void init() {
        noNameWarning.setVisible(false);
    }

    @Override
    public void stop() {
    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characterLoadPopup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent characterLoadParent;
        try {
            characterLoadParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return characterLoadParent;
    }


    public boolean createNewCharacter(ActionEvent actionEvent) {
        if(newCharacterNameField.getText().length() == 0) {
            noNameWarning.setVisible(true);
            return false;
        } else {
            fileService.saveNewCharacter(newCharacterNameField.getText());
        }
        return true;
    }

    public void loadCharacter(ActionEvent actionEvent) {
    }
}
