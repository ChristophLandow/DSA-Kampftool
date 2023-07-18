package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.model.Gear;
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

    public AbilityListItemController(){
        
    }

    @Override
    protected void updateItem(Ability ability, boolean empty) {
        super.updateItem(ability, empty);

        if(empty || ability == null) {
            setText(null);
            setGraphic(null);
        } else {
            render();
            setText(null);
            setGraphic(abilityListItemAnchor);
        }
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
