package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterLoadPopupController;
import de.cLandow.dsaKampftool.controller.subcontroller.ChooseCharacterOrDirectoryPopupController;
import de.cLandow.dsaKampftool.controller.subcontroller.HealthAndEnduranceBoxController;
import de.cLandow.dsaKampftool.controller.subcontroller.MenuController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupScreenController implements RenderController {
    @FXML HBox healthAndEnduranceBox;
    @FXML VBox screenBox;
    @FXML Label nameLabel;
    @FXML Label baseAtLabel;
    @FXML Label basePaLabel;
    @FXML Label baseFkLabel;
    @FXML Label baseIniLabel;
    @FXML HBox menuBox;

    private final Tool tool;
    private final PrefService prefService;
    private Stage popupStage;
    private CharacterLoadPopupController characterLoadPopupController;
    private ChooseCharacterOrDirectoryPopupController chooseCharacterOrDirectoryPopupController;

    private HealthAndEnduranceBoxController healthAndEnduranceBoxController;
    private Character actualCharacter;
    private CharacterScreenController characterScreenController;
    private MenuController menuController;


    public SetupScreenController(Tool tool){
        this.tool = tool;
        this.prefService = new PrefService();
    }
    @Override
    public void init() {
        menuController = new MenuController(this, popupStage);
        menuBox.getChildren().add(menuController.render());
        if(actualCharacter == null) {
            openChooseCharacterOrDirectoryPopup();
        }
        menuController.init();
        //check/create Home-Directory in Home/Documents
        //check/create Gear-Directory in Home-Directory
        WriteSetupFileService setupFileService = new WriteSetupFileService();
        setupFileService.createMainFolder();
        setupFileService.createSetupFolder();
        //check/create Character-Directory in Home-Directory
        WriteCharacterFileService writeCharacterFileService = new WriteCharacterFileService();
        writeCharacterFileService.createCharacterFolder();
        //create Weapon.xml
        WriteWeaponFileService writeGearFileService = new WriteWeaponFileService();
        writeGearFileService.createFile();
        //create Armor.xml
        WriteArmorFileService writeArmorFileService = new WriteArmorFileService();
        writeArmorFileService.createFile();
        //create Ability.xml
        WriteAbilityFileService writeAbilityFileService = new WriteAbilityFileService();
        writeAbilityFileService.createFile();
        //Write Characteristics.fxml
        WriteCharacteristicsFileService writeCharacteristicsFileService = new WriteCharacteristicsFileService();
        writeCharacteristicsFileService.createFile();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/mainSetup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent setupScreenParent;
        try {
            setupScreenParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return setupScreenParent;
    }

    public void openCharacterLoadPopup() {
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        characterLoadPopupController = new CharacterLoadPopupController(this);
        popupStage.setScene(new Scene(characterLoadPopupController.render()));
        popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
        characterLoadPopupController.init();
        popupStage.show();
    }

    public void openChooseCharacterOrDirectoryPopup(){
        popupStage = new Stage();
        popupStage.initModality(Modality.WINDOW_MODAL);
        chooseCharacterOrDirectoryPopupController = new ChooseCharacterOrDirectoryPopupController(this);
        popupStage.setScene(new Scene(chooseCharacterOrDirectoryPopupController.render()));
        popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
        chooseCharacterOrDirectoryPopupController.init();
        popupStage.show();
    }

    public void closeCharacterLoadPopup(){
        closePopupStage();
        openCharacterScreen();
        loadHealthAndEndurance();
    }

    public void closePopupStage(){
        if(popupStage != null){
            popupStage.close();
        }
    }

    public void setActualCharacter(Character character){
        this.actualCharacter = character;
    }

    public void loadCharacterName(){
        nameLabel.setText(actualCharacter.getName());
    }


    public Stage getPopupStage(){
        return this.popupStage;
    }

    public void openCharacterScreen() {
        screenBox.getChildren().clear();
        if (characterScreenController == null) {
            characterScreenController = new CharacterScreenController(actualCharacter);
            screenBox.getChildren().add(characterScreenController.render());
            screenBox.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterScreenStyles.css");
            characterScreenController.init();
        } else {
            screenBox.getChildren().add(characterScreenController.getCharacterScreenParent());
        }
    }

    public void loadStats() {
        baseAtLabel.setText(Integer.toString(actualCharacter.getAt()));
        basePaLabel.setText(Integer.toString(actualCharacter.getPa()));
        baseFkLabel.setText(Integer.toString(actualCharacter.getFk()));
        baseIniLabel.setText(Integer.toString(actualCharacter.getIni()));
    }

    private void loadHealthAndEndurance() {
        this.healthAndEnduranceBoxController = new HealthAndEnduranceBoxController(getCharacterScreenController());
        healthAndEnduranceBox.getChildren().add(healthAndEnduranceBoxController.render());
        healthAndEnduranceBoxController.init();
    }

    public Tool getTool(){
        return this.tool;
    }

    public CharacterScreenController getCharacterScreenController(){
        return this.characterScreenController;
    }
}
