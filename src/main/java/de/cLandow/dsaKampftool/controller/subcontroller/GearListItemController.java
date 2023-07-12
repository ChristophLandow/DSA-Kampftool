package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Gear;
import de.cLandow.dsaKampftool.model.Weapon_closeCombat;
import static de.cLandow.dsaKampftool.Constants.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;



public class GearListItemController  extends ListCell<Gear> {

    @FXML Label itemNameLabel;
    @FXML AnchorPane gearListItemAnchor;

    private FXMLLoader listCellLoader;
    private GearListBoxController gearListBoxController;

    private Gear equipedGear ;

    public GearListItemController(GearListBoxController gearListBoxController) {
        this.gearListBoxController = gearListBoxController;
    }

    @Override
    protected void updateItem(Gear gear, boolean empty) {
        super.updateItem(gear, empty);

        if(empty || gear == null) {
            setText(null);
            setGraphic(null);
        } else {
            render();
            setGear(gear);
            itemNameLabel.setText(gear.getName());
            setText(null);
            setGraphic(gearListItemAnchor);
        }
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
                gearListBoxController.setDoubleClickedGearToEquipment(equipedGear);
            }
        }
    }

    public void setGear(Gear gear) {
        this.equipedGear = gear;
    }
}
