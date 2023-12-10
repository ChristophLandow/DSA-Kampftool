package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.subController.CharacterIconMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class MainScreenController implements RenderController {

    public CharacterIconMenuController characterIconMenuController;

    public MainScreenController(Tool tool){

    }
    @Override
    public void init() {
        loadCharacterIconMenu();
    }



    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/mainSetup.fxml"));
        loader.setControllerFactory(c->this);
        final Parent setupScreenParent;
        try {
            setupScreenParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return setupScreenParent;
    }

    private void loadCharacterIconMenu() {
        characterIconMenuController = new CharacterIconMenuController(this);
        characterIconMenuController.render();
        characterIconMenuController.init();
    }
}
