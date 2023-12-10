package de.cLandow.dsaKampftool.controller.subController;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.MainScreenController;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class CharacterIconMenuController implements RenderController {

    private final MainScreenController mainScreenController;

    public CharacterIconMenuController(MainScreenController mainScreenController){
        this.mainScreenController = mainScreenController;
    }


    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/characterIconMenu.fxml"));
        loader.setControllerFactory(c->this);
        final Parent characterIconMenuParent;
        try {
            characterIconMenuParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return characterIconMenuParent;
    }
}
