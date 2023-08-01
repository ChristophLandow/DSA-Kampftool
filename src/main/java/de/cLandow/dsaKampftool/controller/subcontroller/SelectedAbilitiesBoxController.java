package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import de.cLandow.dsaKampftool.model.Characteristic;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.IOException;

public class SelectedAbilitiesBoxController implements RenderController {

    @FXML ListView<Ability> selectionListView;

    ObservableList<Ability> observableAbilityList = FXCollections.observableArrayList();
    private ListChangeListener<Ability> listChangeListener;
    private final AddAbilityPopupController addAbilityPopupController;

    public SelectedAbilitiesBoxController(AddAbilityPopupController addAbilityPopupController){
            this.addAbilityPopupController = addAbilityPopupController;
    }

    @Override
    public void init() {
        selectionListView.setCellFactory(selcetedAbilitiesListView -> new AbilityListItemController(this));
        createListChangeListener();
        observableAbilityList.addListener(listChangeListener);
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/selectedAbilitiesBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public void addAbilityToSelectedList(Ability ability) {
        if(!checkForAbility(ability)){
            observableAbilityList.add(ability);
        }
    }

    public void deleteAbilityfromSelectedList(Ability ability){
        if(checkForAbility(ability)){
            observableAbilityList.remove(ability);
        }
    }

    public boolean checkForAbility(Ability check){
        for (Ability ability : observableAbilityList) {
            if (ability.getName().equals(check.getName())) {
                return true;
            }
        }
        return false;
    }

    private void createListChangeListener() {
        listChangeListener = c -> {
            if(c.next()){
                selectionListView.getItems().clear();
                observableAbilityList.forEach(ability -> selectionListView.getItems().add(ability));
            }
        };
    }
}
