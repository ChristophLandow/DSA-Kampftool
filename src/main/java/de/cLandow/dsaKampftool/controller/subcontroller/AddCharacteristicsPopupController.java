package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AddCharacteristicsPopupController implements RenderController {

    @FXML VBox selectedCharacteristicsVBox;
    @FXML VBox characteristicsListVBox;
    private final CharacteristicsListBoxController characteristicsListBoxController;
    private CharacterScreenController characterScreenController;

    public AddCharacteristicsPopupController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
        this.characteristicsListBoxController = new CharacteristicsListBoxController(this);
    }

    @Override
    public void init() {
        //load VBox for characteristics list
        characteristicsListVBox.getChildren().add(characteristicsListBoxController.render());
        characteristicsListBoxController.init();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/addCharacteristicsPopup.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void closeAddCharacteristicsPopup(ActionEvent actionEvent) {
        characterScreenController.closePopup();
    }

    public void addCharacteristicsToHero(ActionEvent actionEvent) {
    }
    
}
