package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class CharacteristicsListItemController extends ListCell<Characteristic> {

    @FXML Circle selectCircle;
    @FXML Circle removeCircle;
    @FXML Label characteristicNameLabel;
    @FXML AnchorPane characteristicListItemAnchor;
    private FXMLLoader listCellLoader;
    private final CharacteristicsListBoxController characteristicsListBoxController;
    private Characteristic characteristic;

    public CharacteristicsListItemController(CharacteristicsListBoxController characteristicsListBoxController) {
        this.characteristicsListBoxController = characteristicsListBoxController;
    }

    @Override
    protected void updateItem(Characteristic characteristic, boolean empty) {
        super.updateItem(characteristic, empty);

        if(empty || characteristic == null) {
            setText(null);
            setGraphic(null);
        } else {
            render();
            removeCircle.setVisible(false);
            removeCircle.setDisable(true);
            setCharacteristic(characteristic);
            characteristicNameLabel.setText(characteristic.getName());
            setText(null);
            setGraphic(characteristicListItemAnchor);
        }
    }

    private void render() {
        if (listCellLoader == null) {
            listCellLoader = new FXMLLoader(Tool.class.getResource("views/subViews/characteristicListItem.fxml"));
            listCellLoader.setControllerFactory(c -> this);
            try {
                listCellLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public void removeCharacteristicFromList(MouseEvent mouseEvent) {
    }

    public void setCharacteristicToList(MouseEvent mouseEvent) {
    }
}
