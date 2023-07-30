package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Characteristic;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CharacteristicsListBoxController implements RenderController {
    @FXML ListView<Characteristic> characteristicsListView;
    @FXML TextField searchCharacteristicsTextField;
    private final AddCharacteristicsPopupController addCharacteristicsPopupController;

    private ObservableList<Characteristic> characteristicObservableList = FXCollections.observableArrayList();

    public CharacteristicsListBoxController(AddCharacteristicsPopupController addCharacteristicsPopupController){
        this.addCharacteristicsPopupController = addCharacteristicsPopupController;

    }

    @Override
    public void init() {
        loadCharacteristicsList();
        characteristicsListView.setCellFactory(characteristicsListView -> new CharacteristicsListItemController(this));
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characteristicsListBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void loadCharacteristicsList(){
        ReadFileService readFileService = new ReadFileService();
        characteristicObservableList = readFileService.loadCharacteristics();
    }


}
