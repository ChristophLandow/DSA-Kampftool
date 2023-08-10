package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subcontroller.LoadCharacterPopupController;
import de.cLandow.dsaKampftool.controller.subcontroller.CharacterVBoxController;
import de.cLandow.dsaKampftool.controller.subcontroller.MenuController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SetupScreenController implements RenderController {


    @FXML VBox characterSetupVBox;
    @FXML VBox screenBox;

    @FXML HBox menuBox;

    private final Tool tool;
    private Stage popupStage;
    private LoadCharacterPopupController characterLoadPopupController;

    private CharacterVBoxController characterBoxController;

    private Character actualCharacter;
    private CharacterScreenController characterScreenController;
    private MenuController menuController;
    private Image currentAvatar;


    public SetupScreenController(Tool tool){
        this.tool = tool;
    }
    @Override
    public void init() {
        menuController = new MenuController(this, popupStage);
        menuBox.getChildren().add(menuController.render());
        if(actualCharacter == null) {
            openCharacterLoadPopup();
        }
        menuController.init();
        //check/write Home-Directory in Home/Documents
        //check/write Gear-Directory in Home-Directory
        WriteSetupFileService setupFileService = new WriteSetupFileService();
        setupFileService.createMainFolder();
        setupFileService.createSetupFolder();
        //check/write  Character-Directory in Home-Directory
        WriteCharacterFileService writeCharacterFileService = new WriteCharacterFileService();
        writeCharacterFileService.createCharacterFolder();
        //Write  Weapon.xml
        WriteWeaponFileService writeGearFileService = new WriteWeaponFileService();
        writeGearFileService.createFile();
        //Write  Armor.xml
        WriteArmorFileService writeArmorFileService = new WriteArmorFileService();
        writeArmorFileService.createFile();
        //Write  Ability.xml
        WriteAbilityFileService writeAbilityFileService = new WriteAbilityFileService();
        writeAbilityFileService.createFile();
        //Write Characteristics.fxml
        WriteCharacteristicsFileService writeCharacteristicsFileService = new WriteCharacteristicsFileService();
        writeCharacteristicsFileService.createFile();
        //init Character Service
        CharacterService characterService = new CharacterService();
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
        characterLoadPopupController = new LoadCharacterPopupController(this);
        popupStage.setScene(new Scene(characterLoadPopupController.render()));
        popupStage.getScene().getStylesheets().add("/de/cLandow/dsaKampftool/styles/characterLoadPopupStyles.css");
        characterLoadPopupController.init();
        popupStage.show();
    }

    public void closeCharacterLoadPopup(){
        openCharacterScreen();
        loadCharacterSetupBox();
        closePopupStage();
    }

    public void closePopupStage(){
        if(popupStage != null){
            popupStage.close();
        }
    }

    public void setCurrentCharacter(Character character){
        this.actualCharacter = character;
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

    public Tool getTool(){
        return this.tool;
    }

    public CharacterScreenController getCharacterScreenController(){
        return this.characterScreenController;
    }

    public void loadCharacterSetupBox() {
        this.characterBoxController = new CharacterVBoxController(characterScreenController, actualCharacter);
        characterSetupVBox.getChildren().add(characterBoxController.render());
        characterBoxController.init();
    }

    public void setCurrentAvatar(Image image) {
        currentAvatar = image;
    }
}
