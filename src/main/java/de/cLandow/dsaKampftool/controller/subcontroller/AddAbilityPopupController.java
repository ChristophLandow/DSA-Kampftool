package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AddAbilityPopupController implements RenderController {

    @FXML TextArea explainingTextField;
    @FXML VBox abilityListVBox;
    @FXML VBox selectedAbilitiesVBox;
    @FXML Button closeButton;
    @FXML Button addButton;

    private final AbilityListBoxController abilityBoxController;
    private final SelectedAbilitiesBoxController selectedAbilitiesBoxController;
    private final CharacterScreenController characterScreenController;

    public AddAbilityPopupController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
        this.abilityBoxController = new AbilityListBoxController(this);
        this.selectedAbilitiesBoxController = new SelectedAbilitiesBoxController(this);

    }

    @Override
    public void init() {
        //load AbilityList VBox
        abilityListVBox.getChildren().add(abilityBoxController.render());
        abilityBoxController.init();
        //load selected abilities List VBox
        selectedAbilitiesVBox.getChildren().add(selectedAbilitiesBoxController.render());
        selectedAbilitiesBoxController.init();
    }



    @Override
    public void stop() {
    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/addAbilityPopup.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void closeAddSpecialAbilityPopup(ActionEvent actionEvent) {
        characterScreenController.closePopup();
    }

    public void addSpecialAbilityToHero(ActionEvent actionEvent) {
    }

    public void addAbilityToSelectedList(Ability ability) {
        selectedAbilitiesBoxController.addAbilityToSelectedList(ability);
    }
}
