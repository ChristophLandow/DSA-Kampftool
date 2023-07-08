package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GearListItemController  extends ListCell<Weapon_closeCombat> {

    @FXML Label itemNameLabel;
    @FXML AnchorPane gearListItemAnchor;

    private FXMLLoader listCellLoader;

    public GearListItemController() {
    }

    @Override
    protected void updateItem(Weapon_closeCombat weaponCloseCombat, boolean empty) {
        super.updateItem(weaponCloseCombat, empty);

        if(empty || weaponCloseCombat == null) {

            setText(null);
            setGraphic(null);

        } else {
            render();
        }
        if(weaponCloseCombat != null){
            itemNameLabel.setText(weaponCloseCombat.name());
        }
        setText(null);
        setGraphic(gearListItemAnchor);
    }

    private void render() {
        if (listCellLoader == null) {
            listCellLoader = new FXMLLoader(Tool.class.getResource("views/subViews/gearListItem.fxml"));
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
                System.out.println(itemNameLabel.getText());
            }
        }
    }

}
