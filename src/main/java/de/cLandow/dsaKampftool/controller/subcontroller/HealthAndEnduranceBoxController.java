package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.CharacterScreenController;
import de.cLandow.dsaKampftool.controller.ScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class HealthAndEnduranceBoxController implements ScreenController {

    private final CharacterScreenController characterScreenController;

    public HealthAndEnduranceBoxController(CharacterScreenController characterScreenController){
        this.characterScreenController = characterScreenController;
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
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/healthEnduranceBox.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }
}
