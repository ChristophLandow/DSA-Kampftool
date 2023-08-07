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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static de.cLandow.dsaKampftool.Constants.*;

public class CharacterLoadPopupController implements RenderController, Initializable {


    @FXML VBox characterImageVBox;
    @FXML TextField newCharAgilityField;
    @FXML TextField newCharStrengthField;
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

    private final SetupScreenController setupScreenController;
    private ArrayList<String> characterNames = new ArrayList<>();
    private final ReadFileService readFileService;
    private final WriteCharacterFileService writeCharacterFileService;
    private final CharacterImageBoxController characterImageBoxController;


    public CharacterLoadPopupController(SetupScreenController setupScreenController){
        this.setupScreenController = setupScreenController;
        this.readFileService = new ReadFileService();
        this.writeCharacterFileService = new WriteCharacterFileService();
        this.characterImageBoxController = new CharacterImageBoxController();
    }

    @Override
    public void init() {
        noNameWarning.setVisible(false);
        noStatsWarning.setVisible(false);
        characterImageVBox.getChildren().add(characterImageBoxController.render());
        characterImageBoxController.init();
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
        if(newCharacterNameField.getText().isEmpty()) {
            noNameWarning.setVisible(true);
        } else if ((newCharAtField.getText().isEmpty()) || (newCharPaField.getText().isEmpty()) || (newCharFkField.getText().isEmpty()) || (newCharIniField.getText().isEmpty())){
            noStatsWarning.setVisible(true);
        } else {
            try {
                String name = parseToXmlSafeName(newCharacterNameField.getText());
                Integer attack = Integer.parseInt(newCharAtField.getCharacters().toString());
                Integer parade = Integer.parseInt(newCharPaField.getCharacters().toString());
                Integer shoot =  Integer.parseInt(newCharFkField.getCharacters().toString());
                Integer initiative = Integer.parseInt(newCharAtField.getCharacters().toString());
                Integer lifePoints = Integer.parseInt(newCharLifepointsField.getCharacters().toString());
                Integer endurancePoints = Integer.parseInt(newCharEnduranceField.getCharacters().toString());
                Integer strength = Integer.parseInt(newCharStrengthField.getCharacters().toString());
                Integer agility = Integer.parseInt(newCharAgilityField.getCharacters().toString());
                setupScreenController.setActualCharacter(writeCharacterFileService.saveNewCharacterAsFXM(name, attack, parade, shoot, initiative, lifePoints, endurancePoints, strength, agility));
                stop();
            } catch (NumberFormatException e) {
                noStatsWarning.setVisible(true);
                newCharAtField.clear();
                newCharPaField.clear();
                newCharFkField.clear();
                newCharIniField.clear();
                newCharEnduranceField.clear();
                newCharLifepointsField.clear();
                newCharAgilityField.clear();
                newCharStrengthField.clear();
            }
        }
    }

    private String parseToXmlSafeName(String text) {
        return text.replace(" ","_");
    }

    public void loadCharacter() {
        Character character = readFileService.loadCharacter(parseToXmlSafeName(characterBox.getValue()));
        setupScreenController.setActualCharacter(character);
        setupScreenController.loadStats();
        stop();
    }

    public void close(ActionEvent actionEvent) {
    }
}
