package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AbilityListItemController extends ListCell<Ability> {

    @FXML Label abilityNameLabel;
    @FXML AnchorPane abilityListItemAnchor;

    private FXMLLoader listCellLoader;
    private final SpecialAbilityPopupController specialAbilityPopupController;
    private Ability ability;

    public AbilityListItemController(SpecialAbilityPopupController specialAbilityPopupController){
        this.specialAbilityPopupController = specialAbilityPopupController;
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
            abilityNameLabel.setText(ability.name());
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

    public void doubleClicked(MouseEvent mouseEvent) {
    }
}