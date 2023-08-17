package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import de.cLandow.dsaKampftool.controller.SetupScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController implements RenderController {
    private final SetupScreenController setupScreenController;
    private Stage popupStage;

    public MenuController(SetupScreenController setupScreenController, Stage popupStage){
        this.setupScreenController = setupScreenController;
        this.popupStage = popupStage;
    }

    @Override
    public void init() {
    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/menuBox.fxml"));
        loader.setControllerFactory(c->this);
        final Parent menuBarParent;
        try {
            menuBarParent =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return menuBarParent;
    }

    public SetupScreenController getSetupScreenController() {
        return setupScreenController;
    }

    public void openAbilitiesScreen(MouseEvent mouseEvent) {
    }

    public void openCharacteristicsScreen(MouseEvent mouseEvent) {
    }

    public void openGearScreen(MouseEvent mouseEvent) {
    }

    public void openCharacterScreen(MouseEvent mouseEvent) {
    }

    public void openFightScreen(MouseEvent mouseEvent) {
    }
}
