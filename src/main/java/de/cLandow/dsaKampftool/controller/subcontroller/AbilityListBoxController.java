package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.services.ReadFileService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AbilityListBoxController implements RenderController {

    @FXML TextField searchAbilityTextField;
    @FXML ListView<Ability> abilityListView;

    private ObservableList<Ability> observableAbilityList;

    public AbilityListBoxController(AddAbilityPopupController addAbilityPopupController){

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
        return null;
    }

    private void loadAbilityListView() {
        abilityListView.setItems(observableAbilityList);
    }

    private void loadAbilityList() {
        ReadFileService readFileService = new ReadFileService(this);
        observableAbilityList = readFileService.loadAbilities();
    }
}
