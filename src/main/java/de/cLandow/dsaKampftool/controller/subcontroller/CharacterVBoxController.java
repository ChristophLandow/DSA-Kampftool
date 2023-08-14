package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import de.cLandow.dsaKampftool.model.Character;
import de.cLandow.dsaKampftool.services.AvatarService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CharacterVBoxController implements RenderController {


    @FXML VBox avatarVBox;
    @FXML Label strengthLabel;
    @FXML Label agilityLabel;
    @FXML Label nameLabel;
    @FXML Label baseAtLabel;
    @FXML Label basePaLabel;
    @FXML Label baseFkLabel;
    @FXML Label baseIniLabel;
    @FXML HBox healthAndEnduranceBox;

    private final HealthAndEnduranceBoxController healthAndEnduranceBoxController;
    private final CharacterScreenController characterScreenController;
    private final SetupScreenController setupScreenController;
    private final AvatarBoxController avatarBoxController;
    private final Character currentCharacter;

    public CharacterVBoxController(SetupScreenController setupScreenController, CharacterScreenController characterScreenController, Character currentCharacter){
        this.characterScreenController = characterScreenController;
        this.setupScreenController = setupScreenController;
        this.healthAndEnduranceBoxController = new HealthAndEnduranceBoxController(characterScreenController);
        this.currentCharacter = currentCharacter;
        this.avatarBoxController = new AvatarBoxController(this, currentCharacter);
    }

    @Override
    public void init() {
        loadCharacterName();
        loadStats();
        loadHealthAndEndurance();
        loadAvatarBox();
        avatarBoxController.safePngFromCurrentCharacter();
        loadCharacterAvatar();
    }

    private void loadAvatarBox() {
        avatarVBox.getChildren().add(avatarBoxController.render());
        avatarBoxController.setCurrentAvatar(setupScreenController.getCurrentAvatar());
        avatarBoxController.setCurrentCharacter(currentCharacter);
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characterSetupBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void loadHealthAndEndurance() {
        healthAndEnduranceBox.getChildren().add(healthAndEnduranceBoxController.render());
        healthAndEnduranceBoxController.init();
    }

    public void loadStats() {
        baseAtLabel.setText(Integer.toString(currentCharacter.getAt()));
        basePaLabel.setText(Integer.toString(currentCharacter.getPa()));
        baseFkLabel.setText(Integer.toString(currentCharacter.getFk()));
        baseIniLabel.setText(Integer.toString(currentCharacter.getIni()));
    }

    public void loadCharacterName(){
        nameLabel.setText(currentCharacter.getName());
    }

    private void loadCharacterAvatar() {
        avatarBoxController.init();
    }




}
