package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.AvatarService;
import de.cLandow.dsaKampftool.services.ReadFileService;
import de.cLandow.dsaKampftool.services.WriteCharacterFileService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadCharacterPopupController implements RenderController, Initializable {


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
    private AvatarBoxController avatarBoxController;


    public LoadCharacterPopupController(SetupScreenController setupScreenController){
        this.setupScreenController = setupScreenController;
        this.readFileService = new ReadFileService();
        this.writeCharacterFileService = new WriteCharacterFileService();
        this.avatarBoxController = new AvatarBoxController(this);
    }

    @Override
    public void init() {
        noNameWarning.setVisible(false);
        noStatsWarning.setVisible(false);
        characterImageVBox.getChildren().add(avatarBoxController.render());
        avatarBoxController.init();
    }

    @Override
    public void stop() {
        this.avatarBoxController = null;
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
                setupScreenController.setCurrentCharacter(writeCharacterFileService.saveNewCharacterAsFXM(name, attack, parade, shoot, initiative, lifePoints, endurancePoints, strength, agility));
                setNewAvatar();
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
        setupScreenController.setCurrentCharacter(character);
        loadAvatarFromFile(character);
        stop();
    }

    private void setNewAvatar(){
        if(avatarBoxController != null){
            if(avatarBoxController.getAvatar() != null){
                setupScreenController.setCurrentAvatar(avatarBoxController.getAvatar());
            }
        }
    }

    public void close(ActionEvent actionEvent) {
    }

    public void loadAvatarFromFile(Character character){
        AvatarService avatarService = new AvatarService();
        Image avatar = avatarService.loadAvatarFromCharacterDirectory(character);
        setupScreenController.setCurrentAvatar(avatar);
    }
}
