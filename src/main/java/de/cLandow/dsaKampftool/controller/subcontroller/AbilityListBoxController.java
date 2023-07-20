package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AbilityListBoxController implements RenderController {

    @FXML TextField searchAbilityTextField;
    @FXML ListView<Ability> abilityListView;

    private final AddAbilityPopupController addAbilityPopupController;
    private ObservableList<Ability> observableAbilityList;

    public AbilityListBoxController(AddAbilityPopupController addAbilityPopupController){
        this.addAbilityPopupController = addAbilityPopupController;
    }

    @Override
    public void init() {
        loadAbilityList();
        abilityListView.setCellFactory(abilitiesListView -> new AbilityListItemController(this));
        loadAbilityListView();
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/abilityListBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void loadAbilityListView() {
        abilityListView.setItems(observableAbilityList);
    }

    private void loadAbilityList() {
        ReadFileService readFileService = new ReadFileService(this);
        observableAbilityList = readFileService.loadAbilities();
    }

    public void sendAbilityToSelectedList(Ability ability) {
        addAbilityPopupController.addAbilityToSelectedList(ability);
    }
}
