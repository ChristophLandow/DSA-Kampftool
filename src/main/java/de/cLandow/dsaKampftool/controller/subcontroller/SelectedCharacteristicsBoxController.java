package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.IOException;

public class SelectedCharacteristicsBoxController implements RenderController {

    @FXML ListView<Characteristic> selectedCharacteristicsListView;
    private final AddCharacteristicsPopupController addCharacteristicsPopupController;
    private ObservableList<Characteristic> characteristicObservableList = FXCollections.observableArrayList();
    private ListChangeListener<Characteristic> listChangeListener;

    public SelectedCharacteristicsBoxController(AddCharacteristicsPopupController addCharacteristicsPopupController){
        this.addCharacteristicsPopupController = addCharacteristicsPopupController;
    }

    @Override
    public void init() {
        selectedCharacteristicsListView.setCellFactory(selectedCharacteristicListView -> new CharacteristicsListItemController(this));
        createListChangeListener();
        addListChangeListener();
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

    public void addCharacteristicToList(Characteristic characteristic) {
        characteristicObservableList.add(characteristic);
    }

    private void createListChangeListener() {
        listChangeListener = c -> {
            if(c.next()){
                selectedCharacteristicsListView.getItems().clear();
                characteristicObservableList.forEach(characteristic -> selectedCharacteristicsListView.getItems().add(characteristic));
            }
        };
    }

    private void addListChangeListener() {
        characteristicObservableList.addListener(listChangeListener);
    }

    private Boolean checkList(Characteristic check){
        for (Characteristic characteristic : characteristicObservableList) {
            if (characteristic.getName().equals(check.getName())) {
                return true;
            }
        }
        return false;
    }
}
