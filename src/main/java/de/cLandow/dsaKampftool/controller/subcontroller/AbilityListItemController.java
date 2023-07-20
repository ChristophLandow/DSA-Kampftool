package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AbilityListItemController extends ListCell<Ability> {

    @FXML Label abilityNameLabel;
    @FXML AnchorPane abilityListItemAnchor;

    private FXMLLoader listCellLoader;
    private final AddAbilityPopupController specialAbilityPopupController;
    private Ability ability;

    public AbilityListItemController(AddAbilityPopupController specialAbilityPopupController){
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
            abilityNameLabel.setText(ability.getName());
            setText(null);
            setGraphic(abilityListItemAnchor);
            System.out.println();
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
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 2) {

                specialAbilityPopupController.addAbilityToList(ability);

            }
        }
    }

    public void addAbility(MouseEvent mouseEvent) {
    }

    public void deleteAbility(MouseEvent mouseEvent) {
    }
}
