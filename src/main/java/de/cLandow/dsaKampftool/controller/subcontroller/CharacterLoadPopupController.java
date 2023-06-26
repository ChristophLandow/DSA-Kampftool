package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.PrefService;
import de.cLandow.dsaKampftool.services.ReadFileService;
import de.cLandow.dsaKampftool.services.WriteCharacterFileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CharacterLoadPopupController implements RenderController, Initializable {

    private final SetupScreenController setupScreenController;

    @FXML Spinner<String> newCharacterProtraitSpinner;
    @FXML Circle characterImageCircle;
    @FXML Label directoryLabel;
    @FXML ComboBox<String> characterBox;
    @FXML TextField newCharacterNameField;
    @FXML TextField newCharAtField;
    @FXML TextField newCharFkField;
    @FXML TextField newCharPaField;
    @FXML TextField newCharIniField;
    @FXML Text noNameWarning;
    @FXML Text noStatsWarning;
    @FXML TextField newCharEnduranceField;
    @FXML TextField newCharLifepointsField;


    private ArrayList<String> characterNames = new ArrayList<>();
    private final ReadFileService readFileService;
    private final WriteCharacterFileService writeCharacterFileService;


    public CharacterLoadPopupController(SetupScreenController setupScreenController){
        this.setupScreenController = setupScreenController;
        this.readFileService = new ReadFileService();
        this.writeCharacterFileService = new WriteCharacterFileService();
    }

    @Override
    public void init() {
        noNameWarning.setVisible(false);
        noStatsWarning.setVisible(false);
    }

    @Override
    public void stop() {
        setupScreenController.loadCharacterName();
        setupScreenController.closeCharacterLoadPopup();
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


    public void createNewCharacter() {
        if(checkTextField(newCharacterNameField)) {
            noNameWarning.setVisible(true);
        } else if ((checkTextField(newCharAtField)) || (checkTextField(newCharPaField)) || (checkTextField(newCharFkField)) || (checkTextField(newCharIniField))){
            noStatsWarning.setVisible(true);
        } else {
            try {
                int attack = Integer.parseInt(newCharAtField.getCharacters().toString());
                int parade = Integer.parseInt(newCharPaField.getCharacters().toString());
                int shoot =  Integer.parseInt(newCharFkField.getCharacters().toString());
                int initiative = Integer.parseInt(newCharAtField.getCharacters().toString());
                int lifePoints = Integer.parseInt(newCharLifepointsField.getCharacters().toString());
                int endurancePoints = Integer.parseInt(newCharEnduranceField.getCharacters().toString());
                setupScreenController.setActualCharacter(writeCharacterFileService.saveNewCharacterAsFXM(newCharacterNameField.getText(), attack, parade, shoot, initiative, lifePoints, endurancePoints));
                saveCharacterName(newCharacterNameField.getText());
                setupScreenController.loadStats();
                stop();
            } catch (NumberFormatException e) {
                noStatsWarning.setVisible(true);
                newCharAtField.clear();
                newCharPaField.clear();
                newCharFkField.clear();
                newCharIniField.clear();
            }
        }
    }

    public void saveCharacterName(String name){
        PrefService prefService = new PrefService();
        prefService.saveCharacterName(name);
    }

    public void loadCharacter() {
        Character character = readFileService.loadCharacter(characterBox.getValue());
        setupScreenController.setActualCharacter(character);
        setupScreenController.loadStats();
        stop();
    }

    public boolean checkTextField(TextField field){
        return field.getText().length() == 0;
    }

    public void close(ActionEvent actionEvent) {
    }

    public void uploadOwnPicture(ActionEvent actionEvent) {
    }
}
