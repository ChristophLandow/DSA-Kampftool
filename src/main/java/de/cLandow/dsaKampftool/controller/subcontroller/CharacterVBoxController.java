package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Character;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharacterVBoxController implements RenderController {


    @FXML Circle avatarCircle;
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
    private final Character currentCharacter;
    private Image currentImage;

    public CharacterVBoxController(CharacterScreenController characterScreenController, Character currentCharacter){
        this.characterScreenController = characterScreenController;
        this.healthAndEnduranceBoxController = new HealthAndEnduranceBoxController(characterScreenController);
        this.currentCharacter = currentCharacter;
    }

    @Override
    public void init() {
        loadCharacterName();
        loadStats();
        loadHealthAndEndurance();
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

    public void setCharacterImage(Image image) {
        currentImage = image;
        avatarCircle.setFill(new ImagePattern(currentImage));
    }

    public void saveAsPNG(Image image, String path) {
        File outputFile = new File(path);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
