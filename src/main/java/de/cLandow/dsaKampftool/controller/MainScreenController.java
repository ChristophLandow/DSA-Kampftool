package de.cLandow.dsaKampftool.controller;

import de.cLandow.dsaKampftool.Tool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class MainScreenController implements RenderController {

    public MainScreenController(Tool tool){

    }
    @Override
    public void init() {

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
}
