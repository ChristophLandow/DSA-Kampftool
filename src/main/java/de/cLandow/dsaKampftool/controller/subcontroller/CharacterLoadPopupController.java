package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.ScreenController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.ReadFileService;
import de.cLandow.dsaKampftool.services.WriteFileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CharacterLoadPopupController implements ScreenController, Initializable {


    private final SetupScreenController setupScreenController;
    @FXML ComboBox<String> characterBox;
    @FXML TextField newCharacterNameField;
    @FXML Text noNameWarning;

    private ArrayList<String> characterNames = new ArrayList<>();
    private final ReadFileService readFileService;
    private final WriteFileService writeFileService;


    public CharacterLoadPopupController(SetupScreenController setupScreenController){
        this.setupScreenController = setupScreenController;
        this.readFileService = new ReadFileService();
        this.writeFileService = new WriteFileService();
    }

    @Override
    public void init() {
        noNameWarning.setVisible(false);
    }

    @Override
    public void stop() {
        setupScreenController.getPopupStage().close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        characterNames = readFileService.loadCharakterNamesForChoiceBox();
        characterBox.getItems().addAll(characterNames);
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
            setupScreenController.setActualCharacter(writeFileService.saveNewCharacterAsFXM(newCharacterNameField.getText()));
            stop();
        }
    }

    public void loadCharacter(ActionEvent actionEvent) {
        setupScreenController.setActualCharacter(readFileService.loadCharacter(characterBox.getValue()));
        stop();
    }


}
