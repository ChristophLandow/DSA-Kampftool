package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class AbilityListItemController extends ListCell<Ability> {


    @FXML Circle addAbilityCircle;
    @FXML Circle deleteAbilityCircle;
    @FXML Label abilityNameLabel;
    @FXML AnchorPane abilityListItemAnchor;

    private final AbilityListBoxController abilityListBoxController;
    private  final SelectedAbilitiesBoxController selectedAbilitiesBoxController;
    private FXMLLoader listCellLoader;
    private Ability ability;

    public AbilityListItemController(AbilityListBoxController abilityListBoxController){
        this.abilityListBoxController = abilityListBoxController;
        this.selectedAbilitiesBoxController = null;
    }

    public AbilityListItemController(SelectedAbilitiesBoxController selectedAbilitiesBoxController) {
        this.selectedAbilitiesBoxController = selectedAbilitiesBoxController;
        this.abilityListBoxController = null;
    }

    @Override
    protected void updateItem(Ability ability, boolean empty) {
        super.updateItem(ability, empty);

        if(empty || ability == null) {
            setText(null);
            setGraphic(null);
        } else {
            render();
            setAbility(ability);
            abilityNameLabel.setText(ability.getName());
            if(selectedAbilitiesBoxController == null){
                deleteAbilityCircle.setDisable(true);
                deleteAbilityCircle.setVisible(false);
            } else {
                addAbilityCircle.setDisable(true);
                addAbilityCircle.setVisible(false);
            }
            setText(null);
            setGraphic(abilityListItemAnchor);
        }
    }

    private void setAbility(Ability ability) {
        this.ability = ability;
    }

    private void render() {
        if (listCellLoader == null) {
            listCellLoader = new FXMLLoader(Tool.class.getResource("views/subViews/abilityListItem.fxml"));
            listCellLoader.setControllerFactory(c -> this);
            try {
                listCellLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addAbility(MouseEvent mouseEvent) {
        if(abilityListBoxController != null && ability != null){
            abilityListBoxController.sendAbilityToSelectedList(ability);
        } else {
            System.out.println("Ability wird nicht korrekt geladen");
        }
    }

    public void deleteAbility(MouseEvent mouseEvent) {
        if(selectedAbilitiesBoxController != null && ability != null){
            selectedAbilitiesBoxController.deleteAbilityfromSelectedList(ability);
        } else {
            System.out.println("Ability wird nicht korrekt gelöscht");
        }
    }
}
