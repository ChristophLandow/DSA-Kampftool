package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class CharacteristicsListBoxController implements RenderController {

    private final AddCharacteristicsPopupController addCharacteristicsPopupController;

    public CharacteristicsListBoxController(AddCharacteristicsPopupController addCharacteristicsPopupController){
        this.addCharacteristicsPopupController = addCharacteristicsPopupController;

    }

    @Override
    public void init() {

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
}
