package de.cLandow.dsaKampftool.controller.subcontroller;

import de.cLandow.dsaKampftool.Tool;
import de.cLandow.dsaKampftool.controller.RenderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static de.cLandow.dsaKampftool.Constants.MAINWEAPON;
import static de.cLandow.dsaKampftool.Constants.MAINWEAPON_IMAGE;

public class EquipmentController implements RenderController {

    @FXML BorderPane equipmentContainer;
    @FXML ImageView equipmentImageView;

    private String zone;

    public EquipmentController(String zone){
        this.zone = zone;
    }
    @Override
    public void init() {
       // addHoverEffekt();

    }

    @Override
    public void stop() {

    }

    @Override
    public Parent render() {
        Parent parent = null;
        final FXMLLoader loader = new FXMLLoader(Tool.class.getResource("views/subViews/equipmentContainer.fxml"));
        loader.setControllerFactory(c -> this);
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parent;
    }

    private void addHoverEffekt() {
        //addBorderPaneEffect((ImageView) pane.getCenter());
        //addToolTipp((ImageView) pane.getCenter());
    }

    private void addBorderPaneEffect(ImageView view) {
        view.setOnMouseEntered((event) -> {

        });
    }
    private void addToolTipp(ImageView view) {
        Tooltip newTooltip = new Tooltip("test");
        Tooltip.install(view,newTooltip);
    }

    private void changeIconToSetMode(String item) {
        switch(item){
            case MAINWEAPON -> {
                equipmentImageView.setImage(loadImage(MAINWEAPON_IMAGE));
            }
        }
    }

    private Image loadImage(String path){
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Image(input);
    }


}
