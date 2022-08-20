package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.FileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CharacterLoadPopupController implements ScreenController, Initializable {

    private final Tool tool;
    @FXML ChoiceBox<String> characterChoiceBox;
    @FXML TextField newCharacterNameField;
    @FXML Text noNameWarning;

    private ArrayList<String> characterNames = new ArrayList<>();
    private final FileService fileService;

    public CharacterLoadPopupController( Tool tool){
        this.tool = tool;
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
    public void initialize(URL location, ResourceBundle resources) {
        characterNames = fileService.loadCharakterNamesForChoiceBox();
        characterChoiceBox.getItems().addAll(characterNames);
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


    public void createNewCharacter(ActionEvent actionEvent) {
        if(newCharacterNameField.getText().length() == 0) {
            noNameWarning.setVisible(true);
        } else {
            fileService.saveNewCharacter(newCharacterNameField.getText());
            stop();
        }
    }

    public void loadCharacter(ActionEvent actionEvent) {
        Character loadedCharacter = fileService.loadCharacter(characterChoiceBox.getValue());
        tool.setActualCharacter(loadedCharacter);
        stop();
        //TODO: ChoiceBox initialisieren
    }


}
