package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.IOException;

public class SelectedCharacteristicsBoxController implements RenderController {

    @FXML ListView<Characteristic> selectedCharacteristicsListView;
    private final AddCharacteristicsPopupController addCharacteristicsPopupController;

    public SelectedCharacteristicsBoxController(AddCharacteristicsPopupController addCharacteristicsPopupController){
        this.addCharacteristicsPopupController = addCharacteristicsPopupController;
    }

    @Override
    public void init() {
        selectedCharacteristicsListView.setCellFactory(selectedCharacteristicListView -> new CharacteristicsListItemController(this));
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/selectedCharacteristicsBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }
}
