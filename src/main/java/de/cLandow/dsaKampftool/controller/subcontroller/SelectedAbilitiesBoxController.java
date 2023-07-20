package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.model.Ability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.IOException;

public class SelectedAbilitiesBoxController implements RenderController {

    @FXML ListView<Ability> selectionListView;

    public SelectedAbilitiesBoxController(AddAbilityPopupController addAbilityPopupController){

    }

    @Override
    public void init() {
        selectionListView.setCellFactory(selcetedAbilitiesListView -> new AbilityListItemController(this));
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
        selectionListView.getItems().add(ability);
    }
}
